import numpy as np

# g = np.arange(18)
# print(g)
# print("Rank:", g.ndim)

g = np.arange(18)
print(g)
print("Rank", g.ndim)

g.shape = (6,3)
g.reshape(6,2)
print(g)