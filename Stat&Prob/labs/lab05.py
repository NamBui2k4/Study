


# ex01
import numpy as np
x = list(np.random.choice([0,1,2,3,4,5], 3650, p = [0.1, 0.2, 0.3, 0.2, 0.15, 0.05]))
np.set_printoptions(threshold = np.inf)
print(x)

# a)
domain = set(x)
X = set(x)
print("random variable: ", X)

# b)
P = [x.count(i)/len(x) for i in domain]
print("probability distribution function: " , P )

# c)

EX =0
for i in X:
    EX += i*P[i]
print("Expectation: ", EX)

# d)
P_3 = 0
P_3 = sum([x.count(i)/len(x) for i in domain if i >=3])
print("probability of having 3 or more emergency cases: ", P_3)