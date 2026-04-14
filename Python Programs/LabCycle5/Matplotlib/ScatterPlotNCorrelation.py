import matplotlib.pyplot as plt
import numpy as np

hours = np.random.uniform(1, 10, 50)
marks = 10 * hours + np.random.normal(0, 10, 50)
colors = np.where(marks >= 50, 'green', 'red')
plt.scatter(hours, marks, c=colors)
plt.plot(np.unique(hours), np.poly1d(np.polyfit(hours, marks, 1))(np.unique(hours)), 'b--')
plt.title("Study Hours vs Marks"); plt.show()