package org.yj.leetcode;

public class LeetCode11 {


    public static void main(String[] args) {
        LeetCode11 leetCode = new LeetCode11();
        //int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] array = {2, 2, 5};
        System.out.println(leetCode.containerWithMostWater(array));
        //ystem.out.println(leetCode.solution(array));
        //System.out.println(leetCode.solution1(array));
    }


    public int containerWithMostWater(int[] nums) {
        //  int left = 0, right = nums.length-1;
        int res = 0;
        int mid = (nums.length - 1) / 2;
        int left = mid;
        int right = mid;
        while (left >= 0 && right <= nums.length - 1) {
            //left = left < 0 ? 0 : left;
            //right = right > nums.length - 1 ? nums.length - 1 : right;
            int x = Math.min(nums[left], nums[right]);
            int y = right - left;
            res = Math.max(res, x * y);

            if (nums[left] < nums[right]) {
                left--;
            } else {
                right++;
            }
            //left--;
            //right++;

        }

        return res;
    }

    public int solution(int[] array) {
        int res = 0;
        if (array == null || array.length < 2) {
            return res;
        }

        int i = 0, j = array.length - 1;
        while (i < j) {
            int a = j - i;
            int b = 0;
            if (array[i] > array[j]) {
                b = array[j];
                j--;
            } else {
                b = array[i];
                i++;
            }
            res = Math.max(res, a * b);
        }
        return res;
    }

    public int solution1(int[] array) {
        int res = 0;
        if (array == null || array.length < 2) {
            return res;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int a = Math.min(array[i], array[j]);
                int b = j - i;
                res = Math.max(res, a * b);
            }
        }


        return res;
    }
}
