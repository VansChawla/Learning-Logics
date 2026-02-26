import scipy.stats as stats

mu = 75
sigma = 10

prob_less_85 = stats.norm.cdf(85, mu, sigma)
prob_less_65 = stats.norm.cdf(65, mu, sigma)

percentage = (prob_less_85 - prob_less_65) * 100
print(f"Percentage of students scoring between 65 and 85: {percentage:.2f}%")