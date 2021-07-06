#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right, *parent;
    Node(int key, Node *left = NULL, Node *right = NULL, Node *parent = NULL) : value(key), left(left), right(right), parent(parent) {}
};

Node *insert(Node *root, int key)
{
    if (root == NULL)
    {
        return new Node(key);
    }

    if (key < root->value)
    {
        root->left = insert(root->left, key);
        root->left->parent = root;
    }
    else
    {
        root->right = insert(root->right, key);
        root->right->parent = root;
    }

    return root;
}

bool checker(Node *root, int low, int high)
{
    if (root == NULL)
        return true;
    if ((root->value < low) || (root->value > high))
        return false;

    return (checker(root->left, low, root->value - 1) && checker(root->right, root->value + 1, high));
}

int main()
{
    Node *root = NULL;
    vector<int> keys = {15, 10, 20, 8, 12, 16, 25};

    for (int i = 0; i < keys.size(); i++)
    {
        root = insert(root, keys[i]);
    }

    sort(keys.begin(), keys.end());

    if (checker(root, keys[0], keys[keys.size() - 1]))
    {
        cout << "Positive: Given binary tree is a BST" << endl;
    }
    else
    {
        cout << "Negative: Given binary tree is not a BST" << endl;
    }

    return 0;
}