import java.util.Arrays;

public class Code {

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.value) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static boolean checker(Node root, int low, int high) {
        if (root == null) {
            return true;
        }
        if ((root.value < low) || (root.value > high)) {
            return false;
        }

        return (checker(root.left, low, root.value-1) && checker(root.right, root.value+1, high));
    }

    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int i = 0; i < keys.length; i++) {
            root = insert(root, keys[i]);
        }

        Arrays.sort(keys);

        if (checker(root, keys[0], keys[keys.length-1])) {
            System.out.print("Positive: Given binary tree is a BST");
        }
        else {
            System.out.print("Negative: Given binary tree is not a BST");
        }
    }
}
