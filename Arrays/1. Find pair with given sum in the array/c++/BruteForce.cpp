#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>

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
    int n = 6;
    // scanf("%d", &n);
    vector<int> arr(n);

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &arr[i]);
    // }

    int sum = 0;
    // scanf("%d", &sum);

    arr = {8, 7, 2, 5, 3, 1};
    sum = 10;

    findPair(arr, sum);

    return 0;
}