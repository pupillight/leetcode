package org.yj.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1332 {


    private boolean isPalind(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public int removePalindromeSub(String s) {
        if (isPalind(s, 0, s.length() - 1)) {
            return 1;
        }
        return 2;
    }


    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sum = 0;

        boolean isOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if ((v & 1) == 1) {
                isOdd = true;
            }
            sum += v - (v & 1);
        }

        int res = isOdd ? sum + 1 : sum;
        return res;
    }

    public int countBinarySubstrings(String s) {

        StringBuilder builder = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                s.substring(i, j);
                builder.append(j);
                char c = s.charAt(i);
                map.containsKey(c);
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        return -1;
    }

    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            int v = (n >>> i) & 1;
            res = res | v;
        }
        return res;
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int v = (n >>> i) & 1;
            res = res | (v << (31 - i));
        }
        return res;
    }


    public boolean isPow(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        LeetCode1332 question = new LeetCode1332();

        int n = 964176192;

        System.out.println(question.isPow(3));
        System.out.println(question.reverseBits(n));
        //System.out.println(question.removePalindromeSub("ababb"));

    }
}
