public class Code {

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.value) {
            root.left = insert(root.left, key);
            root.left.parent = root;
        }
        else {
            root.right = insert(root.right, key);
            root.right.parent = root;
        }

        return root;
    }

    public static void ascending(Node root) {
        if (root == null) {
            return;
        }
        ascending(root.left);
        System.out.print(root.value + " ");
        ascending(root.right);
    }

    public static Node findMaxKey(Node root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    public static Node deleteNode(Node root, int elem) {
        if (root == null) {
            root = null;
            return root;
        }

        if (elem == root.value) {
            if ((root.left == null) && (root.right == null)) {
                return null;
            }
            else if ((root.left != null) && (root.right != null)) {
                Node pre = findMaxKey(root.left);
                root.value = pre.value;
                root.left = deleteNode(root.left, pre.value);
            }
            else {
                if (root.left != null) {
                    root = root.left;
                }
                else {
                    root = root.right;
                }
            }

        }
        else {
            if (elem < root.value) {
                root.left = deleteNode(root.left, elem);
            }
            else {
                root.right = deleteNode(root.right, elem);
            }
        }

        return root;
    }
    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] keys =  {1,4,7,9,2,5,8,6,3};

        for (int i = 0; i < keys.length; i++) {
            root = insert(root, keys[i]);
        }

        ascending(root);
        System.out.print("\n");
        root = deleteNode(root, 5);
        ascending(root);
        System.out.print("\n");
    }
}
