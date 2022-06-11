package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode215 {

    public int findKthSmallest(int[] num, int k) {
        if (num == null || num.length == 0 || k < 1) {
            return Integer.MIN_VALUE;
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> -(e1 - e2));
        for (int i = 0; i < k; i++) {
            queue.add(num[i]);
        }
        for (int i = k; i < num.length; i++) {
            int topValue = queue.peek();
            if (num[i] < topValue) {
                queue.poll();
                queue.add(num[i]);
            }
        }
        int res = queue.peek();
        return res;

    }


    public int findKthLargest(int[] num, int k) {
        if (num == null || num.length == 0 || k < 1) {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> (e1 - e2));
        for (int i = 0; i < k; i++) {
            queue.add(num[i]);
        }
        for (int i = k; i < num.length; i++) {
            int topValue = queue.peek();
            if (num[i] > topValue) {
                queue.poll();
                queue.add(num[i]);
            }
        }
        int res = queue.peek();
        return res;

    }


    public void fastSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        fastSort(array, 0, array.length - 1);
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    private void fastSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = left;
        while (i != j) {
            while (i != j && array[j] >= array[pivot]) {
                j--;
            }
            while (i != j && array[i] <= array[pivot]) {
                i++;
            }
            if (i != j) {
                swap(array, i, j);
            }
        }
        swap(array, pivot, i);
        fastSort(array, left, i);
        fastSort(array, i + 1, right);
    }


    public List<Integer> addToArrayForm(int[] nums, int k) {
        int value = 0;
        for (int num : nums) {
            value = value * 10 + num;
        }
        value = value + k;
        List<Integer> res = new ArrayList<>();
        while (value > 0) {
            res.add(value % 10);
            value = value / 10;
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        LeetCode215 leetCode = new LeetCode215();
        //int[] arr = {3,2,1,5,6,4};
        //int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] arr = {100, 90, 1, 4, 5, 6};
        //int res = leetCode.findKthLargest(arr, 0);
        //System.out.println(res);

        //System.out.println(leetCode.findKthSmallest(arr,3));

        //leetCode.fastSort(arr);

        // Arrays.stream(arr).forEach(System.out::println);


        int nums[] = {2, 1, 5};
        System.out.println(leetCode.addToArrayForm(nums, 1000));

    }
}
