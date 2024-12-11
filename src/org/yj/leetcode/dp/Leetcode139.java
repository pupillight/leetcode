package org.yj.leetcode.dp;

import java.util.*;

public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);
                if (dp[j] && set.contains(subStr)) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }

    public boolean validPartition(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        dp[1] = false;
        if (nums[0] == nums[1]) {
            dp[2] = true;
        }

        for (int i = 3; i <= len; i++) {

            boolean s1 = nums[i - 1] == nums[i - 2] && dp[i - 2];
            boolean s2 = nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3];
            boolean s3 = nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] == nums[i - 3] + 1 && dp[i - 3];
            if (s1 || s2 || s3) {
                dp[i] = true;
            }
        }
        return dp[len];
      /*  int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = false;
        // dp[1] = false;
        if (nums[0] == nums[1]) {
            dp[1] = true;
        }

        for (int i = 2; i < len; i++) {

            boolean s1 = nums[i] == nums[i - 1] && dp[i - 2];
            boolean s2 = nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2] && dp[i - 2];
            boolean s3 = nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1 && dp[i - 2];
            if (s1 || s2 || s3) {
                dp[i] = true;
            }
        }
        return dp[len];*/

    }


    public static void main(String[] args) {

        Leetcode139 instance = new Leetcode139();
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};

        List<String> list = List.of(wordDict);
      //  System.out.println(instance.wordBreak(s, list));

     int[]   nums = {4,4,4,5,6};
        System.out.println(instance.validPartition(nums));
    }
}
