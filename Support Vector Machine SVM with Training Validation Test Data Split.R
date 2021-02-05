# load package kernlab
library(kernlab)

# read data into R
myData=read.table("F:/Documents/! IMPORTANT/ISYE 6501/Working/credit_card_data-headers.txt",header=TRUE)


#Set seed to produce reproducible results
set.seed(99)

# set % of data set to be set for training data set  
trainprop = 0.6

# select 60% (trainprop) of data as training, rest to be split equally for validation and test data
sample1 <- sample.int(n = nrow(myData), size = floor(trainprop*nrow(myData)), replace = FALSE)
training <- myData[sample1,]

valAndTest <- myData[-sample1,]
sample2 <- sample.int(n = nrow(valAndTest), size = floor(0.5*nrow(valAndTest)), replace = FALSE)

validation <- valAndTest[sample2,]
test <- valAndTest[-sample2,]

# create vector of 6 rows, 1 column filled with zeros to store results of...
# ...6 different kvsm models
results <- rep(0,6) 

  # train ksvm model 1. Vanilladot is a simple linear kernel.
  model1 <- ksvm(R1~., data=training, type="C-svc", kernel="vanilladot",C=1,scaled=TRUE)
    # see what the model predicts for validation set
  pred1 <- predict(model1, validation[,-11])
    # see what fraction of the model's predictions match the actual classification for validation set
  results[1] = sum(pred1 == validation[,11]) / nrow(validation)

  # train ksvm model 2. Vanilladot is a simple linear kernel.
  model2 <- ksvm(R1~., data=training, type="C-svc", kernel="vanilladot",C=50,scaled=TRUE)
    # see what the model predicts for validation set
  pred2 <- predict(model2, validation[,-11])
    # see what fraction of the model's predictions match the actual classification for validation set
  results[2] = sum(pred2 == validation[,11]) / nrow(validation)  
  
  # train ksvm model 3. Vanilladot is a simple linear kernel.
  model3 <- ksvm(R1~., data=training, type="C-svc", kernel="vanilladot",C=100,scaled=TRUE)
    # see what the model predicts for validation set
  pred3 <- predict(model3, validation[,-11])
    # see what fraction of the model's predictions match the actual classification for validation set
  results[3] = sum(pred3 == validation[,11]) / nrow(validation)  
  
  # train ksvm model 4. Rbfdot is a non-linear kernel.
  model4 <- ksvm(R1~., data=training, type="C-svc", kernel="rbfdot",C=50,scaled=TRUE)
  # see what the model predicts for validation set
  pred4 <- predict(model4, validation[,-11])
  # see what fraction of the model's predictions match the actual classification for validation set
  results[4] = sum(pred4 == validation[,11]) / nrow(validation)  
  
  # train ksvm model 5. Laplacedot is a non-linear kernel.
  model5 <- ksvm(R1~., data=training, type="C-svc", kernel="laplacedot",C=50,scaled=TRUE)
  # see what the model predicts for validation set
  pred5 <- predict(model5, validation[,-11])
  # see what fraction of the model's predictions match the actual classification for validation set
  results[5] = sum(pred5 == validation[,11]) / nrow(validation)
  
  # train ksvm model 6. Tanhdot is a non-linear kernel.
  model6 <- ksvm(R1~., data=training, type="C-svc", kernel="tanhdot",C=50,scaled=TRUE)
  # see what the model predicts for validation set
  pred6 <- predict(model6, validation[,-11])
  # see what fraction of the model's predictions match the actual classification for validation set
  results[6] = sum(pred6 == validation[,11]) / nrow(validation)

# plot comparison of model performance to select 'best' model
plot(results, xlab = "Model #", ylab = "Accuracy using Validation Set")
title("Support Vector Machine")
print(results)

# Chosen Model Parameters and Accuracy

# calculate a1.am
a <- colSums(model3@xmatrix[[1]] * model3@coef[[1]])
a
# calculate a0
a0 <- model3@b
a0

trueacc <- predict(model3, test[,-11])
#see what fraction of the chosen model's predictions match the actual classification for test set
sum(trueacc == test[,11]) / nrow(test)