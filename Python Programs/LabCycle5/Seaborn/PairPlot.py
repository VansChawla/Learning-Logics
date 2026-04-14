import matplotlib.pyplot as plt
import seaborn as sns

iris = sns.load_dataset('iris')

sns.pairplot(iris, hue='species', diag_kind='kde')
plt.show()