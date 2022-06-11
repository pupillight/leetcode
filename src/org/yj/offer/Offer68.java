package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.*;

public class Offer68 {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs1(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.value, node);
            dfs(node.left);

        }
        if (node.right != null) {
            parent.put(node.right.value, node);
            dfs(node.right);
        }
    }

    public void dfs(TreeNode node) {
        if (node.left != null) {
            parent.put(node.left.value, node);
            dfs(node.left);

        }
        if (node.right != null) {
            parent.put(node.right.value, node);
            dfs(node.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root);
        while (p != null) {
            visited.add(p.value);
            p = parent.get(p.value);
        }

        while (q != null) {
            if (visited.contains(q.value)) {
                return q;
            }

            q = parent.get(q.value);
        }

        return null;
    }

    public static void main(String[] args) {

        Offer68 offer = new Offer68();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);


        //System.out.println(offer.findNode(root, 4));

        System.out.println(offer.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)));

    }
}
