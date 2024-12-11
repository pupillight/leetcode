package org.yj.leetcode.dp;

public class Leetcode712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c2);
                }
            }
        }

        return dp[m][n];

    }

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int l = commonSubstr(s1, s3);
        int r = commonSubstr(s2, s3);
        if (l == 0 && r == s3.length()) {
            return true;
        }
        if (r == 0 && l == s3.length()) {
            return true;
        }
        if (l + r == s3.length()) {
            return true;
        }
        return false;
    }

    private int commonSubstr(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int ans = dp[m][n];
        return ans;
    }


    public static void main(String[] args) {
        Leetcode712 instance = new Leetcode712();
        String word1 = "sea", word2 = "eat";

       // System.out.println(instance.minimumDeleteSum(word1, word2));
       int[] nums1 = {1,4,2};
       int[] nums2 = {1,2,4};
        System.out.println(instance.maxUncrossedLines(nums1, nums2));
    }
}
