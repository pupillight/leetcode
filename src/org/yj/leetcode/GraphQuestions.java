package org.yj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GraphQuestions {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            union(parents, a, b);
        }
        return isConnected(parents, source, destination);
    }

    private int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return parent[i];
    }

    private boolean isConnected(int[] parent, int m, int n) {
        return find(parent, m) == find(parent, n);
    }

    private void union(int[] parent, int m, int n) {

        int rootM = find(parent, m);
        int rootN = find(parent, n);
        if (rootM == rootN) return;
        parent[rootM] = rootN;

    }

    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        boolean[] marked;
        List<Integer>[] adj;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        marked = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        dfs(source, marked, adj);
        if (marked[destination]) {
            return true;
        }
        return false;
    }

    private void dfs(int source, boolean[] marked, List<Integer>[] adj) {
        marked[source] = true;
        for (int i = 0; i < adj[source].size(); i++) {
            int v = adj[source].get(i);
            if (!marked[v]) {
                dfs(v, marked, adj);
            }
        }
    }

    int way = 0;

    public int numWays(int n, int[][] relation, int k) {
        List<Integer>[] adj = new ArrayList[n];
        int[] path = new int[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
            path[i] = -1;
        }
        for (int i = 0; i < relation.length; i++) {
            adj[relation[i][0]].add(relation[i][1]);
        }
        //0->n-1
        dfsNumWays(adj, 0, n - 1, 0, k);
        return way;
    }

    private void dfsNumWays(List<Integer>[] adj, int start, int end, int round, int k) {
        if (round == k) {
            if (start == end) {
                way++;
            }
            return;
        }
        for (Integer w : adj[start]) {
            dfsNumWays(adj, w, end, round + 1, k);
        }
    }


    public static void main(String[] args) {
        GraphQuestions questions = new GraphQuestions();
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(questions.numWays(5, relation, 3));
      /*  int n = 6, source = 0, destination = 5;
        int{][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(questions.validPath(n, edges, source, destination));*/
    }


}
