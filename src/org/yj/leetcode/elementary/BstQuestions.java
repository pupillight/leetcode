package org.yj.leetcode.elementary;

import java.util.*;

public class BstQuestions {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isNodeSymmetric(root.left, root.right);
    }


    public boolean isNodeSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        } else {
            if (leftNode.val == rightNode.val) {
                return isNodeSymmetric(leftNode.left, rightNode.right) && isNodeSymmetric(leftNode.right, rightNode.left);
            }
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val >= root.val) || (root.right != null && root.right.val <= root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    boolean isValid = true;

    public boolean isValidBST1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        dsf(root, list);
        return isValid;
    }

    private void dsf(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        dsf(root.left, list);
        if (!list.isEmpty() && list.peekLast() >= root.val) {
            isValid = false;
            return;
        }
        list.add(root.val);
        dsf(root.right, list);
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }


    public int maxDepth1(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int i) {
        if (root == null) {
            return i;
        }
        if (root.left == null && root.right == null) {
            return i + 1;
        }
        int left = maxDepth(root.left, i + 1);
        int right = maxDepth(root.right, i + 1);
        return Math.max(left, right);
    }


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        int ans = Integer.MIN_VALUE;
        if (!list.isEmpty() && k > 0) {
            ans = list.get(k - 1);
        }
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int j = 1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = null;
                node = deque.poll();
                if (j % 2 != 0) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            j++;
            res.add(list);
        }
        return res;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder == null || preorder.length == 0) && (inorder == null || inorder.length == 0)) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = rootIndex(preorder[0], inorder);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        root.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    private int rootIndex(int value, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            if (value == inOrder[i]) {
                return i;
            }
        }
        return -1;
    }


    /* public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         TreeNode root =null;
         return mergeTrees(root1, root2, root);
     }

     public TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode root) {
         if (root1 == null && root2 == null) {
             return null;
         } else if (root1 == null || root2 == null) {
             return root1 == null ? root2 : root1;
         }
         root = new TreeNode();
         int v1 = root1 == null ? 0 : root1.val;
         int v2 = root2 == null ? 0 : root2.val;
         root.val = v1 + v2;
         root.left = mergeTrees(root1.left, root2.left, root.left);
         root.right = mergeTrees(root1.right, root2.right, root.right);
         return root;
     }*/
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode root = null;
        root = mergeTreesDFS(root1, root2);
        return root;
    }

    public TreeNode mergeTreesDFS(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;

        }
        TreeNode root = new TreeNode();
        root.left = mergeTreesDFS(root1.left, root2.left);
        root.right = mergeTreesDFS(root1.right, root2.right);
        int v1 = root1 == null ? 0 : root1.val;
        int v2 = root2 == null ? 0 : root2.val;
        root.val = v1 + v2;
        return root;
    }

    public void dfs(TreeNode node) {

        if (node == null) {
            return;
        }
        System.out.println(node.val);
        dfs(node.left);
        dfs(node.right);

    }


   /* public TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode root) {

        if (root1 == null && root2 == null) {
            return null;
        } else {
            root= new TreeNode();
            int v1 = root1 == null ? 0 : root1.val;
            int v2 = root2 == null ? 0 : root2.val;
            root.val = v1 + v2;
        }
        root.left = mergeTrees(root1.left, root2.left, root.left);
        root.right = mergeTrees(root1.right, root2.right, root.right);

        return root;
    }*/


    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(left, mid);
        root.right = sortedListToBST(mid.next, right);
        return root;
    }


    public ListNode getMidNode(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = left + (right - left) / 2;
        root.val = nums[mid];
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
  /*
    List<String> res = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuffer pathSB = new StringBuffer(path);
        pathSB.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(pathSB.toString());  // 把路径加入到答案中
        } else {
            pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
            constructPaths(root.left, pathSB.toString(), paths);
            constructPaths(root.right, pathSB.toString(), paths);
        }
    }*/

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        String builder = "";
        backTrack(root, builder);
        System.out.println("builder=" + builder);
        return res;
    }

    private void backTrack(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(path);
        builder.append(root.val);
        // path = path + root.val;
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
            return;
        }
        //path = path + "->";
        builder.append("->");

        backTrack(root.left, builder.toString());
        backTrack(root.right, builder.toString());
    }
/*    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String builder = "";
        backTrack(root, builder);
        System.out.println("builder="+builder);
        return res;
    }

    private void backTrack(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        path = path + "->";
        backTrack(root.left, path);
        backTrack(root.right, path);
    }*/


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<Integer> pathP = new ArrayList<>();
        List<Integer> pathQ = new ArrayList<>();
        commonAncestor(root, p, q);
        return null;

    }


    private void commonAncestor(TreeNode node, TreeNode p, TreeNode q) {

        if (node.left.val == p.val || node.right.val == p.val) {
            return;
        }
        commonAncestor(node.left, p, q);
        commonAncestor(node.right, p, q);

    }


    public boolean isBalanced(TreeNode root) {
        if (calculateHeight(root) == -1) return false;
        return true;
    }

    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left) + 1;
        int rightHeight = calculateHeight(node.right) + 1;
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight);
    }

   /* public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int height = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    ans = Math.min(ans, height);
                    return ans;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println(height);
        return ans;
    }*/

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = treeMinHeight(root);
        return ans;
    }

    private int treeMinHeight(TreeNode node) {
        int minHeight = Integer.MAX_VALUE;
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null) {
            minHeight = Math.min(minHeight, treeMinHeight(node.left));
        }
        if (node.right != null) {
            minHeight = Math.min(minHeight, treeMinHeight(node.right));
        }
        return minHeight + 1;
    }


    public static void main(String[] args) {
        BstQuestions questions = new BstQuestions();
        //TreeNode root = null;

/*        TreeNode leftnode2 = new TreeNode(2);
        TreeNode rightnode2 = new TreeNode(2);


        leftnode2.right = new TreeNode(3);
        rightnode2.right = new TreeNode(3);
        TreeNode root = new TreeNode(1, leftnode2, rightnode2);
        //TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));

        //System.out.println(questions.maxDepth(root));
        //System.out.println(questions.isValidBST(root));
        System.out.println(questions.isSymmetric(root));*/
//        int[] preOrder = {3, 9, 20, 15, 7};
//        int[] inOrder = {9, 3, 15, 20, 7};
//
//        TreeNode node = questions.buildTree(preOrder, inOrder);
//
//        System.out.println();

//
//        TreeNode r1 = new TreeNode(1);
//        r1.left = new TreeNode(3);
//        r1.left.left = new TreeNode(5);
//        r1.right = new TreeNode(2);
//
//
//        TreeNode r2 = new TreeNode(2);
//        r2.left = new TreeNode(1);
//        r2.left.right = new TreeNode(4);
//        r2.right = new TreeNode(3);
//        r2.right.right = new TreeNode(7);
/*
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.left.left = new TreeNode(3);
        //r1.right = new TreeNode(2);


        TreeNode r2 = new TreeNode(1);
        r2.right = new TreeNode(2);
        r2.right.right = new TreeNode(3);*/
/*        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        //r1.right = new TreeNode(2);


        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(3);*/
        // TreeNode node = questions.mergeTrees(r1, r2);
        //questions.dfs(node);


//        int[] array = {1, 2, 3, 4, 5};
//        TreeNode node = questions.sortedArrayToBST(array);
//        System.out.println();
//        ListNode head = new ListNode(10);
//        head.next = new ListNode(-3);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(9);
//
//        TreeNode root=questions.sortedListToBST(head);
//        System.out.println();
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.left.left = new TreeNode(4);
        r1.left.right = new TreeNode(5);
        r1.right = new TreeNode(3);
        // r1.right.right = new TreeNode(4);
        // r1.right.right.right = new TreeNode(4);
        // r1.right = new TreeNode(3);
        //r1.right = new TreeNode(2);
        //questions.binaryTreePaths(r1).stream().forEach(System.out::println);
        //System.out.println();


        // questions.lowestCommonAncestor(r1, new TreeNode(4), new TreeNode(3));
        //System.out.println(questions.isBalanced(r1));
        System.out.println(questions.minDepth(r1));

    }
}


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
}
