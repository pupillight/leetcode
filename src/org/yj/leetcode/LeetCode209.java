package org.yj.leetcode;

import java.util.Arrays;

public class LeetCode209 {

    public int findMiddleIndex(int[] nums) {
        int ans = -1;
        if (nums.length == 1) {
            return 0;
        }
        int[] preSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
        //middleIndex nums[0]- nums[middleIndex-1] = nums[middleIndex+1] - nums[len-1]
        //           preSum[middleIndex] - preSum[0] = preSum[len-1]- preSum[middleIndex+1]
        //        preSum[middleIndex]   +preSum[middleIndex+1] =preSum[len-1]
        //preSum[middleIndex]   +preSum[middleIndex+1] =sum(nums)
        int len = preSums.length;
        for (int i = 0; i < len; i++) {
          /*  if (i+1< len && preSums[i] - preSums[0] == preSums[len-1] - preSums[i + 1]) {
                return i;
            }*/
            if (i + 1 < len && (preSums[i] + preSums[i + 1]) == preSums[len - 1]) {
                return i;
            }
        }
        return ans;
    }

    public int findMiddleIndex1(int[] nums) {
        int ans = -1;
        if (nums.length == 1) {
            return 0;
        }
        int leftSum = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (leftSum + nums[i] == sum) {
                return i;
            }
            leftSum = leftSum + nums[i];
            sum = sum - nums[i];
        }
        return ans;
    }


    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int minSubArrayLen2(int target, int[] nums) {

        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    len = Math.min(len, j - i + 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;


    }

    public int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while (l < nums.length && r < nums.length) {
            sum = sum + nums[r];
            //缩小窗口
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    public int sumOddLengthSubarrays(int[] arr) {

        int len = arr.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }

        int sum = 0;
        for (int odd = 1; odd < preSum.length; odd = odd + 2) {
            for (int i = odd; i < preSum.length; i++) {
                sum = sum + preSum[i] - preSum[i - odd];
            }
        }
        return sum;
    }

    public int largestAltitude(int[] gain) {

        int[] preSum = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            preSum[i + 1] = preSum[i] + gain[i];
        }

        int max = preSum[0];
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i] > max) {
                max = preSum[i];

            }
        }
        return max;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {

        int index = left;
        while (left <= right) {
            for (int i = 0; i < ranges.length; i++) {
                if (left >= ranges[i][0] && left <= ranges[i][1]) {
                    left++;
                    break;
                }
            }
            if (index != left) {
                index = left;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LeetCode209 questions = new LeetCode209();
        /*int[] array = {1, 2, 3};
        System.out.println(questions.minSubArrayLen(3, array));
        System.out.println(questions.minSubArrayLen1(2, array));*/


        //int[] array = {1, 2, 3, 4, 5};
        int[] array = {1, 4, 2, 5, 3};


        //System.out.println(questions.findMiddleIndex1(array));
        //System.out.println(questions.findMiddleIndex(array));

        //System.out.println(questions.sumOddLengthSubarrays(array));

        int[][] arr = {{1, 10}, {10, 20}};
        System.out.println(questions.isCovered(arr, 21, 21));
    }


}
