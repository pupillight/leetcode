package org.yj.dp;

public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        //init
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        int res = dp[n - 1][m - 1];
        return res;
    }
    public static void main(String[] args) {
        //this is a line from master
    }
}
