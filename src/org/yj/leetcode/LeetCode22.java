package org.yj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    List<String> paths = new ArrayList<>();

    public List<String> create(int n) {
        String path = "";
        create(n, path, 0, 0);
        return paths;
    }

    public void create(int n, String path, int left, int right) {
        if (right > left) {
            return;
        }
        if (left > n) {
            return;
        }
        if (path.length() == 2 * n) {
            paths.add(path);
            return;
        }
        create(n, path + "(", left + 1, right);
        create(n, path + ")", left, right + 1);
    }


    public static void main(String[] args) {
        LeetCode22 leetCode = new LeetCode22();
        //System.out.println(leetCode.create(2));

        leetCode.create(1).stream().forEach(System.out::println);
    }
}
