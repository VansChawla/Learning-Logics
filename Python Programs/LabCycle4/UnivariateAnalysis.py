import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

data_uni = np.random.normal(50, 5, 100)

plt.figure(figsize=(10, 4))

plt.subplot(1, 2, 1)
sns.histplot(data_uni, kde=True, color='green')
plt.title("Histogram")

plt.subplot(1,2,2)
sns.boxplot(x=data_uni, color='orange')
plt.title('Boxplot')

plt.show()