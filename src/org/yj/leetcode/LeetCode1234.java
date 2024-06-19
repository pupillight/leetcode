package org.yj.leetcode;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.IntStream;

public class LeetCode1234 {


    // the first number  which is bigger than target
    public int theFirstNumber1(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid ;
            } else {
                l = mid;
            }
        }
        System.out.println(l);
        System.out.println(r);
        return l;
    }
    public int theFirstNumber(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
        System.out.println(r);
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int start = theFirstNumber(nums, target);
        int end = theFirstNumber(nums, target+1);

        if(start==nums.length){
           return res;
        }
        if(nums[start]!=target){
            return res;
        }
        res[0]= start;
        res[1]=end-1;
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (index == -1) {
            return res;
        }

        int i = index;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        res[1] = i - 1;

        i = index;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        //res[0] = i == 0 ? 0 : i + 1;
        res[0] = i + 1;
        return res;
    }


    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), t.charAt(i));
            map2.put(t.charAt(i), s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (map1.get(s.charAt(i)) != t.charAt(i) || map2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }

        }

        return true;
    }


    public boolean threeConsecutiveOdds(int[] arr) {

        if (arr.length < 3) {
            return false;
        }
        int k = 3;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i] & 1;
            if (sum == 3) {
                return true;
            }
        }
        for (int i = k; i < arr.length; i++) {
            sum = sum - (arr[i - k] & 1);
            sum = sum + (arr[i] & 1);
            if (sum == 3) {
                return true;
            }
        }
        return false;
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

      /*  char[] chars = s.toCharArray();


        Map<Character, Integer> map = new HashMap<>();
        int len = chars.length;
        int[][] arr = new int[len + 1][26];
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (int i = 1; i <= len; i++) {
            char c = chars[i - 1];
            map.put(c, map.getOrDefault(c, 0) + 1);
            arr[i] = arr[i - 1].clone();
            arr[i][c - 'A']++;
        }
        int k = len / 4;
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> map1 = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) {
                map1.put(entry.getKey(), entry.getValue() - k);
            }
        }

        if (map1.size() == 0) {
            return 0;
        }
        int j = 0;

        for (int i = 1; i <= len; i++) {

            for (int l = 0; l < 26; l++) {
                char c = (char) ('A' + l);
                int diff = arr[i][l] - arr[j][l];
            }

        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {

            char c = chars[i];
            if (map1.containsKey(c)) {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }
            while (map1.containsKey(c) && map2.containsKey(c) && map1.get(c) == map2.get(c)) {
                if (map2.containsKey(chars[j])) {
                    map2.put(chars[j], map2.get(chars[j]) - 1);
                    if (map2.get(chars[j]) == 0) {
                        map2.remove(chars[j]);
                    }
                }
                res = Math.min(res, i - j + 1);
                j++;
            }


        }


        return res;*/
    }

    public static void main(String[] args) {
        LeetCode1234 instance = new LeetCode1234();
        //String s = "WQWRQQQW";
        //String s = "QQWE";

        //System.out.println(instance.balancedString(s));

        int[] nums = {5, 7, 8, 8, 8, 12};
        System.out.println(instance.theFirstNumber(nums, 9));
        System.out.println("-------");
        System.out.println(instance.theFirstNumber1(nums, 8));
        //int[] nums = {1, 4};
        int target = 8;
        //System.out.println(instance.searchRange(nums, target));

    }
}
