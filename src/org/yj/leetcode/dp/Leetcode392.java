package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length() ? true : false;
    }

    private boolean check(int arr[], int k) {

        for (int i : arr) {
            if (i != 0 && i < k) return false;
        }
        return true;
    }

    public int longestSubstring(String s, int k) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int len = s.length();
        if (check(arr, k)) {
            return s.length();
        }
        for (int i = 0; i < s.length(); i++) {
            if(i>len-k){
                break;
            }
            arr[s.charAt(i) - 'a']--;
            if (check(arr, k)) {
                return s.length() - i - 1;
            }
        }
        for (int i = s.length() - 1; i > 0; i--) {
            if(i<k){
                break;
            }
            arr2[s.charAt(i) - 'a']--;
            if (check(arr2, k)) {
                return i ;
            }
        }

        return 0;
    }

    private String fLeft(String s, int k, int i, Map<Character, Integer> map) {
        if (i < 0) {
            return "";
        }
        boolean isMatch = map.values().stream().allMatch(item -> item >= k);
        if (isMatch) {
            return s.substring(i, s.length());
        }
        char c = s.charAt(i);
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
            map.remove(c);
        }

        return fLeft(s, k, i + 1, map);
    }

    private String fRight(String s, int k, int i, Map<Character, Integer> map) {
        if (i < 0) {
            return "";
        }
        boolean isMatch = map.values().stream().allMatch(item -> item >= k);
        if (isMatch) {
            return s.substring(0, i + 1);
        }
        char c = s.charAt(i);
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
            map.remove(c);
        }

        return fRight(s, k, i - 1, map);
    }

    public static void main(String[] args) {

        Leetcode392 instance = new Leetcode392();
        String s = "bbaaacbd";
        int k = 3;
        System.out.println(instance.longestSubstring(s, k));


    }
}
