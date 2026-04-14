import numpy as np
import pandas as pd

print("\n--- Pandas Q5: Time Series Analysis ---")
dates = pd.date_range(start='2026-01-01', periods=90, freq='D')
sales = pd.Series(np.random.randint(50, 200, size=90), index=dates)
monthly_sales = sales.resample('ME').sum()
print("Monthly Total Sales:\n", monthly_sales)