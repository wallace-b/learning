# read data into R
tempData=read.table("F:/Documents/temps.txt",header=TRUE)

# extract number of rows and columns
n = nrow(tempData)
m = ncol(tempData) 

# set t, threshold value
t = 25

# set C, correction factor
C = 5

# copy the data structure of tempData and replace all data points...
#...except date with 0's. CUSUM calculations (St) will be inserted...
#...for each day of each year
cusum <- tempData
cusum[,2:m]=0

# create a df to store the first day when St > T for each year, initialize with 0's
summerEnd = data.frame("Year" = c(1996,1997,1998,1999,2000,2001,2002,2003,
                         2004,2005,2006,2007,2008,2009,2010,2011,
                         2012,2013,2014,2015),
                       "Unofficial End of Summer" = rep(0,m-1) )

# loop for each year x=1996,1997,...,2015
for (x in 2:m){
  
  # initialize s at step 0 = 0
  s = 0
  
  # calculate mean temp for each year using first 30 days of temps (July Only)
  u = mean(tempData[1:31,x])
  
  # one could potentially use a mean of 'summer' months only (not used in this run)
  # u1 = mean(tempData[1:62,x]) 
  
  # loop for each row - day from July through to October
  for (i in 1:n){
    s = max(0, s + u - tempData[i,x] - C) # calc St
    cusum[i,x] = s # insert St into 
    test = summerEnd[x-1,2] # insert St into CUSUM df
    
    # logical test to insert first day when St > T
    if (s>t & test==0) summerEnd[x-1,2] = toString(cusum[i,1]) else 0 
  }
}

# print results
print(summerEnd)
x = matrix(c(64,87,91,83,68,87,86,92,77,100,75,104,80,79,90,68,50,48,90,76))
model = HoltWinters (x, alpha = 0.7, beta = 0.8, gamma = FALSE, )
y <- model[["fitted"]]
