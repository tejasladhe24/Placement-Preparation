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

Node *iterativeInsert(Node *root, int key)
{
    if (root == NULL)
    {
        root = new Node(key);
        return root;
    }

    Node *parent;
    Node *curr = root;

    while (curr)
    {
        parent = curr;
        if (key < curr->value)
        {
            curr = curr->left;
        }
        else
        {
            curr = curr->right;
        }
    }

    if (key < parent->value)
    {
        parent->left = new Node(key);
    }
    else
    {
        parent->right = new Node(key);
    }

    return root;
}

int main()
{
    vector<int> keys = {15, 10, 20, 8, 12, 16, 25, 30};

    Node *root = NULL;
    for (int i = 0; i < keys.size(); i++)
    {
        root = iterativeInsert(root, keys[i]);
    }

    ascending(root);
    cout << endl;

    return 0;
}