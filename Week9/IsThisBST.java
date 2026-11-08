import java.util.*;
import java.io.*;
public class IsThisBST{
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static Node root;
    static boolean checkBST(Node root) {
        return check(root, 0, Integer.MAX_VALUE);
    }

    static boolean check(Node n, int min, int max) {
        if (n == null) return true;
        if (n.data <= min || n.data >= max) return false;
        return check(n.left, min, n.data) && check(n.right, n.data, max);
    }
    static Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        if(data < node.data){
            node.left = insert(node.left, data);
        } else if(data > node.data){
            node.right = insert(node.right, data);
        }
        return node;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            int data = Integer.parseInt(input[i]);
            root = insert(root, data);
        }
        boolean check = checkBST(root);
        if(check){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
