package org.yj.leetcode.graph.shortestpath;

import java.util.Arrays;

public class Floyd {
    public void solution(int[][] graphs, int n) {

        int[][] dist = new int[n + 1][n + 1];
/*        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }*/
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dist[i][j] = Integer.MAX_VALUE;

            }
            dist[i][i] = 0;
        }

        for (int i = 0; i < graphs.length; i++) {
            int[] graph = graphs[i];
            int start = graph[0];
            int end = graph[1];
            int w = graph[2];
            dist[start][end] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE
                            && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        System.out.println(dist);
    }

    public static void main(String[] args) {
        int[][] graphs = {
                {1, 2, 2},
                {1, 3, 5},
                {2, 3, 2},
                {2, 4, 6},
                {3, 4, 7},
                {4, 3, 2},
                {4, 5, 4},
                {3, 5, 1}
        };
        Floyd instance = new Floyd();
        instance.solution(graphs, 5);


    }
}
