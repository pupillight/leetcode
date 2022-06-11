package org.yj.leetcode;

public class LeetCode283 {

    public void moveZero1(int[] array) {
        int i = 0, j = 0;
        for (; i < array.length; i++) {
            if (array[i] != 0) {
                swap(array, i, j);
                j++;
            }
//            if (array[j] != 0) {
//                j++;
//            }
        }
    }

    public void moveZero(int[] array) {
        int i = 0, j = 0;
        for (; i < array.length; i++) {
            if (array[i] != 0) {
                if (i != j) {
                    array[j] = array[i];
                }
                j++;
            }
        }
        while (j < array.length) {
            array[j] = 0;
            j++;
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static void main(String[] args) {
        LeetCode283 leetCode = new LeetCode283();
//        int[] array = {5, 0, 0, 7};
//        leetCode.moveZero(array);
//        //leetCode.moveZero1(array);
//
//        for (int v : array) {
//            System.out.println(v);
//        }

        int t=10;

        for(int i=0;i<32;i++)
        {
           System.out.print( (1<<i & t) ==0 ? 0:1);
        }

        System.out.println();
        for(int i=31;i>=0;i--)
        {
            System.out.print( (1<<i & t) ==0 ? 0:1);
        }
    }
}
