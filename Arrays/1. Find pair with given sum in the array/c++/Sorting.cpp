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
    sort(arr.begin(), arr.end());

    int low = 0;
    int high = arr.size() - 1;

    while (low < high)
    {
        if (arr[low] + arr[high] == sum)
        {
            printPair(pair<int, int>(arr[low], arr[high]));
            low = low + 1;
        }
        else if (arr[low] + arr[high] < sum)
        {
            low = low + 1;
        }
        else if (arr[low] + arr[high] > sum)
        {
            high = high - 1;
        }
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