package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode72 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // insert delete update
                    int tmp = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    tmp = Math.min(tmp, dp[i - 1][j - 1]);
                    dp[i][j] = tmp + 1;
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {

        Leetcode72 instance = new Leetcode72();

        System.out.println(instance.minDistance("", "a"));

    }
}
