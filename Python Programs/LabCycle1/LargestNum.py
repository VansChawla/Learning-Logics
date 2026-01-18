maximum = 0
# x = [4,56,2,9,32]
n = int(input("Enter the size of list: "))
x = []
for i in range(n):
    val = int(input("Enter a number: "))
    x.append(val)

for i in x:
    if maximum < i:
        maximum = i

print(maximum)