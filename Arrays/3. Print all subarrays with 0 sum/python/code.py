# This code give subarrays of size two and three

arr = list(map(int,input("Array: ").split(" ")))

for i in range(len(arr)):
    for j in range(i+1,len(arr)):
        if (arr[i] + arr[j] == 0):
            print((arr[i],arr[j]))

for i in range(len(arr)):
    for j in range(i+1,len(arr)):
        for k in range(j+1,len(arr)):
            if (arr[i] + arr[j] + arr[k] == 0):
                print((arr[i],arr[j],arr[k]))

# Input Example - 4 2 -3 -1 0 -4