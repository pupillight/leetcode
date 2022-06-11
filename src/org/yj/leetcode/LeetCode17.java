package org.yj.leetcode;

import java.util.*;

public class LeetCode17 {
    List<LinkedList<String>> list = new ArrayList<>();

    public LinkedList<String> allPhoneNumbers(String str) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        LinkedList<String> paths = new LinkedList<>();
        backTracking(str, 0, paths, map, new StringBuilder());
        return paths;
    }

    private void backTracking(String text, int startIndex, LinkedList<String> paths, Map<Character, String> map, StringBuilder builder) {
        if (startIndex == text.length()) {
            paths.add(builder.toString());
            return;
        }
        char c = text.charAt(startIndex);
        String letters = map.get(c);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            builder.append(letters.charAt(i));
            backTracking(text, startIndex + 1, paths, map, builder);
            builder.deleteCharAt(startIndex);
        }
    }
    /*private void backTracking(int k, String str, LinkedList<String> paths, int startIndex) {
        if (k == paths.size()) {
            list.add(new LinkedList<String>(paths));
            return;
        }

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            paths.add(c + "");
            backTracking(k, str, paths, i + 1);
            paths.removeLast();
        }

    }*/


    public static void main(String[] args) {
        LeetCode17 leetCode = new LeetCode17();

        System.out.println(leetCode.allPhoneNumbers("23"));
    }
}
