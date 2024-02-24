package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode53 {
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return res;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        res= dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode53 leetCode = new LeetCode53();

        int[] nums ={-1,-2};
        System.out.println(leetCode.maxSubArray(nums));
    }
}
