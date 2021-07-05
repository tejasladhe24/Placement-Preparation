# from binarytree import Node

class Node:
    left = None
    right = None
    parent = None
    def __init__(self,value):
        self.value = value

def insert(root, key):
    if root is None:
        return Node(key)

    if key < root.value:
        root.left = insert(root.left, key)
        root.left.parent = root 
    else:
        root.right = insert(root.right, key)
        root.right.parent = root 
 
    return root

def ascending(root):
    if root is None:
        return
    ascending(root.left)
    print(root.value, end=' ')
    ascending(root.right)

def searchElem(root,elem):
    if root is None:
        print("Root is empty")
        return

    curr = root

    while((curr) and (curr.value is not elem)):
        if (elem < curr.value):
            curr = curr.left
        else:
            curr = curr.right
    
    if curr is None:
        print("Element not found")
        return
    elif (curr.parent is None):
        print("Position: Root Node")
        return
    elif (elem < curr.parent.value):
        print("Position: Left of Node with key", curr.parent.value)
        return
    else:
        print("Position: Right of Node with key", curr.parent.value)
        return
    
keys = [15, 10, 20, 8, 12, 16, 25,30]

root = None
for key in keys:
    root = insert(root,key)

searchElem(root,30)