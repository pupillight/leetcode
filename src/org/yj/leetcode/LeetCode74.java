package org.yj.leetcode;

public class LeetCode74 {

    public boolean find(int[][] array, int target) {
        int i = array.length;
        int j = array[0].length;
        int k = i * j;
        int left = 0, right = k - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = array[mid / j][mid % j];
            if (tmp == target) {
                System.out.println(mid / j);
                System.out.println(mid % j);
                return true;
            } else if (tmp > target) {
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
        LeetCode74 leetcode = new LeetCode74();

        int[][] array = {{1, 2}, {3, 4}, {7, 9}};
        System.out.println(leetcode.find(array, 9));

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.println(array[i][j]);
//            }
//        }
    }

}
