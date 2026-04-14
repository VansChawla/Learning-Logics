import numpy as np

print("\n--- NumPy Q4: Matrix Operations ---")
A = np.random.randint(1, 10, size=(3, 3))
B = np.random.randint(1, 10, size=(3, 3))
print("Element-wise Multiplication:\n", A * B)
print("Matrix Dot Product:\n", np.dot(A, B))
print("Transpose of A:\n", A.T)
try:
    print("Inverse of A:\n", np.linalg.inv(A))
except np.linalg.LinAlgError:
    print("Matrix A is singular and cannot be inverted.")