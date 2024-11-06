package org.yj.leetcode.dp;

public class DPQuestions {


    public int robByDp(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int a = dp[i - 1];
            int b = dp[i - 2] + nums[i];
            dp[i] = Math.max(a, b);
        }
        return dp[nums.length - 1];
    }


    public int rob(int[] nums) {
        return rob(nums, 0, nums.length - 1);
    }

    private int rob(int[] nums, int left, int right) {
        int k = right - left;
        if (k == 0) {
            return nums[0];
        } else if (k == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int a = rob(nums, 0, k - 1);
        int b = rob(nums, 0, k - 2) + nums[k];
        return Math.max(a, b);
        //return Math.max(rob(nums, 0, k - 1), rob(nums, 0, k -2) + nums[k]);

    }


    public static void main(String[] args) {
        DPQuestions questions = new DPQuestions();
        //int[] nums={1,2,3,1};
        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(questions.rob(nums));
        System.out.println(questions.robByDp(nums));

    }
}
