import java.util.*;
public class InsertionSortP2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + (k == n - 1 ? "" : " "));
            }
            System.out.println();
        }
        sc.close();
    }
}