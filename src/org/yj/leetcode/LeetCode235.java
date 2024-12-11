package org.yj.leetcode;


import java.util.*;
import java.util.stream.Collectors;

public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return root;
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (p.val < root.val && q.val < root.val) {
            left = lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            right = lowestCommonAncestor(root.right, p, q);
        } else {
            left = lowestCommonAncestor(root.left, p, q);
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }

    }


    public String restoreString(String s, int[] indices) {

        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], s.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        map.entrySet().stream().sorted((e1, e2) -> {
            return e1.getKey() - e2.getKey();
        }).forEach(e -> builder.append(e.getValue()));
        return builder.toString();
    }

    public int minTimeToVisitAllPoints(int[][] points) {


        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - points[i - 1][0]);
            int y = Math.abs(points[i][1] - points[i - 1][1]);

            sum += Math.min(x, y) + Math.abs(x - y);
        }

        return sum;

    }


    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = !dp[i - j];
                    if (dp[i])
                        break;
                }
            }
        }
        return dp[n];
    }

    public boolean divisorGame1(int n) {
        boolean[] dp = new boolean[n + 2];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (!dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
        r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);

        r1.right = new TreeNode(8);
        r1.right.left = new TreeNode(7);
        r1.right.right = new TreeNode(9);

        LeetCode235 question = new LeetCode235();
        //  System.out.println(question.lowestCommonAncestor(r1, new TreeNode(7), new TreeNode(9)).val);

        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(question.restoreString("codeleet", indices));

    }
}

