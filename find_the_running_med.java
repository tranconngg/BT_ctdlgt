package BTtuan11;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class find_the_running_med {
    public static List<Double> runningMedian(List<Integer> arr) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            if (maxPQ.isEmpty() || num < maxPQ.peek()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }

            // can bang heaps
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.offer(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }

            // tinh the median
            double median;
            if (maxPQ.size() == minPQ.size()) {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            } else {
                median = maxPQ.peek();
            }

            result.add(median);
        }
        return result;
    }
}
