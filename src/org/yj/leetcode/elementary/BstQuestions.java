package org.yj.leetcode.elementary;

import org.yj.application.data.structure.stack.Node;
import org.yj.leetcode.TreeNode;

import java.beans.JavaBean;
import java.util.*;
import java.util.stream.Collectors;

public class BstQuestions {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

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
        } else if (leftNode.val != rightNode.val) {
            return false;
        } else {
            return isNodeSymmetric(leftNode.left, rightNode.right) && isNodeSymmetric(leftNode.right, rightNode.left);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list, "");
        return list;
    }

    private void dfs(TreeNode node, List<String> list, String s) {
        if (node == null) {
            return;
        }
        s = s + node.val;
        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }
        s = s + "->";
        dfs(node.left, list, s);
        dfs(node.right, list, s);

    }

    /*public int minDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int size =0;
        while (!queue.isEmpty()) {

            result++;
            size= queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return result;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return result;
    }*/
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int answer = 0;
        if (root.left == null && root.right != null) {
            return right + 1;

        }
        if (root.left != null && root.right == null) {
            return left + 1;
        }
        answer = Integer.min(left, right) + 1;
        return answer;
    }

    /*    public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = countNodes(root.left);
            int r = countNodes(root.right);
            int count = l + r + 1;
            return count;
        }*/
    int nodeCount = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countNodes1(root);
        return nodeCount;
    }

    public void countNodes1(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeCount++;
        countNodes1(root.left);
        countNodes1(root.right);
    }
    /*public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int result = Integer.max(l, r) + 1;
        return result;
    }
*/

/*    public int maxDepth1(TreeNode root) {
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
    }*/

    int height = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepthByPreOrder(root, 0);

    }

    public int maxDepthByPreOrder(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return i + 1;
        }
        //if (root.left != null || root.right != null) {
        //height++;
        //}
        int left = maxDepthByPreOrder(root.left, i + 1);
        int right = maxDepthByPreOrder(root.right, i + 1);
        return Math.max(left, right);

    }

    public boolean isBalanced(TreeNode root) {
        int height = isBalancedDfs(root);
        if (height == -1) {
            return false;
        }
        return true;
    }

    int isBalancedDfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = isBalancedDfs(node.left);
        if (l == -1) {
            return -1;
        }
        int r = isBalancedDfs(node.right);
        if (r == -1) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        } else {
            return Integer.max(l, r) + 1;
        }

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                index = i;
                break;
            }
        }
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        root.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /*int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {

        minDiffInBSTDfs(root);
        return minDiff;
    }

    private void minDiffInBSTDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        minDiffInBSTDfs(node.left);
        if (pre != null) {
            int diff = node.val - pre.val;
            System.out.println(diff);
            System.out.println(minDiff);
            minDiff = Math.min(minDiff, diff);

        }
        pre = node;
        minDiffInBSTDfs(node.right);
    }*/
 /*   int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        minDiffInBSTDfs(root);
        return minDiff;
    }


    public int minDiffInBST(TreeNode root) {

        minDiffInBSTDfs(root);
        return minDiff;
    }*/

   /* private void minDiffInBSTDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        minDiffInBSTDfs(node.left);
        if (pre != null) {
            int diff = node.val - pre.val;
            minDiff = Integer.min(minDiff, diff);
        }
        pre = node;
        minDiffInBSTDfs(node.right);
    }
*/
    /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) {
             return null;
         }
         if (root.val == p.val || root.val == q.val) {
             return root;
         }
         TreeNode lResult = lowestCommonAncestor(root.left, p, q);
         TreeNode rResult = lowestCommonAncestor(root.right, p, q);
         if (lResult == null && rResult == null) return null;
         else if (lResult != null && rResult == null) {
             return lResult;
         } else if (lResult == null && rResult != null) {
             return rResult;
         } else if (lResult.val != rResult.val) {
             return root;
         } else {
             return lResult;
         }

     }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = new HashMap<>();
        lowestCommonAncestorDfs(root, map);
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            set.add(q);
            q = map.get(q.val);
        }
        return null;
    }

    private void lowestCommonAncestorDfs(TreeNode root, Map<Integer, TreeNode> map) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left.val, root);
            lowestCommonAncestorDfs(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            lowestCommonAncestorDfs(root.right, map);
        }
    }

    TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findModeDfs(root, map);

        List<Map.Entry> list = map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).collect(Collectors.toList());
        System.out.println(list);
        return null;
    }

    private void findModeDfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        findModeDfs(root.left, map);
        if (preNode != null) {
            if (preNode.val == root.val) {
                map.put(root.val, map.get(root.val) + 1);
            } else {
                map.put(root.val, 1);
            }
        } else {
            map.put(root.val, 1);
        }
        preNode = root;
        findModeDfs(root.right, map);
    }

    boolean isPathSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return isPathSum;
    }

    private void dfs(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (targetSum == sum) {
                isPathSum = true;
            }
            return;
        }
        dfs(node.left, targetSum, sum);
        dfs(node.right, targetSum, sum);
    }

    int leftSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum += root.left.val;
        }
        sumOfLeftLeaves(root.right);
        return leftSum;
    }


    public int[] findMode1(TreeNode root) {
        findModeDfs(root);
        int[] res = map.entrySet().stream().filter(entry -> entry.getValue() == max).mapToInt(entry -> entry.getKey()).toArray();
        return res;
    }

    int preVal = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public void findModeDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        findModeDfs(node.left);
        if (preVal == Integer.MIN_VALUE) {
            count = 1;
            max = count;
        } else if (preVal == node.val) {
            count++;
            if (count > max) {
                max = count;
                map.clear();
            }
        } else if (preVal != node.val) {
            count = 1;
        }
        preVal = node.val;
        map.put(node.val, count);
        findModeDfs(node.right);
    }


    int minDiffValue = 0;
    TreeNode previousNode = null;

    private void miniDiffDfs(TreeNode root) {
        if (root == null) {
            return;
        }

        miniDiffDfs(root.left);
        if (previousNode != null) {
            int diff = Math.abs(root.val - previousNode.val);
            if (minDiffValue == 0) {
                minDiffValue = diff;
            } else if (minDiffValue > diff) {
                minDiffValue = diff;
            }
        }
        previousNode = root;
        miniDiffDfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        miniDiffDfs(root);
        return minDiffValue;
    }

    StringBuilder ans = new StringBuilder();

    public void tree2str(TreeNode node, String leftBracket, String rightBracket) {
        if (node == null) {
            return;
        }
        ans.append(leftBracket);
        ans.append(node.val);
        tree2str(node.left, "(", ")");
        if (node.left == null && node.right != null) {
            ans.append("()");
        }
        tree2str(node.right, "(", ")");
        ans.append(rightBracket);
    }

    public String tree2str(TreeNode root) {
        tree2str(root, "", "");
        return ans.toString();
    }


    int maxDiameter = -1;

    private int diameterOfBinaryTreeDfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = diameterOfBinaryTreeDfs(node.left);
        int r = diameterOfBinaryTreeDfs(node.right);
        int result = Integer.max(l, r) + 1;
        if (l + r + 1 > maxDiameter) {
            maxDiameter = l + r + 1;
        }
        return result;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeDfs(root);
        return maxDiameter - 1;
    }

    boolean isChildNode = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isChildNode = isSubtreeDfs(root, subRoot);
        return isChildNode;
    }

    private boolean isSubtreeDfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            boolean lResult = isSubtreeDfs(root.left, subRoot.left);
            boolean rResult = isSubtreeDfs(root.right, subRoot.right);

            return lResult && rResult;
        } else {
            return isSubtreeDfs(root.left, subRoot) || isSubtreeDfs(root.right, subRoot);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Double> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            avg = sum / size;
            list.add(avg);
        }
        return list;
    }
   /* Map<Integer, Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        boolean l = findTarget(root.left, k);
        if (!map.containsKey(k - root.val)) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        } else {
            return true;
        }
        boolean r = findTarget(root.right, k);
        return l == true || r == true;
    }*/

    public static void main(String[] args) {
        BstQuestions questions = new BstQuestions();

/*        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(2);*/
        //root.right.left = new TreeNode(2);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode subRoot = new TreeNode(1);
      /*  subRoot.left = new TreeNode(1);
        //subRoot.left.left = new TreeNode(1);
        //subRoot.left.right = new TreeNode(2);
        subRoot.right = new TreeNode(2);*/


        //System.out.println(questions.binaryTreePaths(root));
        // System.out.println(questions.countNodes(root));
        //System.out.println(questions.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(2)).val);

        //System.out.println(questions.isSubtree(root, subRoot));
        //System.out.println(questions.isUnivalTree(root));

        //System.out.println(questions.findTarget(root, 9));


        //System.out.println(questions.getMinimumDifference(root));
        //Arrays.stream(questions.findMode1(root)).forEach(System.out::println);

        //System.out.println(questions.findMode1(root));
    }
}



  /*  public boolean isValidBST(TreeNode root) {
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


    *//* public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
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
     }*//*
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


   *//* public TreeNode mergeTrees(TreeNode root1, TreeNode root2, TreeNode root) {

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
    }*//*


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
  *//*
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
    }*//*

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        String builder = "";
        backTrack(root, builder);
        System.out.println("builder=" + builder);
        return res;
    }


*//*    List<String> res = new ArrayList<>();
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
    }*//*


 *//* public boolean isBalanced(TreeNode root) {
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
    }*//*

 *//* public int minDepth(TreeNode root) {
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
    }*//*

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
//
//    public int findTilt(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return findTilt(root.left) + findTilt(root.right) + Math.abs(nodeSum(root.left) - nodeSum(root.right));
//    }
//
//    public int nodeSum(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return nodeSum(node.left) + nodeSum(node.right) + node.val;
//    }

    int tilt = 0;

    public int findTilt(TreeNode root) {
        findTiltDfs(root);
        //help(root);
        return tilt;
    }

    private int findTiltDfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findTiltDfs(node.left);
        int right = findTiltDfs(node.right);
        tilt = tilt + Math.abs(left - right);
        return left + right + node.val;

    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftValue = help(node.left);
        int rightValue = help(node.right);
        tilt += Math.abs(leftValue - rightValue);
        return leftValue + rightValue + node.val;

    }

    *//*public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
        return false;
    }*//*


    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

   *//* public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }*//*

    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node.left) + 1;
        int rightHeight = treeHeight(node.right) + 1;
        return Math.max(leftHeight, rightHeight);

    }

    public int treeDiff(TreeNode node) {

        int l = treeHeight(node.left);
        int h = treeHeight(node.right);
        int diff = Math.abs(l - h);
        return diff;
    }


    *//* public boolean isSameTree(TreeNode p, TreeNode q) {
         return isSameNode(p, q);
     }


     private boolean isSameNode(TreeNode p, TreeNode q) {
         if (p == null && q == null) {
             return true;
         } else if (p == null || q == null) {
             return false;
         } else if (p != null && q != null) {

             if (p.val == q.val) {
                 return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
             }
         }

         return false;
     }
    public boolean isSymmetric_new(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricNode(root.left, root.right);
    }

    private boolean isSymmetricNode(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            if (node1.val == node2.val) {
                return isSymmetricNode(node1.left, node2.right) && isSymmetricNode(node1.right, node2.left);
            }
        }
        return false;
    }



    public TreeNode sortedArrayToBST1(int[] nums) {
        return sortedArrayToBST1(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST1(nums, left, middle - 1);
        root.right = sortedArrayToBST1(nums, middle + 1, right);
        return root;
    }
*//*
    public int minDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ans++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
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
        return ans;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumDfs(root, 0, targetSum);
    }

    private boolean hasPathSumDfs(TreeNode node, int pathSum, int target) {
        if (node == null) {
            return false;
        }
        pathSum += node.val;
        if (node.left == null && node.right == null) {
            //pathSum += node.val;
            if (pathSum == target) {
                return true;
            }
            return false;
        }

        return hasPathSumDfs(node.left, pathSum, target) || hasPathSumDfs(node.right, pathSum, target);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

  *//*      System.out.println(leftNode == null ? "null" : leftNode.val);
        System.out.println(rightNode == null ? "null" : rightNode.val);

        System.out.println(root.val);
        System.out.println("----------");*//*

        root.right = leftNode;
        root.left = rightNode;

        *//*TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;*//*

        return root;
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> res = new ArrayList<>();
        treePaths(root, res, "");
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

    private void treePaths(TreeNode node, List<String> res, String path) {
        if (node == null) {
            return;
        }
        path += node.val;
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        path += "->";
        treePaths(node.left, res, path);
        treePaths(node.right, res, path);
    }

    private void treePaths1(TreeNode node, List<String> res, String path) {
        if (node == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(path);
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(builder.toString());
            return;
        }
        builder.append("->");
        treePaths1(node.left, res, builder.toString());
        treePaths1(node.right, res, builder.toString());
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumOfLeftLeavesDfs(root);
        return sum;
    }

    private void sumOfLeftLeavesDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        sumOfLeftLeavesDfs(node.left);
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum = sum + node.left.val;
        }
        sumOfLeftLeavesDfs(node.right);
    }

    int maxCount = 0;
    List<Integer> modeList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        findModeDfs(root, map);
        System.out.println("----------");
        System.out.println(modeList);
        System.out.println("----------");
        int[] array = new int[modeList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = modeList.get(i);
        }
        return array;
    *//*    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
        int ans = list.get(0).getValue();
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            if (ans > list.get(i).getValue()) {
                break;
            } else if (ans == list.get(i).getValue()) {
                res.add(list.get(i).getKey());
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }*//*

    }

    public int[] findMode1(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        findModeDfs(root, map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
        int ans = list.get(0).getValue();
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0).getKey());
        for (int i = 1; i < list.size(); i++) {
            if (ans > list.get(i).getValue()) {
                break;
            } else if (ans == list.get(i).getValue()) {
                res.add(list.get(i).getKey());
            }
        }
        int[] array = new int[res.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = res.get(i);
        }
        System.out.println("----------");
        System.out.println(modeList);
        System.out.println("----------");
        return array;
    }

    private void findModeDfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        findModeDfs(node.left, list);
        list.add(node.val);
        findModeDfs(node.right, list);
    }

    private void findModeDfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        findModeDfs(node.left, map);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        int currentCount = map.get(node.val);
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modeList.clear();
            modeList.add(node.val);
        } else if (currentCount == maxCount) {
            modeList.add(node.val);
        }

        findModeDfs(node.right, map);
    }

    String treeStr = "";

    public String tree2str(TreeNode root) {
        tree2strDfs1(root);
        return treeStr;
    }

    private void tree2strDfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        treeStr += node.val;
        if (node.left != null) {
            treeStr += "(";
        } else if (node.right != null) {
            treeStr += "(";
        }
        tree2strDfs1(node.left);
        if (node.left != null) {
            treeStr += ")";
        } else if (node.right != null) {
            treeStr += ")";
        }

        if (node.right != null) {
            treeStr += "(";
        }
        tree2strDfs1(node.right);
        if (node.right != null) {
            treeStr += ")";
        }
    }

    private void tree2strDfs(TreeNode node, String left, String right) {
        if (node == null) {
            return;
        }
        treeStr += node.val;
        *//*if(node.left ==null && node.right ==null){
            //treeStr+=")";
            return;
        }*//*
        treeStr += left;
        tree2strDfs(node.left, "(", ")");
        treeStr += right;
        treeStr += "(";
        tree2strDfs(node.right, "(", ")");
        treeStr += ")";

    }

    int sumValue = 0;

    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        sumRootToLeafDfs(root, list, "");
      *//*  System.out.println(list);
        int ans = 0;
        for (String s : list) {
            ans = ans + str2int(s);
        }
        return ans;*//*
        return sumValue;
    }

    public int str2int(String str) {
        int len = str.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int t = str.charAt(i) - '0';
            ans = ans * 2 + t;
        }
        return ans;
    }

    private void sumRootToLeafDfs(TreeNode node, List<String> list, String path) {

        if (node == null) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(path);
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            //str2int(builder.toString());
            sumValue += str2int(builder.toString());
            //list.add(builder.toString());
        }

        sumRootToLeafDfs(node.left, list, builder.toString());
        sumRootToLeafDfs(node.right, list, builder.toString());

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        isUnivalTreeDfs(root, map);
        if (map.size() > 1) {
            return false;
        }
        return true;
    }

    private void isUnivalTreeDfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        isUnivalTreeDfs(node.left, map);
        isUnivalTreeDfs(node.right, map);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        leafSimilarDfs(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        leafSimilarDfs(root2, l2);
        if (l1.size() != l2.size()) {
            return false;
        } else {
            for (int i = 0; i < l1.size(); i++) {
                if ((l1.get(i) ^ l2.get(i)) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void leafSimilarDfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        leafSimilarDfs(node.left, list);
        leafSimilarDfs(node.right, list);
    }

    List<TreeNode> nodePath = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorDfs(root, p, q);
        TreeNode res = findFirstParent(q);
        return res;
    }

    private TreeNode findFirstParent(TreeNode q) {
        int t = nodePath.size();
        for (int i = t - 1; i >= 0; i--) {
            TreeNode node = nodePath.get(i);
            boolean isParent = findFirstParentDfs(node, q);
            if (isParent) {
                return node;
            }
        }
        return null;
    }

    private boolean findFirstParentDfs(TreeNode node, TreeNode q) {
        if (node == null) {
            return false;
        }
        if (node.val == q.val) {
            return true;
        } else if (node.val > q.val) {
            return findFirstParentDfs(node.left, q);
        } else {
            return findFirstParentDfs(node.right, q);
        }
    }

    private void lowestCommonAncestorDfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return;
        }
        nodePath.add(node);
        if (node.val == p.val) {
            return;
        } else if (node.val > p.val) {
            lowestCommonAncestorDfs(node.left, p, q);
        } else {
            lowestCommonAncestorDfs(node.right, p, q);
        }

    }

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            ans = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //System.out.println(ans);
        }

        return ans;

    }


    public void dfsParents(TreeNode node, Map<Integer, TreeNode> parents) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parents.put(node.left.val, node);
            dfsParents(node.left, parents);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            dfsParents(node.right, parents);
        }
    }

    public TreeNode lowestCommonAncestorBtree(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        dfsParents(root, parents);
        while (p != null) {
            set.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int xHeight = 0;
        int yHeight = 0;
        int index = 0;
        while (!queue.isEmpty()) {
            index++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    xHeight = index;
                }
                if (node.val == y) {
                    yHeight = index;
                }
                if (node.left != null) {
                    if (node.left.val == x) {
                        map.put(x, node);
                    }
                    if (node.left.val == y) {
                        map.put(y, node);
                    }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        map.put(x, node);
                    }
                    if (node.right.val == y) {
                        map.put(y, node);
                    }
                    queue.add(node.right);
                }
            }
        }
        TreeNode xNode = map.get(x);
        TreeNode yNode = map.get(y);
        if (xHeight == yHeight && xNode.val != yNode.val) {
            return true;
        }
        return false;


       *//* Map<Integer, TreeNode> map = new HashMap<>();
        isCousinsDfs(root, x, y, map);
        TreeNode nodeX = map.get(x);
        TreeNode nodeY = map.get(y);
        int xLength = nodeHeight(nodeX);
        int yLength = nodeHeight(nodeY);
        if (nodeX != nodeY) {
            if (xLength == yLength) {
                return true;
            }
        }
        return false;*//*
    }


    *//*private int nodeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
    }

    private void isCousinsDfs(TreeNode node, int x, int y, Map<Integer, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.val == x) {
                map.put(x, node);
                return;
            }
            if (node.left.val == y) {
                map.put(y, node);
                return;
            }
            isCousinsDfs(node.left, x, y, map);
        }
        if (node.right != null) {
            if (node.right.val == x) {
                map.put(x, node);
                return;
            }
            if (node.right.val == y) {
                map.put(y, node);
                return;
            }
            isCousinsDfs(node.right, x, y, map);
        }
    }
*//*


    int maxDepth = Integer.MIN_VALUE;
    int result = -1;

    public int findBottomLeftValue(TreeNode root) {
        this.findBottomLeftValue(root, 0);
        return result;
    }

    public void findBottomLeftValue(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                System.out.println(depth);
                result = node.val;
            }
            return;
        }
        findBottomLeftValue(node.left, depth + 1);
        findBottomLeftValue(node.right, depth + 1);

    }

    public boolean isBalanced(TreeNode root) {

        int height = getHeight(root);
        if (height > -1) {
            return true;
        }
        return false;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lHeight = getHeight(node.left);
        if (lHeight == -1) {
            return -1;
        }
        int rHeight = getHeight(node.right);
        if (rHeight == -1) {
            return -1;
        }
        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        } else {
            return Integer.max(lHeight, rHeight) + 1;
        }
    }

    //private LinkedList<TreeNode> list = new LinkedList<>();

    private Map<Integer, TreeNode> map = new LinkedHashMap<>();

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        findParents(root, p);
        List<Map.Entry<Integer, TreeNode>> list = map.entrySet().stream().collect(Collectors.toList());
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode node = list.get(i).getValue();
            if (findChild(node, q)) {
                return node;
            }
        }
        return null;
       *//* while (iterator.hasNext()) {
            TreeNode node = iterator.next().getValue();
            if (findChild(node, q)) {
                return node;
            }
        }
*//*
 *//*        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            if (findChild(node, q)) {
                return node;
            }
        }*//*

    }

    public void findParents(TreeNode root, TreeNode p) {

        if (root == null) {
            return;
        }
  *//*      if (!list.contains(root) && !list.contains(p)) {
            list.push(root);
        }*//*

        if ((root.left != null || root.right != null) && !map.containsKey(root.val) && !map.containsKey(p.val)) {
            map.put(root.val, root);
        }

        if (root.val == p.val) {
            return;
        }
        findParents(root.left, p);
        findParents(root.right, p);
    }

    public boolean findChild(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return findChild(root.left, p) || findChild(root.right, p);
    }


    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        boolean lResult = isSymmetric2(left.left, right.right);
        boolean rResult = isSymmetric2(left.right, right.left);
        return lResult && rResult;
    }*/



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
}
*/
