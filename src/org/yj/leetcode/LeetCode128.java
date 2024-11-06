package org.yj.leetcode;

import org.yj.application.data.structure.linked.LinkNode;

import java.util.*;

public class LeetCode128 {

    public void moveZeroes1(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                arr[j] = nums[i];
                j++;
            } else {
                continue;
            }
        }

        for (int i = 0; i < len; i++) {
            nums[i] = arr[i];
        }

    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;


        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i <len; i++) {
            nums[i]=0;
        }

        Arrays.stream(nums).forEach(System.out::println);
    }


    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            count = 1;
            while (set.contains(currNum - 1)) {
                currNum = currNum - 1;
                count++;
            }
            res = Math.max(res, count);

        }
        return res;

    }

    public static void main(String[] args) {
        LeetCode128 leetCode = new LeetCode128();

      /* int[] nums = {100,4,200,1,3,2};
        System.out.println(leetCode.longestConsecutive(nums));*/
        int[] nums = {0, 1, 0, 3, 12};
        leetCode.moveZeroes(nums);

    }
}
