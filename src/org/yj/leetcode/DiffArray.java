package org.yj.leetcode;

import java.util.Arrays;

public class DiffArray {


    public int minStartValue(int[] nums) {
        int ans=1;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        int min= preSum[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
            if(preSum[i] < min)
            {
                min= preSum[i];
            }
        }

        if(min<=0){
            ans= 1-min;
        }
        return ans;

    }

    public static void main(String[] args) {

        int[] array = {3, 0, -1, 7, 7};
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        int[] diffArray = new int[array.length];
        diffArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            diffArray[i] = array[i] - array[i - 1];
        }

        //1-3 +2
        Arrays.stream(diffArray).forEach(System.out::print);
        diffArray[1] = diffArray[1] + 2;
        diffArray[4] = diffArray[4] - 2;
        System.out.println();
        //1-2 -3
        diffArray[1] = diffArray[1] - 3;
        diffArray[3] = diffArray[3] + 3;

        Arrays.stream(diffArray).forEach(System.out::print);

        int[] preSum = new int[array.length];
        preSum[0] = diffArray[0];
        for (int i = 1; i < diffArray.length; i++) {
            //preSum[i]= diffArray[i]+preSum[i-1];
            array[i] = diffArray[i] + array[i - 1];
        }

        System.out.println();
        Arrays.stream(array).forEach(System.out::print);
    }

}
