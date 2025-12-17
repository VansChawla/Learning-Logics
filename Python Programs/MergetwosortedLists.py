list1 = [27,34,78,91,100,130]
list2 = [4,32,72,98,120]
mergedList = []
i = 0
j = 0

while i < len(list1) and j < len(list2):
    if list1[i] < list2[j]:
        mergedList.append(list1[i])
        i += 1
    else:
        mergedList.append(list2[j])
        j += 1

while i < len(list1):
    mergedList.append(list1[i])
    i += 1

while j < len(list2):
    mergedList.append(list2[j])
    j += 1

print(mergedList)