package org.yj.leetcode.graph.shortestpath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NoWeightShortestPath {

    public void solution(int[][] graphs, int source) {

        int n = graphs.length;

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        dist[source] = 0;
        visited[source] = true;

        path[source] = source;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (graphs[v][j] == 1) {
                        if (!visited[j]) {
                            queue.add(j);
                            dist[j] = dist[v] + 1;
                            visited[j] = true;
                            path[j] = v;
                        }
                    }
                }
            }
        }

        Arrays.stream(dist).forEach(System.out::println);
        System.out.println("-------------------");
        Arrays.stream(path).forEach(System.out::println);
    }

    public static void main(String[] args) {
        NoWeightShortestPath instance = new NoWeightShortestPath();

        int[][] graphs = {
                {0, 1, 1, -1, -1, -1},
                {1, 0, 1, 1, -1, -1},
                {1, 1, 0, -1, 1, -1},
                {-1, 1, -1, 0, -1, 1},
                {-1, -1, 1, -1, 0, 1},
                {-1, -1, -1, 1, 1, 0}
        };

        instance.solution(graphs, 1);
    }
}
