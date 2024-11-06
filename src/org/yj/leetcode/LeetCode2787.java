package org.yj.leetcode;

import java.util.Arrays;
import java.util.List;

public class LeetCode2787 {
    static final int MODULO = 1000000007;

    public int numberOfWays(int n, int x) {
        int maxNum = (int) Math.pow(n + 0.5, 1.0 / x);
        int[][] dp = new int[maxNum + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= maxNum; i++) {
            int power = (int) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                if (j < power) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - power]) % MODULO;
                }
            }
        }
        return dp[maxNum][n];
    }

    public int numberOfWays1(int n, int x) {
        int arr[] = new int[n];
        final int MODULO = 1000000007;
        Arrays.fill(arr, 1);
        int index=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                arr[i - 1] = arr[i - 1] * i;
            }
            if (arr[i-1]>n){
                index =i-1;
                break;
            }
        }
        int[] nums = arr;
        if(index>0){
             nums =Arrays.copyOfRange(arr,0,index);
        }

        int ans = 0;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        int len = nums.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - nums[i - 1]])%MODULO;
                }
            }
        }
        ans = dp[len][n];
        return ans;
    }

    public static void main(String[] args) {
        LeetCode2787 instance = new LeetCode2787();

        int n = 4, x = 1;

        System.out.println(instance.numberOfWays1(n, x));

    }
}
