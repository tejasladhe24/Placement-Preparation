#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <sstream>

using namespace std;

void printPair(pair<int, int> pair)
{
    cout << "(" << pair.first << ", " << pair.second << ")" << endl;
}

void findPair(vector<int> arr, int sum)
{
    bool not_found = true;
    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = 0; j < arr.size(); j++)
        {
            if (i == j)
            {
                continue;
            }

            else if (arr[i] + arr[j] == sum)
            {
                printPair(pair<int, int>(arr[i], arr[j]));
                not_found = false;
            }
        }
    }

    if (not_found)
    {
        cout << "No pairs found!" << endl;
    }
}

int main()
{
    string input;
    getline(cin, input);
    stringstream ss(input);
    string temp;

    vector<int> arr;

    while (getline(ss, temp, ' '))
    {
        arr.push_back(stoi(temp));
    }

    int sum;
    scanf("%d", &sum);

    // input example = 8 7 2 5 3 1 ; sum = 10

    findPair(arr, sum);

    return 0;
}