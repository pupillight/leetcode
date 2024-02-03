package org.yj.leetcode.graph.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DJ1 {


    public List<Integer> solution(int[][] graphs, int s, int n) {

        List<Edge>[] adj = new List[n + 1];
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int[] graph : graphs) {
            int start = graph[0];
            int end = graph[1];
            int w = graph[2];
            Edge edge = new Edge(start, end, w);
            adj[start].add(edge);

        }

        dist[s] = 0;
        Comparator<int[]> comparator = (e1, e2) -> e1[1] - e2[1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        queue.add(new int[]{s, dist[s]});

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int u = element[0];
            int distU = element[1];

            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (Edge edge : adj[u]) {
                int v = edge.end;
                int w = edge.w;
                if (distU + w < dist[v]) {
                    dist[v] = distU + w;
                    queue.add(new int[]{v, dist[v]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i]);
        }
        return null;
    }


    public static void main(String[] args) {
/*        int[][] graphs = {
                {1, 2, 2},
                {1, 3, 5},
                {2, 3, 2},
                {2, 4, 6},
                {3, 4, 7},
                {4, 3, 2},
                {4, 5, 4},
                {3, 5, 1}
        };*/

        int[][] graphs = {
                {1, 2, 1},
                {1, 3, 10},
                {2, 3, 3}

        };

        DJ1 instance = new DJ1();
        instance.solution(graphs, 1, 3);


    }
}

