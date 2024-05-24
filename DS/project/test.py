# def GCD(A, B):
#     if A%B == 0:
#         return B
#     return GCD(B, A%B)

# def LCM(A, B):
#     return (A*B)/GCD(A,B)
    
# m = 2

# GCD(2024, 1000 + m) # --> output: 2

# LCM(2024, 1000+m)  # --> output: 1014024.0

# 1b

n = 5
x = 0
output = []

while  n > 0:
    
    y = (2 - 2024*x)/1002

    if y.is_integer():
        output.append((x,y))
        n = n - 1
        
    x +=1

print(output)

# (x,y) = [(451, -911.0), (952, -1923.0), (1453, -2935.0), (1954, -3947.0), (2455, -4959.0)]