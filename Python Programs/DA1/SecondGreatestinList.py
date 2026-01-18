l = [12,16,13,19,17]

largest = l[0]
secondLargest = l[0]

for i in l:
    if i > largest:
        secondLargest = largest
        largest = i
    elif i > secondLargest:
        secondLargest = i
    
print(f"Second largest is {secondLargest} and largest is {largest}")