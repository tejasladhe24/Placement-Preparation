def printMatrix(matrix):
    for i in range(len(matrix)):
        print([elem for elem in matrix[i]])

def createSpiral(arr,m,n):
    matrix = []
    for i in range(m):
        matrix.append([0]*n)

    idx=0
    s=0
    while (idx < m*n):
        for i in range(s+0,n-s):                  # Horizontal Top
            matrix[s+0][i] = arr[idx]
            idx = idx + 1

        if (idx == m*n):
            break

        for i in range(s+1,m-1-s):                # Vertical Right
            matrix[i][-1-s] = arr[idx]
            idx = idx + 1

        if (idx == m*n):
            break

        for i in range(s+0,n-s):                # Horizontal Bottom
            matrix[-1-s][n-1-i] = arr[idx]
            idx = idx + 1

        if (idx == m*n):
            break

        for i in range(s+1,m-1-s):              # Vertical Left
            matrix[m-1-i][s+0] = arr[idx]
            idx = idx + 1

        if (idx == m*n):
            break

        s+=1                                    # Increase depth by 1
        
    return matrix

m = int(input("m: "))
n = int(input("n: "))
arr = list(map(int, input("Array: ").split(" ")))
if (len(arr) != m*n):
    exit("No of elements is not equal to m*n")

matrix = createSpiral(arr,m,n)

printMatrix(matrix)

'''
Example inputs - 

5
5
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

3
9
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27

9
3
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27

'''
