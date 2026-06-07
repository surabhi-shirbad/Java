import java.util.*;

public class BstRoot2leaf {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert into BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Print a root-to-leaf path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("null");
    }

    // Print all root-to-leaf paths
    public static void Root2leaf(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.data);

        // Leaf node
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            Root2leaf(root.left, path);
            Root2leaf(root.right, path);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int values[] = {2, 4, 6, 3, 10, 8, 5, 7, 8};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("\n\nRoot to Leaf Paths:");
        ArrayList<Integer> path = new ArrayList<>();
        Root2leaf(root, path);
    }
}