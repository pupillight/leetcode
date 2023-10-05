package org.yj.leetcode;

import java.util.Arrays;

public class NumArray {

    int[] preSum = null;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right > preSum.length - 2) {
            return 0;
        }
        return preSum[right + 1] - preSum[left];

    }


    public static int[] removeDuplicate(int[] nums) {

        int i = 1;
        int j = 0;

        while (i < nums.length && j <= i) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j]=nums[i];
            }else{
                //do nothing
            }
            i++;
        }
        //int[] res = new int[j+1];
        int[] res =Arrays.copyOfRange(nums,0,j+1);
        return res;
    }

    public static void main(String[] args) {
        //int[] arr = {-2, 0, 3, -5, 2, -1};
        //NumArray instance = new NumArray(arr);
        int[] arr = {1,1,3};
      Arrays.stream(removeDuplicate(arr)).forEach(System.out::println);
     /*   System.out.println(instance.sumRange(0, 2));
        System.out.println(instance.sumRange(2, 5));
        System.out.println(instance.sumRange(0, 5));*//**/


/*        int num = 7;
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append(num >> i & 1);
        }
        System.out.println(builder.toString());*/

    }
}
