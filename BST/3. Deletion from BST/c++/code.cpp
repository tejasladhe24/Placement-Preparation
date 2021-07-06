#include <iostream>

using namespace std;

class Node
{
public:
    int value;
    Node *left, *right, *parent;
    Node(int key = 0, Node *left_item = NULL, Node *right_item = NULL, Node *parent = NULL) : value(key), left(left_item), right(right_item), parent(parent) {}
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

Node *findMaxKey(Node *root)
{
    while (root->right != NULL)
    {
        root = root->right;
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

Node *deleteNode(Node *root, int elem)
{
    if (root == NULL)
    {
        return NULL;
    }

    if (elem == root->value)
    {
        if ((root->left == NULL) && (root->right == NULL))
        {
            root = NULL;
            return root;
        }
        else if ((root->left != NULL) && (root->right != NULL))
        {
            Node *pre = findMaxKey(root->left);
            root->value = pre->value;
            root->left = deleteNode(root, pre->value);
        }
        else
        {
            if (root->left != NULL)
                root = root->left;
            else
                root = root->right;
        }
    }
    else
    {
        if (elem < root->value)
        {
            root->left = deleteNode(root->left, elem);
        }
        else
        {
            root->right = deleteNode(root->right, elem);
        }
    }

    return root;
}

int main()
{
    Node *root = NULL;
    int arr[] = {1, 2, 4, 8, 5, 6, 7, 9, 3};

    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); i++)
    {
        root = insert(root, arr[i]);
    }

    ascending(root);
    cout << endl;
    root = deleteNode(root, 6);
    ascending(root);
    cout << endl;

    return 0;
}