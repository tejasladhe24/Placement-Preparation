# Install binarytree library for more flexibility: pip install binarytree
from binarytree import Node

# class Node:
#     left = None
#     right = None

#     def __init__(self,value):
#         self.value = value

def recursiveInsert(root, key):
    if root is None:
        return Node(key)

    if key < root.value:
        root.left = recursiveInsert(root.left, key)
    else:
        root.right = recursiveInsert(root.right, key)

    return root

def ascending(root):
    if root is None:
        return
    ascending(root.left)
    print(root.value, end=' ')
    ascending(root.right)

keys = [15, 10, 8, 20, 12, 16, 25, 30]


root = None
for key in keys:
    root = recursiveInsert(root,key)


ascending(root)

print(root)  # Use this with imported Node class to print out tree data structure