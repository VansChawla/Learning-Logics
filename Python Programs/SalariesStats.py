import random
import statistics

def analyze_salaries():
    salaries = []
    for _ in range(50):
        salaries.append(random.randint(45000, 90000))

    #Part(A)
    mean_1 = statistics.mean(salaries)
    median_1 = statistics.median(salaries)
    mode_1 = max(salaries, key=salaries.count)

    print("Initial Statistics (50 Employees)")
    print(f"Mean:   {mean_1:,.2f}")
    print(f"Median: {median_1:,.2f}")
    print(f"Mode:   {mode_1}")

    #Part(B): Introduce Executive Salary (Add 2,000,000)\
    salaries.append(2000000)
    print(f"\nAdded Executive Salary: 2,000,000")

    #Part(C): Re-calculate Stats
    mean_2 = statistics.mean(salaries)
    median_2 = statistics.median(salaries)
    mode_2 = max(salaries, key=salaries.count)

    print("New Statistics (51 Employees)")
    print(f"Mean:   {mean_2:,.2f}")
    print(f"Median: {median_2:,.2f}")
    print(f"Mode:   {mode_2}")

    # Calculate Shifts
    print("\n--- Shift in Values ---")
    print(f"Mean Shift:   {mean_2 - mean_1:,.2f}")
    print(f"Median Shift: {median_2 - median_1:,.2f}")

if __name__ == "__main__":
    analyze_salaries()

