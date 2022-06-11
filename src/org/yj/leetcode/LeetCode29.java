package org.yj.leetcode;

public class LeetCode29 {

    public int divide(int a, int b) {

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        if (a == Integer.MIN_VALUE && b == -1) {

            return Integer.MAX_VALUE;
        }
        //System.out.println((a > 0) ^ (b > 0));
        boolean isNegative = (a > 0) ^ (b > 0) == true ? true : false;
        int res = 0;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int count = 0;
        while (a <= b) {
            a = a - b;
            count++;
        }
        if (isNegative) {
            res = -count;
        } else {
            res = count;
        }
        return res;
    }

    public int divide1(int a, int b) {

        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        //System.out.println((a > 0) ^ (b > 0));
        boolean isNegative = (a > 0) ^ (b > 0) == true ? true : false;
        int res = 0;
        a = Math.abs(a);
        System.out.println(a);
        b = Math.abs(b);
        int count = 0;
        while (a >= b) {
            a = a - b;
            count++;
        }
        if (isNegative) {
            res = -count;
        } else {
            res = count;
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode29 leetCode = new LeetCode29();
        System.out.println(leetCode.divide(Integer.MIN_VALUE, 1));
    }
}
