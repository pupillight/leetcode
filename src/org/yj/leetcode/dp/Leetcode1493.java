package org.yj.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1493 {

    public int longestSubarray1(int[] nums) {

        int l = 0;
        int r = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int tmp = 0;
        int ans = 0;
        while (l < len && r < len && l <= r) {
            int num = nums[r];
            if (num == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            if (map.size() > 0 && map.get(0) == 2) {
                tmp = r - l;
                ans = Math.max(ans, tmp);
            }
            while (map.size() > 0 && map.get(0) == 2) {
                if (nums[l] == 0) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                }
                l++;
            }
            r++;
        }
        tmp = r - l;
        ans = Math.max(ans, tmp);
        return ans - 1;
    }

    public int longestSubarray(int[] nums) {
        int l = 0, r = 0;
        int len = nums.length;
        int ans = 0, cnt = 0;
        while (l < len && r < len && l <= r) {
            int num = nums[r];
            if (num == 0) cnt++;
            while (cnt == 2) {
                if (nums[l++] == 0) cnt--;
            }
            ans = Math.max(ans, r - l);
            r++;
        }
        return ans;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {


        int l = 0;
        int r = 0;
        int len = nums.length;
        int ans = 0;
        int max=0;
        while (r < len && l <= r) {

            int num = nums[r];
            max=Math.max(max,num);
            if (max >= left && max <= right) {
               // ans = Math.max(ans, r - l + 1);
                ans++;
            } else {
                l = r;
            }
            r++;
        }
        return ans;
    }


    public static void main(String[] args) {
        Leetcode1493 instance = new Leetcode1493();
        // int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        //int[] nums = {1, 1, 0, 1};
        //System.out.println(instance.longestSubarray(nums));
        int[] nums = {2, 1, 4, 3};
        int left = 2, right = 3;
        System.out.println(instance.numSubarrayBoundedMax(nums, left, right));


    }
}
