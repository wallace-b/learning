# ---------- Factor Selection / Reduction of Dimensionality Linear Regression ----------
# Clear environment
rm(list = ls())

# Setting the random number generator seed so that our results are reproducible
set.seed(1)

# First, read in the data
data=read.table("F:/Documents/uscrime.txt", 
                     stringsAsFactors = FALSE, header=TRUE)

# Optional check to make sure the data is read correctly
head(data)

############################
##### Examining Plots  #####
############################

# As Elastic Net & LASSO tends to eliminate 1 of 2 highly-correlated factors, it is worth investigating
# correlation between factors.

# Plot some 2D graphs of the data to see if there is correlation or not
library(GGally)

ggpairs(data, columns = c("Po1", "Po2", "U1", "U2", "Ineq", "Wealth", "Crime"),
        mapping=ggplot2::aes(color= "#3366FF"))

# Look at the correlation matrix of the data
corr <- cor(data)
round(corr, 2)

#######################
##### Preliminary #####
#######################

# Split 80% Data for Training and 20% for Pseudo-Testing. 
# A sort of Validation/Test set will be used to compare model quality.
# We are simply aiming to compare the models against a set of data that they aren't fitted to the 
# random effects of the Training set i.e. this pseudo Validation/Test set.

trainIndex <- sample.int(n = nrow(data), size = floor(0.80*nrow(data)), replace = F)
train <- data[trainIndex,]
test <- data[-trainIndex,]

# create RMSE function to call

rmse = function(actual, predicted) {
  sqrt(mean((actual - predicted) ^ 2))
}

##################################
#####  Stepwise regression  ######
##################################

# Perform backward elimination. We can use the trace argument to suppress the output.

model_back <- lm(Crime~., data = train)

step(model_back, direction = "backward")
# The output of this code will show the elimination of the 15 factors, one by one, until the optimal model size
# of 8 predictors.
# At each step, the model tests to see which factor being substracted from the model results in the lowest AIC 
# and proceeds to remove factors selected this way until it reaches its optimal size and there is, presumably, 
# no improvement to AIC (or worsening of AIC) with the removal of another factor.

step(model_back,
     direction = "backward",
     trace = 0)

# Perform forward selection. We can use the trace argument to suppress the output.
model_forward <- lm(Crime~1, data = train)
#step(model_forward,
    #scope = formula(lm(Crime~., data = data)),
    #direction = "forward")
# the output of this code will show the addition of factors, one by one, until the optimal model size of 6 
# predictors. At each step, the model tests to see which factor being added to the model results in the lowest
# AIC and proceeds to add factors selected this way until it reaches its optimal size and there is, presumably,
# minimal improvement to AIC (or worsening of AIC) with the addition antoher factor.

step(model_forward,
     scope = formula(lm(Crime~., data = train)),
     direction = "forward",
     trace = 0)

# Perform stepwise regression. We can use the trace argument to suppress the output.
model_both <- lm(Crime~., data = train)
#step(model_both,
     #scope = list(lower = formula(lm(Crime~1, data = data)),
     #             upper = formula(lm(Crime~., data = data))),
     #direct = "both")
step(model_both,
     scope = list(lower = formula(lm(Crime~1, data = train)),
                  upper = formula(lm(Crime~., data = train))),
     direction = "both",
     trace = 0)

# Turning off trace - Surprisingly, the stepwise regression just performs 7 eliminations to result in the same
# factor selection as the backward elimination. Contrary to the flowchart presented in the lecture materials,
# the stepwise regression initiates with all factors included like backwards elimination and then after 
# eliminating 3 or so factors, begins to test if reintroducing previously eliminated factors improves
# (reduces) AIc. At no step does the re-introduction of a factor improve AIC, so the model just proceeds to 
# elimintte 7 factors.

# Rebuild linear regression model with selected predictors
model_both_New <- lm(Crime~ M + Ed + Po1 + M.F + U1 + U2 + Ineq + Prob, data = train)

summary(model_both_New)
plot(model_both_New)




# Omit AIC and BIC calculations for comparison as they are not easily performed on glmnet output.
#AIC(model_both_New)
#BIC(model_both_New)

# Prediction on Test set. Prediction is set to #3 since it is technically the 3rd model in the Code.
prediction3 = predict(model_both_New, newdata = test)

# Calculate RMSE
rmse(test$Crime, prediction3)

# And now calculate R^2 and adj R^2 on Test set
SSE.3 = sum((prediction3 - test[,16])^2)
SStot.3 = sum((test[,16] - mean(test[,16]))^2)
R2.3 <- 1 - SSE.3/SStot.3
R2.3

R2.adj.3 = 1 - ((1 - R2.3)*(nrow(train)-1)/(nrow(train)-8-1))
R2.adj.3

# P-values are included in the 'summary' output, but since there are drawbacks to p-values as a quality metric
# i.e. there is always a chance that factors included are actually insignificant.
# We look to Adjusted R^2 and RMSE to measure quality.

#####################
#####  LASSO  ######
####################

# Starting with the code provided in the 03/02 Monday office hours..

# Load library 'glmnet'
library(glmnet)

# Load library 'dplyr' to scale data. So (Factor#2) column does not need to be scaled, so there is some
# benefit to scaling the data manually
library(dplyr)
train_scaled <- train
test_scaled <- test
train_scaled %>% mutate_each_(funs(scale),vars=c("M","Ed","Po1","Po2","LF","M.F","Pop","NW",
                                                 "U1","U2","Wealth","Ineq","Prob","Time"))
test_scaled %>% mutate_each_(funs(scale),vars=c("M","Ed","Po1","Po2","LF","M.F","Pop","NW",
                                                 "U1","U2","Wealth","Ineq","Prob","Time"))

# Run cv.glmnet. Use Cross-validation to improve model quality due to size of data set. 
# alpha = lambda from lecture material, lambda = tau from lecture material, 
# nlambda = number of tau values tested, nfolds = 8 fold cross validation,
# alpha = 1 == LASSO, alpha = 0 == Ridge Regression, 0 < alpha < 1 == Elastic Net
model_lasso <- cv.glmnet(x=as.matrix(train_scaled[,-16]),
                         y=as.matrix(train_scaled[,16]),
                         alpha=1,
                         nfolds=8,
                         nlambda=20,
                         type.measure="mse",
                         family="gaussian",
                         standardize=FALSE)

# Print out some outputs, including a plot of MSE with confidence intervals for each lambda
model_lasso
plot(model_lasso)
cbind("lambda"=model_lasso$lambda,"MSE"=model_lasso$cvm, "# Non-zero Coefficients"=model_lasso$nzero)
model_lasso$glmnet.fit
model_lasso$lambda.1se

# Show the lambda (tau) that corresponds to the smallest MSA and the coefficients for this model.
model_lasso$lambda.min
coef(model_lasso,s=model_lasso$lambda.min)

# Prediction on Test set using the best lambda value model
prediction_lasso <- predict(model_lasso, s=model_lasso$lambda.min,newx=as.matrix(test_scaled[,-16]))

# RMSE
rmse(test$Crime, prediction_lasso)

# And now calculate R^2 and adj R^2 on Test set
SSE.4 = sum((prediction_lasso - test_scaled[,16])^2)
SStot.4 = sum((test_scaled[,16] - mean(test_scaled[,16]))^2)
R2.4 <- 1 - SSE.4/SStot.4
R2.4

R2.adj.4 = 1 - ((1 - R2.4)*(nrow(train_scaled)-1)/(nrow(train_scaled)-10-1))
R2.adj.4

#########################
#####  Elastic Net ######
#########################

# Run Elastic Net for alpha = 0.25, 0.5 and 0.75.
# With more time, I could run a loop for steps of alpha between 0 and 1, store all the coefficients and quality metrics,
# and select the highest adjusted R^2 or something...

# Run cv.glmnet. Use Cross-validation to improve model quality due to size of data set. 
# alpha = lambda from lecture material, lambda = tau from lecture material, 
# nlambda = number of tau values tested, nfolds = 8 fold cross validation,
# alpha = 1 == LASSO, alpha = 0 == Ridge Regression, 0 < alpha < 1 == Elastic Net
model_elasticnet1 <- cv.glmnet(x=as.matrix(train_scaled[,-16]),
                         y=as.matrix(train_scaled[,16]),
                         alpha=0.5,
                         nfolds=8,
                         nlambda=20,
                         type.measure="mse",
                         family="gaussian",
                         standardize=FALSE)

# Print out some outputs, including a plot of MSE with confidence intervals for each lambda
model_elasticnet1
plot(model_elasticnet1)
cbind("lambda"=model_elasticnet1$lambda,"MSE"=model_elasticnet1$cvm,"# Non-zero Coefficients"=model_elasticnet1$nzero)
model_elasticnet1$glmnet.fit
model_elasticnet1$lambda.1se

# Show the lambda (tau) that corresponds to the smallest MSA and the coefficients for this model.
model_elasticnet1$lambda.min
coef(model_elasticnet1,s=model_elasticnet1$lambda.min)

# Prediction on Test set using the best lambda value model
prediction_elnet1 <- predict(model_elasticnet1, s=model_elasticnet1$lambda.min,newx=as.matrix(test_scaled[,-16]))

# RMSE
rmse(test$Crime, prediction_elnet1)

# And now calculate R^2 and adj R^2 on test set
SSE.5 = sum((prediction_elnet1 - test_scaled[,16])^2)
SStot.5 = sum((test_scaled[,16] - mean(test_scaled[,16]))^2)
R2.5 <- 1 - SSE.5/SStot.5
R2.5

R2.adj.5 = 1 - ((1 - R2.5)*(nrow(train_scaled)-1)/(nrow(train_scaled)-9-1))
R2.adj.5

############
# Run cv.glmnet. Use Cross-validation to improve model quality due to size of data set. 
# alpha = lambda from lecture material, lambda = tau from lecture material, 
# nlambda = number of tau values tested, nfolds = 8 fold cross validation,
# alpha = 1 == LASSO, alpha = 0 == Ridge Regression, 0 < alpha < 1 == Elastic Net
model_elasticnet2 <- cv.glmnet(x=as.matrix(train_scaled[,-16]),
                             y=as.matrix(train_scaled[,16]),
                             alpha=0.25,
                             nfolds=8,
                             nlambda=20,
                             type.measure="mse",
                             family="gaussian",
                             standardize=FALSE)

# Print out some outputs, including a plot of MSE with confidence intervals for each lambda
model_elasticnet2
plot(model_elasticnet2)
cbind("lambda"=model_elasticnet2$lambda,"MSE"=model_elasticnet2$cvm,"# Non-zero Coefficients"=model_elasticnet2$nzero)
model_elasticnet2$glmnet.fit
model_elasticnet2$lambda.1se

# Show the lambda (tau) that corresponds to the smallest MSA and the coefficients for this model.
model_elasticnet2$lambda.min
coef(model_elasticnet2,s=model_elasticnet2$lambda.min)

# Prediction on Test set using the best lambda value model
prediction_elnet2 <- predict(model_elasticnet2, s=model_elasticnet2$lambda.min,newx=as.matrix(test_scaled[,-16]))

# RMSE
rmse(test$Crime, prediction_elnet2)

# And now calculate R^2 and adj R^2 on test set
SSE.6 = sum((prediction_elnet2 - test_scaled[,16])^2)
SStot.6 = sum((test_scaled[,16] - mean(test_scaled[,16]))^2)
R2.6 <- 1 - SSE.6/SStot.6
R2.6

R2.adj.6 = 1 - ((1 - R2.6)*(nrow(train_scaled)-1)/(nrow(train_scaled)-10-1))
R2.adj.6

############
# Run cv.glmnet. Use Cross-validation to improve model quality due to size of data set. 
# alpha = lambda from lecture material, lambda = tau from lecture material, nlambda = number of tau values tested
# nfolds = 8 fold cross validation. alpha = 1 == LASSO, alpha = 0 == Ridge Regression, 0 < alpha < 1 == Elastic Net
model_elasticnet3 <- cv.glmnet(x=as.matrix(train_scaled[,-16]),
                               y=as.matrix(train_scaled[,16]),
                               alpha=0.75,
                               nfolds=8,
                               nlambda=20,
                               type.measure="mse",
                               family="gaussian",
                               standardize=FALSE)

# Print out some outputs, including a plot of MSE with confidence intervals for each lambda
model_elasticnet3
plot(model_elasticnet3)
cbind("lambda"=model_elasticnet3$lambda,"MSE"=model_elasticnet3$cvm,"# Non-zero Coefficients"=model_elasticnet3$nzero)
model_elasticnet3$glmnet.fit
model_elasticnet3$lambda.1se

# Show the lambda (tau) that corresponds to the smallest MSA and the coefficients for this model.
model_elasticnet3$lambda.min
coef(model_elasticnet3,s=model_elasticnet3$lambda.min)

# Prediction on Test set using the best lambda value model
prediction_elnet3 <- predict(model_elasticnet3, s=model_elasticnet3$lambda.min,newx=as.matrix(test_scaled[,-16]))

# RMSE
rmse(test$Crime, prediction_elnet3)

# And now calculate R^2 and adj R^2 on test set
SSE.7 = sum((prediction_elnet3 - test_scaled[,16])^2)
SStot.7 = sum((test_scaled[,16] - mean(test_scaled[,16]))^2)
R2.7 <- 1 - SSE.7/SStot.7
R2.7

R2.adj.7 = 1 - ((1 - R2.7)*(nrow(train_scaled)-1)/(nrow(train_scaled)-9-1))
R2.adj.7

# Adjusted R^2 Performance and RMSE is similar across all 3 models.
# Elastic Net model#1 appears to perform the best.
# Interestingly, Elastic Net model#2, which had an alpha value (lambda) = 0.25 and closest of the three to
# Ridge Regression, included both Po1 and Po2 factors which are highly correlated.
# As stated in the lecture material, the quadratic term has a tendency to preserve factors, albeit close to
# zero at times. LASSO tends to eliminate one of the highly correlated factors with a zero coefficient.
# This behaviour is evident in Elastic Net model#1 and #3 as they eliminate the Po2 factor.

# Elastic Net appears to perform slightly better than LASSO. I believe this intuitively makes sense as
# Elastic Net incorporates LASSO methodology alongside Ridge Regression.

# Curiously, the stepwise regression model performed better in terms of RMSE and Adjusted R^2. I suspect
# the stepwise regression model (a basic linear regression) is overfitting the small data set.
# With more time, I would endeavour to perform CV-lm. Regretfully I can't get 'DAAG' package to work.
# I have also tried using the 'caret' package to perform cv-lm, but it does not appear to significantly
# reduce predictive ability and hence R^2 and increase error as expected.