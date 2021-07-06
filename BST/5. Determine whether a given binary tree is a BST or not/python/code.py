class Node:
    left = None
    right = None
    parent = None

    def __init__(self,key):
        self.value = key

def insert(root, key):
    if root is None:
        return Node(key)

    if (key < root.value):
        root.left = insert(root.left, key)
    else:
        root.right = insert(root.right, key)
    
    return root

def checker(root, low, high):
    if root is None:
        return True
    if (root.value < low) or (root.value > high):
        return False
    
    return (checker(root.left, low, root.value - 1) and checker(root.right, root.value + 1, high))

root = None
arr = [] 
keys = [15, 10, 20, 8, 12, 16, 25]

for key in keys:
    root = insert(root,key)

if (checker(root, min(keys), max(keys))):
    print("Positive: Given binary tree is a BST")
else:
    print("Negative: Given binary tree is not a BST")