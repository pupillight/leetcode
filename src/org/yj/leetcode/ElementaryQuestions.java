package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ElementaryQuestions {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {

        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else
                map.put(nums1[i], 1);
        }
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) ) {
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;*/

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else
                map.put(nums1[i], 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else
                map.put(nums1[i], 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                set.add(nums2[i]);
            }
        }

        int[] res = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i] = iterator.next();
            i++;
        }

        return res;
    }


    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void rotate(int[] nums, int k) {

        int[] newNums = new int[nums.length];
        if (k > nums.length) {
            k = k % nums.length;
        }


        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newNums[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newNums[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }

    }

    public int[] plusOne(int[] digits) {

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            if (i == digits.length - 1) {
                sum = sum + 1;
            }
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = carry;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        }
        return digits;


    }


    public void reverseString(char[] s) {
        /*Stack<Character> stack = new Stack<>();
        for (char c : s) {
            stack.push(c);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }*/

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }

    }

    public int reverse(int x) {
        int y = 0;
        // int sign = 1;
        // if (x < 0) {
        //     sign = -1;
        // }
        // x = Math.abs(x);
        while (x != 0) {
            if (y > (Integer.MAX_VALUE) / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }


    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        if (map.size() == 0) {
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            while (i < j && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) i++;
            while (i < j && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))) j--;
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = 0;
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

    public String longestCommonPrefix1(String[] strs) {
        int row = strs.length;
        int col = strs[0].length();
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix(String[] strs) {
        String commonPrefixStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefixStr = commonPrefix(commonPrefixStr, strs[i]);
        }
        return commonPrefixStr;
    }


    public String longestCommonPrefix2(String[] strs) {
        int left = 0;
        int right = strs.length - 1;
        return longestCommonPrefix(strs, left, right);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = left + (right - left) / 2;
        String aStr = longestCommonPrefix(strs, left, mid);
        String bStr = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(aStr, bStr);

    }

    public String commonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            i++;
        }
        return a.substring(0, i);
    }

    private String merge(String[] strs, int left, int mid, int right) {
        // commonPrefix(strs[left],strs[mid]);
        return commonPrefix(strs[left], strs[right]);

    }





    public static void main(String[] args) {
        ElementaryQuestions questions = new ElementaryQuestions();
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // questions.moveZeroes(nums);
        // Arrays.stream(nums).forEach(System.out::println);
        // questions.removeDuplicates(nums);
        //int[] nums1 = {1, 2, 2, 1};
        //int[] nums2 = {2, 2};
        //int[] nums1={4,9,5};
        //int[] nums2={9,4,9,8,4};
        //System.out.println(questions.intersect1(nums1, nums2));
//        int[] nums = {9, 9, 9};
//        questions.plusOne(nums);
//        questions.reverseString("hello".toCharArray());
//-2147483648
        //2147483648
        //System.out.println(questions.reverse(-113));
        //System.out.println(questions.firstUniqChar("aabb"));
        //System.out.println(questions.isPalindrome("race a car"));
        //System.out.println(questions.isPalindrome("......a....."));
        //System.out.println(questions.strStr("", ""));
        //String[] strs = {"aaa", "aa", "aaa"};
        //System.out.println(questions.longestCommonPrefix(strs));
        //System.out.println(questions.commonPrefix("flower","ooow"));


    }

}
