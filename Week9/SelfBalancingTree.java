import java.util.*;
import java.io.*;
public class SelfBalancingTree{
    static class Node{
        int val;
        Node left, right;
        int ht;
    }
    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0;
            return node;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        int balance = height(root.left) - height(root.right);
        if (balance > 1) {
            if (val > root.left.val) root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1) {
            if (val < root.right.val) root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    static int height(Node node) {
        return node == null ? -1 : node.ht;
    }
    static Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    static void inOrder(Node root, List<String> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.val + "(BF=" + getBalance(root) + ")");
            inOrder(root.right, result);
        }
    }
    static void preOrder(Node root, List<String> result) {
        if (root != null) {
            result.add(root.val + "(BF=" + getBalance(root) + ")");
            preOrder(root.left, result);
            preOrder(root.right, result);
        }
    }
    static int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().trim().split("\\s+");
        Node root = null;
        for(int i = 0; i < n; i++){
            int data = Integer.parseInt(input[i]);
            root = insert(root, data);
        }
        int m = Integer.parseInt(br.readLine());
        root =insert(root, m);

        List<String> inOrderResult = new ArrayList<>();
        inOrder(root, inOrderResult);
        System.out.println(String.join(" ", inOrderResult));

        List<String> preOrderResult = new ArrayList<>();
        preOrder(root, preOrderResult);
        System.out.println(String.join(" ", preOrderResult));
    }
}