public class Node {
    int value;
    Node left, right, parent;

    Node(int key) {
        this.value = key;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
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
}
