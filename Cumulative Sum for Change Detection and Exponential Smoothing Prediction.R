# read data into R
tempData=read.table("F:/Documents/temps.txt",header=TRUE)

# extract number of rows and columns
n = nrow(tempData)
m = ncol(tempData) 

#====================CUSUM for Change Detection of End of Unofficial Summer=================

# set t, threshold value
t = 25

# set C, correction factor
C = 5

# copy the data structure of tempData and replace all data points...
#...except date with 0's. CUSUM calculations (St) will be inserted...
#...for each day of each year
cusum <- tempData
cusum[,2:m]=0
# create an index col for dates i.e. 1-Jul = 1, 2-Jul = 2,..., 28-Sept = 90 etc.
index <- 1:n
# bind index col to cusum
cusum <- cbind(index,cusum)

# create a df to store the first day when St > T for each year, initialize with 0's
summerEnd = data.frame("Year" = c(1996,1997,1998,1999,2000,2001,2002,2003,
                         2004,2005,2006,2007,2008,2009,2010,2011,
                         2012,2013,2014,2015),
                       "Unofficial End of Summer Index" = rep(0,m-1),
                       "Unofficial End of Summer Date" = rep(0,m-1))

# loop for each year x=1996,1997,...,2015
for (x in 2:m){
  
  # initialize s at step 0 = 0
  s = 0
  
  # calculate mean temp for each year using first 30 days of temps (July Only)
  u = mean(tempData[1:31,x])
  
  # loop for each row - day from July through to October
  for (i in 1:n){
    s = max(0, s + u - tempData[i,x] - C) # calc St
    cusum[i,x+1] = s # insert St into 
    test = summerEnd[x-1,2] # insert St into CUSUM df
    
    # logical test to insert first day (index and date) when St > T
    if (s>t & test==0) summerEnd[x-1,2] = (cusum[i,1]) else 0
    if (s>t & test==0) summerEnd[x-1,3] = toString(cusum[i,2]) else 0
  }
}
# print results
print(summerEnd)

#========================Holt Winters for Forecasting=======================
# load package 'forecast'
library(forecast)

# create 1-dimensional vector for HoltWinters fn containing unofficial end of summer...
#...dates as numbers from tempData index
summerEndVector = summerEnd[,2]

# run HoltWinters fn - double exponential smoothing with no seasonality...
#...alpha, beta = NULL for autoregression optimization
# include trend as we are looking for upward or downward trend in early or late summers...
#...occurring over time
# no seasonality as there is no peak/trough pattern in 20 years of unofficial end....
#...of summer dates
model = HoltWinters (summerEndVector, alpha = NULL, beta = NULL, gamma = FALSE, l.start=64, b.start=23)

# show and plot results
model
plot(model[["fitted"]])
plot(model)

# forecast model prediction and plot
plot(forecast(model))