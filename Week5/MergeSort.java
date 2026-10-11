import java.util.*;
import java.io.*;
public class MergeSort {
    public static void merge(int[] arr, int left, int mid, int right){
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while(i < mid - left + 1 && j < right - mid){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while(i < mid - left + 1){
            arr[k++] = leftArr[i++];
        }
        while(j < right - mid){
            arr[k++] = rightArr[j++];
        }
    }
    public static void mergeSort(int[] arr, int left, int right){
        int mid = (left + right) / 2;
        if(left < right){
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        mergeSort(arr, 0, n - 1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}