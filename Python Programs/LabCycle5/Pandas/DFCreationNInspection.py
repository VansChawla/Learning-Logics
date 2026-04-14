import pandas as pd
import numpy as np

print("--- Pandas Q1: DataFrame Creation & Inspection ---")
data = {
    'Name': ['Alice', 'Bob', 'Charlie', 'David', 'Eve', 'Frank', 'Grace', 'Hank'],
    'Age': [20, 21, 22, 20, 23, 21, 22, 24],
    'Score': [85, 90, 78, 92, 88, 76, 95, 89],
    'Grade': ['B', 'A', 'C', 'A', 'B', 'C', 'A', 'B']
}
df = pd.DataFrame(data)
print("Head:\n", df.head())
print("Tail:\n", df.tail())
print("Info:"); df.info()
print("Describe:\n", df.describe())