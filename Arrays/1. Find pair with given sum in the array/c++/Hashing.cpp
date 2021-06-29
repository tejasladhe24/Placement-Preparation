#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <map>
#include <sstream>

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