def fibonacci(n):
    if(n==1 or n==0):
        return 1;
    return fibonacci(n-1) + fibonacci(n-2)

a = int(input())
for i in range(a):
    print(fibonacci(i), end="  ")