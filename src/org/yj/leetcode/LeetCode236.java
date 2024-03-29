package org.yj.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode236 {


/*    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
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
    }*/
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


   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        } else {
            return null;
        }
    }*/


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
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
        } else {
            return null;
        }

    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root);
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            } else {
                q = map.get(q.val);
            }
        }

        return null;
    }

    private void dfs1(TreeNode node) {
        if (node != null && node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left);
        }
        if (node != null && node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right);
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        if (node.left != null) map.put(node.left.val, node);
        if (node.right != null) map.put(node.right.val, node);
    }


   /* public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        int lDepth = 0;
        while (left != null) {
            lDepth++;
            left = left.left;
        }

        TreeNode right = root.right;
        int rDepth = 0;
        while (right != null) {
            rDepth++;
            right = right.right;
        }

        if (lDepth == rDepth) {
            return (2 << lDepth) - 1;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        int res = l + r + 1;
        return res;
    }
*/

    int count = 0;

    public int removePalindromeSub(String s) {
        int res = removePalindromeSub(s, 0, s.length() - 1);
        return res;
    }

    private boolean isPalind(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public int removePalindromeSub(String s, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (isPalind(s, l, r)) {
            count++;
            return 1;
        }

        int left = 0;
        int right = 0;
        left = removePalindromeSub(s, l + 1, r);
        right = removePalindromeSub(s, l, r - 1);
        return Math.max(left, right);

/*        boolean res = isPalind(s, l + 1, r) || isPalind(s, l, r - 1);

        if (res) {
            count = count + 2;
            return 2;
        } else {
            int left = 0;
            int right = 0;
            left += removePalindromeSub(s, l + 1, r);
            right += removePalindromeSub(s, l, r - 1);
            return Math.max(left, right)+1;
        }*/


    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return Math.max(left, right) + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    ////

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
        r1.left.left = new TreeNode(0);
        r1.left.left.left = new TreeNode(4);
        //r1.left.right = new TreeNode(4);

        //r1.right = new TreeNode(8);
        //r1.right.left = new TreeNode(7);
        //r1.right.right = new TreeNode(9);

        LeetCode236 question = new LeetCode236();
        System.out.println(question.minDepth(r1));
        //System.out.println(question.lowestCommonAncestor(r1, new TreeNode(7), new TreeNode(8)).val);

        // System.out.println(question.countNodes(r1));


        //System.out.println(question.removePalindromeSub("ababb"));

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
