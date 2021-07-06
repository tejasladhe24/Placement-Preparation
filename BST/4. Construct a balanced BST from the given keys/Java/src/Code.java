import java.util.Arrays;

public class Code {
    public static void ascending(Node root) {
        if (root == null) {
            return;
        }
        ascending(root.left);
        System.out.print(root.value + " ");
        ascending(root.right);
    }

    public static Node construct(int[] keys, int low, int high, Node root) {
        if (low > high) {
            return root;
        }

        int mid = (low+high)/2;
        root = new Node(keys[mid]);
        root.left = construct(keys, low, mid-1, root.left);
        root.right = construct(keys, mid+1, high, root.right);

        return root;
    }

    public static void main(String[] args) throws Exception {
        Node root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Arrays.sort(keys);

        root = construct(keys, 0, keys.length-1, root);

        ascending(root);
        System.out.print("\n");
    }
}
