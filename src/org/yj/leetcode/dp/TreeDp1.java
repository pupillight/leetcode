package org.yj.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class TreeDp1 {
    List<Integer>[] adj;
    int[][] dp;
    int[] root;

    public int maxSatisfaction(int n, int[][] leaders) {
        adj = new List[n + 1];
        dp = new int[n + 1][2];
        root = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList();

        }
        for (int[] leader : leaders) {
            adj[leader[1]].add(leader[0]);
            root[leader[0]] = leader[1];
        }
        int i = 1;
        while (root[i] != 0) {
            i = root[i];
        }
        System.out.println(i);
        dfs(i);
        return Math.max(dp[5][0], dp[5][1]);
    }

    /*
        private int findRoot(int[][] leaders){

            for (int[] leader : leaders) {
                root[leader[0]] = leader[1];
            }

            int i=1;
            while(root[i]!=0)
            {
                i=root[i];
            }
            return i;
        }*/
    private void dfs(int u) {
        dp[u][1] = 1;
        for (Integer v : adj[u]) {
            dfs(v);
            dp[u][0] += Math.max(dp[v][1], dp[v][0]);
            dp[u][1] += dp[v][0];
        }

    }

    public static void main(String[] args) {
        TreeDp1 instance = new TreeDp1();
        int[][] leaders = {{2, 3},
                {1, 3},
                {7, 4},
                {6, 4},
                {3, 5},
                {4, 5}
        };

        System.out.println(instance.maxSatisfaction(7, leaders));
    }
}
