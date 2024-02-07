import random

# a)
def roll_two_dice(n):
    X = []
    for i in range(1,n,1):
        x = random.randint(1,6)
        y = random.randint(1,6)
        X.append(str(x) + ' ' + str(y))
    return X
x = roll_two_dice(10000)
# b) 
def sum_two_dice(n):
    X = []
    for i in range(n):
        x = random.randint(1,6)
        y = random.randint(1,6)
        X.append(x+y)
    return X
X = sum_two_dice(10000)
# c)
set_X = list(set(X))
P = [X.count(value)/10000 for value in set_X]

import statistics as st
# d) 

mu = Exp = st.mean(X)
sigma_2 = var = st.variance(X)
sigma = devia = st.stdev(X)

# 2
import math
import matplotlib.pyplot as plt
from math import pi, e
# a)
def normal_pdf(x, mu, sigma_2):
    return (1/math.sqrt(2*pi*sigma_2))*e**(-(x-mu)**2/2*sigma_2)
print(X)
Set_X = list(set(X))
print(Set_X)
Set_Y = [normal_pdf(value,mu, sigma_2) for value in Set_X]
plt.plot(Set_X,Set_Y)

plt.show()

# b) 

def normal_cdf(x, mu, sigma):
    return (1/2)*(1 + math.erf(x - mu)/sigma*math.sqrt(2))
    
Y = [normal_cdf(value,mu, sigma_2) for value in X]
# plt.plot(X,Y)
# plt.show()

# c) P(2 < X < 7) <=> P(-1/4 < Z < 1)
mu = 3
sigma_2 = 16
P = normal_cdf(1, mu, math.sqrt(sigma_2)) -(1 - normal_cdf(-1/4, mu, math.sqrt(sigma_2)))

