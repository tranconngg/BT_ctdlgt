package BTtuan9;

import java.util.Scanner;

public class Vo_bo_5 {
    static int[] a;
    static int[] segTree;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        SegmentTree();

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int min = queryMin(1, 1, n, l, r);
                System.out.println(min);
            } else if (type == 2) {
                int id = scanner.nextInt();
                int v = scanner.nextInt();
                update(1, 1, n, id, v);
            }
        }
    }

    static void SegmentTree() {
        segTree = new int[4 * n];
        build(1, 1, n);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            segTree[node] = a[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            segTree[node] = Math.min(segTree[2 * node], segTree[2 * node + 1]);
        }
    }

    static int queryMin(int node, int start, int end, int l, int r) {
        if (r < start || l > end) {

            return Integer.MAX_VALUE;
        }
        if (l <= start && end <= r) {

            return segTree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = queryMin(2 * node, start, mid, l, r);
        int rightMin = queryMin(2 * node + 1, mid + 1, end, l, r);
        return Math.min(leftMin, rightMin);
    }

    static void update(int node, int start, int end, int id, int v) {
        if (start == end) {

            a[id] = v;
            segTree[node] = v;
        } else {
            int mid = (start + end) / 2;
            if (id >= start && id <= mid) {

                update(2 * node, start, mid, id, v);
            } else {

                update(2 * node + 1, mid + 1, end, id, v);
            }
            segTree[node] = Math.min(segTree[2 * node], segTree[2 * node + 1]);
        }
    }
}
