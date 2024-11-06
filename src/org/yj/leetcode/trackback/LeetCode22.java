package org.yj.leetcode.trackback;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    private List<String> list = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

    String parentheses[] = {"{", "}"};

    public List<String> generateParenthesis(int n) {
        trackback(n, "", 0, 0);
        return list;
    }
    private void trackback(int n, String str, int l, int r) {
        if (l > n || r > l) {
            return;
        }
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }
        trackback(n, str + "(", l + 1, r);
        trackback(n, str + ")", l, r + 1);
    }
    private void trackback1(int n, int index, String str, int l, int r) {
        if (l > n || r > l) {
            return;
        }
        if (index == 2 * n) {
            list.add(str);
            return;
        }
        trackback1(n, index + 1, str + "{", l + 1, r);
        trackback1(n, index + 1, str + "}", l, r + 1);
    }




    public static void main(String[] args) {
        LeetCode22 leetCode = new LeetCode22();

        System.out.println(leetCode.generateParenthesis(3));
    }
}
