import numpy as np
import matplotlib.pyplot as plt

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