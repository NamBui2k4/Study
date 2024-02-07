# 1. hàm mean
from statistics import mean
a = [1,1,1,2,3,1, 2, 3, 4, 4,5]
mean_a = mean(a)
print(a)


# 2. hàm geometric_mean
from statistics import geometric_mean
data = [2, 4, 6, 8, 10]
geo_mean = geometric_mean(data)
print(f"Geometric Mean of the data is: {geo_mean}")

# 3. hàm harmonic_mean
from statistics import harmonic_mean
data1 = [2, 4, 8, 16, 32]
hm1 = harmonic_mean(data1)
print(f"Kêt: {hm1}")

# 4. median
from statistics import median
data = [1, 2, 4, 5, 6]
median_value = median(data)
print(f"Median of the data is: {median_value}")

# 5.hàm median_low
from statistics import median_low
data = [5.2, 3.4, 4, 1]
median_low_value = median_low(data)
print(f"Low Median of the data is: {median_low_value}")

# 6. hàm median_high
from statistics import median_high
data = [5.2, 3.4,3.2, 4, 1]
med_high = median_high(data)
print(f"High Median: {med_high}")

# 7. hàm median_grouped
from statistics import median_grouped
data = [41, 45.3, 57.3, 59.1, 55.5, 42, 55.9]
interval = 5
result = median_grouped(data, interval)
print("Median_grouped:", result)

# 5. hàm mode
from statistics import mode
data = [1, 2, 2, 3, 3, 3, 4, 4, 4, 5]
m = mode(data)
print(f"Mode: {m}")

# 6. hàm correlation
from statistics import correlation
# Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, and  Neptune
orbital_period = [88, 225, 365, 687, 4331, 10_756, 30_687, 60_190]    # days
dist_from_sun = [58, 108, 150, 228, 778, 1_400, 2_900, 4_500] # million km
# Show that a perfect monotonic relationship exists
correlation(orbital_period, dist_from_sun)

# 7. hàm multimode
from statistics import multimode
data = [1, 2, 3, 3, 4,4, 4, 5, 5, 6, 6]
modes = multimode(data)
print(f"Modes: {modes}")


# 8. hàm pstdev
from statistics import pstdev
pstdev([1.5, 2.5, 2.5, 2.75, 3.25, 4.75])

# 9. hàm quantilee
from statistics import quantiles
data = [1, 2, 3, 4, 5, 6]
n = 4
result = quantiles(data, n = 6)
print(f"Quantiles: {result}")

# 10. hàm covariance
from statistics import covariance
x = [1, 2, 3, 4, 5, 6, 7, 8, 9]
y = [1, 2, 3, 1, 2, 3, 1, 2, 3]
print(f"covariance: {covariance(x, y)}")

# 11. hàm pvariance
from statistics import pvariance
data = [0.0, 0.25, 0.25, 1.25, 1.5, 1.75, 2.75, 3.25]
print(f"covariance: {pvariance(data)}")

# 12. hàm stdev
from statistics import stdev
print(f"stdev: {stdev([1.5, 2.5, 2.5, 2.75, 3.25, 4.75])}")

# 13. hàm variance
from statistics import variance
data = [2.75, 1.75, 1.25, 0.25, 0.5, 1.25, 3.5]
print(f"stdev: {variance(data)}")

# 11. hàm linear_regression
from statistics import linear_regression
year = [1971, 1975, 1979, 1982, 1983]
films_total = [1, 2, 3, 4, 5]
slope, intercept = linear_regression(year, films_total)
print('slope = ', slope)
print('intercept = ', intercept)
print('total films in 2019: ', round(slope * 2019 + intercept))