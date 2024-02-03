package org.yj.leetcode.monostack;

import org.yj.leetcode.TreeNode;
import org.yj.leetcode.amazon.ListNode;

import java.util.*;

public class MonotonicStack {

    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return null;
        }
        //int[] res = new int[prices.length];
        int[] res = Arrays.copyOf(prices, prices.length);
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            int top = prices[stack.peek()];
            int cur = prices[i];
            if (cur > top) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && cur <= prices[stack.peek()]) {
                    res[stack.peek()] = prices[stack.peek()] - prices[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2 == null || nums2.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    int v = stack.pop();
                    if (map.containsKey(v)) {
                        res[map.get(v)] = nums2[i];
                    }
                }
                stack.push(nums2[i]);
            }
        }
        return res;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inOrder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inOrder);
        TreeNode root = createBst(preorder, inOrder);
        return root;

    }

    private int findIndexInOrder(int value, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            if (value == inOrder[i]) return i;
        }
        return -1;
    }

    private TreeNode createBst(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0 || inOrder == null || inOrder.length == 0) {
            return null;
        }

        int rootValue = preOrder[0];
        int index = findIndexInOrder(rootValue, inOrder);
        TreeNode root = new TreeNode(rootValue);
        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
        root.left = createBst(leftPreOrder, leftInOrder);
        int[] rightPreOrder = Arrays.copyOfRange(preOrder, index + 1, preOrder.length);
        int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
        root.right = createBst(rightPreOrder, rightInOrder);
        return root;

    }


    private int findMax(int[] nums) {
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        int index = findMax(nums);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        return root;

    }


    public ListNode removeNodes(ListNode head) {

        ListNode currNode = head;
        LinkedList<Integer> stack = new LinkedList();
        stack.push(currNode.val);
        currNode = currNode.next;
        // ListNode dummyHead = new ListNode(-1);
        while (currNode != null) {
            if (currNode.val <= stack.peek()) {
                stack.push(currNode.val);
            } else {
                while (!stack.isEmpty() && currNode.val > stack.peek()) {
                    stack.pop();
                }
                stack.push(currNode.val);
                // dummyHead.next = new ListNode(currNode.val);
            }

            currNode = currNode.next;
        }

        ListNode res = new ListNode(-1);
        ListNode dummyHead = res;
        while (!stack.isEmpty()) {
            dummyHead.next = new ListNode(stack.removeLast());
            dummyHead = dummyHead.next;
        }
        return res.next;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length * 2];
        Arrays.fill(res, -1);

        LinkedList<Integer> stack = new LinkedList();
        stack.push(0);
        for (int i = 1; i < nums.length * 2; i++) {
            int j = i % nums.length;
            if (nums[j] <= nums[stack.peek()]) {
                stack.push(j);
            } else {
                while (!stack.isEmpty() && nums[j] > nums[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = nums[j];
                }
                stack.push(j);
            }
        }
       return Arrays.copyOfRange(res, 0,nums.length);
    }


    public static void main(String[] args) {
        MonotonicStack instance = new MonotonicStack();
        int[] nums = {1,2,1};
        int[] res =instance.nextGreaterElements(nums);
        Arrays.stream(res).forEach(System.out::println);

        //System.out.println(instance.finalPrices(new int[]{10, 1, 1, 6}));

     /*   int[] num1 = {1, 3, 5, 2, 4};
        int[] num2 = {6, 5, 4, 3, 2, 1, 7};
        int[] res = instance.nextGreaterElement(num1, num2);
        Arrays.stream(res).forEach(System.out::println);*/
/*        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode node = instance.bstFromPreorder(preorder);
        System.out.println(node);*/

       /* int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode node = instance.constructMaximumBinaryTree(nums);
        System.out.println(node);*/

/*        ListNode root = new ListNode(5);
        root.next= new ListNode(2);
        root.next.next= new ListNode(13);
        root.next.next.next= new ListNode(3);
        root.next.next.next.next= new ListNode(8);
        instance.removeNodes(root);*/

   /*     ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(1);

        instance.removeNodes(root);*/
    }
}
