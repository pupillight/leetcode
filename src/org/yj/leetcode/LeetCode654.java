package org.yj.leetcode;

public class LeetCode654 {


    public int finaMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                right = mid + 1;

            } else {
                left = mid;
            }

        }
        return nums[left];
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        for (int i = 0; i < nums.length; i++) {

        }
        return null;

    }

    public static void main(String[] args) {
        LeetCode654 leetCode654 = new LeetCode654();
        int[] nums = {3, 2, 1};
        //int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(leetCode654.finaMax(nums));

    }
}
