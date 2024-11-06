package org.yj.leetcode.trackback;

import java.util.*;

public class LeetCode78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        res.add(list);
        trackBack(nums, 0, list);
        return res;
    }

    private void trackBack(int[] num, int index, List<Integer> list) {

        if (list.size() > 0) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < num.length; i++) {
            list.add(num[i]);
            trackBack(num, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int num = nums[i];
            if (!set.contains(num - 1)) {
                len++;
                while (set.contains(++num)) {
                    len++;
                }

                res = Math.max(res, len);
            }
        }
        return res;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int num = nums[i];
            if (!set.contains(num + 1)) {
                len++;
                while (set.contains(--num)) {
                    len++;
                }

                res = Math.max(res, len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode78 leetCode = new LeetCode78();
     /* int[]  nums = {1,2};
        System.out.println(leetCode.subsets(nums));*/
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(leetCode.longestConsecutive(nums));
        //System.out.println(leetCode.generateParenthesis(3));
    }
}
