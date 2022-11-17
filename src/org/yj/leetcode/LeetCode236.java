package org.yj.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode236 {


    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
/*
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (root.left != null) {
            parent.put(root.left.val, root);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
        }
    }*/
/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);
    while (p != null) {
        visited.add(p.val);
        p = parent.get(p.val);
    }
    while (q != null) {
        if (visited.contains(q.val)) {
            return q;
        }
        q = parent.get(q.val);
    }
    return null;
}*/


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        }else{
            return null;
        }
    }


    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
       /* r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);

        r1.right = new TreeNode(8);*/
        // r1.right.left = new TreeNode(7);
        // r1.right.right = new TreeNode(9);

        LeetCode236 question = new LeetCode236();
        System.out.println(question.lowestCommonAncestor(r1, new TreeNode(6), new TreeNode(2)).val);

    }
}

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/
