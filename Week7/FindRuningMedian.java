import java.util.*;
import java.io.*;
public class FindRunningMedian{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size() == minHeap.size()){
                double median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            } else {
                System.out.printf("%.1f\n", (double)maxHeap.peek());
            }
        }
    }
}