package org.yj.application.data.algorithm;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        mergeArray(nums, l, mid, r);

    }

    private void mergeArray(int[] nums, int l, int mid, int r) {

        int len = r - l + 1;
        int i = l;
        int j = mid + 1;

        int[] arr = new int[len];
        int t = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                arr[t++] = nums[i++];
            } else {
                arr[t++] = nums[j++];
            }
        }
        if (i <= mid) {
            arr[t++] = nums[i++];
        }
        if (j <= r) {
            arr[t++] = nums[j++];
        }

        for (int k = 0; k < len; k++) {
            nums[l + k] = arr[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 9, -1};
        MergeSort sorter = new MergeSort();
        sorter.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
