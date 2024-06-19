package org.yj.leetcode;

import java.util.*;

public class LeetCode2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() == len) {
                res = res + n - i;
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
        }
        return res;

    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {

        if (k < 1) {
            return 0;
        }
        int ans = 0;
        int len = nums.length;
        int res = 1;
        int j = 0;
        for (int i = 0; i < len; i++) {
            res = res * nums[i];
            while (j < len && j <= i && res >= k) {
                res = res / nums[j];
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int res = 1;
            for (int j = i; j < len; j++) {
                res = res * nums[j];
                if (res < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }


    public int numberOfSubstrings(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int j = 0;
        int res = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.size() == 3) {
                res += len - i;
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    map.remove(s.charAt(j));
                }
                j++;
            }
        }
        return res;
    }

    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.containsKey(max) && map.get(max) == k) {
                res += len - i;
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        int ans = 0;
        int len = nums.length;
        int[] preSum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
    /*    for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }*/
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            if(preSum[i+1]>=goal){
                if (map.containsKey( preSum[i + 1]-goal)) {
                    ans = ans + map.get( preSum[i + 1]-goal);
                }
            }
            map.put(preSum[i + 1], map.getOrDefault(preSum[i + 1], 0) + 1);
        }


        return ans;
    }


    public static void main(String[] args) {
        LeetCode2799 instance = new LeetCode2799();
        //int[] nums = {1,3,1,2,2};
        //int[] nums = {5, 5, 5, 5};
        //System.out.println(instance.countCompleteSubarrays(nums));
        //int[] nums = {1, 0, 1, 0, 1};
        //int k = 2;
        int[] nums = {0, 0, 0, 0, 0};
        int k = 0;
        System.out.println(instance.numSubarraysWithSum(nums, k));
        //System.out.println(instance.numberOfSubstrings("aaacb"));

        //System.out.println(instance.numSubarrayProductLessThanK1(nums, k));

    }
}
