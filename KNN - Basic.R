# load package kknn
library(kknn)

# read data into R
myData=read.csv("credit_card_data-headers.csv",header=TRUE)

#Set seed to produce reproducible results
set.seed(1)

# m = number of rows in data set (data points)
# n = number
m <- nrow(myData)
n <- ncol(myData)

# to test for 1 to 'kn' nearest neighbors
kn <- 50

# create vector of kn rows, 1 column filled with zeros to store results of...
# individual accuracy calculations by kknn model
results <- rep(0,kn)

# start loop testing for 'k' nearest neighbors, where k=1,2,3,...,kn
for (x in 1:kn){
  
  # create vector of m rows, 1 column filled with zeros to store 0 or 1 prediction by model
  predicted <- rep(0,m) 
  
  # for each row, estimate its response based on the other rows, omitting itself...
  # ...as its own nearest neighbor
  for (i in 1:m){ 
      model=kknn(R1~.,myData[-i,],myData[i,],k=x, scale = TRUE)
      
      # rounding of cts proportion of nearby 1's output by model to 0 or 1
      predicted[i] <- as.integer(fitted(model)+0.5)  
  }
  
  # logical test comparing prediction to Response values (R1) divided by m rows to calc accuracy
  accuracy = sum(predicted == myData[,11]) / m
  
  # store results of this round of accuracy calculations at 'i' to results vector at 'x'
  results[x] <- accuracy
}
# plot results and find at which kn value max occurs
plot(results, xlab = "value of k", ylab = "Accuracy")
title("K-Nearest-Neighbors")
max(results)
which.max(results)