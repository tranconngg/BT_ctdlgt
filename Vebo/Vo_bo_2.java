package BTtuan9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Vo_bo_2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] qua = new long[n];

        for (int i = 0; i < n; i++) {
            qua[i] = scanner.nextLong();
        }

        long[] maxthuong = findMaxthuong(n, k, qua);

        for (int i = 0; i < n; i++) {
            System.out.print(maxthuong[i] + " ");
        }
    }

    public static long[] findMaxthuong(int n, int k, long[] qua) {
        long[] maxthuong = new long[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            pq.add(qua[i]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            sum += qua[i];
            maxthuong[i] = sum;
        }

        return maxthuong;
    }
}