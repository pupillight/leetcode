package org.yj.leetcode;

public class NumArray {

    int[] preSum = null;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right > preSum.length - 2) {
            return 0;
        }
        return preSum[right + 1] - preSum[left];

    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 3, -5, 2, -1};
        NumArray instance = new NumArray(arr);

        System.out.println(instance.sumRange(0, 2));
        System.out.println(instance.sumRange(2, 5));
        System.out.println(instance.sumRange(0, 5));


    }
}
