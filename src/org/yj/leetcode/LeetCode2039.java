package org.yj.leetcode;

import java.util.*;

public class LeetCode2039 {


    List<Integer>[] adj;
    boolean[] isVisited;
    int[] path;
    int[] dist;

    //无权图最短路径
    public void shortestPath(int[][] edges, int n) {

        int len = n;
        adj = new List[len];
        isVisited = new boolean[len];
        path = new int[len];
        dist = new int[len];
        Arrays.fill(path, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }


        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        dist[0] = 0;
        isVisited[0] = true;
        path[0] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Integer v : adj[curr]) {
                if (!isVisited[v]) {
                    queue.add(v);
                    if (dist[v] > dist[curr] + 1) {
                        dist[v] = dist[curr] + 1;
                    }
                    isVisited[v] = true;
                    path[v] = curr;
                }
            }
        }

    }


    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int len = patience.length;
        shortestPath(edges, len);
        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            int time = patience[i] * ((2 * dist[i] - 1) / patience[i]) + 2 * dist[i] + 1;
            res = Math.max(res, time);
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode2039 instance = new LeetCode2039();
        int[][] edges = {{0, 1,}, {1, 2}};

        int[] patience = {0, 2, 1};
        System.out.println(instance.networkBecomesIdle(edges, patience));

    }
}
