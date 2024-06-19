package org.yj.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode746 {


    private int f(int[] cost, int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if(memo[n]!=-1){
            return memo[n];
        }
        int a = f(cost, n - 1, memo) + cost[n - 1];
        int b = f(cost, n - 2, memo) + cost[n - 2];
        memo[n] = Math.min(a, b);
        return memo[n];
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp,-1);
        int res = f(cost, cost.length, dp);
        return res;
    }

    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;

        int[] dp = new int[len + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= len; i++) {
            int a = dp[i - 1] + cost[i - 1];
            int b = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(a, b);
        }
        return dp[len];
    }


    public static void main(String[] args) {

        LeetCode746 leetcode = new LeetCode746();
        int[] cost = {10, 15, 20};
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(leetcode.minCostClimbingStairs(cost));
        System.out.println(leetcode.minCostClimbingStairs1(cost));

    }

}
