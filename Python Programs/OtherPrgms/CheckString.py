a = "P@#yn26at^&i5ve"

char = 0
dig = 0
special = 0

for i in a:
    if i.isdigit():
        dig += 1
    elif i.isalpha():
        char += 1
    else:
        special += 1

print(f"Characters are {char}\nDigit are {dig}\nSpecial characters are {special}")