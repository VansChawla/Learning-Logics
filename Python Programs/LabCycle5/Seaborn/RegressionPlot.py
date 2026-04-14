import seaborn as sns
import matplotlib.pyplot as plt

tips = sns.load_dataset('tips')

sns.lmplot(data=tips, x='total_bill', y='tip', col='sex', hue='sex')
plt.show()