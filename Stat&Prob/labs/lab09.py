
# line charts

import matplotlib.pyplot as plt
# # 1
years = [2010, 2011, 2012, 2013, 2014, 2015]
samples = [0.895, 0.91, 0.919, 0.926, 0.929, 0.931]
plt.plot(years, samples)
plt.show()

# 2
years = range (2000, 2011)
apples = [0.895, 0.91, 0.919, 0.926, 0.929, 0.931, 0.934, 0.936, 0.937, 0.9375, 0.9]
oranges = [0.962, 0.941, 0.930, 0.923, 0.918, 0.908, 0.907, 0.904, 0.901, 0.898, 0.7]

plt.plot(years, apples)
plt.plot (years, oranges)
plt.xlabel ('Year' )
plt.ylabel ('Yield')
plt.show()

plt.figure(figsize=(9,3))

plt.plot(years, apples, marker = 'x')
plt.show()


# # Scatter plot
import numpy as np
girls_grades = np.random.randint(100, size=30)
boys_grades = np.random.randint(100, size=30)
grades_range = np.random.randint(100, size=30)

fig=plt.figure(figsize=(3, 3))
ax=fig.add_axes([0,0,1,1])
ax.scatter(grades_range, girls_grades, color='r')
ax.scatter(grades_range, boys_grades, color='b')
ax.set_xlabel('Grades Range')
ax.set_ylabel('Grades Scored')
ax.set_title('scatter plot')

plt.show()

# bar graphs
years = range (2000, 2006)
oranges = [0.4, 0.8, 0.9, 0.7, 0.6, 0.8]

plt.xlabel('Year')
plt.ylabel('Yield')
plt.bar(years, oranges)
plt.show()


apples = [0.35, 0.6, 0.9, 0.8, 0.65, 0.8]
plt.bar (years, apples)

plt.bar (years, oranges, bottom=apples)
plt.show()


data = [[30, 25, 50, 20],
        [40, 23, 51, 17]]
X = np.arange(4)
fig=plt.figure()
ax = fig.add_axes([0,0,1,1])
ax.bar(X + 0.00, data[0], color ='b', width = 0.25)
ax.bar(X + 0.25, data[1], color = 'g', width = 0.25)
ax.set_xticks([0.25,1.25,2.25,3.25])
ax.set_xticklabels([2015,2016,2017,2018])
ax.legend(labels=[ 'Oranges', 'Apples'])
plt.show()


# # Histogram
from matplotlib import pyplot as plt
import numpy as np

fig,ax=plt.subplots(1,1)

a = np.array([72,87,5,73,56,73,55,54,11,20,51,5,79,31,27])
ax.hist(a, bins = [0,25,50,75,100])
ax.set_title("histogram of result")
ax.set_xticks([0,25,50,75,100])
ax.set_xlabel('marks' )
ax.set_ylabel('no. of students')
plt.show()


# Exercise
# 1
import pandas as pd
# a
iris_pd = pd.read_csv("iris.csv", delimiter=',')
x_label = iris_pd['sepal_length'].tolist()
y_label = iris_pd['sepal_width'].tolist()

x_range = np.random.randint(3 , 5, size = len(x_label))
y_range = np.random.randint(3, 5, size=len(y_label))

fig = plt.figure(figsize = (3,3))
ax = fig.add_axes([0,0,1,1])
ax.scatter(x_range, x_label, color='r', label='sepal_length')
ax.scatter(y_range, y_label, color='b', label='sepal_width')
ax.set_xlabel('sepal_length')
ax.set_ylabel('sepal_with')
ax.set_title('scatter plot')
ax.legend()
plt.show()

# b
fig,ax=plt.subplots(1,1)

a = np.array(x_label)
ax.hist(a, bins = [0,2,4,6,8,10])
ax.set_title("histogram of result")
ax.set_xticks([0,2,4,6,8, 10])
ax.set_xlabel('sepal_length' )
ax.set_ylabel('no. of sepal_length')
plt.show()