package org.yj.leetcode;


import java.util.*;

public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 0; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

/*        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }*/
        return dp[0][len - 1];
    }

    public int findNumberOfLIS(int[] nums) {
     /*   int[] dp = new int[nums.length];

        for (int i = 0; i < ; i++) {
            
        }*/

        return -1;
    }


    public static void main(String[] args) {
        LeetCode300 instance = new LeetCode300();

        System.out.println(instance.longestPalindromeSubseq("cbbd"));
        // int[] nums = {10, 9, 2, 5, 3, 7, 50, 101, 18};
        // System.out.println(instance.lengthOfLIS(nums));

    }

}
