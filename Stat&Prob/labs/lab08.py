# Dataframe là cấu trúc dữ liệu (data structure) hai chiều, 
# tức là dữ liệu được căn chỉnh theo kiểu bảng trong các hàng (row) và cột (column). 
# Chúng ta có thể thực hiện các thao tác cơ bản trên hàng / cột như chọn, xóa, thêm và đổi tên
import pandas as pd
df = pd.DataFrame({'numbers': [1, 2, 3], 'colors': ['red', 'white', 'blue']})
print(df)
import numpy as np
import pandas as pd
# Create sample DataFrame using numpy
df = pd.DataFrame(np.random.randn(5, 3), columns=['N1', 'N2', 'N3'])
print(df)

# Create DataFrame
import pandas as pd
df = pd.DataFrame({'Nl' : [1, 2, 3, 4], 'N2' : [4, 3, 2, 1]})
print(df)

#crate a DataFrame from a list of dictionaries
import pandas as pd
L = [{'Name': 'John', 'Last Name': 'Smith'},
{'Name': 'Mary', 'Last Name': 'Wood'}]
df = pd.DataFrame(L)
print(df)

# Load data from file
data = np.loadtxt("sample.txt", delimiter=',')
print(data)
# an alternative way
data = pd.read_csv("sample.txt", delimiter=',')
print(data)

print(data)
print("Print column Score")
print(data.Score)

# Access data
df = pd.DataFrame(np.random.randn(10, 3), columns=['N1', 'N2', 'N3'])
print(df)

df.head(5)

df.tail(5)

N2 = df['N2']
print(N2)

df[['N1', 'N2']]

# Exercises
import pandas as pd

# 1. Exploratory Data Analysis for IRIS dataset
iris_df = pd.read_csv('iris.csv')
print("First 5 data points for IRIS dataset:")
print(iris_df.head())

print("\nSummary statistics for IRIS dataset:")
summary_iris = pd.DataFrame({
    'count': [len(iris_df[col]) for col in iris_df.columns],
    'mean': [sum(iris_df[col]) / len(iris_df[col]) for col in iris_df.columns],
    'std': [((sum((x - sum(iris_df[col]) / len(iris_df[col])) ** 2 for x in iris_df[col]) / (len(iris_df[col]) - 1)) ** 0.5) for col in iris_df.columns],
    'min': [min(iris_df[col]) for col in iris_df.columns],
    'max': [max(iris_df[col]) for col in iris_df.columns]
}, index=iris_df.columns)
print(summary_iris)

# 2. Exploratory Data Analysis for POPULATION dataset
population_df = pd.read_csv('HEREETOROS')
print("\nFirst 5 data points for POPULATION dataset:")
print(population_df.head())

print("\nSummary statistics for POPULATION dataset:")
summary_population = population_df.groupby('year').agg(['count', 'mean', 'std', 'min', 'max'])
print(summary_population)

