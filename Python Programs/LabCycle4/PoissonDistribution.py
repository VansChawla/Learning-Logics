import scipy.stats as stats

lambda_val = 5
k = 8

prob_more_than_8 = stats.poisson.sf(k, lambda_val)
print(f"Probability of receiving more than 8 clicks: {prob_more_than_8:.4f}")