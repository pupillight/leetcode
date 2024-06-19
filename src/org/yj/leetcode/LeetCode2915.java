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
        int[][] dp = new int[len+1][target + 1];
        Arrays.fill(dp[0], -1);

        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i]=dp[i-1].clone();
            int num = nums.get(i-1);
            for (int j = num; j <= target ; j++) {

        /*        if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }*/
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
            }
        }
        //System.out.println(dp);
        return dp[len][target];
    }

    public static void main(String[] args) {
        LeetCode2915 instance = new LeetCode2915();
        List<Integer> list = List.of(1,1,5,4,5);
        int target = 3;
        System.out.println(instance.lengthOfLongestSubsequence(list, target));

    }
}
