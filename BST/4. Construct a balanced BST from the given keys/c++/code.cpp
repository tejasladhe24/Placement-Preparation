#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right;
    Node(int key, Node *left_item = NULL, Node *right_item = NULL) : value(key), left(left_item), right(right_item) {}
};

void ascending(Node *root)
{
    if (root == NULL)
    {
        return;
    }
    ascending(root->left);
    cout << root->value << " ";
    ascending(root->right);
}

Node *construct(vector<int> keys, int low, int high, Node *root)
{
    if (low > high)
    {
        return root;
    }

    int mid = (low + high) / 2;

    root = new Node(keys[mid]);

    root->left = construct(keys, low, mid - 1, root->left);
    root->right = construct(keys, mid + 1, high, root->right);

    return root;
}

int main()
{
    Node *root = NULL;

    vector<int> keys = {15, 10, 20, 8, 12, 16, 25};
    sort(keys.begin(), keys.end());

    root = construct(keys, 0, keys.size() - 1, root);
    ascending(root);
    cout << endl;
    return 0;
}