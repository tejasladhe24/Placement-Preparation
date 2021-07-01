// This code give subarrays of size two and three
#include <stdio.h>
#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector<int> input()
{
    vector<int> arr;
    string input;

    getline(cin, input);
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, ' '))
    {
        arr.push_back(stoi(temp));
    }

    return arr;
}

void TwoElemsSubArrays(vector<int> arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = i + 1; j < arr.size(); j++)
        {
            if (arr[i] + arr[j] == 0)
            {
                cout << "(" << arr[i] << ", " << arr[j] << ")" << endl;
            }
        }
    }
}

void ThreeElemsSubArrays(vector<int> arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = i + 1; j < arr.size(); j++)
        {
            for (int k = j + 1; k < arr.size(); k++)
            {
                if (arr[i] + arr[j] + arr[k] == 0)
                {
                    cout << "(" << arr[i] << ", " << arr[j] << ", " << arr[k] << ")" << endl;
                }
            }
        }
    }
}

int main()
{
    vector<int> arr = input();
    TwoElemsSubArrays(arr);
    ThreeElemsSubArrays(arr);

    return 0;
}

// Input Example - 4 2 -3 -1 0 -4