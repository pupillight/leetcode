package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        if (nums.length == 1) return nums[0];
        int preSum = 0;
        int minPreSum = 0;

        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            preSum += num;
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }

        return ans;

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

    public int maximumCostSubstring1(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            int v = map.getOrDefault(c, c - 'a' + 1);
            if (dp[i - 1] <= 0) {
                dp[i] = v;
            } else {
                dp[i] = dp[i - 1] + v;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            int val = vals[i];
            char c = chars.charAt(i);
            arr[c - 'a'] = val;
        }
        int[] dp = new int[s.length() + 1];
        int ans = 0;
        dp[0] = 0;

        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (dp[i - 1] <= 0) {
                dp[i] = arr[c - 'a'];
            } else {
                dp[i] = dp[i - 1] + arr[c - 'a'];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        /*Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        //char[] arr =s.toCharArray();
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int ans = 0;
        ans = Math.max(ans, dp[0]);
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i - 1] + arr[i];
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;*/
    }

    public int maxSubarraySum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);

           /* if(dp[i-1]>0){
                dp[i]= dp[i-1]+nums[i];
            }else {
                dp[i]= nums[i];
            }
            max = Math.max(max,dp[i]);*/
        }
        return dp[nums.length-1];
    }

    public int maxSubarraySumCircular(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int min = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            min = Math.min(min, dp[i]);
        }
        int res = Arrays.stream(nums).sum() - min;
        return res;
    }

    public static void main(String[] args) {

        Leetcode53 instance = new Leetcode53();

        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        //System.out.println(instance.maxSubarraySum(nums));


        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] nums = {-2};
        //int[] nums = {-2, -1};
        //System.out.println(instance.maxSubArray(nums));
        //System.out.println(instance.maxSubArray3(nums));
        //instance.sort(nums);

        //instance.mergeSortedArray(new int[]{2, 6}, new int[]{1, 3});
        // int[] nums = {-2, 9, -3, 4};
        // instance.mergeSort(nums);

/*        String s = "okyytyj";
        String chars = "uafndmokwztrjphgle";
        int[] vals = {189, -229, 860, 782, -194, -582, -743, 966, 777, 90, 526, -806, -992, 845, -997, 340, 80, 705};
        System.out.println(instance.maximumCostSubstring(s, chars, vals));*/


        int[] nums = {1, -2, -3, -2};
        System.out.println(instance.maxSubarraySumCircular(nums));

    }
}
