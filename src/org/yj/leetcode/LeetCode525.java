package org.yj.leetcode;

import java.util.*;

public class LeetCode525 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            boolean res = flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i + 1 == len || flowerbed[i + 1] == 0);
            if (res) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }


    public int f(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int[] array = new int[2];
        for (int i = l; i <= r; i++) {
            array[nums[i] - 0]++;
        }
        int m = array[0];
        int n = array[1];
        if (m == n) {
            return m * 2;
        }
        int lMax = f(nums, l + 1, r);
        int rMax = f(nums, l, r - 1);
        int res = Math.max(lMax, rMax);
        return res;
    }

    public int findMaxLength(int[] nums) {

        //int res = f(nums, 0, nums.length - 1);
        int res = 0;
        int len = nums.length;
        int max = 0;
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i] - 0]++;
        }
        int m = array[0];
        int n = array[1];
        int k = Math.min(m, n) * 2;
        Arrays.fill(array, 0);

        for (int i = 0; i < k; i++) {
            array[nums[i] - 0]++;
        }
        res = f(nums, 0, k - 1);
        max = Math.max(max, res);
        for (int i = k; i < len; i++) {
            res = f(nums, i - k + 1, i);
            max = Math.max(max, res);
        }

        return max;
      /*  int[] dp = new int[nums.length];
        dp[0] = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(nums[0], 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            boolean isEqual = map.get(0) == map.get(1);
            if (isEqual) {
                dp[i] =map.get(0)*2;
            } else {
                dp[i] = dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return dp[nums.length - 1];*/

        //sliding window
        /*int len = nums.length;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int m = map.get(0)==null?0:map.get(0);
        int n = map.get(1)==null?0:map.get(1);
        int k = Math.min(m, n) * 2;
        if(k==0) return 0;
        map.clear();
        int res = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        boolean isEqual = map.get(0) == map.get(1);
        if (isEqual) {
            res = map.get(0) * 2;
        }
        for (int i = k; i < len; i++) {
            map.put(nums[i - k], map.getOrDefault(nums[i-k], 0) - 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            isEqual = map.get(0) == map.get(1);
            if (isEqual) {
                res = Math.max(res, map.get(0) * 2);
            }
        }

        return res;*/
    }

    public static void main(String[] args) {
        LeetCode525 instance = new LeetCode525();
        int[] nums = {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0};

        //int[] nums = {0, 1, 1, 0, 1, 1, 1, 0};
        //int[] nums = {1,1,1,1};
        // System.out.println(instance.findMaxLength(nums));

        int[] flowerbed = {0, 0, 1, 0, 1};
        System.out.println(instance.canPlaceFlowers(flowerbed, 1));


    }
}
