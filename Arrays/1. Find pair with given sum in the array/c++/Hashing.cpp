#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <map>

using namespace std;

void printPair(pair<int, int> pair)
{
    cout << "(" << pair.first << ", " << pair.second << ")" << endl;
}

void findPair(vector<int> arr, int sum)
{
    map<int, int> Map;
    for (int i = 0; i < arr.size(); i++)
    {
        auto itr = Map.find(sum - arr[i]);
        if (itr != Map.end())
        {
            printPair(pair<int, int>(arr[Map.at(sum - arr[i])], arr[i]));
        }

        Map.insert({arr[i], i});
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