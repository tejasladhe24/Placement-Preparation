# arr = input("arr: ")
# sum = input("sum: ")
arr = '8 7 2 5 3 1'
sum = '10'
sum = int(sum)
arr = list(map(int,arr.split(" ")))

print('arr: ', arr, type(arr))
print('sum: ', sum, type(sum))

def findPair(arr, sum):
    Dict = {}
    for i,e in enumerate(arr):
        if (sum-e) in Dict:
            print(arr[Dict.get(sum-e)], arr[i])

        Dict[e] = i

findPair(arr,sum)