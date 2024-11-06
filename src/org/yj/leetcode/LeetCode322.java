package org.yj.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode322 {
    LinkedList list = new LinkedList();
    int min = Integer.MAX_VALUE;

    /*  public int coinChange3(int[] coins, int amount) {
          f(coins, amount, 0);
          return min == Integer.MAX_VALUE ? -1 : min;

      }*/
    public int coinChange4(int[] coins, int amount) {
        //return f(coins, amount, coins.length - 1);
        return dfs(coins,amount,0);

    }

    private int dfs(int[] coins, int amount, int i) {

        if (i ==coins.length) {
            if (amount == 0) {
                return 0;
            } else {
                return amount + 1;
            }
        }
        if (amount < coins[i]) {
            return dfs(coins, amount, i + 1);
        }


        int l = dfs(coins, amount, i + 1);
        int r = dfs(coins, amount - coins[i], i) + 1;
        return Math.min(l, r);
    }

    private int f(int[] coins, int amount, int i) {
        if (i < 0) {
            if (amount == 0) {
                return 0;
            } else {
                return Integer.MAX_VALUE / 2;
            }
        }
        if (amount < 0) {
            return -1;
        }
        if (amount < coins[i]) {
            return f(coins, amount, i - 1);
        }
        int l = f(coins, amount, i - 1);
        int r = f(coins, amount - coins[i], i) + 1;
        return Math.min(l, r);
    }
  /*  private void f(int[] coins, int amount, int i) {
        if (amount == 0) {
            min = Math.min(min, list.size());
            return;
        }
        if (amount < 0) {
            return;
        }
        if (i >= coins.length && amount != 0) {
            return;
        }

        for (int j = i; j < coins.length; j++) {
            list.add(coins[j]);
            f(coins, amount - coins[j], j);
            list.removeLast();
        }
    }*/


    public int coinChange(int[] coins, int amount) {

        int ans = -1;
        int len = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if (dp[amount] > amount)
            return -1;
        ans = dp[amount];
        return ans;
    }

    public int coinChange1(int[] coins, int amount) {
        int ans = -1;
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        Arrays.fill(dp[0], amount + 1);
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i], amount + 1);
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        if (dp[len][amount] > amount)
            return -1;
        ans = dp[len][amount];
        return ans;
    }

    public int change1(int amount, int[] coins) {
        int ans = 0;
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        ans = dp[len][amount];
        return ans;
    }

    public int change(int amount, int[] coins) {
        int ans = 0;
        int len = coins.length;
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        ans = dp[amount];
        return ans;
    }

    public int numberOfWays(int n, int x) {

        final int MODULO = 1000000007;
        int ans = 0;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < x; j++) {
                nums[i - 1] = nums[i - 1] * i;
            }
            if (nums[i - 1] > n) {
                index = i - 1;
                break;
            }
        }
        int[] arr = nums;
        if (index > 0) {
            arr = Arrays.copyOfRange(nums, 0, index);
        }

        int dp[] = new int[n + 1];
        dp[0] = 1;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = n; j >= nums[i]; j--) {
                dp[j] = (dp[j] + dp[j - nums[i]]) % MODULO;
            }
        }
        ans = dp[n];
        return ans;
    }


    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }

            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        LeetCode322 instance = new LeetCode322();
        //int[] coins = {2};
        //int amount = 3;
        //System.out.println(instance.coinChange1(coins, amount));
        int amount = 11;
        int[] coins = {1, 2, 5};
        //int amount = 0;
        //int[] coins = {1};

        System.out.println(instance.coinChange(coins, amount));

        System.out.println(instance.coinChange4(coins, amount));
       /* int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(instance.combinationSum4(nums, target));*/
        //System.out.println(instance.numberOfWays(75, 5));

    }

}
