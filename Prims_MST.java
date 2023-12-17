package BTtuan13;

import java.util.List;
import java.util.PriorityQueue;

public class Prims_MST {
    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        int[] a = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int minWeight = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            minWeight += weight;

            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);

                if (u == node && !visited[v] && w < a[v]) {
                    a[v] = w;
                    pq.add(new Edge(v, w));
                }

                if (v == node && !visited[u] && w < a[u]) {
                    a[u] = w;
                    pq.add(new Edge(u, w));
                }
            }
        }

        return minWeight;
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
