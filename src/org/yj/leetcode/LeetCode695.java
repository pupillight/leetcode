package org.yj.leetcode;

public class LeetCode695 {
    int m;
    int n;
    int[][] mark;

    public int dfs1(int[][] grid, int i, int j) {

        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0 || mark[i][j] == 1) {
            return 0;
        }
        //向4个方向dfs
        //right
        mark[i][j] = 1;
        //grid[i][j] = 0;
        int area = 1;
        if (j + 1 < n && grid[i][j + 1] == 1) {
            area += dfs(grid, i, j + 1);
        }
        //down
        if (i + 1 < m && grid[i + 1][j] == 1) {
            area += dfs(grid, i + 1, j);
        }
        // left
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            area += dfs(grid, i, j - 1);
        }
        //up
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            area += dfs(grid, i - 1, j);
        }
        return area;
    }

    public int dfs(int[][] grid, int i, int j) {

        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0 || mark[i][j] == 1) {
            return 0;
        }

        mark[i][j] = 1;
        //grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i - 1, j);
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        m = grid.length;
        n = grid[0].length;
        mark = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(grid, i, j), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode695 instance = new LeetCode695();
        int[][] grid = {{0, 1, 1}};
        System.out.println(instance.maxAreaOfIsland(grid));

    }
}
