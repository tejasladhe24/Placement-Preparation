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

vector<int> createArray(int m, int n)
{
    vector<int> arr(m * n);

    string input;
    string temp;

    cin >> ws; // stream out any whitespace
    getline(cin, input);
    stringstream ss(input);

    for (int i = 0; i < m * n; i++)
    {
        getline(ss, temp, ' ');
        arr[i] = stoi(temp);
    }

    return arr;
}

vector<vector<int>> createSpiral(vector<int> arr, int m, int n)
{
    vector<vector<int>> matrix(m, vector<int>(n));

    int idx = 0;
    int s = 0;
    while (idx < m * n)
    {
        for (int i = s; i < n - s; i++) // Horizontal Top
        {
            matrix[s + 0][i] = arr[idx];
            idx = idx + 1;
        }
        if (idx == m * n)
            break;

        for (int i = s + 1; i < m - 1 - s; i++) // Vertical Right
        {
            matrix[i][n - 1 - s] = arr[idx];
            idx = idx + 1;
        }
        if (idx == m * n)
            break;

        for (int i = s; i < n - s; i++) // Horizontal Bottom
        {
            matrix[m - 1 - s][n - 1 - i] = arr[idx];
            idx = idx + 1;
        }
        if (idx == m * n)
            break;

        for (int i = s + 1; i < m - 1 - s; i++) // Vertical Left
        {
            matrix[m - 1 - i][s + 0] = arr[idx];
            idx = idx + 1;
        }
        if (idx == m * n)
            break;

        s += 1; //  Increase depth by 1
    }

    return matrix;
}

int main()
{
    cout << "m: ";
    cin >> m;

    cout << "n: ";
    cin >> n;

    vector<int> arr = createArray(m, n);
    vector<vector<int>> matrix = createSpiral(arr, m, n);

    printMatrix(matrix);

    return 0;
}

/*
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


//*/