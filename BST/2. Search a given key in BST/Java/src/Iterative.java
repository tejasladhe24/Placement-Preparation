public class Iterative {

    public static void searchElem(Node root, int elem) {
        if (root == null) {
            System.out.print("Root is empty");
            return;
        }

        Node curr = root;
        while ((curr != null) && (curr.value != elem)) {
            if (elem < curr.value) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        if (curr == null) {
            System.out.print("Element not found\n");
            return;
        }
        else if (curr.parent == null) {
            System.out.print("Position: Root Node\n");
            return;
        }
        else if (elem < curr.parent.value) {
            System.out.println("Position: Left of Node with key " + curr.parent.value);
            return;
        }
        else  {
            System.out.println("Position: Right of Node with key " + curr.parent.value);
            return;
        }        
    }

    public static void main(String args[]) {
        Node root = null;

        int[] keys = {15, 10, 20, 8, 12, 16, 25, 30};
        for (int i = 0; i < keys.length; i++) {
            root = root.insert(root, keys[i]);
        }

        // root.ascending(root);
        // System.out.print("\n");

        searchElem(root, 20);
    }
}
