a = input()
a_reverse = ""
for char in a:
    a_reverse = char + a_reverse

if(a == a_reverse):
    print("palindrome")
else:
    print("not a palindrome")