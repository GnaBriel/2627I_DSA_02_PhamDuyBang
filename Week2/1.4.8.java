import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            sc.close();
            Arrays.sort(a);
            long pairs = 0;
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    cnt++;
                } else {
                    pairs += (long) cnt * (cnt - 1) / 2;
                    cnt = 1;
                }
            }
            if (n > 0) {
                pairs += (long) cnt * (cnt - 1) / 2;
            }
            System.out.println(pairs);
        } catch (FileNotFoundException e) {
            System.out.println("Nothing there");
        }
    }
}
