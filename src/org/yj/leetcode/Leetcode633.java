package org.yj.leetcode;

public class Leetcode633 {

    public int bSearch(int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid == target) {
                return mid;
            } else if ((long) mid * mid < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        for (int i = 0; i * i <= c; i++) {
            int one = i * i;
            int other = c - i * i;
            int ans = bSearch(other, i, c);
            if (ans != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {

        int a = 0;
        int b = c;

        while (a <= b && a * a <= c && b * b <= c) {
            long v =(long) a * a + (long)b * b;

            if (v == c) {
                return true;
            } else if (v < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        Leetcode633 instance = new Leetcode633();

        //System.out.println(instance.judgeSquareSum(100000));
        System.out.println(instance.judgeSquareSum1(0));
       /* System.out.println(instance.judgeSquareSum(2));
        System.out.println(instance.judgeSquareSum(3));
        System.out.println(instance.judgeSquareSum(5));*/
    }


}