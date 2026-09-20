import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class FourSum {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static void main(String[] args) {
        FastReader in = new FastReader();
        String nStr = in.next();
        if (nStr == null) return;
        int n = Integer.parseInt(nStr);
        long x = in.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        int initialCapacity = (int) ((n * n / 2) / 0.75) + 1;
        HashMap<Long, int[]> seen = new HashMap<>(initialCapacity);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long needed = x - a[i] - a[j];
                if (seen.containsKey(needed)) {
                    int[] pair = seen.get(needed);
                    System.out.println((pair[0] + 1) + " "  + (pair[1] + 1) + " "  + (i + 1) + " "  + (j + 1));
                    return;
                }
            }
            for (int j = 0; j < i; j++) {
                seen.put(a[j] + a[i], new int[]{j, i});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}