# arr = input("arr: ")
# sum = input("sum: ")
arr = '8 7 2 5 3 1'
sum = '10'
sum = int(sum)
arr = list(map(int,arr.split(" ")))

print('arr: ', arr, type(arr))
print('sum: ', sum, type(sum))

def findPair(arr, sum):
    arr.sort()
    # arr = '1 2 3 5 7 8'

    (low, high) = (0,len(arr)-1)
    while (low < high):
        if (arr[low] + arr[high] == sum):
            print(arr[low], arr[high])
            low = low + 1

        elif (arr[low] + arr[high] < sum):
            low = low + 1

        elif (arr[low] + arr[high] > sum):
            high = high - 1
    
findPair(arr,sum)
