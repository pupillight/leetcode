package org.yj.leetcode;

import java.util.*;

public class LeetCode739 {


    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

   /* public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peekFirst()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                    int index = stack.pollFirst();
                    ans[index] = i - index;
                }
                stack.addFirst(i);
            }
        }
        return ans;
    }*/


    public static void main(String[] args) {
        LeetCode739 instance = new LeetCode739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(instance.dailyTemperatures(temperatures)).forEach(System.out::println);
    }
}
