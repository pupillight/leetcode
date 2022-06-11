package org.yj.leetcode;

import java.util.*;

public class LeetCode77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> paths = new LinkedList();

    public List<List<Integer>> combine(int n, int k) {
        allCombinations(n, k, 1);
        return res;
    }

    private void allCombinations(int n, int k, int index) {
        if (paths.size() == k) {
            res.add(new LinkedList<Integer>(paths));
            return;
        }
        for (int i = index; i <= n; i++) {
            paths.offer(i);
            allCombinations(n, k, i + 1);
            paths.removeLast();
        }
    }




    public static void main(String[] args) {
        LeetCode77 leetCode = new LeetCode77();
        leetCode.combine(3, 2);
        System.out.println();
    }

    /*ArrayList<Deque<Integer>> res = new ArrayList<>();
    Deque<Integer> paths = new LinkedList();
    public void allCombinations(int n, int k) {
        allCombinations(n, k, 1);
    }

    private void allCombinations(int n, int k, int index) {
        if (paths.size() == k) {
            res.add(new LinkedList<Integer>(paths));
            return;
        }
        for (int i = index; i <= n; i++) {
            paths.offer(i);
            allCombinations(n, k, i + 1);
            paths.removeLast();
        }
    }*/


}
