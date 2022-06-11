package org.yj.application.data.leetcode;

import java.util.PriorityQueue;

public class ArrayLeetCode {


    public void Print(int[] array) {
        subPrint(array, array.length - 1);
    }

    private void subPrint(int[] array, int i) {
        if (i == 0) {
            System.out.println(array[i]);
            return;
        }
        subPrint(array, i - 1);
        System.out.println(array[i]);
    }

    public void maxSubsequence(int[] array, int k) {
        if (k < 0) {
            return;
        }

/*
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < array.length; i++) {
            map.put( array[i],i);
        }

        int[] tempArray= array;
        Arrays.sort(tempArray);
        int[] res=Arrays.copyOfRange(tempArray,tempArray.length-k,tempArray.length);
        for (int i = 0; i < res.length; i++) {
            res[i]=map.get(res[i]);
            System.out.println(res[i]);
        }
//
       // Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }*/


        java.util.PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < k; i++) {
            queue.add(array[i]);
        }


        for (int i = k; i < array.length; i++) {
            int tmp = queue.peek();
            if (array[i] > tmp) {
                queue.poll();
                queue.add(array[i]);
            }
        }


        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }


/*    public void moveZero2End(int[] array) {
        int i = 0;
        int j = 0;

        while (i < array.length) {

            if (array[i] != 0) {
                //swap
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                j++;
            }
            i++;
        }
    }*/

    public void moveZero2End(int[] array) {
        int i = 0;
        int j = 0;

        while (i < array.length) {
            if (array[i] != 0) {
                if (i != j) {
                    array[j] = array[i];
                }
                j++;
            }
            i++;

        }

        while (j < array.length) {

            array[j] = 0;
            j++;
        }
    }


    /**
     * 在二维数组中需要指定数字
     *
     * @param array
     * @param target
     * @return
     */
    public boolean findTargetNumber(int[][] array, int target) {

        //将有序的二维数组转化为一位数组
        //用二分查找方式查找
        int i = 0;
        int m = array.length;
        int n = array[0].length;
        int j = m * n;

        while (i <= j) {

            int mid = (i + j) / 2;
            int midValue = array[mid / n][mid % n];

            if (target < midValue) {
                j = mid - 1;
            } else if (target > midValue) {
                i = mid + 1;
            } else {
                System.out.println(mid / n);
                System.out.println(mid % n);
                return true;
            }

        }


        return false;
    }


    public boolean findNumberMultiArray(int[][] array, int target) {
        int m = array.length;
        int n = array[0].length;
        int leftButtomValue = array[m - 1][0];
        int i = m - 1;
        int j = 0;
        while ((i >= 0 && i < m) && (j >= 0 && j < n)) {
            if (target == array[i][j]) {
                System.out.println(i);
                System.out.println(j);
                return true;
            } else if (target > array[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayLeetCode coder = new ArrayLeetCode();

   /*     int[] t = {0, 2, 0, 3, 6};
        coder.moveZero2End(t);

        for (int i : t) {
            System.out.println(i);
        }
*/

        int[][] array = {{1, 5, 8}, {3, 6, 9}, {5, 14, 16},};
        // System.out.println(coder.findTargetNumber(array, 3));
        System.out.println(coder.findNumberMultiArray(array, 14));
        ///System.out.println(coder.arraySum(t));
        /// coder.Print(t);

//
//        int k = 2;
//
//
//        coder.maxSubsequence(t, 3);
//
//        for (int i = 0; i < t.length; i++) {
//            System.out.println(t[i]);
//        }


    }


}
