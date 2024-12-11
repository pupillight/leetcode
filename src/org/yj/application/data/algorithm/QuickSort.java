package org.yj.application.data.algorithm;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = nums[i];
        int l = i + 1;
        int r = j;
        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            while (l < r && nums[l] < pivot) {
                l++;
            }

            if (l < r) {
                //swap();
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        nums[i] = nums[l];
        nums[l] = pivot;
        sort(nums, i, l - 1);
        sort(nums, l + 1, j);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 9, -1};
        QuickSort sorter = new QuickSort();
        sorter.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
