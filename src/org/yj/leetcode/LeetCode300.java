package org.yj.leetcode;


import java.util.*;

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,1);
        int max=1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j],dp[i]+1);
                }
                max= Math.max(max,dp[j]);
            }
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] =Math.max(dp[i], dp[j]+1);
                }
                max= Math.max(max,dp[i]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LeetCode300 instance = new LeetCode300();


        /* int[] nums = {10, 9, 2, 5, 3, 7, 50, 101, 18};
         System.out.println(instance.lengthOfLIS(nums));
*/
        int[] nums = {0,1,0,3,2,3};
        //int[] nums = {10, 9, 2, 5, 3, 7, 50, 101, 18};
        //int[] nums = {0};
        System.out.println(instance.lengthOfLIS(nums));
        System.out.println(instance.lengthOfLIS1(nums));

    }

}