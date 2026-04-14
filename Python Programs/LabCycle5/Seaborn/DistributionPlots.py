import seaborn as sns
import matplotlib.pyplot as plt

# Q1: Distribution Plots
tips = sns.load_dataset('tips')
sns.histplot(data=tips, x='total_bill', hue='time', kde=True)
plt.title("Total Bill Distribution"); plt.show()