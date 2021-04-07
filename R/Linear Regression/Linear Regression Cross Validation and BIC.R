## Linear Regression with CV and BIC - complexity-balanced performance - and Prediction ##

rm(list = ls())
# read data into R
crimeData=read.table("F:/Documents/uscrime.txt", 
                     stringsAsFactors = FALSE, header=TRUE)

# Fit a linear regression model
lm_uscrime <- lm(Crime~., data = crimeData)

# Print a summary of the model, incl. AIC (which requries stats package)
lm_uscrime
summary(lm_uscrime)

library(stats)
AIC(lm_uscrime)
BIC(lm_uscrime)

# Create the test datapoint manually
test_point <- data.frame(M= 14.0, So = 0, Ed = 10.0, Po1 = 12.0, Po2 = 15.5,
                         LF = 0.640, M.F = 94.0, Pop = 150, NW = 1.1,
                         U1 = 0.120, U2 = 3.6, Wealth = 3200, Ineq = 20.1,
                         Prob = 0.040, Time = 39.0)

# Predict the crime rate for test data point
pred_model <- predict(lm_uscrime, test_point)
pred_model

# Check the spread of data
qqnorm(crimeData$Crime)

# Reduce crimeData to only significant factors t-value = 0, 0.001, 0.01 & 0.05 ...
#...M, Ed, Po1, U2, Ineq & Prob, along with Response
library(dplyr)
crimeDataReduced <- crimeData %>% select(M, Ed, Po1, U2, Ineq, Prob, Crime)

# Fit a linear regression model using only significant factors
lm_uscrime1 <- lm(Crime~., data = crimeDataReduced)

# Print model to console, AIC
lm_uscrime1
summary(lm_uscrime1)
AIC(lm_uscrime1)
BIC(lm_uscrime1)

# Create the test datapoint manually for significant factors only
test_point1 <- data.frame(M= 14.0, Ed = 10.0, Po1 = 12.0, U2 = 3.6, Ineq = 20.1, Prob = 0.040)

# Predict the crime rate for test data point for significant factors only
pred_model1 <- predict(lm_uscrime1, test_point1)
pred_model1

#### CROSS VALIDATION LINEAR REGRESSION ####

# Perform 4-fold CV with the linear model that was created earlier, load caret package
library(caret)

# Fit linear regression models using 4-fold cross validation
train_control <- trainControl(method="cv", number=4)

# Predict the crime rate for test data point using 4-fold cv lm
lm_uscrime2 <- train(Crime~.,
               data = crimeData,
               trControl=train_control,
               method = "lm")

# Print model to console with AIC
lm_uscrime2
summary(lm_uscrime2)

# Predict the crime rate for test data point with 4-fold cv lm model
pred_model2 <- predict(lm_uscrime2, test_point)
pred_model2

# Predict the crime rate for test data point using 4-fold cv lm for only significant factors
lm_uscrime3 <- train(Crime~.,
                data = crimeDataReduced,
                trControl=train_control,
                method = "lm")

# Print model to console with AIC
lm_uscrime3
summary(lm_uscrime3)

# Predict the crime rate for test data point with 4-fold cv lm model for significant factors only 
pred_model3 <- predict(lm_uscrime3, test_point1)
pred_model3
