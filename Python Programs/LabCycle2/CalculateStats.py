import math
import statistics

numbers = [12, 7, 12, 9, 15]
n = len(numbers)

#mean
mean = sum(numbers) / n
print(f"The mean of the array is {mean}")

#median
sorted_arr = sorted(numbers)
median = sorted_arr[n // 2]
print(f"The median of the array is {median}")

#mode
mode = statistics.mode(numbers)
print(f"The mode of the array is {mode}")

#standard deviation
variance_sum = 0;
for x in numbers:
    variance_sum += (x - mean) ** 2

variance = variance_sum / n
std = math.sqrt(variance)
print(f"The standard deviation of the array is {std:.3f}")

