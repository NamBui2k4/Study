x =[61, 74, 128, 106, 59, 45, 83, 69, 125, 25, 52, 94, 143, 119, 92]
a = 0
from statistics import mean
import math

from statistics import mean
from statistics import variance
import math 

from statistics import stdev
# print(mean(x))
# print(stdev(x))
# print(variance(x))

x = [49, 105, 61, 34, 59, 143, 87, 40, 138, 128, 102, 91, 125, 25, 92,
 68, 118, 66, 124, 144, 131, 130, 146, 59, 44, 138, 99, 123, 77, 88
]
# print(mean(x))

_x = mean(x)
for i in x:
    a+= (i-_x)**2/(len(x)-1)
print(stdev(x))
print(math.sqrt(a))