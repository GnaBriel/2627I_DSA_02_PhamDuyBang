import java.util.*;
import java.io.*;
public class FindMedian{
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static int quickSelect(int[] arr, int low, int high, int k){
        if(low < high){
            int pivot = partition(arr, low, high);
            if(pivot == k){
                return arr[k];
            } else if(pivot < k){
                return quickSelect(arr, pivot + 1, high, k);
            } else {
                return quickSelect(arr, low, pivot - 1, k);
            }
        }
        return arr[k];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int medianIndex = n / 2;
        int median = quickSelect(arr, 0, n - 1, medianIndex);
        System.out.println(median);
    }
}