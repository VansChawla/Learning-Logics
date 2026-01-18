s = input("Write a string here :- ").lower()
vowelcount = 0;
for i in s:
    if (i=='a' or i=='e' or i=='i' or i=='o' or i=='u'):
        vowelcount += 1

print(vowelcount)