def createMatrix(m,n):
    matrix = [[0]*n]*m
    for i in range(m):
        arr_str = input()
        temp = list(map(int, arr_str.split(" ")))
        if (len(temp) == n):
            matrix[i] = temp
        else:
            exit("Row input is wrong")

    return matrix

def Spiral(matrix,m,n):
    arr = []

    s=0
    while (len(arr) < m*n):
        for i in range(s+0,n-s):                  # Horizontal Top
            arr.append(matrix[s+0][i])
        if (len(arr) == m*n):
            break
        for i in range(s+1,m-1-s):                # Vertical Right
            arr.append(matrix[i][-1-s])
        if (len(arr) == m*n):
            break
        for i in range(s+0,n-s):                # Horizontal Bottom
            arr.append(matrix[-1-s][n-1-i])
        if (len(arr) == m*n):
            break
        for i in range(s+1,m-1-s):              # Vertical Left
            arr.append(matrix[m-1-i][s+0])
        if (len(arr) == m*n):
            break

        s+=1                                    # Increase depth by 1
        
    return arr

m = int(input("m: "))
n = int(input("n: "))

matrix = createMatrix(m,n)
arr = Spiral(matrix,m,n)

print(arr)

'''
Example inputs - 

5
5
1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9

3
9
1 2 3 4 5 6 7 8 9
20 21 22 23 24 25 26 27 10
19 18 17 16 15 14 13 12 11

9
3
1 2 3
20 21 4
19 22 5
18 23 6
17 24 7
16 25 8
15 26 9
14 27 10 
13 12 11
'''
