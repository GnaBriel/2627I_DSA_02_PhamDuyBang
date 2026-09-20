public class Main {
    public static int binarySearchFirst(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == key) {
                result = mid;
                right = mid - 1;

            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
