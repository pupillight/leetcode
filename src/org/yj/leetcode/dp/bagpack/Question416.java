package org.yj.leetcode.dp.bagpack;

import java.util.Arrays;

public class Question416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
                if (dp[target]) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }

                if (dp[len][target]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartition2(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int t = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }

                if (dp[i][j] == t) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean canPartition3(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int t = sum / 2;
        return f(nums, 0, t);
    }

    private boolean f(int[] nums, int i, int t) {
        if (t == 0) {
            return true;
        }
        if (t < 0) {
            return false;
        }
        if (i >= nums.length) {
            return false;
        }
        boolean a = f(nums, i + 1, t - nums[i]);
        boolean b = f(nums, i + 1, t);
        return a || b;
    }

    public static void main(String[] args) {

        Question416 question = new Question416();
        int[] nums = {1, 5, 11, 5};
        System.out.println(question.canPartition3(nums));
        System.out.println(question.canPartition(nums));
    }
}
