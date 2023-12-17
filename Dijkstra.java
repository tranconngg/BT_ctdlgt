package BTtuan13;

import java.util.*;

public class Dijkstra {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Khởi tạo đồ thị và các khoảng cách ban đầu
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }

        // Khởi tạo mảng khoảng cách
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); // Gán giá trị ban đầu là -1
        distances[s] = 0; // Khoảng cách từ điểm bắt đầu đến chính nó là 0

        // Khởi tạo hàng đợi ưu tiên
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{s, 0});

        // Áp dụng thuật toán Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            // Cập nhật khoảng cách tới các đỉnh kề
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextDist = neighbor[1];

                if (distances[nextNode] == -1 || distance + nextDist < distances[nextNode]) {
                    distances[nextNode] = distance + nextDist;
                    pq.offer(new int[]{nextNode, distances[nextNode]});
                }
            }
        }

        // Chuyển kết quả thành List và trả về
        List<Integer> shortestDistances = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                shortestDistances.add(distances[i]);
            }
        }
        return shortestDistances;
    }
}
