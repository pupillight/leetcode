package org.yj.leetcode;

public class LeetCode463 {
    int row, col, len;
    int[][] mark;

    public int islandPerimeter(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        len = 0;
        mark = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && mark[i][j]==0) {
                    len =dfs(grid, i, j);
                }
            }
        }
        return len;
    }

    public int dfs(int[][] grid, int i, int j) {
        int ans=0;
        if (i == row || i < 0 || j == col || j < 0 || grid[i][j] == 0) {
            return 1;
        }
        if (mark[i][j] == 1) {
            return 0;
        }
        mark[i][j] = 1;
        ans+=dfs(grid, i, j + 1);
        ans+=dfs(grid, i, j - 1);
        ans+=dfs(grid, i + 1, j);
        ans+=dfs(grid, i - 1, j);
      System.out.println(ans);
        return ans;
    }
    public void dfs1(int[][] grid, int i, int j) {
        if (i == row || i < 0 || j == col || j < 0 || grid[i][j] == 0) {
            len++;
            return;
        }
        if (mark[i][j] == 1) {
            return;
        }
        mark[i][j] = 1;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        //int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}};
        //int[][] grid = {{1, 1, 0, 0}};
        LeetCode463 instance = new LeetCode463();
        System.out.println(instance.islandPerimeter(grid));
    }
}
