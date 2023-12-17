package BTtuan12;
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

public class Roads_and_Libraries {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        // tao dnah sach ke cua cac thanh pho
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> city : cities) {
            int u = city.get(0);
            int v = city.get(1);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];

        long totalCost = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {


                long numCities = dfs(i, adjList, visited);
                totalCost += c_lib + (numCities - 1) * c_road;
            }
        }

        return totalCost;
    }


    static long dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        long count = 1;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {

                count += dfs(neighbor, adjList, visited);
            }
        }
        return count;
    }
}
