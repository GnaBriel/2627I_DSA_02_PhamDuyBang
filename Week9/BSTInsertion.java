import java.util.*;
import java.io.*;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class BST {
    Node root;
    BST() {
        root = null;
    }
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
public class BSTInsertion {
    static void printInOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BST bst = new BST();
        String[] input = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(input[i]);
            bst.root = bst.insert(bst.root, data);
        }
        printInOrder(bst.root);
    }
}