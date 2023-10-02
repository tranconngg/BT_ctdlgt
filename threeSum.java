package BTtuan1CTGL;

import java.lang.reflect.Array;
import java.util.Arrays;

public class threeSum {
    public static boolean binarySearch(int[] a, int l, int r, int number) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] == number) return true;
            else if (a[mid] > number) r = mid - 1;
            else if (a[mid] < number) l = mid + 1;
        }
        return false;
    }

    public static void threesum(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (binarySearch(a, j+1, n-1, -a[i]-a[j])) { // Tìm kiếm số còn lại
                    System.out.println(a[i] + " " + a[j] + " " + (-a[i]-a[j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a={1,5,-2,-5,3,-4};
        threesum(a);
    }
}
