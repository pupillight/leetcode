package org.yj.leetcode;

import org.yj.leetcode.amazon.ListNode;

import java.util.*;

public class StackQuestions {
    private void addString2Stack(String text, LinkedList<Character> list) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '#') {
                if (list.size() > 0) {
                    list.removeFirst();
                }
            } else {
                list.addFirst(c);
            }
        }
    }

    private String formatStr(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();

    }

    public boolean backspaceCompare(String s, String t) {
        return formatStr(s).equals(formatStr(t));
        /*LinkedList<Character> list1 = new LinkedList<>();
        addString2Stack(s, list1);
        LinkedList<Character> list2 = new LinkedList<>();
        addString2Stack(t, list2);
        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
        }*/

        //return true;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(0);

        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.getFirst()]) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getFirst()]) {
                    ans[stack.getFirst()] = i - stack.getFirst();
                    stack.removeFirst();
                }
                stack.addFirst(i);
            }
        }
        return ans;
    }

    public int calPoints(String[] operations) {

        if (operations == null || operations.length == 0) {
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];

            if (operation.equals("+")) {
                int sum = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(sum);
            } else if (operation.equals("C")) {
                list.removeLast();
            } else if (operation.equals("D")) {
                list.addLast(list.getLast() * 2);
            } else {
                list.add(Integer.valueOf(operation));
            }
        }
        int res = list.stream().mapToInt(e -> e).sum();
        return res;
    }


    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        ans = Arrays.copyOf(prices, prices.length);
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(0);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[list.getFirst()]) {
                list.addFirst(i);
            } else {
                while (list.size() > 0 && prices[i] <= prices[list.getFirst()]) {
                    ans[list.getFirst()] = prices[list.getFirst()] - prices[i];
                    list.removeFirst();
                }
                list.addFirst(i);
            }
        }
        return ans;
    }

    public String makeGood(String s) {

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                if (list.size() > 0
                        && Character.isLowerCase(list.getLast())
                        && Character.toUpperCase(list.getLast()) == c) {
                    list.removeLast();
                } else {
                    list.add(c);
                }
            } else {
                if (list.size() > 0
                        && Character.toUpperCase(c) == list.getLast()) {
                    list.removeLast();
                } else {
                    list.add(c);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : list) {
            builder.append(character);
        }
        return builder.toString();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(0);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[list.getFirst()]) {
                list.addFirst(i);
            } else {
                while (list.size() > 0 && nums2[i] > nums2[list.getFirst()]) {
                    if (map.containsKey(nums2[list.getFirst()])) {
                        int index = map.get(nums2[list.getFirst()]);
                        ans[index] = nums2[i];

                    }
                    list.removeFirst();
                }
                list.addFirst(i);
            }
        }
        return ans;
    }

    public String removeDuplicates(String s) {

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (list.size() > 0 && list.getFirst() == c) {
                list.removeFirst();
            } else {
                list.addFirst(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        list.stream().forEach(e -> builder.append(e));
        return builder.reverse().toString();
    }


    public void dfs(ListNode node, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.next, list);
        list.add(node.val);
    }


    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();

        dfs(head, list);
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != list.removeFirst()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            StringBuilder builder = new StringBuilder();
            while (i < path.length() && path.charAt(i) != '/') {
                builder.append(path.charAt(i));
                i++;
            }
            if (builder.length() > 0) {

                String str = builder.toString();
                if (str.equals(".")) {
                    //if (list.size() > 0) list.removeFirst();
                } else if (str.equals("..")) {
                    if (list.size() > 0) list.removeFirst();
                    //if (list.size() > 0) list.removeFirst();
                } else {
                    list.addFirst(str);
                }
            }
            i++;
        }
        if (list.size() == 0) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        while (!list.isEmpty()) {
            ans.append("/");
            ans.append(list.removeLast());
        }

        return ans.toString();

    }

    public int lengthOfLIS(int[] nums) {

        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        stack.add(nums[0]);
        max = stack.size();
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.getFirst()) {
                stack.removeFirst();
            }
            stack.addFirst(nums[i]);
            max = stack.size();
        }
        return max;
    }

    public static void main(String[] args) {
        StackQuestions instance = new StackQuestions();

        //int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        //Arrays.stream(instance.dailyTemperatures(nums)).forEach(System.out::println);
        //String[] operations = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        //System.out.println(instance.calPoints(operations));

        //int[] prices = {8,4,6,2,3};
        //int[] prices = {10, 1, 1, 6};
        //Arrays.stream(instance.finalPrices(prices)).forEach(System.out::println);
        //System.out.println(instance.makeGood("Pp"));
        int[] nums1 = {2, 4};
        int[] nums2 = {10, 9, 2, 5, 3, 7, 101, 18};
        // Arrays.stream(instance.nextGreaterElement(nums1, nums2)).forEach(System.out::println);

        System.out.println(instance.lengthOfLIS(nums2));

        //instance.simplifyPath("/home/");
       // System.out.println(instance.simplifyPath("/a/../../b/../c//.//"));
    }
}
