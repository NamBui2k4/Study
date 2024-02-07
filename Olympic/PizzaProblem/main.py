def solve(n):
    res = ((n - 1)*(n - 2)*(n*n - 3*n + 12))/24
    print((res% 987654321))
solve(n)