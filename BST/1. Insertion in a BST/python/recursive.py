# Install binarytree library for more flexibility: pip install binarytree
# from binarytree import Node
import time

class Node:
    left = None
    right = None

    def __init__(self,value):
        self.value = value

def recursiveInsert(root, key):
    if root is None:
        return Node(key)

    if key < root.value:
        root.left = recursiveInsert(root.left, key)
    else:
        root.right = recursiveInsert(root.right, key)

    return root

def ascending(root,arr):
    if root is None:
        return
    
    ascending(root.left,arr)
    arr.append(root.value)
    ascending(root.right,arr)

keys = [15, 10, 8, 20, 12, 16, 25,30]

t1 = time.time()

root = None
for key in keys:
    root = recursiveInsert(root,key)

t2 = time.time()
print("\n",t2 - t1, "secs")

arr = []
ascending(root,arr)

print(arr)

# print(root)  # Use this with imported Node class to print out tree data structure