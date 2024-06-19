package org.yj.leetcode;

import java.util.*;

public class LeetCode1013 {


    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int i = 0, cur = 0;
        while (i < arr.length) {
            cur += arr[i];
            if (cur == target) {
                break;
            }
            i++;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        while (j < arr.length - 1) {
            cur += arr[j];
            if (cur == (target * 2)) {
                return true;
            }
            j++;
        }
        return false;

    }


    public static void main(String[] args) {
        LeetCode1013 instance = new LeetCode1013();
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(instance.canThreePartsEqualSum(arr));

    }
}
