package org.yj.leetcode;

import org.yj.application.data.structure.linked.LinkNode;

import java.util.*;

public class LeetCode1971 {
    List<Integer>[] adj;
    boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            adj[v].add(w);
            adj[w].add(v);
        }
        dfs(source, destination);
        if (visited[destination]) {
            return true;
        }
        return false;
    }

    private void dfs(int v, int dest) {
        visited[v] = true;
        if (visited[dest]) {
            return;
        }
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                dfs(w, dest);
            }
        }
    }

    public boolean validPath1(int n, int[][] edges, int source, int destination) {

        List<Integer>[] adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adjacentArr[edge[0]].add(edge[1]);
            adjacentArr[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[source] = true;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(source);
        while (!queue.isEmpty() && !visited[destination]) {
            int vertex = queue.poll();
            List<Integer> adjacent = adjacentArr[vertex];
            for (int next : adjacent) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return visited[destination];


    }

    public int findCenter(int[][] edges) {
        int[] degree = new int[edges.length + 2];
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            degree[v]++;
            degree[w]++;
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == edges.length) {
                return i;
            }
        }

        return -1;


    }

    public int findCenter2(int[][] edges) {
        int n = edges.length + 1;
        int[] degrees = new int[n + 1];
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
        for (int i = 1; ; i++) {
            if (degrees[i] == n - 1) {
                return i;
            }
        }
    }


    public int findCenter1(int[][] edges) {
        List<Integer>[] adj = new List[edges.length + 2];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            adj[v].add(w);
            adj[w].add(v);
        }

        for (int i = 0; i < adj.length; i++) {
            if (adj[i].size() == edges.length) {
                return i;
            }
        }
        return -1;
    }



/*
    private void dfs(int s, int[][] edges) {
        visited[s] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == s) {
                int w=edges[i][1];
                dfs(w, edges);
            }
        }
    }*/

    public int fib(int n) {
        int[] dp=new int[n+1];
        if (n==0) return 0;
        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode1971 instance = new LeetCode1971();
        System.out.println(instance.fib(5));
       /* int[][] edges= {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(instance.validPath(6, edges, 0, 5));*/
        /*int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(instance.validPath(3, edges, 0, 2));*/
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        //System.out.println(instance.findCenter1(edges));
    }
}
