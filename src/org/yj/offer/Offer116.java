package org.yj.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer116 {
/*
    int[] parents;
    private int find(int p) {
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parents[pRoot] = qRoot;
    }

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int length=isConnected.length;
        parents = new int[length];
        for (int i = 0; i <length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (i == parents[i]) {
                ans++;
            }
        }
        return ans;
    }*/

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }


/*
    private boolean[] visited;
    private int gCount = 0;
    private int[] group;
    List<Integer>[] adj;
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        adj = new List[length];
        for (int i=0;i<length;i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[length];
        group = new int[length];
        Arrays.fill(group,-1);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                dfs(i);
                gCount++;
            }
        }

        int ans = gCount;
        return ans;
    }

    private void dfs(int p) {
        visited[p] = true;
        for (int q : adj[p]) {
            if (!visited[q]) {
                dfs(q);
            }
        }
    }*/

/*    public int findCircleNum1(int[][] isConnected) {
        int length = isConnected.length;
        Graph graph = new Graph(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
        int ans = graph.calGroupCount();
        return ans;
    }*/

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
