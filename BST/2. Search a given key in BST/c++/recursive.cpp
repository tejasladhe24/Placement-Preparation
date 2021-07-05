#include <iostream>
#include <vector>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right;
    Node *parent;

    Node(int key = 0, Node *left_item = NULL, Node *right_item = NULL, Node *parent_item = NULL) : value(key), left(left_item), right(right_item), parent(parent_item) {}
};

Node *insert(Node *root, int key)
{
    if (root == NULL)
    {
        root = new Node(key);
        return root;
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

void searchElem(Node *root, int elem)
{
    if (root == NULL)
    {
        cout << "Element not found" << endl;
        return;
    }

    if (elem == root->value)
    {
        if (root->parent == NULL)
        {
            cout << "Position: Root Node" << endl;
        }
        else if (elem < root->parent->value)
        {
            cout << "Position: Left of Node with key " << root->parent->value << endl;
        }
        else
        {
            cout << "Position: Right of Node with key " << root->parent->value << endl;
        }
    }
    else
    {
        if (elem < root->value)
        {
            searchElem(root->left, elem);
        }
        else
        {
            searchElem(root->right, elem);
        }
    }
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
    vector<int> keys = {15, 10, 20, 8, 12, 16, 25, 30};

    for (int i = 0; i < keys.size(); i++)
    {
        root = insert(root, keys[i]);
    }

    // ascending(root);
    searchElem(root, 20);
    cout << endl;

    return 0;
}