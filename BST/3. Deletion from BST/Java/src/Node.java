public class Node {
    int value;
    Node left, right, parent;

    Node(int key) {
        this.value = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
