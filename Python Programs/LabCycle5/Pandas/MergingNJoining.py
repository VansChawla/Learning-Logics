import numpy as np
import pandas as pd

print("\n--- Pandas Q4: Merging & Joining ---")
df1 = pd.DataFrame({'EmpID': [1, 2, 3], 'Name': ['John', 'Emma', 'Sam']})
df2 = pd.DataFrame({'EmpID': [2, 3, 4], 'Salary': [50k, 60k, 70k]})
print("Inner Join:\n", pd.merge(df1, df2, on='EmpID', how='inner'))
print("Left Join:\n", pd.merge(df1, df2, on='EmpID', how='left'))
print("Outer Join:\n", pd.merge(df1, df2, on='EmpID', how='outer'))