package org.yj.application.data.leetcode;

import java.util.*;

public class StrLeetCode {


    public String getLongestStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                res++;
            } else {
                int index = map.get(c);
                if (index >= start) {
                    start = index + 1;
                }
                map.put(c, i);
                //res++;
            }
        }
        return str.substring(start, res);
    }


   /* public int getLongestUnrepeatableStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int len = 0;

        Set<Character> set = new HashSet();
        while (i < str.length()) {
            char c = str.charAt(i);
            while (set.contains(c)) {
                set.remove(str.charAt(j));
                j++;
            }
            set.add(c);
            len = Math.max(len, i - j + 1);
            i++;
        }
        return len;
    }*/

    public int getLongestUnrepeatableStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int len = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (i < str.length()) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int index = map.get(c);
                j = index + 1;
            }
            map.put(c, i);
            len = Math.max(len, i - j + 1);
            i++;
        }
        return len;
    }

    public int strIndex(String text, String pattern) {
        if (text == null || pattern == null || text.length() == 0) {
            return -1;
        }
        if (pattern.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {

            char c1 = text.charAt(i);
            char c2 = pattern.charAt(j);
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;

            }
        }

        int index = i - j;

        return index;
    }


    public boolean isValidBracket1(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.pop() != '(') return false;
                if (c == ']' && stack.pop() != '[') return false;
                if (c == '}' && stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();

    }

    public boolean isValidBracket(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');


        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsValue(c)) {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.pop() != map.get(c)) return false;

            }
        }
        return stack.isEmpty();

    }


    public static void main(String[] args) {
        StrLeetCode leetCode = new StrLeetCode();
        //System.out.println(leetCode.getLongestStr("abcdcbef"));
        // System.out.println(leetCode.getLongestStr("abcabcbb"));
        //System.out.println(leetCode.getLongestUnrepeatableStr("abcbc"));
        //System.out.println(leetCode.strIndex("abcabcde", "abcd"));
        System.out.println(leetCode.isValidBracket("{}([]})"));


    }
}
