#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector<int> arr;

void printArray(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

void binSort(vector<int> &arr)
{
    vector<int> result;

    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == 0)
        {
            result.push_back(0);
        }
    }

    int size = result.size();

    for (int i = 0; i < arr.size() - size; i++)
    {
        result.push_back(1);
    }

    arr = result;
}

int main()
{
    string input, temp;
    getline(cin, input);
    stringstream ss(input);
    while (getline(ss, temp, ' '))
    {
        arr.push_back(stoi(temp));
    }

    binSort(arr);

    printArray(arr);

    return 0;
}

// Input example - 1 0 1 0 1 0 0 1
