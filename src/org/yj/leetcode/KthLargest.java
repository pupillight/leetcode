package org.yj.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> queue;
    int size = 0;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            } else {
                queue.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (queue.isEmpty()) {
            queue.add(val);
        } else if (queue.size() < size) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        } else {
            //do nothing
        }
        int ans = queue.peek();
        return ans;
    }


    public static void main(String[] args) {

      /*  int[] nums = {0};
        KthLargest instance = new KthLargest(2, nums);

        System.out.println(instance.add(-1));
        System.out.println(instance.add(1));
        System.out.println(instance.add(-2));
        System.out.println(instance.add(-4));
        System.out.println(instance.add(3));*/



    }
}
