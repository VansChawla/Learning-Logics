import numpy as np
from scipy.stats import skew

def analyze_housing_data():

    np.random.seed(42)
    prices = np.random.lognormal(mean=11.0, sigma=0.8, size=50)

    print("Housing Price Data Analysis")
    print(f"Dataset Size: {len(prices)}")
    print(f"Sample Prices: {prices[:5]}")

    # Part A: Calculate Range, Variance, Standard Deviation

    # Range = Max - Min
    price_range = np.ptp(prices) # ptp stands for "peak to peak"

    # Variance (ddof=1 for Sample Variance)
    price_variance = np.var(prices, ddof=1)

    # Standard Deviation (ddof=1 for Sample Std Dev)
    price_std_dev = np.std(prices, ddof=1)

    print(f"\nRange:              {price_range:,.2f}")
    print(f"Variance:           {price_variance:,.2f}")
    print(f"Standard Deviation: {price_std_dev:,.2f}")

    # Part B: Determine Skewness
    
    skewness_value = skew(prices)

    print(f"\nSkewness Score:     {skewness_value:.4f}")

    # Determine direction
    if skewness_value > 0:
        print("Conclusion: The data is POSITIVELY skewed (tail is on the right).")
        print("This indicates that a few very expensive houses are pulling the average up.")
    elif skewness_value < 0:
        print("Conclusion: The data is NEGATIVELY skewed (tail is on the left).")
    else:
        print("Conclusion: The data is perfectly symmetrical (Normal Distribution).")

if __name__ == "__main__":
    analyze_housing_data()

