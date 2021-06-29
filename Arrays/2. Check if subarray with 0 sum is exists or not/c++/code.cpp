#include <iostream>
#include <vector>
#include <sstream>
#include <set>

using namespace std;

bool hasZeroSumSubList(vector<int> v)
{
    set<int, greater<int>> checks;
    int sum = 0;

    for (int i = 0; i < v.size(); i++)
    {
        sum = sum + v[i];

        if (checks.find(sum) != checks.end())
        {
            return true;
        }

        checks.insert(sum);
    }

    return false;
}

int main()
{
    string arr_str;

    getline(cin, arr_str);

    vector<int> arr;

    stringstream ss(arr_str);
    string temp;

    while (getline(ss, temp, ' '))
    {
        arr.push_back(stoi(temp));
    }

    // input example = 3 4 -7 3 1 3 1 -4 -2 -2
    // arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};

    bool result = hasZeroSumSubList(arr);

    if (result)
    {
        cout << "True" << endl;
    }
    else
    {
        cout << "False" << endl;
    }

    return 0;
}
