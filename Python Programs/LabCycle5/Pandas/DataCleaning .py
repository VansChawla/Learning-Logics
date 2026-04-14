import numpy as np
import pandas as pd

print("\n--- Pandas Q2: Data Cleaning ---")
dirty_df = pd.DataFrame({'ID': [1, 2, 2, 4], 'Score': [90, np.nan, 80, 80]})
print("Missing Values:\n", dirty_df.isnull().sum())
dirty_df['Score'] = dirty_df['Score'].fillna(dirty_df['Score'].mean())
clean_df = dirty_df.drop_duplicates()
print("Cleaned Data:\n", clean_df)