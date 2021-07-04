public class Recursive {

    public static Node recursiveInsert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.getValue()) {
            root.setLeft(recursiveInsert(root.getLeft(), key));
        }
        else {
            root.setRight(recursiveInsert(root.getRight(), key));
        }

        return root;
    }

    
    public static void ascending(Node root) {
        if (root == null) {
            return;
        }

        ascending(root.getLeft());
        System.out.print(root.getValue() + " ");
        ascending(root.getRight());
    }

    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] keys = {15, 10, 8, 20, 12, 16, 25, 30};

        for (int i = 0; i < keys.length; i++) {
            root = recursiveInsert(root, keys[i]);
        }

        ascending(root);
    }
}
