package BTtuan9;

import java.util.Arrays;
import java.util.List;

public class Jesse_cookies_vobo {
    static class MyPriorityQueue {
        private int[] heap;
        private int size;
        private int capacity;

        public MyPriorityQueue() {
            capacity = 10;
            heap = new int[capacity];
            size = 0;
        }

        public void add(int item) {
            ensureCapacity();
            heap[size] = item;
            size++;
            heapifyUp(size - 1);
        }

        public int poll() {
            if (isEmpty()) {
                throw new IllegalStateException("Priority queue is empty");
            }

            int item = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Priority queue is empty");
            }

            return heap[0];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (size == capacity) {
                capacity *= 2;
                heap = Arrays.copyOf(heap, capacity);
            }
        }

        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;

            if (index > 0 && heap[index] < heap[parentIndex]) {
                swap(index, parentIndex);
                heapifyUp(parentIndex);
            }
        }

        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex != index) {
                swap(index, smallestIndex);
                heapifyDown(smallestIndex);
            }
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    }
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        MyPriorityQueue pq = new MyPriorityQueue();
        for (int num : A) {
            pq.add(num);
        }

        int count = 0;
        while (pq.peek() < k && pq.size > 1) {
            int leastSweetCookie = pq.poll();
            int secondLeastSweetCookie = pq.poll();

            int newCookie = leastSweetCookie + (2 * secondLeastSweetCookie);
            pq.add(newCookie);
            count++;
        }
        return pq.peek() >= k ? count : -1;
    }
}
