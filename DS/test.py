
def gcd(a,b):
    if a%b == 0:
        return b
    return gcd(b,a%b)

# print(gcd(56,4))

def gcd1(a, b):
    while b != 0:
        a, b = b, a % b
    return a


print(gcd(60,13))
print(gcd1(60,13))