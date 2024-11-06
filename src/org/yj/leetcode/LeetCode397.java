package org.yj.leetcode;


import java.util.Arrays;

public class LeetCode397 {


    public int integerReplacement(int n) {
        int ans = 0;
        if(n==1){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] =0;
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1], dp[(i + 1)/2]+1) + 1;
            }
        }

        ans= dp[n];
        return ans;

    }

    public static void main(String[] args) {
        LeetCode397 instance = new LeetCode397();

    }

}
