from abc import ABC, abstractmethod
import math

# 1. Base Class
class Shape(ABC):
    @abstractmethod
    def area(self):
        pass

# 2. Subclasses
class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    
    def area(self):
        return math.pi * self.radius ** 2

    def __str__(self):
        return f"Circle(r={self.radius}, Area={self.area():.2f})"

class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def area(self):
        return self.width * self.height

    def __str__(self):
        return f"Rectangle({self.width}x{self.height}, Area={self.area():.2f})"

# --- Driver Code ---
# Mixed list of shapes
shapes = [
    Rectangle(3, 4),  # Area 12
    Circle(5),        # Area ~78.5
    Rectangle(2, 2),  # Area 4
    Circle(1)         # Area ~3.14
]

# Sort by area using lambda key
sorted_shapes = sorted(shapes, key=lambda s: s.area())

# Polymorphic print
print("--- Sorted Shapes by Area ---")
for shape in sorted_shapes:
    print(shape)