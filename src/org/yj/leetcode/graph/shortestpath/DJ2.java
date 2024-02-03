package org.yj.leetcode.graph.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class DJ2 {


    public List<Integer> solution(int[][] graphs, int s, int n) {

        boolean[] visited = new boolean[n + 1];
        int[] path = new int[n + 1];
        int[] dist = new int[n + 1];
        List<Edge>[] adj = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            path[i] = -1;
        }
        for (int i = 0; i < graphs.length; i++) {
            int[] graph = graphs[i];
            Edge edge = new Edge(graph[0], graph[1], graph[2]);
            adj[graph[0]].add(edge);
            if (graph[0] == s) {
                dist[graph[1]] = graph[2];
                path[graph[1]]= s;
            }
        }
        dist[s] = 0;
        visited[s] = true;
        path[s]=s;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = s;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (dist[j] < min) {
                        min = dist[j];
                        index = j;
                    }
                }
            }
            if (index == s) {
                break;
            }
            visited[index] = true;
            for (Edge edge : adj[index]) {
                int v = edge.end;
                int w = edge.w;
                if (!visited[v] && dist[v] > dist[index] + w) {
                    dist[v] = dist[index] + w;
                    path[v] = index;
                }
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int[][] graphs = {
                {1, 2, 1},
                {1, 3, 10},
                {2, 3, 3}

        };

        DJ2 instance = new DJ2();
        instance.solution(graphs, 1, 3);

    }
}


