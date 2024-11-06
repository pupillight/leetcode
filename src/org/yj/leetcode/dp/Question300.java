package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //dp[i] = dp[j] + 1;
                }
                res = Math.max(res, dp[i]);

            }
        }
        return res;
    }

    public int minimumOperations(List<Integer> nums) {
        int len = nums.size();
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int ans = 0;
        for (int i = 1; i < len; i++) {
            //dp[i] = dp[i-1];
            for (int j = 0; j < i; j++) {
                if (nums.get(i)< nums.get(j)) {
                   // dp[i]++;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans =Math.max(ans,dp[i]);
        }
        return ans;
    }

    public int minimumOperations1(List<Integer> nums) {
        int len = nums.size();
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans =Math.max(ans,dp[i]);
        }
        return len-ans;
    }


    public static void main(String[] args) {

        Question300 question = new Question300();
        int[] nums = {0, 1, 0, 3, 2, 3};
       // System.out.println(question.lengthOfLIS(nums));

        List<Integer> list= List.of(1,3,2,1,3,3);

        System.out.println(question.minimumOperations(list));
    }
}
