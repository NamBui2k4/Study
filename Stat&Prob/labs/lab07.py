import matplotlib.pyplot as plt
import math
def generator_data(a, b, size): 
    n = (b-a)/(size-1)
    result = []
    s = a
    while s <b:
        result.append(s)
        s = s+n
    if len(result) < size:
        result.append(b)
    return result

# a = 4
# b = 6
# X = generator_data(a,b,100)
# print(X)

# Uniform distribution (phan phoi deu)
def pmf_uniform_cont(a,b):
    
    return 1/(b - a)



def plot_pmf_uniform_cont (a, b):
# Plot the probability mass function of Uniform(a, b)
    X = generator_data(a, b, 100)
    if b != a:
        P = [pmf_uniform_cont (a, b) for x in X]
    plt.plot(X, P, '-')
    plt.plot([a, a], [0, 1/(b-a)], 'g--')
    plt.plot([b, b], [0, 1/(b-a)], 'g--')
    plt.title('PDF of Uniform continuous distribution (%0.2f, %0.2f)' %(a,b))
    plt.show()
# plot_pmf_uniform_cont (4, 6)

# 2 Normal distribution

import math
def pmf_normal(x, mu, sigma):
    return (1/(math.sqrt(2*math.pi*sigma**2)))*math.exp(-(x-mu)**2/2*sigma**2)

def cdf_normal (x, mu, sigma): 
    return 1/2 * (1+math.erf((x - mu)/(sigma*math.sqrt(2))))




def plot_pmf_normal (mu, sigma):
#Plot the probability mass function of Normal (mu, sigma)

    X = generator_data( mu - 4*sigma, mu+ 4*sigma, 1000)
    P_normal = [pmf_normal (x, mu, sigma) for x in X]
    plt.plot(X, P_normal, '-')
    plt.title('PMF of Normal (%.2f, %.2f)' %(mu, sigma))
    plt.xlabel('X')
    plt.ylabel('P') 
    plt.show()
# plot_pmf_normal (0, 1.5)

def plot_cdf_normal (mu, sigma):
    X = generator_data( mu - 4*sigma, mu+ 4*sigma, 1000)
    P_normal = [cdf_normal (x, mu, sigma) for x in X]
    plt.plot(X, P_normal, '-')
    plt.title('CDF of Normal (%.2f, %.2f)' %(mu, sigma))
    plt.xlabel('X')
    plt.ylabel('P') 
    plt.show()
# plot_cdf_normal(0, 1.5)

# P(Z < 1.51)
print(round(cdf_normal(1.51,0,1),4))
# P(Z < 2.13)
print(round(cdf_normal(2.13,0,1),4))
# P(Z < -0.87)
print(round(cdf_normal(-0.87,0,1),4))
# P(Z > 1.11)
print(round(1 - cdf_normal(1.11,0,1),4))
# P(Z > -0.66)
print(round(1 - cdf_normal(-0.66,0,1),4))
# P(0.28 < Z < 1.31)
print(round(cdf_normal(1.31,0,1) - cdf_normal(0.28,0,1),4))
# # P(-0.86 < Z < 0.12)
print(round(cdf_normal(0.12,0,1) - cdf_normal(-0.86,0,1),4))
# # P(-2.2 < Z < -0.16)
print(round(cdf_normal(-0.16,0,1) - cdf_normal(-2.2,0,1),4))
# X ~ N(20,3^2) p (18 < X < 21)
print(round(cdf_normal(21,20,3) - cdf_normal(18,20,3),4))
# X ~ N( 1.5, 0.1^2 ) p (-0.5 < X < 0.5 )
print(round(cdf_normal(0.5,1.5,0.1) - cdf_normal(-0.5,1.5,0.1),4))