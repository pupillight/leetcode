package org.yj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2958 {
    public int maxSubarrayLength(int[] nums, int k) {


        int ans = 0;
        int len = nums.length;

        if (k > len) {
            return 0;
        }
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            ans = Math.max(ans, i - j + 1);
            while (map.get(num) > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
        }
        return ans;

    }

    private boolean check(Map<Character, Integer> map, int k) {

        if (map.size() != 4) {
            return false;
        }
        boolean res = map.values().stream().allMatch(value -> value == k);
        return res;
    }

    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int k = len / 4;
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (map.get('Q') == k && map.get('E') == k && map.get('R') == k && map.get('W') == k) {
            return 0;
        }

        int res = len;
        int j = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            map.put(c, map.get(c) - 1);
            while (map.get('Q') <= k && map.get('E') <= k && map.get('R') <= k && map.get('W') <= k) {
                res = Math.min(res, i - j + 1);
                map.put(chars[j], map.get(chars[j]) + 1);
                j++;
            }
        }
        return res;

    }

    private boolean f(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && arr[i] > 2) {
                return true;
            }
        }
        return false;
    }

    public int maximumLengthSubstring1(String s) {
        int[] arr = new int[26];
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < s.length() && l <= r) {
            char c = s.charAt(r);
            arr[c - 'a']++;
            while (l <= r && f(arr)) {
                arr[s.charAt(l) - 'a']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;

    }

    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int j = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
            while (j <= i && f(arr)) {
                arr[s.charAt(j) - 'a']--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public String shortestBeautifulSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int ans = Integer.MAX_VALUE;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (j <= i && map.get('1') != null && map.get('1') == k) {
                if (i - j + 1 < ans) {
                    ans = i - j + 1;
                    str = s.substring(j, i + 1);
                }
                if (i - j + 1 == ans) {
                    if (s.substring(j, i + 1).compareTo(str) < 0) {
                        str = s.substring(j, i + 1);
                    }
                }
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    map.remove(map.get(s.charAt(j)));
                }
                j++;
            }
        }

        return ans == Integer.MAX_VALUE ? "" : str;

    }


    private boolean isYear(String str) {
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        if (str.charAt(4) != '-') {
            return false;
        }
        if (!Character.isDigit(str.charAt(5))) {
            return false;
        }
        if (!Character.isDigit(str.charAt(6))) {
            return false;
        }
        if (str.charAt(7) != '-') {
            return false;
        }
        if (!Character.isDigit(str.charAt(8))) {
            return false;
        }
        if (!Character.isDigit(str.charAt(9))) {
            return false;
        }
        return true;
    }

    public List<String> findYears(String str) {

        List<String> years = new ArrayList<>();

        int k = 10;
        int len = str.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(str.charAt(i));

        }
        if(isYear(builder.toString())){
            years.add(builder.toString());
        }
        for (int i = k; i < len; i++) {
            builder.append(str.charAt(i));
            builder.deleteCharAt(0);
            if(isYear(builder.toString())){
                years.add(builder.toString());
            }
        }
        //yyyy-mm-dd
        return years;
    }


    public static void main(String[] args) {
        LeetCode2958 instance = new LeetCode2958();
        // int[] nums = {1,2,3,1,2,3,1,2};
        // int k = 2;
        // int[] nums = {1};
        // int k = 1;
        //System.out.println(instance.maxSubarrayLength(nums, k));
        //String s = "QQWE";
        //System.out.println(instance.balancedString(s));

        String s = "1111111011111";
        int k = 12;

       // System.out.println(instance.shortestBeautifulSubstring(s, k));

       String str="china is created in 1949-10-01, i was born on 1977-12-25.";
        System.out.println(instance.findYears(str.trim()));
    }
}
