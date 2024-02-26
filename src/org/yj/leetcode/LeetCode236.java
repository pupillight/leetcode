package org.yj.leetcode;


import java.util.*;
import java.util.stream.Collectors;

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

    private void dfs(TreeNode node) {
        if (node != null && node.left != null) {
            map.put(node.left.val, node);
            dfs(node.left);
        }
        if (node != null && node.right != null) {
            map.put(node.right.val, node);
            dfs(node.right);
        }
    }


    public int countNodes(TreeNode root) {
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


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        //findPaths(root, paths, new LinkedList<>());
        findPaths(root, paths, "");
        return paths;
    }

    private void findPaths(TreeNode node, List<String> paths, LinkedList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {

            StringBuilder builder = new StringBuilder();
            for (Integer v : path) {
                builder.append(v);
            }
            paths.add(builder.toString());
            return;
        }
        if (node.left != null) {

            findPaths(node.left, paths, path);
            path.removeLast();
        }
        if (node.right != null) {

            findPaths(node.right, paths, path);
            path.removeLast();
        }
    }

    private void findPaths(TreeNode node, List<String> paths, String path) {
        if (node == null) {
            return;
        }
        //path+=path;
        path += node.val;
        //path+="->";

        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        findPaths(node.left, paths, path + "->");
        findPaths(node.right, paths, path + "->");
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted((e1, e2) -> e1.getValue() - e2.getValue()).collect(Collectors.toList());
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int v = entry.getValue();
            while (index < k && v >= 1) {
                v -= 1;
                index++;
            }
            entry.setValue(v);
        }
        int res = (int) list.stream().filter(item -> item.getValue() != 0).count();
        return res;
    }


    int leftSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesDfs(root);
        return leftSum;
    }

    private void sumOfLeftLeavesDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            leftSum += node.left.val;
        }
        sumOfLeftLeavesDfs(node.left);
        sumOfLeftLeavesDfs(node.right);
    }

    int blValue = 0;
    int maxDepth = Integer.MIN_VALUE;

    public int findBottomLeftValue(TreeNode root) {

        findBottomLeftValueDfs(root, 0);
        return blValue;
    }

    private void findBottomLeftValueDfs(TreeNode node, int depth) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                blValue = node.val;
            }
        }
        if(node.left!=null)
        {
            depth++;
            findBottomLeftValueDfs(node.left, depth );
            depth--;
        }
        if(node.right!=null){
            depth++;
            findBottomLeftValueDfs(node.right, depth );
            depth--;
        }


    }
    private void findBottomLeftValueDfs1(TreeNode node, int depth) {

        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                blValue = node.val;
            }
        }
        findBottomLeftValueDfs(node.left, depth + 1);
        findBottomLeftValueDfs(node.right, depth + 1);

    }



        public static int sumArray(int[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 6 && (i + 1) < arr.length && arr[i + 1] == 7) {
                    i++; // Skip 6 and 7
                } else {
                    sum += arr[i];
                }
            }
            return sum;
        }


    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
        //r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);

        r1.right = new TreeNode(8);
        r1.right.left = new TreeNode(7);
        //r1.right.right = new TreeNode(9);

        LeetCode236 question = new LeetCode236();
        //System.out.println(question.lowestCommonAncestor(r1, new TreeNode(7), new TreeNode(8)).val);
        //int[] arr = {4, 3, 1, 1, 3, 3, 2};
        //int k = 3;
        //System.out.println(question.findLeastNumOfUniqueInts(arr, k));
        System.out.println(question.binaryTreePaths(r1));


        int[] arr = {1, 2, 3, 4,6,7,5};
        int result = sumArray(arr);
        System.out.println(result); // Output: 15
        //System.out.println(question.countNodes(r1));

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
