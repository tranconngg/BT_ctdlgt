package BTtuan9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Vo_bo_4 {

    int[] tree;
    int[] arr;
    int n;

    public Vo_bo_4(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, x) - 1;
        tree = new int[maxSize];
        build(0, n - 1, 0);
    }

    private int build(int start, int end, int current) {
        if (start == end) {
            tree[current] = arr[start];
            return tree[current];
        }
        int mid = (start + end) / 2;
        tree[current] = Math.max(build(start, mid, current * 2 + 1), build(mid + 1, end, current * 2 + 2));
        return tree[current];
    }

    public int getMax(int left, int right) {
        return getMaxUtil(0, n - 1, left, right, 0);
    }

    private int getMaxUtil(int start, int end, int left, int right, int current) {
        if (left <= start && right >= end) {
            return tree[current];
        }
        if (end < left || start > right) {
            return Integer.MIN_VALUE;
        }
        int mid = (start + end) / 2;
        return Math.max(getMaxUtil(start, mid, left, right, 2 * current + 1),
                getMaxUtil(mid + 1, end, left, right, 2 * current + 2));
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Vo_bo_4 segmentTree = new Vo_bo_4(arr);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(segmentTree.getMax(l - 1, r - 1));
        }
    }
}