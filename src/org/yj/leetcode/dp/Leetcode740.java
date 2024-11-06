package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode740 {
    public int deleteAndEarn1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int len = nums[nums.length - 1] + 1;

        int[] arr = new int[len];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        int[] dp = new int[len];
        dp[1] = arr[1];
        if (arr.length < 3) {
            return dp[1];
        }
        dp[2] = Math.max(arr[1], arr[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[len - 1];
    }

    public int deleteAndEarn2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = IntStream.of(nums).max().getAsInt();
        //Arrays.sort(nums);
        int len = max + 1;

        int[] arr = new int[len];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        int[] dp = new int[len];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[len - 1];
    }

    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = map.keySet().stream().sorted().collect(Collectors.toList());
        int len = list.size();
        int[] dp = new int[len + 1];
        dp[0] = 0;
        //dp[1] = list.get(0);
        int j=0;
        for (int i = 1; i <= len; i++) {
            int curr = list.get(i - 1);
            while(list.get(j)<curr-1){
                j++;
            }
            dp[i] = Math.max(dp[i - 1], dp[j] + curr * map.get(curr));
        }
        return dp[len];
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : power) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = map.keySet().stream().collect(Collectors.toList());
        int n = list.size();
        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int j = 0;
            int curr = list.get(i - 1);
            while (true) {
                if (list.get(j) >= curr - 2) {
                    break;
                }
                j++;
            }
/*            while(list.get(j)<curr-2){
               j++;
            }*/
            dp[i] = Math.max(dp[i - 1], dp[j] + (long) curr * map.get(curr));
        }

        return dp[n];

/*        if (power.length == 1) {
            return power[0];
        }
        Arrays.sort(power);
        int len = power[power.length - 1] + 1;
        int[] arr = new int[len];
        for (int i = 0; i < power.length; i++) {
            arr[power[i]] += power[i];
        }
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = arr[1];
        if (arr.length < 3) {
            return arr[1];
        }
        dp[2] = Math.max(arr[1], arr[2]);
        for (int i = 3; i < arr.length; i++) {
            //dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2]), dp[i - 3] + arr[i]);
            dp[i] = Math.max(dp[i - 1], dp[i - 3] + arr[i]);
        }
        return dp[len - 1];*/
    }

    public static void main(String[] args) {

        Leetcode740 instance = new Leetcode740();
        int[] nums = {3, 4,2};
        System.out.println(instance.deleteAndEarn2(nums));
        int[] power = {7, 1, 6, 6};
        //System.out.println(instance.maximumTotalDamage(power));

    }
}
