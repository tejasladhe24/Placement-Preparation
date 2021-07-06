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
        root.left = insert(root.left,key)
        root.left.parent = root
    else:
        root.right = insert(root.right,key)
        root.right.parent = root
    
    return root

def findMaxKey(root):
    while root.right:
        root = root.right
    
    return root

def deleteNode(root,key):
    if root is None:
        return root

    if (key == root.value):
        if ((root.left == None) and (root.right == None)):
            return None
        elif (root.left and root.right):
            pre = findMaxKey(root.left)
            root.value = pre.value
            root.left = deleteNode(root.left, pre.data)
        else:
            if (root.left):
                root = root.left
            else:
                root = root.right

    else:
        if (key < root.value):
            root.left = deleteNode(root.left, key)
        else:
            root.right = deleteNode(root.right, key)
    
    return root

def ascending(root):
    if root is None:
        return
    ascending(root.left)
    print(root.value,end=' ')
    ascending(root.right)

root = None
keys = [1,4,7,9,2,5,8,6,3]
for key in keys:
    root = insert(root,key)

ascending(root)
print("\n")

root = deleteNode(root, 5)

ascending(root)