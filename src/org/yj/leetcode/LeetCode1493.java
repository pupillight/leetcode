package org.yj.leetcode;

import java.util.*;

public class LeetCode1493 {

    public int longestSubarray(int[] nums) {

        int l = 0;
        int r = 0;
        int len = nums.length;

        int count = 0;
        int res = 0;
        while (r < len && l <= r) {

            if (nums[r] == 0) {
                count++;
            }
            while (count > 1 && l <= r) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            res = Math.max(res, r - l);
            r++;
        }
        return res;
    }

    private boolean f(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
          /*  if (arr[i] > 2) {
                return false;
            }
            else */
            if (arr[i] > 1) {
                count++;
            }
        }
        return count > 1 ? false : true;
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int arr[] = new int[10];
        int l = 0, r = 0;
        int ans = 0;
        int same = 0;
        for (; r < s.length(); r++) {

            if (r > 0 && s.charAt(r) == s.charAt(r - 1)) {
                same++;
                if (same > 1) {
                    while (++l > 0 && s.charAt(l) == s.charAt(l - 1)) {
                        same--;


                    }

                }
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public int maximumUniqueSubarray(int[] nums) {

        int l = 0, r = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (; r < len; r++) {
            if (map.containsKey(nums[r])) {
                int orginalL = l;
                l = Math.max(map.get(nums[r]) + 1, l);

                for (int i = orginalL; i < l; i++) {
                    sum -= nums[i];
                }
            }
            map.put(nums[r], r);
            sum = sum + nums[r];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 1;
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                index = Math.max(index, map.get(c) + 1);
            }
            map.put(c, i);
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }


    public int maximumUniqueSubarray1(int[] nums) {

        int l = 0, r = 0;
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int sum = 0;
        for (; r < len; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum = sum - nums[l];
                l++;
            }
            sum = sum + nums[r];
            set.add(nums[r]);


            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int j = 0;
        int i = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int res = 0;
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[j], map.get(fruits[j]) - 1);
                count--;
                if (map.get(fruits[j]) == 0) {
                    map.remove(fruits[j]);
                }
                j++;
            }
            count++;
            res = Math.max(res, count);
        }
        return res;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int j = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            while (map.get(nums[i]) > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }


    private boolean f(Map<Character, Integer> map, int k) {

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) {
                return true;
            }
        }
        return false;

    }

    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }

    public int balancedString1(String s) {

        int len = s.length();
        int k = len / 4;

        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (f(map, k)) {
                char o = s.charAt(j);
                map.put(o, map.get(o) - 1);
                if (map.get(o) == 0) {
                    map.remove(o);
                }
                j++;
            }
        }

        return 0;
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
    public String longestNiceSubstring(String s) {
        String ans = "";
       int len= s.length();
       char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {

            for (int j = i; j < len; j++) {
                String subStr=s.substring(i,j+1);
                if (isNiceSubStr(subStr)) {
                    if (subStr.length() > ans.length()) {
                        ans = subStr;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode1493 instance = new LeetCode1493();

        System.out.println(instance.longestNiceSubstring("YazaAay"));
        //System.out.println(instance.balancedString("QQQW"));


    }
}
