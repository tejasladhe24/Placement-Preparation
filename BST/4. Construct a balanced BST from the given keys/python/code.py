class Node:
    left = None
    right = None

    def __init__(self,key):
        self.value = key

def ascending(root):
    if root is None:
        return
    ascending(root.left)
    print(root.value, end=" ")
    ascending(root.right)

def construct(keys, low, high, root):
    if low > high:
        return root

    mid = (low+high)//2
    root = Node(keys[mid])

    root.left = construct(keys, low, mid-1, root.left)
    root.right = construct(keys, mid+1, high, root.right)

    return root

root = None

keys = [15, 10, 20, 8, 12, 16, 25]
keys.sort()
root = construct(keys, 0, len(keys)-1, root)

ascending(root)
print("\n")