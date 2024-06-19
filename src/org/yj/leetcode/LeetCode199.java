package org.yj.leetcode;

import java.util.*;

public class LeetCode199 {

    public String largestNumber(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        StringBuilder builder = new StringBuilder();
        Collections.sort(list, (e1, e2) -> {
            return String.valueOf(e2 + "" + e1).compareTo(String.valueOf(e1 + "" + e2));
        });
        if (list.get(0) == 0) {
            return "";
        }
        list.forEach(e -> builder.append(e));

        return builder.toString();
    }


    public int reverseBits(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            ans = ans | (t << (31 - i));

        }
        return ans;
    }

    public int reverseBits1(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans << 1;
            int t = (n >> i) & 1;
            if (t == 1) {
                ans += t;
            }
        }
        return ans;
    }


    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.right != null) {
            dfs(node.right, list);
        } else {
            dfs(node.left, list);
        }


    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;

    }

    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return res;

    }


    public static void main(String[] args) {
        LeetCode199 instance = new LeetCode199();


    }
}
