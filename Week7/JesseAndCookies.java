import java.util.*;
import java.io.*;
public class JesseAndCookies{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        String[] firstLine = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int[] arr = new int[n];
        String[] input = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
            minHeap.add(arr[i]);
        }
        int ans = 0;
        while(minHeap.size() > 1 && minHeap.peek() < k){
            int min = minHeap.poll();
            if(minHeap.isEmpty()){
                System.out.println(-1);
                return;
            }
            else{
                int secondMin = minHeap.poll();
                int newCookie = min + 2 * secondMin;
                minHeap.add(newCookie);
                ans++;
            }
        }
        if(minHeap.peek() < k){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}