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


   /* public int minSubArrayLen(int target, int[] nums) {
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
    }*/


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


    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0, index = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - index + 1);
                sum = sum - nums[index];
                index++;
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 1;
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                index = Math.max(map.get(c) + 1, index);
            }
            map.put(c, i);
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 1;
        int index = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(index));
                index++;
            }
            set.add(c);
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
/*            if (deque.isEmpty()) {
                deque.add(nums[i]);
            }
            if (nums[i] < deque.peekLast()) {
                deque.add(nums[i]);
            }*/
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(nums[i]);
        }
        res.add(deque.peekFirst());
        for (int i = k; i < nums.length; i++) {
            //deque.pollFirst();
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(nums[i]);
            int val = deque.peekFirst();
            res.add(val);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        System.out.println(res);
        return ans;
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        boolean ans = false;
        int k = s1.length();
        int[] array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i + k > s2.length()) {
                break;
            }
            String tmp = s2.substring(i, i + k);
            ans = isAnagram2(array, tmp);
            if (ans) {
                return true;
            }
        }
        return false;
    }

   /* private boolean isContained(String s1, String s2) {
        int ans = 0;
        int k = s1.length();
        for (int i = 0; i < k; i++) {
            int val1 = s1.charAt(i) - 'a';
            int val2 = s2.charAt(i) - 'a';
            ans = ans ^ val1 ^ val2;
        }
        if (ans == 0) {
            return true;
        }
        return false;
    }*/

    /* private void backTrack(String str, LinkedList<Character> path, List<String> list, String text) {

         if (path.size() == str.length()) {
             StringBuilder builder = new StringBuilder();
             for (int i = 0; i < path.size(); i++) {
                 builder.append(path.get(i));
             }
             if (text.indexOf(builder.toString()) > -1) {
                 this.isContained = true;
                 //return;
             }
             list.add(builder.toString());
             return;
         }

         for (int i = 0; i < str.length(); i++) {
             char c = str.charAt(i);
             if (path.contains(c)) {
                 continue;
             }
             path.add(c);
             backTrack(str, path, list, text);
             path.removeLast();
         }


     }*/
    /*private void backTrack(String str, LinkedList<Character> path, List<String> list, String text, int index) {

        if (path.size() == str.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
            }
            if (text.indexOf(builder.toString()) > -1) {
                this.isContained = true;
                //return;
            }
            list.add(builder.toString());
            return;
        }

        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (path.contains(c)) {
                continue;
            }
            path.add(c);
            backTrack(str, path, list, text, index);
            path.removeLast();
        }


    }*/
    public boolean isAnagram2(int[] array, String t) {
        int[] array2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            array2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(array, array2);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array1[s.charAt(i) - 'a']++;
            array2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(array1, array2);


      /* Map<Character, Integer> map = new HashMap<>();
       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           map.put(c, map.getOrDefault(c, 0) + 1);
       }
       for (int i = 0; i < t.length(); i++) {
           char c = t.charAt(i);
           if (!map.containsKey(c)) {
               return false;
           } else {
               map.replace(c, map.getOrDefault(c, 0) - 1);
               if (map.getOrDefault(c, 0) == 0) {
                   map.remove(c);
               }
           }
       }
       return map.size() == 0;*/
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.replace(c, map.getOrDefault(c, 0) - 1);
                if (map.getOrDefault(c, 0) == 0) {
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }

    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int i = 0;
        boolean ans = false;
        while (i < nums.length) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                ans = true;
                return ans;
            }
            i++;
        }
        return false;
    }
       /* int left = 0, right = 0, k = 3;
        right = k - 1;

        for (int j = 0; j <= nums.length-k; j++) {
            //for (int i = j; i < k - 1; i++) {
                if (nums[j] < nums[j + 1] &&nums[j + 1] <nums[j+2] ) {
                    return true;
                }
           // }
        }

        return false;*/
       /* while (right < nums.length && left < right) {
            if (nums[left] < nums[left + 1] && nums[left + 1] < nums[left + 2]) {

            }
        }
        return false;*/



    public static void main(String[] args) {
        SlidingWindow instance = new SlidingWindow();
        //int[] arr = {1, 2, 3};
        //int k = 0;
        // System.out.println(instance.findMaxAverage(arr, k));
        // System.out.println(instance.divisorSubstrings(240, 2));
        //System.out.println(instance.isNiceSubStr("aAa"));

        // System.out.println(instance.longestNiceSubstring("c"));
        //System.out.println(instance.numSubarrayProductLessThanK(arr, k));
        //int[] nums = {2,3,1,2,4,3};
        //int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1, 1, 1, 1, 1};
        //System.out.println(instance.minSubArrayLen(11, nums));

        //instance.maxSlidingWindow(nums, 1);
        //System.out.println(instance.checkInclusion("ab", "eidboaoo"));
        System.out.println(instance.increasingTriplet(nums));
        //String s="dvdf";
        //String s = "bbba";
        //System.out.println(instance.lengthOfLongestSubstring(s));
    }
}
