package org.yj.leetcode;

import java.util.*;

public class LeetCode39 {

    List<LinkedList> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public void combinationSum(int[] array, int target) {
/*        if (target == 0) {
            res.add(new LinkedList(list));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            target = target - array[i];
            combinationSum(array, target);
            list.removeLast();

        }*/

        combinationSum(array, target, 0, 0);
    }

    public void combinationSum(int[] array, int target, int sum, int index) {
        if (target == sum) {
            res.add(new LinkedList(list));
            return;
        } else if (target < sum) {
            return;
        }
        for (int i = index; i < array.length; i++) {
            sum = sum + array[i];
            list.add(array[i]);
            combinationSum(array, target, sum, i);
            list.removeLast();
            sum = sum - array[i];
        }
    }


    public int calculatePow(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (num == 0 || num == 1) {
            return num;
        }
        return num * calculatePow(num, pow - 1);

    }

    public int[] printNumbers(int n) {
        if (n < 0) {
            return null;
        }
        int max = calculatePow(10, n);
        //int max = (int) Math.pow(10, n);

        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }
        return null;
    }

    public int[] distinctDifferenceArray(int[] nums) {

        int[] res = new int[nums.length];

        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[len + 1];
        for (int i = len - 1; i > 0; i--) {
            set.add(nums[i]);

            arr[i] = set.size();
        }

        set.clear();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            res[i] = set.size() - arr[i + 1];
        }

        return res;
    }

    public int[] distinctDifferenceArray1(int[] nums) {

        int[] res = new int[nums.length];
        Set<Integer> set1 = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set1.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                set2.add(nums[j]);
            }
            res[i] = set1.size() - set2.size();
            set2.clear();
        }
        return res;
    }

    public int findContentChildren1(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int i = 0, j = 0;

        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                res++;
                j++;
            }
            i++;
        }
        return res;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length) {
                if (g[i] <= s[j]) {
                    res++;
                    j++;
                    break;
                }
                j++;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        LeetCode39 leetCode = new LeetCode39();
//        int[] array = {2, 3, 5};
//        leetCode.combinationSum(array, 8);


        //System.out.println(leetCode.calculatePow(10,3));
        // leetCode.printNumbers(3);
        //int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {3, 2, 3, 4, 2};
        Arrays.stream(leetCode.distinctDifferenceArray(nums)).forEach(System.out::println);

    }
}
