import matplotlib.pyplot as plt
from scipy.stats import norm
import numpy as np

data = np.random.randn(1000)
plt.hist(data, bins=30, density=True, alpha=0.6, color='gray')
x = np.linspace(min(data), max(data), 100)
plt.plot(x, norm.pdf(x, np.mean(data), np.std(data)), 'k', lw=2)
plt.axvline(np.mean(data), color='red', linestyle='dashed', lw=2)
plt.axvline(np.mean(data) + np.std(data), color='blue', linestyle='dotted')
plt.axvline(np.mean(data) - np.std(data), color='blue', linestyle='dotted')
plt.title("Histogram with KDE"); plt.show()