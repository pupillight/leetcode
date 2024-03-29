package org.yj.leetcode;

import java.util.Arrays;

public class DiffArray {

    public int minSubArrayLen(int target, int[] nums) {

      /*  int l = 0;
        int r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (l <= r && r < nums.length) {
            sum = sum + nums[r++];
            while (sum >= target) {
                ans = Integer.min(ans, r - l );
                sum= sum-nums[l];
                l++;
            }

        }

        if(ans == Integer.MAX_VALUE)
        {
            return 0;
        }
        return ans;*/
     /*   int length = nums.length;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        Arrays.stream(sums).forEach(System.out::println);*/

/*        int len = nums.length;
        int[] subfix = new int[len];
        subfix[0] = nums[0];
        for (int i = 1; i < len; i++) {
            subfix[i] = subfix[i - 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int value = subfix[i] + target;
            int firstIndex = bSearch(subfix, value);
            if (firstIndex > -1) {
                ans = Integer.min(ans, firstIndex - i);
            }
        }

        if (ans == Integer.MAX_VALUE) return 0;
        return ans;*/


        int len = nums.length;
        int[] subfix = new int[len + 1];
        //subfix[0] = nums[0];
        for (int i = 1; i < subfix.length; i++) {
            subfix[i] = subfix[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < subfix.length; i++) {
            int value = subfix[i] + target;
            int firstIndex = bSearch(subfix, value);
            if (firstIndex > -1) {
                ans = Integer.min(ans, firstIndex - i);
            }
        }

        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

    public int bSearch(int[] nums, int target) {

        if (target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int minStartValue(int[] nums) {
        int ans = 1;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        int min = preSum[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
            if (preSum[i] < min) {
                min = preSum[i];
            }
        }

        if (min <= 0) {
            ans = 1 - min;
        }
        return ans;

    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];

        for (int i = 0; i < trips.length; i++) {
            int value = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            arr[from] += value;
            if (to + 1 < arr.length) {
                arr[to + 1] -= value;
            }
        }

        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            res = Math.max(res, arr[i]);
        }

        if (res <= capacity) {
            return true;
        }
        return false;

    }

    public int[] calculate(int len, int[][] updates) {

        int[] nums = new int[len];
        int[] diff = new int[len];

        diff[0] = nums[0];
        for (int i = 1; i < len; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            diff[start] += inc;
            if (end + 1 < len) {
                diff[end + 1] -= inc;
            }
        }

        int[] res= new int[len];
        res[0] = diff[0];
        for (int i = 1; i <len ; i++) {
            res[i] = res[i-1]+diff[i];
        }
        return res;
    }


    public static void main(String[] args) {
/*
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
        Arrays.stream(array).forEach(System.out::print);*/

        DiffArray instance = new DiffArray();

        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int res[] = instance.calculate(5,updates);
        Arrays.stream(res).forEach(System.out::println);

     /*   int[][] trips = {{9, 0, 1}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(instance.carPooling(trips, capacity));*/
        //int[] nums = {2, 3, 1, 2, 4, 3};
        //int[] nums = {1, 2, 3, 4, 5};
        //int[] nums = {1, 4, 7, 9};

        //System.out.println(instance.bSearch(nums, 11));
        //System.out.println(instance.minSubArrayLen(15, nums));
    }

}
