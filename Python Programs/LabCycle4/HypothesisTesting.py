import numpy as np
import scipy.stats as stats

group_A = np.random.normal(75, 10, 30)
group_B = np.random.normal(82, 12, 30)

t_stat, p_val = stats.ttest_ind(group_A, group_B)

print(f"T-statistic: {t_stat:.4f}, P-value: {p_val:.4f}")
if p_val < 0.05:
    print("Result: Significant difference found (Reject H0)")
else:
    print("Result: No significant difference (Fail to reject H0)")