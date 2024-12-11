package org.yj.leetcode.dp;

public class Leetcode198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        if (len < 2) {
            return nums[0];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);

    }

    public static void main(String[] args) {
        Leetcode198 instance = new Leetcode198();
      // int[] nums ={1,2,3,1};
        int[] nums ={2,1,1,2};
        System.out.println(instance.rob(nums));
    }
}
