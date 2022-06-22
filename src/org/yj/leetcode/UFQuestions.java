package org.yj.leetcode;

import java.util.Arrays;

public class UFQuestions {

   /* public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        int[] rank = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parent, rank);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private int find(int p, int[] parent) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q, int[] parent, int[] rank) {
        int pRoot = find(p, parent);
        int qRoot = find(q, parent);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }*/
/*
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];

            union(p, q, parent);
        }
        return isConnected(source, destination, parent);
    }

    private boolean isConnected(int p, int q, int[] parent) {
        return find(p, parent) == find(q, parent);
    }

    private int find(int p, int[] parent) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q, int[] parent) {
        int pRoot = find(p, parent);
        int qRoot = find(q, parent);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
*/

   /* public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        int m = grid1.length;
        int n = grid1[0].length;
        int[] parent = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid1[i][j];
                if (value == 1) {
                    union(i, j, parent);
                }
            }
        }
        return ans;
    }

    private int find(int p, int[] parent) {
        while (parent[p] != 0) {
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q, int[] parent) {
        int pRoot = find(p, parent);
        int qRoot = find(q, parent);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    private boolean isConnected(int p, int q, int[] parent) {
        return find(p, parent) == find(q, parent);
    }*/

    /*       public int findCircleNum(int[][] isConnected) {
                int len = isConnected.length;
                int[] parent = new int[len];
                for (int i = 0; i < len; i++) {
                    parent[i] = i;
                }
                for (int i = 0; i < isConnected.length; i++) {
                    for (int j = 0; j < isConnected[i].length; j++) {
                        if (isConnected[i][j] == 1) {
                            union(i, j, parent);
                        }
                    }
                }
                int count = 0;
                for (int i = 0; i < parent.length; i++) {
                    if (parent[i] == i) {
                        count++;
                    }
                }
                return count;
            }

            private int find(int p, int[] parent) {
                while (parent[p] != p) {
                    p = parent[p];
                }
                return p;
            }

            private void union(int p, int q, int[] parent) {
                int pRoot = find(p, parent);
                int qRoot = find(q, parent);
                if (pRoot == qRoot) {
                    return;
                }
                parent[pRoot] = qRoot;
            }*/

   /* int[] parent = null;
    int[] rank = null;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    rank[i * n + j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union(i * n + j, i * n + j - 1);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union(i * n + j, (i - 1) * n + j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;

        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }*/

    int[] parent;
    int[] size;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                parent[i * n + j] = i * n + j;
                size[i * n + j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    size[i * n + j] = 1;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        if (size[i * n + j - 1] == 0) {
                            size[i * n + j - 1] = 1;
                        }
                        union(i * n + j, i * n + j - 1);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        if (size[(i - 1) * n + j] == 0) {
                            size[(i - 1) * n + j] = 1;
                        }
                        union(i * n + j, (i - 1) * n + j);
                    }
                }
            }
        }
        int max = size[0];
        for (int i = 1; i < size.length; i++) {
            if (size[i] > max) {
                max = size[i];
            }
        }
        return max;
    }

    private int find(int p) {
        if (p == parent[p]) {
            return p;
        }
        return find(parent[p]);
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }


    public static void main(String[] args) {
        UFQuestions questions = new UFQuestions();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(questions.maxAreaOfIsland(grid));
//        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
//        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        //questions.countSubIslands(grid1, grid2);

        //char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        // char[][] grid = {{'0'}};
        //System.out.println(questions.numIslands(grid));
        // int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] isConnected = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        //System.out.println(questions.findCircleNum(isConnected));
    }
}
