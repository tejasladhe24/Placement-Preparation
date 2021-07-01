def binSort(arr):
    zeros = 0
    result = [1]*len(arr)
    for elem in arr:
        if (elem == 0):
            zeros += 1

    for i in range(zeros):
        result[i] = 0

    return result

print(binSort(list(map(int,input("Array: ").split(" ")))))

# Input example - 1 0 1 0 1 0 0 1