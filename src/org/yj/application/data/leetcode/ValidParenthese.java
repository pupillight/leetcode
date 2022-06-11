package org.yj.application.data.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthese {

    public static boolean isValidParenthese(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        if (str.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for (int i = 0; i < str.length(); i++) {

            char next = str.charAt(i + 1);
            if (next != map.get(str.charAt(i))) {
                break;
                //return false;
            } else {
                i++;
            }
        }

        for (int j = 0; j < str.length()/2; j++) {
            char next = map.get(str.charAt(j));
            if (next != str.charAt(str.length() - (j+1))) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String str = "[]{}";
        System.out.println(isValidParenthese(str));
    }
}
