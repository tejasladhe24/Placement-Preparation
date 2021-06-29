def hasZeroSumSubList(arr):
    checks = set({0})
    sum = 0
    for elem in arr:
        sum = sum + elem

        if sum in checks:
            return True
        
        checks.add(sum)
    
    return False

arr = input("array: ")
arr = list(map(int, arr.split(" ")))

# input example = 3 4 -7 3 1 3 1 -4 -2 -2
# arr = [3, 4, -7, 3, 1, 3, 1, -4, -2, -2]

print(hasZeroSumSubList(arr))




