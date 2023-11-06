package BTtuan8;

import java.util.List;
import java.util.PriorityQueue;

public class Jessi_and_cookies {
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : A) {
            pq.offer(num);
        }

        int count = 0;
        while (pq.peek() < k && pq.size() > 1) {
            int leastSweetCookie = pq.poll();
            int secondLeastSweetCookie = pq.poll();

            int newCookie = leastSweetCookie + (2 * secondLeastSweetCookie);
            pq.offer(newCookie);
            count++;
        }

        return pq.peek() >= k ? count : -1;
    }

}
