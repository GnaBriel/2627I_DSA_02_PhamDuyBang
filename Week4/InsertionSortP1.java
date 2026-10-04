import java.util.*;
public class InsertionSortP1 {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int target = a[n - 1];
        int i = n - 2;
        while (i >= 0 && a[i] > target) {  
            a[i + 1] = a[i];
            printArray(a);
            i--;
        }
        a[i + 1] = target;
        printArray(a);
    }
}