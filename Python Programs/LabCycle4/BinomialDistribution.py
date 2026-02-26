import scipy.stats as stats
import matplotlib.pyplot as plt
import numpy as np

n = 20
p = 0.10
k = 5

prob = stats.binom.pmf(k,n,p)
print(f"Probability of exactly 5 successes: {prob:.4f}")

x = np.arange(0,n+1)
pmf_values = stats.binom.pmf(x,n,p)

plt.bar(x, pmf_values, color='skyblue')
plt.title('Binomial Distribution PMF (n=20, p=0.1)')
plt.xlabel('Number of Successes')
plt.ylabel('Probability')
plt.show()