package org.yj.leetcode.dp.bagpack;

import java.util.Arrays;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        //System.out.println(dp);
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];

    }

    public int lastStoneWeightII(int[] stones) {

        int sum = Arrays.stream(stones).sum();
        int t = sum >> 1;
        int[] dp = new int[t + 1];
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int j = t; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }
        int l = dp[t];
        int r = sum - l;
        int ans = Math.abs(l - r);
        return ans;
    }


    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                if (coin > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                }
            }
        }
        return dp[len][amount];

    }


    public static void main(String[] args) {
        Leetcode322 instance = new Leetcode322();
        //int[]  nums = {1,5,11,5};
        //int[] coins = {1, 2, 5};
        int[] stones = {2, 7, 4, 1, 8, 1};
        //  System.out.println(instance.lastStoneWeightII(stones));
      /*  int[] coins = {2};
        int amount = 3;
        System.out.println(instance.coinChange(coins, amount));*/
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(instance.change(amount, coins));
        System.out.println(instance.change1(amount, coins));
    }

}
