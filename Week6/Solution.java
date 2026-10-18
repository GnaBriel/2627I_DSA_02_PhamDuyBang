import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        if (firstLine == null) return;
        int n = Integer.parseInt(firstLine.trim());
        int[] arr = new int[n];
        String[] input = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int pivot = arr[0];
        int j = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] < pivot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int temp = arr[0];
        arr[0] = arr[j - 1];
        arr[j - 1] = temp;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        br.close();
    }
}