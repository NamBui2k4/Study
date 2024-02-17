import numpy as np

a = np.array([[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]])

# Loại bỏ hàng thứ 0
print( np.delete(a, 0, axis= 0))

# loại bỏ cột thứ 1
print( np.delete(a, 2, axis=1))





