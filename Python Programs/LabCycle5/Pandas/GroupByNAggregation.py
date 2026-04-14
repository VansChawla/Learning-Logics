import numpy as np
import pandas as pd

print("\n--- Pandas Q3: GroupBy & Aggregation ---")
sales_data = pd.DataFrame({
    'Region': ['North', 'South', 'North', 'East', 'South', 'East'],
    'Units Sold': [100, 150, 200, 50, 120, 80],
    'Revenue': [1000, 1500, 2000, 500, 1200, 800]
})
summary = sales_data.groupby('Region').agg(
    Total_Revenue=('Revenue', 'sum'),
    Avg_Units=('Units Sold', 'mean'),
    Max_Revenue=('Revenue', 'max')
).sort_values(by='Total_Revenue', ascending=False)
print(summary)