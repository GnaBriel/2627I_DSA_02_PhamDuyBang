import java.util.*;
public class CountingSort1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[100];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            cnt[arr[i]]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i] + (i == cnt.length - 1 ? "" : " "));
        }
        System.out.println();
        sc.close();
    }
}