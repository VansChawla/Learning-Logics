import numpy as np
import pandas as pd

def calculate_correlation():
    # 1. Create a synthetic dataset
    # We simulate 30 students where studying more generally leads to higher scores.
    np.random.seed(42)
    hours_studied = np.round(np.random.uniform(1, 10, 30), 1) 
    # Formula: Score approx 40 + 5 * Hours + Random Noise
    exam_scores = 40 + (5 * hours_studied) + np.random.normal(0, 5, 30)
    exam_scores = np.clip(exam_scores, 0, 100).astype(int)

    df = pd.DataFrame({
        'Hours Studied': hours_studied,
        'Exam Score': exam_scores
    })

    print("--- Sample of the Dataset ---")
    print(df.head())

    # 2. Calculate Pearson Correlation Coefficient (r)
    # The .corr() method defaults to 'pearson'
    r_value = df['Hours Studied'].corr(df['Exam Score'])

    print(f"\nPearson Correlation Coefficient (r): {r_value:.4f}")

    return r_value

if __name__ == "__main__":
    r = calculate_correlation()
    
    # 3. Dynamic Explanation
    print("\n--- Interpretation ---")
    if r > 0.7:
        print("Strength: Strong Positive Relationship")
        print("Meaning: As 'Hours Studied' increases, 'Exam Score' consistently increases.")
    elif r > 0.3:
        print("Strength: Moderate Positive Relationship")
    elif r > -0.3:
        print("Strength: Weak or No Relationship")
    else:
        print("Strength: Negative Relationship")