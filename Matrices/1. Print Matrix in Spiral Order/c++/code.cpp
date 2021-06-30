#include <stdio.h>
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int m, n;

void printMatrix(vector<vector<int>> matrix)
{
    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix[0].size(); j++)
        {
            cout << matrix[i][j] << " ";
        }

        cout << endl;
    }
}

void printArray(vector<int> arr)
{
    for (int j = 0; j < arr.size(); j++)
    {
        cout << arr[j] << " ";
    }
    cout << endl;
}

vector<vector<int>> createMatrix(int m, int n)
{
    vector<vector<int>> matrix(m, vector<int>(n));

    string input;
    string temp;

    cin >> ws; // stream out any whitespace
    for (int i = 0; i < m; i++)
    {
        getline(cin, input);
        stringstream ss(input);

        for (int j = 0; j < n; j++)
        {
            getline(ss, temp, ' ');
            matrix[i][j] = stoi(temp);
        }
    }

    return matrix;
}

vector<int> Spiral(vector<vector<int>> matrix)
{
    vector<int> arr;

    int s = 0;
    while (arr.size() < m * n)
    {
        for (int i = s; i < n - s; i++) // Horizontal Top
        {
            arr.push_back(matrix[s + 0][i]);
        }
        if (arr.size() == m * n)
            break;

        for (int i = s + 1; i < m - 1 - s; i++) // Vertical Right
        {
            arr.push_back(matrix[i][n - 1 - s]);
        }
        if (arr.size() == m * n)
            break;

        for (int i = s; i < n - s; i++) // Horizontal Bottom
        {
            arr.push_back(matrix[m - 1 - s][n - 1 - i]);
        }
        if (arr.size() == m * n)
            break;

        for (int i = s + 1; i < m - 1 - s; i++) // Vertical Left
        {
            arr.push_back(matrix[m - 1 - i][s + 0]);
        }
        if (arr.size() == m * n)
            break;

        s += 1; //  Increase depth by 1
    }

    return arr;
}

int main()
{
    cout << "m: ";
    cin >> m;

    cout << "n: ";
    cin >> n;

    vector<vector<int>> matrix;
    matrix = createMatrix(m, n);

    // printMatrix(matrix);

    vector<int> arr = Spiral(matrix);

    printArray(arr);

    return 0;
}

/*
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

//*/