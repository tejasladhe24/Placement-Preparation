# arr = input("arr: ")
# sum = input("sum: ")
arr = '8 7 2 5 3 1'
sum = '10'
sum = int(sum)
arr = list(map(int,arr.split(" ")))

print('arr: ', arr, type(arr))
print('sum: ', sum, type(sum))

def findPair(arr, sum):
    for i in arr:
        for j in arr:
            if (i==j):
                continue
            elif (i+j == sum):
                print(i,j)

findPair(arr,sum)
