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

population_data = np.random.uniform(0, 100, 10000)
sample_means = []

for _ in range(1000):
    sample = np.random.choice(population_data, size=30)
    sample_means.append(np.mean(sample))

plt.hist(sample_means, bins=30, color='purple', edgecolor='black')
plt.title('Sampling Distribution of Means (CLT Demonstration)')
plt.xlabel('Sample Mean')
plt.ylabel('Frequency')
plt.show()