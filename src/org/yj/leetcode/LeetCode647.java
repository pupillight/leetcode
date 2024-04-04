package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode647 {

    /* int count = 0;
     private boolean isPalindromic(String s, int l, int r) {
         while (l < r) {
             if (s.charAt(l) != s.charAt(r)) {
                 return false;
             }
             l++;
             r--;
         }
         return true;
     }

     public void f(String s, int l, int r) {
         if (l > r) {
             return;
         }
         boolean flag = isPalindromic(s, l, r);
         if (flag) {
             count++;
         }
         f(s, l + 1, r);
         f(s, l, r - 1);
     }

     public int countSubstrings(String s) {
         f(s, 0, s.length() - 1);
         return count;
     }*/
    public String longestPalindrome(String s) {

        int len = s.length();
        int max = -1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;

                }
            }
        }

        return s.substring(start, start + max);
    }

    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                        res++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]) {
                            res++;
                        }

                      /*  if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            res++;
                        }*/
                    }
                }
            }
        }
        return res;
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);

        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != newArr[i]) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        if (start == end) {
            return 0;
        }
        return end - start + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {

        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 && i < nums.length - 1 && nums[i] <= nums[i + 1]) ||
                    (i > 0 && i < nums.length - 1 && nums[i - 1] <= nums[i] && nums[i] <= nums[i + 1]) ||
                    (i == nums.length - 1 && i - 1 >= 0 && nums[i - 1] <= nums[i])) {
                continue;
            } else {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        System.out.println(start);
        System.out.println(end);
        if (start == end) {
            return 0;
        }
        return end - start + 1;
    }


    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted((e1, e2) -> (e1.getValue() - e2.getValue())).collect(Collectors.toList());
        int count= list.size();
        for (Map.Entry<Integer, Integer> entry : list) {
            int v = entry.getValue();
            if (k >= v) {
                k = k - v;
                count--;
            }
        }
        int res =count;
        return res;

    }


    public static void main(String[] args) {
        LeetCode647 instance = new LeetCode647();

        String s = "fdsklf";
        //  System.out.println(instance.countSubstrings(s));
        //int[] nums = {2, 6, 4, 8, 10, 9, 15};
        //int[] nums = {1};
        //System.out.println(instance.findUnsortedSubarray(nums));
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        //int[] arr = {5, 5, 4};
        //int k = 1;
        System.out.println(instance.findLeastNumOfUniqueInts(arr, k));

    }
}
