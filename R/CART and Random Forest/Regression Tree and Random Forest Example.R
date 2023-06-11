## Regression Tree and Random Forest ##

# Clear environment
rm(list = ls())

# Setting the random number generator seed so that our results are reproducible
set.seed(1)

# First, read in the data

data <- read.table("F:/Documents/uscrime.txt", stringsAsFactors = FALSE, header = TRUE)

# Optional check to make sure the data is read correctly

head(data)

########################
### Examining Plots  ###
########################

#Plot some 2D graphs of the data to see if there is correlation or not

library(GGally)

ggpairs(data, columns = c("Po1", "Po2", "U1", "U2", "Ineq", "Wealth", "Crime"),
        mapping=ggplot2::aes(color= "#3366FF"))

#Look at the correlation matrix of the data

corr <- cor(data)
round(corr, 2)

############################
##### Regression Tree ######
############################

# Split 75% Data for Training and 25% for Testing. This will be used to compare model quality

trainIndex <- sample.int(n = nrow(data), size = floor(0.75*nrow(data)), replace = F)
train <- data[trainIndex,]
test <- data[-trainIndex,]

# create RMSE function to call

rmse = function(actual, predicted) {
  sqrt(mean((actual - predicted) ^ 2))
}

### Using 'tree' package ###

library(tree)

# Grow regression tree
model1 <- tree(Crime~., data=train, method="anova")

# Display results
summary(model1)
plot(model1)
text(model1, pretty=0)
title(main="Unpruned Regression Tree")

# Perform cross-validation on tree to determine optimal pruning (number of leaves/end nodes)
# requires interpretation of plot
model1.cv <- cv.tree(model1)
plot(model1.cv$size, sqrt(model1.cv$dev / nrow(train)), type = "b",
     xlab = "Tree Size", ylab = "CV-RMSE")

# From plot interpretation, prune regression tree to 2 leaves/end nodes
model1Prune = prune.tree(model1, best = 2)

# Display results
summary(model1Prune)
plot(model1Prune)
text(model1Prune, pretty=0)
title(main="Pruned Regression Tree")

# RMSE on training set
sqrt(summary(model1Prune)$dev / nrow(train))

predictionTrain1 = predict(model1Prune, newdata = train)
rmse(train$Crime, predictionTrain1)

# RMSE on test set
predictionTest1 = predict(model1Prune, newdata = test)
rmse(test$Crime, predictionTest1)

# And now calculate R^2 and adj R^2 on test set

SSE.1 = sum((predictionTest1 - test[,16])^2)
SStot.1 = sum((test[,16] - mean(test[,16]))^2)
R2.1 <- 1 - SSE.1/SStot.1
R2.1

R2.adj.1 = 1 - ((1 - R2.1)*(nrow(train)-1)/(nrow(train)-1-1))
R2.adj.1

### Using 'rpart' package ###

library(rpart)
library(rpart.plot)

# Grow regression tree
model2Grow <- rpart(Crime~., data=train, method="anova")

# Display results
summary(model2Grow)
rpart.plot(model2Grow)
title(main="Unpruned Regression Tree")
rsq.rpart(model2Grow)

# Determine 'cp' i.e. optimal complexity parameter for pruning
plotcp(model2Grow)
bestcp <- model2Grow$cptable[which.min(model2Grow$cptable[,"xerror"]),"CP"]

# Prune regression tree
model2Prune <- prune(model2Grow, cp = bestcp) 

# Display results
summary(model2Prune)
rpart.plot(model2Prune)
title(main="Pruned Regression Tree")
rsq.rpart(model2Prune)

# RMSE on training set
predictionTrain2 = predict(model2Prune, newdata = train)
rmse(train$Crime, predictionTrain2)

# RMSE on test set
predictionTest2 = predict(model2Prune, newdata = test)
rmse(test$Crime, predictionTest2)

# And now calculate R^2 and adj R^2 on test set

SSE.2 = sum((predictionTest2 - test[,16])^2)
SStot.2 = sum((test[,16] - mean(test[,16]))^2)
R2.2 <- 1 - SSE.2/SStot.2
R2.2

R2.adj.2 = 1 - ((1 - R2.2)*(nrow(train)-1)/(nrow(train)-1-1))
R2.adj.2

#########################
##### Random Forest #####
#########################

library(randomForest)

# Random forest, default: 500 trees
crime.rf <- randomForest(Crime~., data=train, importance=TRUE,proximity=TRUE)

# Display results
print(crime.rf)
plot(crime.rf)

# Random forest, re-run with 100 trees based on error vs ntrees
crime.rf <- randomForest(Crime~., data=train, importance=TRUE, proximity=TRUE, ntree=100)

# Display results
print(crime.rf)
plot(crime.rf)

# RMSE on training set
predictionTrain.rf = predict(crime.rf, newdata = train)
rmse(train$Crime, predictionTrain.rf)

# RMSE on test set
predictionTest.rf = predict(crime.rf, newdata = test)
rmse(test$Crime, predictionTest.rf)

# And now calculate R^2 and adj R^2 on test set

SSE.rf = sum((predictionTest.rf - test[,16])^2)
SStot.rf = sum((test[,16] - mean(test[,16]))^2)
R2.rf <- 1 - SSE.rf/SStot.rf
R2.rf

R2.adj.rf = 1 - ((1 - R2.rf)*(nrow(train)-1)/(nrow(train)-15-1))
R2.adj.rf

# Look at variable importance
round(importance(crime.rf), 2)
