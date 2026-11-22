import java.io.*;
import java.util.*;
public class Solution {
    private static void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    private static void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();
        int lowSize = 0;
        int highSize = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().trim().split("\\s+");
            int x = Integer.parseInt(line[0]);
            if (lowSize == 0 || x <= low.lastKey()) {
                add(low, x);
                lowSize++;
            } else {
                add(high, x);
                highSize++;
            }
            if (lowSize > highSize + 1) {
                int maxLow = low.lastKey();
                remove(low, maxLow);
                lowSize--;
                add(high, maxLow);
                highSize++;
            } else if (highSize > lowSize) {
                int minHigh = high.firstKey();
                remove(high, minHigh);
                highSize--;
                add(low, minHigh);
                lowSize++;
            }
            double median;
            if (lowSize > highSize) {
                median = low.lastKey();
            } else {
                median = (low.lastKey() + high.firstKey()) / 2.0;
            }
            sb.append(String.format(Locale.US, "%.1f\n", median));
        }
        System.out.print(sb.toString());
    }
}