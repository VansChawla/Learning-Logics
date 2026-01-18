import pandas as pd
import numpy as np

def find_outliers():
    # 1. Create a synthetic dataset of exam scores
    # We generate 50 normal scores around 75, then add 4 outliers (very low and very high)
    np.random.seed(42)
    scores = np.random.normal(loc=75, scale=10, size=50).astype(int)
    scores = np.append(scores, [20, 25, 100, 115]) # Adding outliers
    
    # Create DataFrame
    df = pd.DataFrame(scores, columns=['Exam_Score'])
    
    # --- Step A: Use describe() ---
    stats = df.describe()
    print("--- Descriptive Statistics ---")
    print(stats)
    
    # Extract quartiles from the description
    # 25% = Q1, 75% = Q3
    Q1 = stats.loc['25%', 'Exam_Score']
    Q3 = stats.loc['75%', 'Exam_Score']
    
    # --- Step B: Calculate IQR Manually ---
    IQR = Q3 - Q1
    
    # --- Step C, D, E: Define Fences ---
    lower_fence = Q1 - (1.5 * IQR)
    upper_fence = Q3 + (1.5 * IQR)
    
    print(f"\n--- Calculations ---")
    print(f"Q1 (25%):     {Q1}")
    print(f"Q3 (75%):     {Q3}")
    print(f"IQR:          {IQR}")
    print(f"Lower Fence:  {lower_fence}")
    print(f"Upper Fence:  {upper_fence}")
    
    # --- Step F: Identify Outliers ---
    # An outlier is anything LESS than the lower fence OR GREATER than the upper fence
    outliers = df[(df['Exam_Score'] < lower_fence) | (df['Exam_Score'] > upper_fence)]
    
    print(f"\n--- Identified Outliers ({len(outliers)} found) ---")
    if not outliers.empty:
        print(outliers)
    else:
        print("No outliers found.")

if __name__ == "__main__":
    find_outliers()