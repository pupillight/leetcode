package org.yj.leetcode.graph;

import java.util.*;

public class Leetcode743 {

    class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    List<Edge>[] adj;

    public int networkDelayTime(int[][] times, int n, int k) {

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];
            int weight = times[i][2];
            adj[start].add(new Edge(start, end, weight));
        }

        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        dist[k] = 0;

        Comparator<int[]> comparator = (e1, e2) -> e1[0] - e2[0];
        PriorityQueue<int[]> queue = new PriorityQueue(comparator);
        queue.add(new int[]{dist[k], k});

        int res = -1;
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int v = element[1];
            int distV = element[0];

            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            for (Edge edge : adj[v]) {
                int u = edge.end;
                if (distV + edge.weight < dist[u]) {
                    dist[u] = distV + edge.weight;
                    queue.add(new int[]{dist[u], u});
                    path[u] = v;

                }
            }
            res = Math.max(res, dist[v]);
        }

        int index = 0;
        for (int i = 1; i < path.length; i++) {
            if (path[i] == -1) {
                index++;
            }
        }
        if (index > 1) res = -1;


        return res;
    }

    public static void main(String[] args) {

        Leetcode743 instance = new Leetcode743();
        //int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        //int[][] times = {{1, 2, 1},{2,3,2},{1,3,4}};
        int[][] times = {{1, 2, 1}};

        System.out.println(instance.networkDelayTime(times, 2, 2));
    }
}
