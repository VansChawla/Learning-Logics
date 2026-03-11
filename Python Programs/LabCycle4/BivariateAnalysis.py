import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats

x = np.random.rand(50) * 10
y = 2 * x + np.random.normal(0, 1, 50)

correlation, _ = stats.pearsonr(x, y)
print(f"Pearson Correlation Coefficient: {correlation:.4f}")

plt.scatter(x, y)
plt.title(f"Scatter Plot (r={correlation:.2f})")
plt.show()