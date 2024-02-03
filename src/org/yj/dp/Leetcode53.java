package org.yj.dp;

import org.yj.application.data.collections.Map;

import java.util.Arrays;

public class Leetcode53 {
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;


    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

/*            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }*/
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray3(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = 0;

            for (int j = i; j < len; j++) {
                sum += nums[j];
                res = Math.max(res, sum);
            }

        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = len - 1; j >= i; j--) {
                sum += nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public int[] mergeSortedArray(int[] nums, int lStart, int lEnd, int rStart, int rEnd) {
        int i = lStart;
        int j = rStart;
        int lLen = lEnd - lStart + 1;
        int rLen = rEnd - rStart + 1;
        int len = lLen + rLen;
        int[] c = new int[len];
        int m = 0;
        while (i <= lEnd && j <= rEnd) {
            if (nums[i] < nums[j]) {
                c[m] = nums[i];
                i++;
            } else {
                c[m] = nums[j];
                j++;
            }
            m++;
        }

        while (i <= lEnd) {
            c[m++] = nums[i++];
        }

        while (j <= rEnd) {
            c[m++] = nums[j++];
        }

        for (int k = 0; k < c.length; k++) {
            nums[lStart + k] = c[k];
        }
        return c;
    }


    public int[] mergeSortedArray(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] c = new int[a.length + b.length];
        int m = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[m] = a[i];
                i++;
            } else {
                c[m] = b[j];
                j++;
            }
            m++;
        }

        while (i < a.length) {
            c[m++] = a[i++];
        }

        while (j < b.length) {
            c[m++] = b[j++];
        }
        //Arrays.stream(c).forEach(System.out::println);
        return c;
    }

    public void mergeSort(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = (i + j) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, j);
        mergeSortedArray(nums, i, mid, mid + 1, j);

    }

    public void mergeSort(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void main(String[] args) {

        Leetcode53 instance = new Leetcode53();
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] nums = {-2};
        //int[] nums = {-2};
        //System.out.println(instance.maxSubArray(nums));
        //System.out.println(instance.maxSubArray3(nums))
        //instance.sort(nums);

        //instance.mergeSortedArray(new int[]{2, 6}, new int[]{1, 3});
        int[] nums = {-2, 9, -3, 4};
        instance.mergeSort(nums);

    }
}
