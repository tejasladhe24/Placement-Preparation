#include <iostream>
#include <vector>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right, *parent;
    Node(int key = 0, Node *left_item = NULL, Node *right_item = NULL, Node *parent = NULL) : value(key), left(left_item), right(right_item) {}
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
        cout << "Root is empty" << endl;
        return;
    }

    Node *curr = root;

    while ((curr) && (elem != curr->value))
    {
        if (elem < curr->value)
        {
            curr = curr->left;
        }
        else
        {
            curr = curr->right;
        }
    }

    if (curr == NULL)
    {
        cout << "Element not found" << endl;
        return;
    }
    else if (curr->parent == NULL)
    {
        cout << "Position: Root Node" << endl;
        return;
    }
    else if (elem < curr->parent->value)
    {
        cout << "Position: Left of Node with key " << curr->parent->value << endl;
        return;
    }
    else
    {
        cout << "Position: Right of Node with key " << curr->parent->value << endl;
        return;
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
    searchElem(root, 12);
    cout << endl;

    return 0;
}