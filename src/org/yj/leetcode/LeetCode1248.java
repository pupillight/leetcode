package org.yj.leetcode;

import java.util.*;

public class LeetCode1248 {
    public long countFairPairs1(int[] nums, int lower, int upper) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public long f(int[] nums, int lower, int upper, int l, int r) {
        long ans = 0;
        if (l >= r) {
            return 0;
        }
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= lower && sum <= upper) {
                ans++;
                long left = f(nums, lower, upper, l + 1, r);
                long right = f(nums, lower, upper, l, r + 1);
                ans += left + right;
                return ans;
            } else if (sum < lower) {
                l++;
            } else if (sum > upper) {
                r--;
            }

        }

        return ans;
    }

    public long countFairPairs2(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        long ans = 0;
        ans = f(nums, lower, upper, 0, nums.length - 1);
        return ans;
    }


    public int theFirstBigger(int[] nums, int r, int target) {
        int l = 0;
       // int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; ++j) {
            //int r = lowerBound(nums, j, upper - nums[j] + 1); // <= upper-nums[j] 的 nums[i] 的个数
            //int l = lowerBound(nums, j, lower - nums[j]); // < lower-nums[j] 的 nums[i] 的个数
            int r = theFirstBigger(nums, j, upper - nums[j] + 1); // <= upper-nums[j] 的 nums[i] 的个数
            int l = theFirstBigger(nums, j, lower - nums[j]); // < lower-nums[j] 的 nums[i] 的个数
            ans += r - l;
        }
        return ans;
    }

    public long countFairPairs6(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = lower - num;
            int right = upper - num;
            //if (left >= 0 && right >= 0) {
                int leftIndex = theFirstBigger(nums, left,i);
                int rightIndex = theFirstBigger(nums, right + 1,i);
                ans += rightIndex - leftIndex;
            //}
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int len = nums.length;
        int[] preSum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            int cur = preSum[i + 1];
            if (map.containsKey(cur - goal)) {
                ans += map.get(cur - goal);
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] & 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curPreSum = preSum[i + 1];
            if (map.containsKey(curPreSum - k)) {
                ans += map.get(curPreSum - k);
            }
            map.put(curPreSum, map.getOrDefault(curPreSum, 0) + 1);
        }
        return ans;

    }



    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int right, int target) {
        int left = -1; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;
    }


    public static void main(String[] args) {
        LeetCode1248 instance = new LeetCode1248();
        //int[] nums = {1,3,1,2,2};
        //int[] nums = {5, 5, 5, 5};
        //System.out.println(instance.countCompleteSubarrays(nums));
        //int[] nums = {1, 0, 1, 0, 1};
        //int k = 2;
        int[] nums = {0, 0, 0, 0, 0, 0};
        int k = 3;
        //System.out.println(instance.theFirstBigger(nums, 4));
        System.out.println(instance.countFairPairs6(nums, 0, 0));
        System.out.println(instance.countFairPairs(nums, 0, 0));
        //System.out.println(instance.numberOfSubarrays(nums, k));
        //System.out.println(instance.numberOfSubstrings("aaacb"));

        //System.out.println(instance.numSubarrayProductLessThanK1(nums, k));

    }
}
