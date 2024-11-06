package org.yj.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1749 {


    public int maxAbsoluteSum(int[] nums) {

        int[] pDp = new int[nums.length];
        int[] nDp = new int[nums.length];
        pDp[0] = nums[0];
        nDp[0] = nums[0];
        int pMax = nums[0];
        int nMax = nums[0];
        int ans = 0;
        ans = Math.max(pMax, Math.abs(nMax));
        for (int i = 1; i < nums.length; i++) {

            if (pDp[i - 1] <= 0) {
                pDp[i] = nums[i];
            } else {
                pDp[i] = pDp[i - 1] + nums[i];
            }

            if (nDp[i - 1] <= 0) {
                nDp[i] = nDp[i - 1] + nums[i];
            } else {
                nDp[i] = nums[i];
            }

            pMax = Math.max(pMax, pDp[i]);
            nMax = Math.min(nMax, nDp[i]);

        }
        ans  = Math.max(pMax,Math.abs(nMax));
        return ans;

    }

    public static void main(String[] args) {

        Leetcode1749 instance = new Leetcode1749();
       int[]  nums = {2,-5,1,-4,3,-2};
        System.out.println(instance.maxAbsoluteSum(nums));

    }
}
