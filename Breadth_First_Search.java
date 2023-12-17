package BTtuan12;

import java.util.*;
public class Breadth_First_Search {

        public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
            // Khởi tạo các biến cần thiết
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // Xây dựng đồ thị từ danh sách cạnh
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                graph[u].add(v);
                graph[v].add(u);
            }

            // Khởi tạo mảng visited và distance
            boolean[] visited = new boolean[n + 1];
            int[] distance = new int[n + 1];
            Arrays.fill(distance, -1);

            // Khởi tạo hàng đợi cho BFS
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            visited[s] = true;
            distance[s] = 0;

            // Tiến hành BFS
            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        distance[v] = distance[u] + 6;
                        queue.add(v);
                    }
                }
            }

            // Chuyển kết quả về dạng List
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i != s) {
                    result.add(distance[i]);
                }
            }

            return result;
        }
    }
