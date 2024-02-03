package org.yj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeQuestions {

    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    int maxDepth = -1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, 1);
        return maxDepth;
    }

    private void maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return;
        }
        maxDepth(node.left, depth + 1);
        maxDepth(node.right, depth + 1);
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if (root.left == null && root.right != null) {
            return right + 1;
        } else if (root.left != null && root.right == null) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 0);
        return min;
    }

    public void minDepth(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            height++;
            if (height < min) {
                min = height;
            }
            return;
        }
        minDepth(root.left, height + 1);
        minDepth(root.right, height + 1);

    }

    /*int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countNodes(root.left);
        countNodes(root.right);
        count++;
        return count;
    }*/

    /*public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l + r + 1;
    }*/
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        int l = 0;
        while (left != null) {
            left = left.left;
            l++;
        }
        TreeNode right = root.right;
        int r = 0;
        while (right != null) {
            right = right.right;
            r++;
        }
        if (l == r) {
            return 2 << l - 1;
        }
        l = countNodes(root.left);
        r = countNodes(root.right);
        return l + r + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int res = dfs(root);
        if (res > -1) {
            return true;
        }
        return false;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (l == -1 || r == -1) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft >= preRight || inLeft >= inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = findIndexInOrder(preorder[preLeft], inorder);
        root.left = buildTree(preorder, preLeft + 1, index + 1, inorder, inLeft, index);
        root.right = buildTree(preorder, index + 1, preRight, inorder, index + 1, inRight);
        return root;
    }

    private int findIndexInOrder(int val, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            if (val == inOrder[i]) {
                return i;
            }
        }
        return -1;
    }



    List<Integer> list = new ArrayList<>();
    private void treeDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        treeDfs(root.left);
        int curValue = root.val;
        list.add(curValue);
        treeDfs(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        treeDfs(root);
        return exisits(list, k);
    }

    private boolean exisits(List<Integer> list, int k) {
        int i = 0;
        int j = list.size() - 1;

        while (i != j) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            } else if (list.get(i) + list.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /*Set<Integer> set = new HashSet<>();

    private boolean treeDfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        boolean leftValue = treeDfs(node.left, k);
        boolean rightValue = treeDfs(node.right, k);

        int value = node.val;
        if (set.contains(k - value)) {
            return true;
        }
        set.add(value);
        return leftValue || rightValue;

    }*/

    public static void main(String[] args) {
        TreeQuestions instance = new TreeQuestions();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        // System.out.println(instance.minDepth(root));
        //int[] preorder = {3, 9, 20, 15, 7};
        //int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        TreeNode node = instance.buildTree(preorder, inorder);
        System.out.println(node);

        //System.out.println(instance.isBalanced(root));
    }
}
