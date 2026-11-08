import java.util.*;
import java.io.*;
public class LowestCommonAncestor{
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static Node root;
    static Node lca(Node node, int n1, int n2){
        if(node == null){
            return null;
        }
        if(node.data > n1 && node.data > n2){
            return lca(node.left, n1, n2);
        }
        if(node.data < n1 && node.data < n2){
            return lca(node.right, n1, n2);
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
        String[] query = br.readLine().trim().split("\\s+");
        int n1 = Integer.parseInt(query[0]);
        int n2 = Integer.parseInt(query[1]);
        Node ancestor = lca(root, n1, n2);
        if(ancestor != null){
            System.out.println(ancestor.data);
        } else {
            System.out.println("LCA not found");
        }
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
}