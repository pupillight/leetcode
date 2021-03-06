package org.yj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        int max=calculatePow(10,n);
        //int max = (int) Math.pow(10, n);

        for (int i = 1; i < max; i++) {
            System.out.println(i);
        }
        return null;
    }


    public static void main(String[] args) {
        LeetCode39 leetCode = new LeetCode39();
//        int[] array = {2, 3, 5};
//        leetCode.combinationSum(array, 8);

        System.out.println();

        //System.out.println(leetCode.calculatePow(10,3));
        leetCode.printNumbers(3);
    }
}
