package org.yj.leetcode;

import java.util.*;

public class Leetcode200 {
//    int[] parent;
//    public int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        parent = new int[n * m];
//        Arrays.fill(parent, -1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    parent[i * m + j] = i * m + j;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    grid[i][j] = '0';
//                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
//                        union(i * m + j, (i - 1) * m + j);
//                    }
//                    if (i + 1 < n && grid[i + 1][j] == '1') {
//                        union(i * m + j, (i + 1) * m + j);
//                    }
//                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
//                        union(i * m + j, i * m + j - 1);
//                    }
//                    if (j + 1 < m && grid[i][j + 1] == '1') {
//                        union(i * m + j, i * m + j + 1);
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (parent[i] == i) {
//                ans++;
//            }
//        }
//        return ans;
//    }
//
//    public int find(int p) {
//        while (p != parent[p]) {
//            p = parent[p];
//        }
//        return p;
//    }
//
//    public boolean isConnected(int p, int q) {
//        return find(p) == find(q);
//    }
//    public void union(int p, int q) {
//        int pRoot = find(p);
//        int qRoot = find(q);
//        if (pRoot == qRoot) {
//            return;
//        }
//        parent[qRoot] = pRoot;
//    }

//    int[] parent;
//    public int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        parent = new int[n * m];
//        Arrays.fill(parent, -1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    parent[i * m + j] = i * m + j;
//                    //rank[i * n + j] = 1;
//                }
//            }
//        }
///*       for (int i = 0; i < parent.length; i++) {
//            parent[i] = i;
//        }*/
//        //Arrays.fill(parent,-1);
//        for (int i = 0; i < n-1 ; i++) {
//            for (int j = 0; j < m-1 ; j++) {
//               /* if (grid[i][j] == '1') {
//                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
//                        union(i * m + j, i * m + j - 1);
//                    }
//                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
//                        union(i * m + j, (i - 1) * m + j);
//                    }
//                }*/
//
//                if (grid[i][j] == '1' && grid[i][j + 1] == '1') {
//                    union(i * m + j, i * m + j + 1);
//                }
//
//                if (grid[i][j] == '1' && grid[i + 1][j] == '1') {
//                    union(i * m + j, (i + 1) * m + j);
//                }
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < parent.length; i++) {
//            if (parent[i] == i) {
//                ans++;
//            }
//        }
//        return ans;
//    }
//
//
//    public int find(int p) {
//
//       /* while (p != -1) {
//            p = parent[p];
//        }
//        return p;*/
//        while (p != parent[p]) {
//            p = parent[p];
//        }
//        return p;
//    }
//
//    public boolean isConnected(int p, int q) {
//        return find(p) == find(q);
//    }
//
//    public void union(int p, int q) {
//        int pRoot = find(p);
//        int qRoot = find(q);
//
//        if (pRoot == qRoot) {
//            return;
//        }
//        parent[pRoot] = qRoot;
//    }

//
//    int[][] g;
//    boolean[] visited;
//    int group = 0;
//
//    public int numIslands(char[][] grid) {
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int t = Math.max(m, n);
//        g = new int[t][t];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                g[i][j] = grid[i][j] - '0';
//            }
//        }
//        visited = new boolean[t];
//
//        for (int i = 0; i < t; i++) {
//            if (!visited[i]) {
//                dfs(i);
//                group++;
//            }
//        }
//        System.out.println(g);
//        return group;
//    }
//
//    public void dfs(int v) {
//        visited[v] = true;
//        List<Integer> adj = new ArrayList<>();
//        for (int i = 0; i < g.length; i++) {
//            if (g[v][i] == 1) {
//                adj.add(i);
//            }
//        }
//        for (Integer w : adj) {
//            if(!visited[w]){
//                dfs(w);
//            }
//        }
//    }

//    public int numIslands(char[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int ans = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//    private void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
//            return;
//        }
//        grid[i][j] = '0';
//        dfs(grid, i - 1, j);
//        dfs(grid, i + 1, j);
//        dfs(grid, i, j - 1);
//        dfs(grid, i, j + 1);
//    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        int r = arr[0];
                        int c = arr[1];
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            queue.add(new int[]{r - 1, c});
                            //grid[r - 1][c] = '0';
                        }
                        if (r + 1 < m && grid[r + 1][c] == '1') {
                            queue.add(new int[]{r + 1, c});
                            //grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            queue.add(new int[]{r, c - 1});
                            //grid[r][c - 1] = '0';
                        }
                        if (c + 1 < n && grid[r][c + 1] == '1') {
                            queue.add(new int[]{r, c + 1});
                            //grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};


        /*char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};*/
        Leetcode200 instance = new Leetcode200();
        System.out.println(instance.numIslands(grid));
    }


}
