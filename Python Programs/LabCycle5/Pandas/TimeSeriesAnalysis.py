import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

dates = pd.date_range(start='2026-01-01', periods=90, freq='D')
daily_sales = pd.Series(np.random.randint(50, 200, size=90), index=dates)

# Resample to monthly ('ME' is the modern alias for Month End)
monthly_total = daily_sales.resample('ME').sum()
monthly_avg = daily_sales.resample('ME').mean()

print("Monthly Total Sales:\n", monthly_total)
print("\nMonthly Average Sales:\n", monthly_avg)

# Plotting
plt.figure(figsize=(12, 5))

# Subplot 1: Daily Sales
plt.subplot(1, 2, 1)
daily_sales.plot(color='blue', title='Daily Sales (90 Days)')
plt.ylabel('Sales')

# Subplot 2: Monthly Total Sales
plt.subplot(1, 2, 2)
monthly_total.plot(kind='bar', color='orange', title='Monthly Total Sales')
plt.ylabel('Total Sales')
plt.xticks(rotation=45)

plt.tight_layout()
plt.show()