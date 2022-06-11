package org.yj.leetcode;

import org.yj.application.data.collections.MaxHeap;

import java.util.*;

public class SlidingWindow {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = Math.abs(map.get(nums[i]) - i);
                if (diff <= k) {
                    return true;
                }
                map.replace(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double ans = 0.00;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            ans = Math.max(ans, sum / k);
        }
        return ans;
    }

    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        if (str.length() < k) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = k;
        while (r <= str.length()) {
            String s = str.substring(l, r);
            int value = Integer.parseInt(s);
            if (value != 0 && num % value == 0) {
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }

    public int countGoodSubstrings(String s) {
        return countGoodSubstrings(s, 3);
    }

    private int countGoodSubstrings(String s, int k) {
        int len = s.length();
        if (len < k) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = k;
        while (r <= len) {
            String subStr = s.substring(l, r);
            System.out.println(subStr);
            if (isGoodStr(subStr)) {
                // System.out.println(subStr);
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }

    private boolean isGoodStr(String subStr) {
        Set<Character> set = new HashSet<>();
        for (char c : subStr.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                //System.out.println(subStr);
                if (isNiceSubStr(subStr)) {
                    if (subStr.length() > ans.length()) {
                        ans = subStr;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isNiceSubStr(String subStr) {
        for (int i = 0; i < subStr.length(); i++) {
            char c = subStr.charAt(i);
            if (Character.isUpperCase(c) && subStr.indexOf(Character.toLowerCase(c)) == -1) {
                return false;
            }
            if (Character.isLowerCase(c) && subStr.indexOf(Character.toUpperCase(c)) == -1) {
                return false;
            }
        }
        return true;
    }


    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (j <= i && sum >= target) {
                len = Math.min(len, i - j + 1);
                sum = sum - nums[j];
                j++;
            }
        }

        int ans = len == Integer.MAX_VALUE ? 0 : len;
        return ans;
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        List<List<Integer>> res = new ArrayList<>();
/*        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            for (int j = i; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();

                value = value * nums[j];
                if (value < k) {
                    list.add(nums[j]);
                }
                res.add(list);
            }
        }*/
        int i = 0, j = 0;
        while (i <= j && j < nums.length) {
            int value = 1;
            List<Integer> list = new ArrayList<>();
            for (int t = i; t <= j; t++) {
                value = value * nums[t];
                list.add(nums[t]);
            }
            if (value < k) {
                res.add(list);
            }
            j++;
            if (j == nums.length && i < nums.length) {
                i++;
                j = i;
            }
       /*     if (i == j) {
                value = nums[i];
                list.add(value);
            } else {
                int t = i;
                while (t <= j) {
                    value = value * nums[t];
                    list.add(nums[t]);
                    t++;
                }
            }
            j++;
            if (value < k) {
                res.add(list);
                if (j == nums.length - 1) {
                    j = i;
                }
            } else {
                i++;
                j = i;
            }*/
        }
        ans = res.size();
        return ans;
    }

    public static void main(String[] args) {
        SlidingWindow instance = new SlidingWindow();
        int[] arr = {1,2,3};
        int k = 0;
        // System.out.println(instance.findMaxAverage(arr, k));
        // System.out.println(instance.divisorSubstrings(240, 2));
        //System.out.println(instance.isNiceSubStr("aAa"));

        // System.out.println(instance.longestNiceSubstring("c"));
        System.out.println(instance.numSubarrayProductLessThanK(arr, k));
    }
}
