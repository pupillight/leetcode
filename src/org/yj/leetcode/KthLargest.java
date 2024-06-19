package org.yj.leetcode;

import java.util.*;

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

    public static List<Integer> reverseArray(List<Integer> a) {
        LinkedList<Integer> res = new LinkedList<>();
        a.stream().forEach(e -> res.addFirst(e));
        return res;
    }

    public static List<Integer> reverseArray1(List<Integer> a) {
        List reversed = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            reversed.add(a.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        System.out.println(KthLargest.reverseArray1(list));
        System.out.println(KthLargest.reverseArray(list));


      /*  int[] nums = {0};
        KthLargest instance = new KthLargest(2, nums);

        System.out.println(instance.add(-1));
        System.out.println(instance.add(1));
        System.out.println(instance.add(-2));
        System.out.println(instance.add(-4));
        System.out.println(instance.add(3));*/


    }
}
