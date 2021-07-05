public class Recursive {

    public static Node recursiveInsert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.value) {
            root.left = recursiveInsert(root.left, key);
        }
        else {
            root.right = recursiveInsert(root.right, key);
        }

        return root;
    }

    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] keys = {15, 10, 8, 20, 12, 16, 25, 30};

        for (int i = 0; i < keys.length; i++) {
            root = recursiveInsert(root, keys[i]);
        }

        root.ascending(root);
    }
}
