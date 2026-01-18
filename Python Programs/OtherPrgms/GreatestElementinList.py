import sys

l = [45, 44,543, 33, 11, 121, 56, 90]
max = -sys.maxsize - 1
idx = 0

for i in range(len(l)):
    if max < l[i]:
        max = l[i]
        idx = i

print(f"Largest number is {max} at index {idx}")

