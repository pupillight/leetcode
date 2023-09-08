package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPQuestions {

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp[] = new int[len];
        dp[0] = 0;
        if (prices[1] > prices[0]) {
            dp[1] = dp[0] + prices[1] - prices[0];
        } else {
            dp[1] = dp[0];
        }
        for (int i = 1; i < len; i++) {
            //if (prices[i] > prices[i - 1]) {
            dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            // }
           /* else {
                dp[i] = dp[i - 1];
            }*/
        }

        int max = dp[0];
        for (int i = 1; i < len; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public int massage1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = 0;
        //f(x) = Max(f(x-2)+nums[x],f(x-1))
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }

        return max;

    }


    public int massage(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return massage(nums, nums.length - 1);
    }

    public int massage(int[] nums, int n) {

        if (n < 0) {
            return 0;
        }
        /*if (n == 0) {
            return nums[0];
        }*/

        int max = 0;
        max = Math.max(massage(nums, n - 2) + nums[n], massage(nums, n - 1));
        return max;

    }

    public List<List<Integer>> generate(int numRows) {

        int len = numRows;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    list.add(dp[i][j]);
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    if (dp[i][j] != 0) list.add(dp[i][j]);
                }

            }
            ans.add(list);
        }
        return ans;
    }


    public static void main(String[] args) {
        DPQuestions questions = new DPQuestions();


        System.out.println(questions.generate(3));
        //int[] num = {2, 1, 4};
        //System.out.println(questions.massage(num));
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {1};
        //System.out.println(questions.maxSubArray(nums));
        //System.out.println(questions.climbStairs(3));
        //System.out.println(questions.uniquePaths(3, 7));
        //nt[] prices = {7, 1, 5, 3, 6, 4};
        //System.out.println(questions.maxProfit(prices));

    }

}
