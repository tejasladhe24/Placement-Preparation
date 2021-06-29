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