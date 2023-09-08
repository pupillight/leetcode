package org.yj.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Offer116 {

    boolean[] visited;
    int count = 0;

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[v][i] == 1 && v != i) {
                dfs(isConnected, i);
            }
        }
    }

    public static void main(String[] args) {
        Offer116 instance = new Offer116();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(instance.findCircleNum(isConnected));
    }
}
