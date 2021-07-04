public class Iterative {
    public static Node iterativeInsert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        Node curr = root;
        Node parent = new Node(0);

        while(curr != null) {
            parent = curr;
            if (key < curr.getValue()) {
                curr = curr.getLeft();
            }
            else {
                curr = curr.getRight();
            }
        }

        if (key < parent.getValue()) {
            parent.setLeft(new Node(key));
        }
        else {
            parent.setRight(new Node(key));
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

    public static void main(String args[]) {
        Node root = null;

        int[] keys = {15, 10, 8, 20, 12, 16, 25, 30};

        for (int i = 0; i < keys.length; i++) {
            root = iterativeInsert(root, keys[i]);
        }

        ascending(root);
        
    }
}
