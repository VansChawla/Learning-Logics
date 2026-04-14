import seaborn as sns
import matplotlib.pyplot as plt

titanic = sns.load_dataset('titanic')
fig, axs = plt.subplots(1, 3, figsize=(15, 4))
sns.countplot(data=titanic, x='class', hue='survived', ax=axs[0])
sns.boxplot(data=titanic, x='class', y='age', ax=axs[1])
sns.violinplot(data=titanic, x='survived', y='fare', ax=axs[2])
plt.tight_layout(); plt.show()