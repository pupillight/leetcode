package org.yj.leetcode;


import java.util.*;

public class LeetCode235 {
    Map<Integer, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> set = new HashSet<>();

        dfs(root);
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }

        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }

        return null;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right);
        }
    }

    boolean isValid = true;
/*

    public boolean isValidBST1(TreeNode root) {
        isValidBST(root, new LinkedList<>());
        return isValid;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode pre) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left, pre);
        if (pre != null && pre.val > root.val) {
            return false;
        }
        boolean right = isValidBST(root.right, pre);
        pre = root;
        return left && right;
    }
*/

  /*  private void isValidBST(TreeNode node, LinkedList<Integer> list) {
        if (node == null) {
            return;
        }
        isValidBST(node.left, list);
        if (!list.isEmpty()) {
            int t = list.pollLast();
            if (node.val <= t) {
                isValid = false;
                return;
            }
        }
        list.push(node.val);
        isValidBST(node.right, list);
    }*/
}

