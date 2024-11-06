package org.yj.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode2915 {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
/*        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        int s = 0;
        for (int x : nums) {
            s = Math.min(s + x, target);
            for (int j = s; j >= x; j--) {
                f[j] = Math.max(f[j], f[j - x] + 1);
            }
        }
        return f[target] > 0 ? f[target] : -1;*/


        int len = nums.size();
        int[][] dp = new int[len + 1][target + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;

        int ans = 0;
        for (int i = 1; i <= len; i++) {
            int num = nums.get(i - 1);
            dp[i]=dp[i-1].clone();
            for (int j = 0; j <= target; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
                }

            }
        }
       if(dp[len][target]<0){
            return -1;
        }
        return dp[len][target];
    }


    public static void main(String[] args) {

        Leetcode2915 instance = new Leetcode2915();
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        //int[][] grid = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        int[] nums = {1,1,5,4,5};
        int target = 3;
        // List.of(nums);


        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        System.out.println(instance.lengthOfLongestSubsequence(list, target));
    }
}
