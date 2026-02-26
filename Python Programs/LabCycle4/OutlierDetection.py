import numpy as np

data = [10, 12, 12, 13, 12, 11, 14, 13, 15, 10, 100, 12, 14, -50]

q1 = np.percentile(data, 25)
q3 = np.percentile(data, 75)
iqr = q3 - q1

lower_bound = q1 - 1.5 * iqr
upper_bound = q1 + 1.5 * iqr

outliers = [x for x in data if x < lower_bound or x > upper_bound]
print(f"Identified Outliers: {outliers}")