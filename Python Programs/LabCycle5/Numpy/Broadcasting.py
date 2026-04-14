import numpy as np

print("\n--- NumPy Q5: Broadcasting ---")
M = np.random.randint(1, 10, size=(3, 3))
v = np.array([10, 20, 30])
print("Adding to each row:\n", M + v)
print("Adding to each column:\n", M + v[:, np.newaxis])