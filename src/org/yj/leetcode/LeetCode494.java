package org.yj.leetcode;

import java.util.Arrays;

public class LeetCode494 {


    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum+target<0 || (sum + target) % 2 != 0) {
            return 0;
        }

        int k =  (sum + target) / 2;
        int len = nums.length;
        int[][] dp = new int[len + 1][k + 1];

        dp[0][0] =1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= k; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        return dp[len][k];

    }

    public static void main(String[] args) {

        LeetCode494 instance = new LeetCode494();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(instance.findTargetSumWays(nums, target));
    }
}
