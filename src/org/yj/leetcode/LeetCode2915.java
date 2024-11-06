package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode2915 {
    List<Integer> res = new ArrayList<>();
    List<Integer> lengths = new ArrayList<>();

    private void f(List<Integer> nums, int target, int index) {
        if (target < 0 || index > nums.size()) {
            return;
        }
        if (index <= nums.size() && target == 0) {
            lengths.add(res.size());
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            res.add(nums.get(i));
            f(nums, target - nums.get(i), i + 1);
            res.remove(res.size() - 1);
        }
    }

    public int lengthOfLongestSubsequence1(List<Integer> nums, int target) {
        f(nums, target, 0);
        int ans = lengths.stream().max(Comparator.comparingInt(item -> item)).orElse(-1);
        return ans;
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int len = nums.size();
        int[][] dp = new int[len + 1][target + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);

        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1].clone();
            int num = nums.get(i - 1);
            for (int j = 0; j <= target; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }
                //   dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
            }
        }
        //System.out.println(dp)
        if (dp[len][target] < 0) {
            return -1;
        }
        return dp[len][target];
    }

    /*public int rob(int[] nums) {

        return f1(nums, nums.length - 1);
    }*/

    private int f1(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }
        if (index == 1) {
            return Math.max(nums[index], nums[index - 1]);
        }
        int x = f1(nums, index - 2) + nums[index];
        int y = f1(nums, index - 1);
        return Math.max(x, y);
    }


    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len < 2) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len < 2) return nums[0];
/*        int x = this.rob(Arrays.copyOfRange(nums, 0, len - 1));
        int y = this.rob(Arrays.copyOfRange(nums, 1, len));
        return Math.max(x, y);*/

        //select 0
        //2---len-1
        int x = f(nums, 0, len - 1);

        // not select 0
        //1 ----len
        int y = f(nums, 1, len);
        return Math.max(x, y);

    }

    public int f(int[] nums, int start, int end) {

        int len = end - start;
        int[] dp = new int[len];
        dp[0] = nums[start];

        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];

    }

    public static void main(String[] args) {
        LeetCode2915 instance = new LeetCode2915();
        List<Integer> list = List.of(1, 1, 5, 4, 5);
        int target = 3;
        //System.out.println(instance.lengthOfLongestSubsequence(list, target));

        int[] nums = {1, 2, 3, 1};
        System.out.println(instance.rob2(nums));

    }
}
