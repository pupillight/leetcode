package org.yj.leetcode.dp.bagpack;

import org.yj.leetcode.dp.Leetcode64;

import java.util.Arrays;

public class Leetcode279 {
    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {

        int[] nums = new int[n + 1];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            nums[i] = i * i;
            if (nums[i] >= n) {
                index = i;
                break;
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= index; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares(int n) {
        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        int i = 1;
        for (i = 1; i * i <= n; i++) {
            dp[i] = dp[i - 1].clone();
            for (int j = 0; j <= n; j++) {
                if (j < i * i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
                }
            }
        }

        return dp[i-1][n];
    }

    public boolean canPartition(int[] nums) {
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


            }
        }

        System.out.println(dp);
        return dp[len][target];


       /* int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // base case
        for (int i = 0; i < dp.length; i++) dp[i][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - nums[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][target];*/

    }

    public static void main(String[] args) {
        Leetcode279 instance = new Leetcode279();
      int[]  nums = {1,5,11,5};
        System.out.println(instance.canPartition(nums));
       // System.out.println(instance.numSquares(13));
    }

}
