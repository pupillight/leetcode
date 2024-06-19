package org.yj.leetcode;

import java.util.*;

public class LeetCode8 {

    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        if (i == len) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        long res = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                res = res * 10 + sign * (c - '0');
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
            i++;
        }
        return (int) res;
    }


    public int reverse(int x) {
        int res = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        while (x != 0) {

            if (sign == 1 && res > (Integer.MAX_VALUE - (x % 10)) / 10) {
                return 0;
            }
            if (sign == -1 && res < (Integer.MIN_VALUE - (x % 10)) / 10) {
                return 0;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }


        return res;

    }

    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum + map.get(s.charAt(i));
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                sum = sum - 2 * map.get(s.charAt(i - 1));
            }
        }
        return sum;
    }

    public int strStr(String haystack, String needle) {

        int j = 0;
        int len = needle.length();
        for (int i = 0; i < haystack.length(); ) {

            if (j < len && haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == len) {
                return i - len;
            }
        }
        return -1;

    }


    private int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            int mod = n % 10;
            sum += mod * mod;
            n = n / 10;

        }
        return sum;
    }

    public boolean isHappy(int n) {
        int sum = getSum(n);
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        while (sum != 1) {
            sum = getSum(sum);
            if (!set.add(sum)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        LeetCode8 instance = new LeetCode8();

        System.out.println(instance.strStr("sadbutsad", "sad"));

        //System.out.println(instance.romanToInt("III"));
        //System.out.println(instance.romanToInt("MCMXCIV"));
        // System.out.println(instance.myAtoi("+12"));
        //System.out.println(instance.myAtoi("-42"));

        // System.out.println(instance.reverse(-2147483648));
    }
}
