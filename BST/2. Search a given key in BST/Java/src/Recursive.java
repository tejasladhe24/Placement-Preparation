public class Recursive {
    public static void searchElem(Node root, int elem) {
        if (root == null){
            System.out.print("Element not found\n");
            return;
        }

        if (elem == root.value) {
            if (root.parent == null) {
                System.out.print("Position: Root Node\n");
            }
            else if (elem < root.parent.value) {
                System.out.println("Position: Left of Node with key " + root.parent.value);
            }
            else {
                System.out.println("Position: Right of Node with key " + root.parent.value);
            }
        }
        else {
            if (elem < root.value){
                searchElem(root.left, elem);
            }
            else {
                searchElem(root.right, elem);
            }
        }
    }

    public static void ascending(Node root) {
        if (root == null) {
            return;
        }
        ascending(root.left);
        System.out.print(root.value + " ");
        ascending(root.right);
    }

    public static void main(String[] args) throws Exception {
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
