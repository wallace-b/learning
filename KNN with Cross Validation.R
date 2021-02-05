# load package kknn
library(kknn)

# read data into R
myData=read.table("F:/Documents/credit_card_data-headers.txt",header=TRUE)

#Set seed to produce reproducible results
set.seed(101)

# to test for 1 to 'kn' nearest neighbors
kn <- 50

# create vector of kn rows, 1 column filled with zeros to store results of...
# individual accuracy calculations by kknn model
accuracy <- rep(0,kn)
resultsMeanAbsError <- rep(0,kn)
resultsMeanSqError <- rep(0,kn)

# start loop testing for 'k' nearest neighbors, where k=1,2,3,...,kn
for (x in 1:kn){
  
  # for each row, estimate its response based on the other rows, omitting itself...
  # ...as its own nearest neighbor
  
  model=cv.kknn(R1~.,myData,
                kcv=10, # 10-fold cross-validation
                k=x, # x nearest neighbors
                scale = TRUE) # scale data
   
  # extract Predictive Accuracy, Mean Absolute Errors and Root Mean Squared Error...
  # ...for kn nearest neighbor model 10-fold cv 
  a <- model[[1]]
  a1 <- as.integer(a[,2]+0.5)
  b <- model[[2]]
  accuracy[x] = sum(a1 == myData[,11])/ nrow(myData)
  resultsMeanSqError[x] <- b[1]
  resultsMeanAbsError[x] <- b[2]
  
  
}
#plot results and find at which kn value max occurs
plot(accuracy, xlab = "value of k", ylab = "Accuracy")
title("K-Nearest-Neighbors")
max(accuracy)
which.max(accuracy)

plot(resultsMeanSqError, xlab = "value of k", ylab = "Root Mean Squared Error")
title("K-Nearest-Neighbors")
min(resultsMeanSqError)
which.min(resultsMeanSqError)

plot(resultsMeanAbsError, xlab = "value of k", ylab = "Mean Absolute Error")
title("K-Nearest-Neighbors")
min(resultsMeanAbsError)
which.min(resultsMeanAbsError)

plot(resultsMeanSqError+resultsMeanAbsError, xlab = "value of k", ylab = "RMSE+MAE")
title("K-Nearest-Neighbors")
min(resultsMeanSqError+resultsMeanAbsError)
which.min(resultsMeanSqError+resultsMeanAbsError)