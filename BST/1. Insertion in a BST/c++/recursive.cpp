#include <iostream>
#include <vector>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right;
    Node(int key, Node *left_elem = NULL, Node *right_elem = NULL) : value(key), left(left_elem), right(right_elem) {}
};

Node *recursiveInsert(Node *root, int key)
{
    if (root == NULL)
    {
        root = new Node(key);
        return root;
    }

    if (key < root->value)
    {
        root->left = recursiveInsert(root->left, key);
    }
    else
    {
        root->right = recursiveInsert(root->right, key);
    }

    return root;
}

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

int main()
{
    Node *root = NULL;
    vector<int> keys = {15, 10, 8, 20, 12, 16, 25, 30};

    for (int i = 0; i < keys.size(); i++)
    {
        root = recursiveInsert(root, keys[i]);
    }

    ascending(root);
    cout << endl;

    return 0;
}