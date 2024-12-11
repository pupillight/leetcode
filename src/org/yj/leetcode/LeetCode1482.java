package org.yj.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCodeLCP07 {
    List<Integer>[] adj;
    boolean[] visited;
    int res = 0;

    public int numWays(int n, int[][] relation, int k) {

        visited = new boolean[n];
        adj = new List[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < relation.length; i++) {
            int v = relation[i][0];
            int w = relation[i][1];
            adj[v].add(w);
        }

        dfs(0, 0, k, n);
        return res;
    }

    private void dfs(int v, int index, int k, int n) {
        //visited[v] = true;

        if (index == k) {
            if (v == n - 1) {
                res++;
            }
            return;
        }
       /* if (v == n - 1 && index == k) {
            res++;
            return;
        }*/
        for (Integer w : adj[v]) {
            // if (!visited[w]) {
            dfs(w, index + 1, k, n);
            // }
        }

    }

    public static void main(String[] args) {
        LeetCodeLCP07 instance = new LeetCodeLCP07();
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};

        System.out.println(instance.numWays(5, relation, 3));

    }
}
