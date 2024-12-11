package org.yj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1482 {


    public static void main(String[] args) {
        LeetCode1482 instance = new LeetCode1482();
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};

        System.out.println(instance.numWays(5, relation, 3));

        System.out.println("--------");
    }
}
