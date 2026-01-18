a = input()
a_reverse = ""
for char in a:
    a_reverse = char + a_reverse

if(a == a_reverse):
    print("palindrome")
else:
    print("not a palindrome")


#Another method to reverse a string
a = "Vansh"
b = ""
for i in range(len(a)-1, -1, -1):
    b = b + a[i]

print(b)