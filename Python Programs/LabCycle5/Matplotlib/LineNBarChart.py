import matplotlib.pyplot as plt
from scipy.stats import norm
import numpy as np

# Q1: Line & Bar Chart
fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(10, 4))
months = np.arange(1, 13)
city_a, city_b = np.random.randint(10, 30, 12), np.random.randint(15, 35, 12)
ax1.plot(months, city_a, label='City A'); ax1.plot(months, city_b, label='City B')
ax1.legend(); ax1.set_title("Monthly Temps (Line)")
ax2.bar(months - 0.2, city_a, 0.4, label='City A'); ax2.bar(months + 0.2, city_b, 0.4, label='City B')
ax2.legend(); ax2.set_title("Monthly Temps (Bar)")
plt.show()