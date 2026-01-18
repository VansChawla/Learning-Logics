l = [-45,23,43,-67,-9,56]
nl = []
pl = []

for i in range(len(l)):
    if(l[i] < 0):
        nl.append(l[i])
    elif(l[i] >= 0):
        pl.append(l[i])

print(f"Negative numbers are: {nl} and Positive numbers are: {pl}")