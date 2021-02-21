# -------------------- Logistic Regression for Classification  -----------------------------
# -------------------- Confusion Matrices produced with Thresholds -------------------------
# Clear environment
rm(list = ls())

# Setting the random number generator seed so that our results are reproducible
set.seed(1)

# First, read in the data
data <- read.table("F:/Working/germancredit.txt", stringsAsFactors = FALSE, header = FALSE)
data[,21] = as.integer(abs(data[,21]-2))

# Check structure of columns
str(data)

# Change relevant categorical columns to factor
data$V1 <- factor(data$V1)
data$V3 <- factor(data$V3)
data$V4 <- factor(data$V4)
data$V6 <- factor(data$V6)
data$V7 <- factor(data$V7)
data$V9 <- factor(data$V9)
data$V10 <- factor(data$V10)
data$V12 <- factor(data$V12)
data$V14 <- factor(data$V14)
data$V15 <- factor(data$V15)
data$V17 <- factor(data$V17)
data$V18 <- factor(data$V18)
data$V19 <- factor(data$V19)
data$V20 <- factor(data$V20)

# re-check structure of columns
str(data)

# Optional check to make sure the data is read correctly
head(data)

# Check how many unique values there are for each predictor
sapply(data, function(x) length(unique(x)))

# Split 80% Data for Training and 20% for Testing. This will be used to compare model quality
trainIndex <- sample.int(n = nrow(data), size = floor(0.80*nrow(data)), replace = F)
train <- data[trainIndex,]
test <- data[-trainIndex,]

#########################
#### Logit Function  ####
#########################

# run Logistic Regression on training data
model1 <- glm(V21~., data=train, family=binomial(link="logit"))

# results
summary(model1)
coef(model1) # coefficients
confint(model1) # 95% CI for the coefficients

# we can also exponentiate the coefficients and interpret them as odds-ratios, ignore exp(intercept)
exp(coef(model1)) # exponentiated coefficients 
exp(confint(model1)) # 95% CI for exponentiated coefficients

predict1 <- predict(model1, type="response", newdata = test) # predictions
#predict1

residuals(model1, type="deviance") # residuals 

pseudoR2.1 = 1 - model1$deviance / model1$null.deviance # pseudo R^2
pseudoR2.1

# Reduce logit function to significant factors V1, V2, V3, V4, V5, V6, V8, V9, V10, V12, V13, V14, V20 ...
# ... and response V21

data.trim <- data[c(1:6,8:10,12:14,20:21)]

str(data.trim)

train.trim <- train[c(1:6,8:10,12:14,20:21)]
test.trim <- test[c(1:6,8:10,12:14,20:21)]

# run Logistic Regression on trimmed training data
model2 <- glm(V21~., data=train.trim, family=binomial(link="logit"))

# results
summary(model2)
coef(model2) # coefficients
confint(model2) # 95% CI for the coefficients

# can also exponentiate the coefficients and interpret them as odds-ratios, ignore exp(intercept)
exp(coef(model2)) # exponentiated coefficients 
exp(confint(model2)) # 95% CI for exponentiated coefficients

predict2 <- predict(model2, type="response", newdata = test.trim) # predictions
#predict2

residuals(model2, type="deviance") # residuals 

pseudoR2.2 = 1 - model2$deviance / model2$null.deviance # pseudo R^2
pseudoR2.2

# Ultimately, I do not believe it was worth reducing the amount of predictors

#########################
### Setting Threshold ###
#########################

library(caret)
library(e1071)

# test for a range of probability thresholds and print out confusion matrix from e1071 package
threshold1 = 0.50

classification1.1 <- factor(ifelse(predict1 < threshold1, 0, 1))
classification2.1 <- factor(ifelse(predict2 < threshold1, 0, 1))
observed <- factor(test[,21])

results1.1 <- confusionMatrix(data=classification1.1, reference=observed)
print(results1.1)

results2.1 <- confusionMatrix(data=classification2.1, reference=observed)
print(results2.1)

threshold2 = 0.60

classification1.2 <- factor(ifelse(predict1 < threshold2, 0, 1))
classification2.2 <- factor(ifelse(predict2 < threshold2, 0, 1))

results1.2 <- confusionMatrix(data=classification1.2, reference=observed)
print(results1.2)

results2.2 <- confusionMatrix(data=classification2.2, reference=observed)
print(results2.2)

threshold3 = 0.70

classification1.3 <- factor(ifelse(predict1 < threshold3, 0, 1))
classification2.3 <- factor(ifelse(predict2 < threshold3, 0, 1))

results1.3 <- confusionMatrix(data=classification1.3, reference=observed)
print(results1.3)

results2.3 <- confusionMatrix(data=classification2.3, reference=observed)
print(results2.3)

threshold4 = 0.80

classification1.4 <- factor(ifelse(predict1 < threshold4, 0, 1))
classification2.4 <- factor(ifelse(predict2 < threshold4, 0, 1))

results1.4 <- confusionMatrix(data=classification1.4, reference=observed)
print(results1.4)

results2.4 <- confusionMatrix(data=classification2.4, reference=observed)
print(results2.4)

threshold5 = 0.90

classification1.5 <- factor(ifelse(predict1 < threshold5, 0, 1))
classification2.5 <- factor(ifelse(predict2 < threshold5, 0, 1))

results1.5 <- confusionMatrix(data=classification1.5, reference=observed)
print(results1.5)

results2.5 <- confusionMatrix(data=classification2.5, reference=observed)
print(results2.5)
 