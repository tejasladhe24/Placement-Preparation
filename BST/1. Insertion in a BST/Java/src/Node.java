public class Node {
    int value;
    Node left, right;

    Node(int key) {
        this.value = key;
        this.left = null;
        this.right = null;
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