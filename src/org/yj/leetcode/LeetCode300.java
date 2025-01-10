package org.yj.leetcode;


import java.util.*;

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,1);
        int max=1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j],dp[i]+1);

                }
                max= Math.max(max,dp[j]);
            }
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //dp[i] =Math.max(dp[i], dp[j]+1);
                    dp[i] =dp[j]+1;
                }
                max= Math.max(max,dp[i]);
            }
        }
        return max;



    }
    public int lengthOfLIS2(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] =Math.max(dp[i], dp[j]+1);
                }
                max= Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] =true;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;

                }
            }
        }

        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        LeetCode300 instance = new LeetCode300();

        String s = "babab";

        //System.out.println(instance.longestPalindrome(s));
        /* int[] nums = {10, 9, 2, 5, 3, 7, 50, 101, 18};
         System.out.println(instance.lengthOfLIS(nums));
*/
        //int[] nums = {0,1,0,3,2,3};
        int[] nums = {0,1,0,3,2,3};

        //int[] nums = {10, 9, 2, 5, 3, 7, 50, 101, 18};
        //int[] nums = {0};
        System.out.println(instance.lengthOfLIS1(nums));
       // System.out.println(instance.lengthOfLIS2(nums));

    }

}