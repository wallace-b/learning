# load outliers package for grubbs.test
library(outliers)

# read data into R
crimeData=read.table("F:/Documents/uscrime.txt",header=TRUE)

# run grubbs.test on last column (number of crimes per 100,000 people)
grubbs.test(crimeData$Crime, type=10)
grubbs.test(crimeData$Crime, type=10, opposite = TRUE)
grubbs.test(crimeData$Crime, type=11)
# type=10 is a test for one outlier (as default, searches for right tailed test....
# ... and can search for left tailed test by opposite parameter). 
# type=11 is a test for two outliers on opposite tails
# m, nrows = 47 i.e. 46 degrees of freedom (n-1), Grubb's critical value = 2.923 for 95% CI

# explore data to see left tail outlier is min and right tail outlier is max
which.min(crimeData$Crime)
min(crimeData$Crime)
which.max(crimeData$Crime)
max(crimeData$Crime)

