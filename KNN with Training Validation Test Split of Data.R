# load package kknn
library(kknn)

# read data into R
myData=read.table("F:/Documents/! IMPORTANT/ISYE 6501/Working/credit_card_data-headers.txt",header=TRUE)

#Set seed to produce reproducible results
set.seed(101)

# set % of data set to be set for training data set  
trainprop = 0.6

# select 60% (trainprop) of data as training, rest to be split equally for validation and test data
sample1 <- sample.int(n = nrow(myData), size = floor(trainprop*nrow(myData)), replace = FALSE)
training <- myData[sample1,]

valAndTest <- myData[-sample1,]
sample2 <- sample.int(n = nrow(valAndTest), size = floor(0.5*nrow(valAndTest)), replace = FALSE)

validation <- valAndTest[sample2,]
test <- valAndTest[-sample2,]

# to test for 1 to 'kn' nearest neighbors
kn=50

# create vector of kn rows, 1 column filled with zeros to store results of...
# individual accuracy calculations by kknn model
results <- rep(0,kn)

# start loop testing for 'k' nearest neighbors, where k=1,2,3,...,kn
for (x in 1:kn){
  
  # run k-nearest neighbor model for x nearest neighbors using training and validation data
  model=kknn(R1~.,training, validation, k=x, distance=2, scale = TRUE)
    
  # rounding of cts proportion of nearby 1's output by model to 0 or 1
  predicted <- as.integer(fitted(model)+0.5)  
  
  # logical test comparing prediction to Response values (R1) divided by m rows to calc accuracy
  accuracy = sum(predicted == validation[,11]) / nrow(validation)
  
  # store results of this round of accuracy calculations at 'i' to results vector at 'x'
  results[x] <- accuracy
}
# plot results and find at which kn value max occurs
plot(results, xlab = "value of k", ylab = "Accuracy")
title("K-Nearest-Neighbors")
max(results)
which.max(results)
chosen = which.max(results)

# use test data set to evaluate performance of chosen model
cModel=kknn(R1~.,training, test, k=chosen, distance=2, scale = TRUE)
cPredicted <- as.integer(fitted(cModel)+0.5)
cAccuracy = sum(cPredicted == test[,11]) / nrow(test)
print(cAccuracy)