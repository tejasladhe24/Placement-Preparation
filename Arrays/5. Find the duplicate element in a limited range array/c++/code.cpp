#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>

using namespace std;

void printArray(vector<int> arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}

int main()
{
    string input, str;
    getline(cin, input);
    stringstream ss(input);
    vector<int> arr;
    while (getline(ss, str, ' '))
    {
        arr.push_back(stoi(str));
    }

    vector<int> temp({arr[0]});

    for (int i = 0; i < arr.size(); i++)
    {
        auto itr = std::find(temp.begin(), temp.end(), arr[i]);
        if (itr == temp.end())
        {
            temp.push_back(arr[i]);
        }
    }

    printArray(temp);

    return 0;
}

// Input example - 1 2 3 4 2 2 3 4 1
