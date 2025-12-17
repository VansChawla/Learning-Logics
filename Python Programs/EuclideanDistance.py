print("Enter coordinates for Point 1:")
x1 = float(input("x1: "))
y1 = float(input("y1: "))

print("\nEnter coordinates for Point 2:")
x2 = float(input("x2: "))
y2 = float(input("y2: "))

X = (x2-x1)**2
Y = (y2-y1)**2

distance = (X + Y) ** 0.5

print(f"\nThe Euclidean distance is: {distance:.2f}")