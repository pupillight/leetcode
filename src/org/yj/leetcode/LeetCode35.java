package org.yj.leetcode;

import java.util.*;

public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Comparator<int[]> comparator = (arr1, arr2) -> arr1[0] * arr1[1] - arr2[0] * arr2[1];
        PriorityQueue<int[]> queue = new PriorityQueue(comparator);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //int n=   nums1[i] * nums2[j];
                //List<Integer> list = new ArrayList<>();
                //list.add(nums1[i]);
                //list.add(nums2[j]);
                int[] temp = {nums1[i], nums2[j]};
                queue.add(temp);
                //res.add(list);
               /* if (queue.size() == k) {

                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        res.add(Arrays.asList(arr[0], arr[1]));
                    }
                    return res;
                }*/
            }
        }
        while(!queue.isEmpty()&& k>0){
            int[] arr =queue.poll();
            res.add(Arrays.asList(arr[0],arr[1]));
            k--;
        }

        return res;
    }


    public static void main(String[] args) {
        LeetCode35 leetCode = new LeetCode35();
//        int[] array = {2, 3, 5};
//        leetCode.combinationSum(array, 8);


        //System.out.println(leetCode.calculatePow(10,3));
        // leetCode.printNumbers(3);
        //int[] nums = {1, 2, 3, 4, 5};
       // int[] nums = {3, 2, 3, 4, 2};
        // Arrays.stream(leetCode.distinctDifferenceArray(nums)).forEach(System.out::println);
       int[] nums1 = {1,1,2};
       int[] nums2 = {1,2,3};
       int k = 2;
        System.out.println(leetCode.kSmallestPairs(nums1, nums2, k));

    }
}
