package org.yj.leetcode.dp;

import java.util.Arrays;

public class Leetcode538 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                 /*   int tmp = 0;
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        tmp = s2.charAt(j - 1);
                    } else {
                        tmp = s1.charAt(i - 1);
                    }

                    System.out.println(tmp);
                    ans += tmp;*/
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }

        int i = m;
        int j = n;
        while (i >= 0 && j >= 0) {

            char c = 0;
            if (i == 0) {
                c = s2.charAt(j-1);
                j--;
            }
            if (j == 0) {
                c = s1.charAt(i-1);
                i--;
            }
            if (i>=1 && j>=1 && s1.charAt(i - 1) != s2.charAt(j - 1)) {
                if (dp[i][j - 1] < dp[i - 1][j]) {
                    c = s2.charAt(j - 1);
                    j--;
                } else {
                    c = s1.charAt(i - 1);
                    i--;
                }

            } else {
                i--;
                j--;
            }

            ans= ans+c;
        }
        return ans;
    }

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
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Leetcode538 instance = new Leetcode538();
        String word1 = "sea", word2 = "eat";

        //System.out.println(instance.minDistance(word1, word2));

        System.out.println(instance.minimumDeleteSum("delete", "leet"));
        //System.out.println(instance.minimumDeleteSum("sea", "eat"));
    }
}
