package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode524 {

    public String findLongestWord(String s, List<String> dictionary) {
        int max = Integer.MIN_VALUE;
        String ans = "";
        for (String word : dictionary) {
            int v = f(s, word);
            if (v>0 && v > max) {
                max = v;
                ans = word;
            } else if (v == max) {
                if (ans.compareTo(word) > 0) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public int f(String s, String target) {
        int i = 0, j = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == target.length()) {
            return j;
        }
        return -1;
    }

    public static void main(String[] args) {

        Leetcode524 instance = new Leetcode524();

        String s = "apple";
        //String[] dictionary = {"ale", "apple", "monkey", "plea"};
        //String[] dictionary = {"ale", "apple", "monkey", "plea"};

        String[] dictionary = {"zxc","vbn"};
        System.out.println(instance.findLongestWord(s, List.of(dictionary)));

    }


}
