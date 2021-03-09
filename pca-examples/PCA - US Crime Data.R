### Summary ###
# I built on to the code and examples presented in. I explored the use of multiple PC's in the linear
# regression models in order to improve upon the poor adjusted R^2 achieved using only a few PC's. I also investigated
# the amount of error, as well as AIC & BIC. I also ran 10-fold CV on the 6 PC's Linear Reg model. The discussion is below.

# Performing matrix operations in R for PCA was somewhat of a challenge, so you will have to forgive me for writing 
# some operations line-by-line and even instances of double-checking calculations, which makes my code larger than it has to be.

### Results ###
# I selected a linear regression model utilizing 6 principal components and 10 fold CV. 
# The coefficients for each of the 15 factors are listed as 'a' in the code (a1, a2, a3...., a15).

# The prediction for the provided test data point with this selected model was Crime = 1248.427, compared with my last
# week's homework result of Crime = 1304.245 

### Discussion ###
# Based on the screeplot of each principal component vs variance, I created models for 4 and 6 PC's, given that this is where
# the addition of more PC's adds less variance to the models. 
# I then compared 15 and 12 PC's to investigate the trade-off for model quality / improving Adjusted R^2.
# For 4 PC's Adjusted R^2 = 0.2433 and Residual Standard Error = 336.4, AIC = 687.0241, BIC = 698.125

# For 6 PC's R^2 = 0.6586, Adjusted R^2 = 0.6074 and Residual Standard Error = 242.3, AIC = 657.8925, BIC = 672.6936

# For 6 PC's 10-fold CV R^2 = 0.5947805, MAE = 220.1389 & RMSE = 259.8227. Not unsurprisingly, R^2 is less when performing CV)

# For 15 PC's Adjusted R^2 = 0.7078 and Residual Standard Error = 209.1, AIC = 650.0291, BIC = 681.4816
# Using all 15 PC's simply results in a Linear Regression model the same as using all 15 factors like last week's homework.
# We have simply put it through some superfluous transformation and not actually reduced the dimensionality of the model at all.
# The measures of quality are actually the same as using all 15 factors in a basic Linear Regression model using all the 
# data for training. From last week, we also know this model is overfitting the data.

# For 12 PC's Adjusted R^2 = 0.6878 and Residual Standard Error = 216.1, AIC = 651.4788, BIC = 677.3808

# I believe the Adjusted R^2 value is very low for utilizing only 4 PC's because every PC is composed of the original 15 factors.
# Therefore, for every PC omitted, some proportion of the highly significant predictors (identified last week) is actually being
# omitted from the model behaviour to predict the response.
# Thankfully, it jumps up to more 'expected' values at 6 PC's and greater.

# Interestingly, BIC is lowest for 6 PC's Linear Regression, but AIC is lowest for using all 15 PC's.

### Code ###
# Clear environment.
rm(list = ls())

# Setting the random number generator seed so that our results are reproducible.
set.seed(101)

#First, Read in the data
usCrime <- read.table("F:/Documents/uscrime.txt", stringsAsFactors = FALSE, header = TRUE)

# optional check to make sure the data is read correctly.
head(usCrime)
summary(usCrime)

# This is one way to examine some of the correlation in the data.
# This is a visualization of a subset of the correlation matrix of the data.
library(GGally)
ggpairs(usCrime, columns = c("Po1", "Po2", "U1", "Pop", "Ineq"))

# Run PCA on the matrix of SCALED predictors.
PCA <- prcomp(usCrime[,1:15], scale. = TRUE)
summary(PCA)

# pca$rotation is the matrix of eigenvectors. The Linear transformation used = rotation matrix (XtX)
rotation <- PCA$rotation

# pca$center is the lateral shift required to have mean / center = 0 used for data scaling.
# i.e. the mean for each data factor given the provided data set.
center <- PCA$center

# calculate sdev for each factor
sdev <- rbind(sd(usCrime[,1]),sd(usCrime[,2]),sd(usCrime[,3]),sd(usCrime[,4]),
              sd(usCrime[,5]),sd(usCrime[,6]),sd(usCrime[,7]),sd(usCrime[,8]),
              sd(usCrime[,9]),sd(usCrime[,10]),sd(usCrime[,11]),sd(usCrime[,12]),
              sd(usCrime[,13]),sd(usCrime[,14]),sd(usCrime[,15]))

# We can use the screeplot function to plot the variances of each of the principal components 
# (where variance = pca$sdev^2) to help us to decide on a number of principal components to use.
screeplot(PCA,type="lines",col="blue")

# Select first 4 principal component as there is minimal variance gained for at >4 PC's for each additional PC added.
PC1 <- PCA$x[,1:4]
PC1

# Build a linear regression model with the first 4 principal components.
usCrimePC1 <- cbind(PC1, usCrime[,16])
modelPCA1 <- lm(V5~., data = as.data.frame(usCrimePC1))
modelPCA1
summary(modelPCA1)
AIC(modelPCA1)
BIC(modelPCA1)

# Select first 6 principal component as there is minimal variance gained for at >6 PC's for each additional PC added.
PC2 <- PCA$x[,1:6]
PC2

# Build a linear regression model with the first 6 principal components.
usCrimePC2 <- cbind(PC2, usCrime[,16])
modelPCA2 <- lm(V7~., data = as.data.frame(usCrimePC2))
modelPCA2
summary(modelPCA2)
AIC(modelPCA2)
BIC(modelPCA2)

#### CROSS VALIDATION LINEAR REGRESSION ####
# Perform 10-fold CV with the linear model that was created earlier, load caret package
library(caret)

# Build linear regression models using 10-fold cross validation
train_control <- trainControl(method="cv", number=10)

modelPCA2CV <- train(V7~.,
                     data = as.data.frame(usCrimePC2),
                     trControl=train_control,
                     method = "lm")
modelPCA2CV
summary(modelPCA2CV)

# Predict the crime rate for test data point using 10-fold cv lm

coefficients <- modelPCA2CV$finalModel$coefficients[2:7]
b0 <- modelPCA2CV$finalModel$coefficients[1]

# calculate scaled regression coefficients factor by factor for k=1 to 6 principal components

scaledCoeff1 <- coefficients*rotation[1,1:6]
scaledCoeff2 <- coefficients*rotation[2,1:6]
scaledCoeff3 <- coefficients*rotation[3,1:6]
scaledCoeff4 <- coefficients*rotation[4,1:6]
scaledCoeff5 <- coefficients*rotation[5,1:6]
scaledCoeff6 <- coefficients*rotation[6,1:6]
scaledCoeff7 <- coefficients*rotation[7,1:6]
scaledCoeff8 <- coefficients*rotation[8,1:6]
scaledCoeff9 <- coefficients*rotation[9,1:6]
scaledCoeff10 <- coefficients*rotation[10,1:6]
scaledCoeff11 <- coefficients*rotation[11,1:6]
scaledCoeff12 <- coefficients*rotation[12,1:6]
scaledCoeff13 <- coefficients*rotation[13,1:6]
scaledCoeff14 <- coefficients*rotation[14,1:6]
scaledCoeff15 <- coefficients*rotation[15,1:6]

scaledCoeffs <- rbind(scaledCoeff1,scaledCoeff2,scaledCoeff3,scaledCoeff4,
                      scaledCoeff5,scaledCoeff6,scaledCoeff7,scaledCoeff8,
                      scaledCoeff9,scaledCoeff10,scaledCoeff11,scaledCoeff12,
                      scaledCoeff13,scaledCoeff14,scaledCoeff15)

a_scaled <- rowSums(scaledCoeffs)
a_scaled
a <- a_scaled/sdev
# coefficients for the original 15 factors for the selected model
a
a0_subtractions <- a*center
a0 <- b0 - sum(a0_subtractions)
# intercept (unscaled)
a0

# Create the test datapoint manually
test_point <- data.frame(M= 14.0, So = 0, Ed = 10.0, Po1 = 12.0, Po2 = 15.5,
                         LF = 0.640, M.F = 94.0, Pop = 150, NW = 1.1,
                         U1 = 0.120, U2 = 3.6, Wealth = 3200, Ineq = 20.1,
                         Prob = 0.040, Time = 39.0)

# Predict the crime rate for test data point
prediction = a0 + sum(a*test_point)
prediction
# Double Check Matrix Multiplication for predictiom
prediction1 = a0 + a[1]*test_point[1] + a[2]*test_point[2] + a[3]*test_point[3] + + a[4]*test_point[4] +
  a[5]*test_point[5] + a[6]*test_point[6] + + a[7]*test_point[7] + a[8]*test_point[8] + a[9]*test_point[9] +
  a[10]*test_point[10] + a[11]*test_point[11] + a[12]*test_point[12] + a[13]*test_point[13] + a[14]*test_point[14] +
  a[15]*test_point[15]
prediction1

# Cross-check result by instead scaling the test point
test_point_scaled <- (test_point-center)/sdev
predictionCC = b0+sum(a_scaled*test_point_scaled)
predictionCC

# Select all principal components for Linear Regression for analysis / comparison with last week's results
PC3 <- PCA$x

# Build a linear regression model with the 15 principal components.
usCrimePC3 <- cbind(PC3, usCrime[,16])
modelPCA3 <- lm(V16~., data = as.data.frame(usCrimePC3))
modelPCA3
summary(modelPCA3)
AIC(modelPCA3)
BIC(modelPCA3)
# R^2 = 0.8031 & Adj R^2 = 0.7078 is equivalent to running basic Linear Regression as per last week for all 15 factors.

# Select 12 principal components for Linear Regression for analysis / comparison with last week's results
PC4 <- PCA$x[,1:12]

# Build a linear regression model with the first 12 principal components.
usCrimePC4 <- cbind(PC4, usCrime[,16])
modelPCA4 <- lm(V13~., data = as.data.frame(usCrimePC4))
modelPCA4
summary(modelPCA4)
AIC(modelPCA4)
BIC(modelPCA4)

