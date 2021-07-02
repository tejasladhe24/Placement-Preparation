arr = list(map(int,input("Array: ").split(" ")))
temp = []

for elem in arr:
    if not (elem in temp):
        temp.append(elem)

print(temp)

# Input example - 1 2 3 4 2 2 3 4 1