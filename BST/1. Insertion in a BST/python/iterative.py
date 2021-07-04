# Install binarytree library for more flexibility: pip install binarytree
# from binarytree import Node

class Node:
    left = None
    right = None

    def __init__(self,value):
        self.value = value

def ascending(root):
    if root is None:
        return
    ascending(root.left)
    print(root.value, end=' ')
    ascending(root.right)

def iterativeInsert(root, key):
    if root is None:
        return Node(key)
    
    parent = None
    curr = root
    while (curr):
        parent = curr
        if key < curr.value:
            curr = curr.left
        else:
            curr = curr.right
        
    if key < parent.value:
        parent.left = Node(key)
    else:
        parent.right = Node(key)
    
    return root

keys = [15, 10, 20, 8, 12, 16, 25,30]

root = None
for key in keys:
    root = iterativeInsert(root,key)

ascending(root)
# print(root)     # Use this with imported Node class to print out tree data structure