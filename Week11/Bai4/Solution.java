import java.util.*;
import java.io.*;
public class Distance{

    puclic static void main(String[] args) throw IOException{
        HashMap<Integer, Integer> map = new HashMap<>();
        BufferredReader br = new BufferedReader(new InputStreamReader(System.in));
        String[2] input = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String[] arr = br.readLine().trim().split("\\s+");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 0; i < n; i++)
    }
}