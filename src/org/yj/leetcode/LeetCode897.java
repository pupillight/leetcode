package org.yj.leetcode;

import org.yj.leetcode.amazon.ListNode;

import java.util.*;

public class LeetCode897 {


    private void increasingBSTDfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        increasingBSTDfs(node.left, list);
        list.add(node.val);
        increasingBSTDfs(node.right, list);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        increasingBSTDfs(root, list);
        TreeNode newRoot = new TreeNode(-1);
        TreeNode curNode = newRoot;

        for (Integer integer : list) {
            curNode.right = new TreeNode(integer);
            curNode = curNode.right;
        }
        return newRoot.right;
    }

    public int findCountYear(String input) {
        Set<String> set = new HashSet<>();
        int ans = 0;
        String text = input.trim();
        char[] chars = text.toCharArray();
        int i = 0;
        int length = chars.length;
        while (i < length) {
            if (chars[i] == '-') {
                StringBuilder builder = new StringBuilder();
                i = i + 4;
                for (int j = 0; j < 4; j++) {
                    builder.append(chars[i]);
                    i++;
                }
                set.add(builder.toString());
            }
            i++;
        }
        ans = set.size();
        return ans;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);
        if (list1 == null || list2 == null) {
            return false;
        } else if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> set) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            set.add(node.val);
        }
        dfs(node.left, set);
        dfs(node.right, set);
    }

   /* int index = 0;
    boolean isLeafSimilar = true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> set = new ArrayList<>();
        dfs(root1, set);
        isContain(root2, set);
        return isLeafSimilar && set.isEmpty();
    }

    private void dfs(TreeNode node, List<Integer> set) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            set.add(node.val);
        }
        dfs(node.left, set);
        dfs(node.right, set);
    }

    private void isContain(TreeNode node, List<Integer> set) {
        if (node == null || set.isEmpty() || isLeafSimilar == false) {
            return;
        }
        if (!set.isEmpty() && node.left == null && node.right == null) {
            if (node.val != set.get(index)) {
                isLeafSimilar = false;
            }else{
                set.remove(index);
            }
            index++;
            return;
        }
        isContain(node.left, set);
        isContain(node.right, set);
    }
*/

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }

    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return true;

            } else if (root.val == 0) {
                return false;
            }
        }
        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);
        if (root.val == 2) {
            return l || r;

        } else if (root.val == 3) {
            return l && r;
        }
        return false;
    }


/*    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);
        if (root.val == 0) {
            return false;
        } else if (root.val == 1) {
            return true;
        } else if (root.val == 2) {
            return l || r;
        } else if (root.val == 3) {
            return l && r;
        }
        return false;
    }*/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans.addFirst(list);
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans.offerLast(list);
            }
        }
        return ans;
    }


    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (slow != null && fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
        }

        ListNode secondHead = slow.next;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(secondHead);
        return root;

    }


    public void flattenDfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        flattenDfs(node.left, list);
        flattenDfs(node.right, list);

    }

    public void flatten(TreeNode root) {

        TreeNode newRoot = new TreeNode(-1);
        List<Integer> list = new ArrayList<>();
        flattenDfs(root, list);

        TreeNode currNode = newRoot;
        for (Integer integer : list) {
            currNode.right = new TreeNode(integer);
            currNode = currNode.right;
        }
        System.out.println(newRoot);
        root = newRoot.right;
    }


    public static void main(String[] args) {
        LeetCode897 leetCode = new LeetCode897();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        //root.left.left = new TreeNode(0);
        //root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(1);

        leetCode.flatten(root);


        // System.out.println(leetCode.increasingBST(root).val);
        //System.out.println(leetCode.isBalanced(root));
        // System.out.println(leetCode.findSecondMinimumValue(root));

        //System.out.println(leetCode.findCountYear("hello abc 04-04-2023, . my son birthday is 05-18-2011."));

//        TreeNode root1 = new TreeNode(2);
//        root1.left = new TreeNode(1);
        //root.left.left = new TreeNode(0);
        //root.left.right = new TreeNode(1);
        //root1.right = new TreeNode(1);
        //System.out.println(leetCode.leafSimilar(root, root1));

        /*int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = leetCode.sortedArrayToBST(nums);
        System.out.println(node);*/

  /*      ListNode listNode = new ListNode(-10);
        listNode.next = new ListNode(-3);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(9);
        TreeNode node =leetCode.sortedListToBST(listNode);
        System.out.println(node);*/
    }


}
