package BTtuan13;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }
    }
    static class DisjointSet {
        int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }

        public boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(gNodes + 1);

        int minWeight = 0;
        int numEdges = 0;
        for (Edge edge : edges) {
            if (!ds.isSameSet(edge.from, edge.to)) {
                ds.union(edge.from, edge.to);
                minWeight += edge.weight;
                numEdges++;
            }
            if (numEdges == gNodes - 1) {
                break;
            }
        }
        return minWeight;
    }
}
