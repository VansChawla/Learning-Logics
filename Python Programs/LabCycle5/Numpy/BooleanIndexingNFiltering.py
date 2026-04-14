import numpy as np

print("\n--- NumPy Q3: Boolean Indexing & Filtering ---")
rand_floats = np.random.rand(20)
greater_than_half = rand_floats[rand_floats > 0.5]
rand_floats[rand_floats < 0.3] = 0
print("Values > 0.5:", greater_than_half)
print("Array after replacing < 0.3 with 0:\n", rand_floats)

