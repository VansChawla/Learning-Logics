import numpy as np

print("\n--- NumPy Q2: Statistical Operations ---")
matrix_5x5 = np.random.randint(1, 51, size=(5, 5))
print("Mean (Rows):", np.mean(matrix_5x5, axis=1))
print("Median (Cols):", np.median(matrix_5x5, axis=0))
print("Std Dev (Rows):", np.std(matrix_5x5, axis=1))
print("Variance (Cols):", np.var(matrix_5x5, axis=0))