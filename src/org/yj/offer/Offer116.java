package org.yj.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer116 {
    boolean[] visited;
    int[] province;
    int provinceCount = 0;
    List<Integer>[] adj;

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        visited = new boolean[length];
        province = new int[length];
        Arrays.fill(province, -1);
        adj = new List[length];
        for (int i = 0; i < length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                dfs(i);
                provinceCount++;
            }
        }
        return provinceCount;
    }

    private void dfs(int v) {
        visited[v] = true;
        province[v]=provinceCount;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Offer116 instance = new Offer116();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(instance.findCircleNum(isConnected));
    }
}

/*class Graph {
    private boolean[] visited;
    private int gCount;
    private int[] group;
    private List<Integer>[] adj;

    public Graph(int count) {
        visited = new boolean[count];
        gCount = 0;
        group = new int[count];
        Arrays.fill(group, -1);
        adj = new List[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int calGroupCount() {
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfs(i);
                gCount++;
            }
        }
        return this.gCount;
    }

    public void dfs(int p) {
        visited[p] = true;
        group[p] = gCount;
        for (int q : adj[p]) {
            if (!visited[q]) {
                dfs(q);
            }
        }
    }

    public void addEdge(int p, int q) {
        if (p == q) {
            return;
        }
        adj[p].add(q);
        adj[q].add(p);
    }
}*/
