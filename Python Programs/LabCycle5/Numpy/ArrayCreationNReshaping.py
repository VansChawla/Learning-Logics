import numpy as np

print("--- NumPy Q1: Array Creation & Reshaping ---")
arr_1d = np.linspace(0, 100, 24)
arr_2d = arr_1d.reshape(4, 6)
print("Shape:", arr_2d.shape)
print("NDIM:", arr_2d.ndim)
print("Dtype:", arr_2d.dtype)