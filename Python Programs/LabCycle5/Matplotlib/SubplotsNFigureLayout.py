import matplotlib.pyplot as plt
import numpy as np

months = np.arange(1, 13)
city_a = np.random.randint(10, 30, 12)
city_b = np.random.randint(15, 35, 12)

fig, axs = plt.subplots(2, 2, figsize=(8, 6))
axs[0,0].plot(months, city_a); axs[0,0].set_title("Line")
axs[0,1].bar(months, city_b); axs[0,1].set_title("Bar")
axs[1,0].scatter(city_a, city_b); axs[1,0].set_title("Scatter")
axs[1,1].hist(city_a); axs[1,1].set_title("Histogram")
plt.tight_layout(); plt.show()