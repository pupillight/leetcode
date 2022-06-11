package org.yj.leetcode;

public class LeetCode240 {
//    public boolean findNumber(int[][] array, int target) {
//        int row = array.length;
//        int col = array[0].length;
//        int m = Math.min(row, col);
//
//        for (int i = 0; i < m; i++) {
//            boolean isRowFound = findByRows(array, i, target);
//            boolean isColFound = findByCols(array, i, target);
//            if (isRowFound || isColFound) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean findNumber(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        int m = Math.min(row, col);

        for (int i = 0; i < m; i++) {
            boolean isRowFound = findByRows(array, i, target);
            boolean isColFound = false;
            if (!isRowFound) {
                isColFound = findByCols(array, i, target);
            }
            if (isRowFound || isColFound) {
                return true;
            }
        }
        return false;
    }

    private boolean findByRows(int[][] array, int row, int target) {

        int left = row;
        int right = array[row].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[row][mid] == target) {
                return true;
            } else if (array[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    private boolean findByCols(int[][] array, int col, int target) {
        int left = col;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid][col] == target) {
                return true;
            } else if (array[mid][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] array = {3, 1, 6, 0, 23, 6, 9, 4, 3, 5};
        //int[] array = {3, 1, 6};
//        LeetCode240 leetcode = new LeetCode240();
//        int[][] array = {{4, 10, 12, 23}, {5, 11, 15, 39}, {9, 19, 21, 99}};
//        //int[][] array = {{1, 2}, {3, 4}};
//        System.out.println(leetcode.findNumber(array, 21));


/*        String a="abcdef";
        int[] array=new int[a.length()];
        for(int i=0;i<a.length();i++)
        {
            array[i]=a.charAt(i)-'a';
            System.out.println(array[i]);
        }*/


        int t = 2;
        System.out.println(1 << 1 );
        System.out.println(1 << 1 ^ 2);
        for (int i = 31; i >= 0; i--) {

            System.out.print((1 << i & t));
            //System.out.println();
            //System.out.print((1<<i & t) ==0?0:1);
        }
        System.out.println();
    }
}
