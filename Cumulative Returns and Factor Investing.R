library(PerformanceAnalytics)
library(xts)
library(lubridate)

fund <- read.csv("F:/Documents/contrafund.csv")
fund$Date <- mdy(fund$Date)
fund2 <- fund[order(fund$Date),]

All.dat <- xts(fund2[,-1],order.by=fund2[,1],)

#Calculate Compound Return for the fund across all the data
Return.cumulative(All.dat$ContraRet,geometric = TRUE)


#Cumulative Returns chart over time
#Check chart in Plots Tab on bottom right in R Studio
chart.CumReturns(All.dat$ContraRet,wealth.index = FALSE, geometric = TRUE)

table.Stats(All.dat$ContraRet)

Mod1 <- lm(ContraRet~Market.Return, data=All.dat)
summary(Mod1)

chart.Drawdown(All.dat$ContraRet)
table.Drawdowns(All.dat$ContraRet,top=5,digits=4)


fund_su3 <- read.csv("F:/Documents/factors.csv")
fund_su3$Date <- mdy(fund_su3$Date)
fund_su3_1 <- fund_su3[order(fund_su3$Date),]

All.dat2 <- xts(fund_su3_1[,-1],order.by=fund_su3_1[,1],)

model1 <- lm(Brk_exret~Mkt_rf,data=All.dat2)
summary(model1)

model2 <- lm(Brk_exret~Mkt_rf+SMB+HML,data=All.dat2)
summary(model2)

model3 <- lm(Brk_exret~Mkt_rf+SMB+HML+Mom+BAB+QMJ,data=All.dat2)
summary(model3)

#QMJ: Quality Factor

#BAB: Betting against beta factor

#MOM: Momentum factor

All.dat<-xts(fund2[,-1],order.by=fund2[,1],)

Return.cumulative(All.dat, geometric =TRUE)
chart.CumReturns(All.dat, wealth.index =FALSE, geometric = TRUE)

SharpeRatio(All.dat$ContraRet,All.dat$Risk.Free)
TreynorRatio(All.dat$ContraRet,All.dat$Market.Return,All.dat$Risk.Free)

All.dat<-transform(All.dat,MktExcess=Market.Return-Risk.Free,FundExcess=ContraRet-Risk.Free)

Alpha=lm(FundExcess~MktExcess,data=All.dat)
summary(Alpha)

