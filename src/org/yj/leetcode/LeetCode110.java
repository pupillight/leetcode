package org.yj.leetcode;

import java.util.*;

public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (dfs(root) == -1) {
            return false;
        }
        return true;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        if (l == -1 || r == -1) {
            return -1;
        }
        int height = Math.max(l, r) + 1;
        return height;
    }

    Map<Integer, Integer> map = new HashMap<>();

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
        return l || r;
    }


    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0 || numbers.length == 1) {
            return null;
        }
        int l = 0;
        int r = numbers.length - 1;
        int mid = l + (r - l) / 2;
        while (l >= 0 && r <= numbers.length - 1 && l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                while (l < r && numbers[l] == numbers[++l]) ;
                while (l < r && numbers[r] == numbers[++r]) ;
                return new int[]{l, r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }


    // LinkedList<Integer> queue = new LinkedList<>();


    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((e1, e2) -> e1 - e2);
        findSecondMinimumValueDfs(root, priorityQueue);
        if (!priorityQueue.isEmpty()) {
            priorityQueue.poll();
        }
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        return priorityQueue.peek();
    }

    private void findSecondMinimumValueDfs(TreeNode node, PriorityQueue<Integer> queue) {
        if (node == null) {
            return;
        }
        findSecondMinimumValueDfs(node.left, queue);
        findSecondMinimumValueDfs(node.right, queue);
        if (!queue.contains(node.val)) queue.add(node.val);
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

   /* int minDiff = Integer.MAX_VALUE;
    TreeNode preNode = null;

    public int minDiffInBST(TreeNode root) {
        miniDiffDfs(root);
        return minDiff;
    }

    private void miniDiffDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        minDiffInBST(node.left);
        if (preNode != null) {
            int diff = Math.abs(node.val - preNode.val);
            if (minDiff > diff) minDiff = diff;
        }
        preNode = node;
        minDiffInBST(node.right);
    }*/

    int sum = 0;
    TreeNode preNode = null;

    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumDfs(root, low, high);
        return sum;
    }

    private void rangeSumDfs(TreeNode node, int l, int r) {
        if (node == null) {
            return;
        }
        rangeSumDfs(node.left, l, r);
        if (node.val >= l && node.val <= r) {
            sum += node.val;
        }
        rangeSumDfs(node.right, l, r);
    }


    int total = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafDfs(root, new StringBuilder());
        return total;
    }

    private void sumRootToLeafDfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            int tmp = str2Int(builder.toString());
            total += tmp;

        }
        sumRootToLeafDfs(node.left, builder);
        sumRootToLeafDfs(node.right, builder);
        builder.deleteCharAt(builder.length() - 1);
    }

    public int str2Int(String str) {
        if (str == null && str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        int v = 0;
        while (i < chars.length) {
            v = v * 2 + (chars[i] - '0');
            i++;
        }
        return v;
    }


    /*  public int findCountYear(String input) {
          int ans = 0;

          List<Integer> list = new ArrayList<>();
          list.add(10);
          list.add(10);



          int count = (int) list.stream().distinct().count();
          String a = input.replace(".", " ");//.replace(",", " ");
          //String b= a.replaceAll(","," ");
          //System.out.println(a);
          // System.out.println(b);
          Set<String> set = new HashSet();
          String[] words = a.split(" ");
          for (int i = 0; i < words.length; i++) {
              if (words[i].length() == 10 && words[i].indexOf("-") > -1) {
                  set.add(words[i].substring(6));
              }
          }
          ans = set.size();
          return ans;
      }*/
   /* private void findSecondMinimumValueDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        findSecondMinimumValueDfs(root.left);
        findSecondMinimumValueDfs(root.right);
        if (root.left != null && root.right != null) {
            if (queue.isEmpty()) {
                if (root.left.val < root.right.val) {
                    queue.addLast(root.left.val);
                    queue.addLast(root.right.val);
                } else {
                    queue.addLast(root.right.val);
                    queue.addLast(root.left.val);
                }
            } else if (!queue.isEmpty()) {
                int v = Math.min(root.left.val, root.right.val);
                if (v >= queue.peekLast()) {
                    //do nothing
                } else if (v > queue.peekFirst()) {
                    if (queue.size() == 2) {
                        queue.removeLast();
                    }
                    queue.addLast(v);
                } else {
                    queue.addFirst(v);
                    if (queue.size() > 2) {
                        queue.removeLast();
                    }
                }
            }
        }
    }*/

    TreeNode newRoot;// = new TreeNode();

    List<Integer> list = new ArrayList<>();

    private void increasingBSTDfs(TreeNode node) {
        if (node == null) {
            return;
        }
        increasingBSTDfs(node.left);
        list.add(node.val);
        increasingBSTDfs(node.right);
    }

    private void createNewNode(TreeNode node, List<Integer> list, int i) {
        if (i == list.size()) {
            return;
        }
        node = new TreeNode(list.get(i));
        i++;
        createNewNode(node.right, list, i);
    }

    public TreeNode increasingBST(TreeNode root) {
        increasingBSTDfs(root);
       // createNewNode(newRoot, list, 0);
        return newRoot;
    }

    public static void main(String[] args) {
        LeetCode110 leetCode = new LeetCode110();
        Set<Integer> set = new HashSet();
        set.add(9);
        set.add(8);
        set.add(9);
        System.out.println(set.size());
        //  leetCode.str2Int("101");

        //System.out.println(leetCode.findCountYear("hello abc 04-04-2023, . my son birthday is 05-18-2011."));
        //int[] numbers = {1, 2, 4, 6, 10};
        // int[] numbers = {0, 0, 3, 4};
        // int target = 0;
        // Arrays.stream(leetCode.twoSum(numbers, target)).forEach(System.out::println);
        // System.out.println(leetCode.twoSum(numbers, target));
       /* TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);*/
        //root.right = new TreeNode(2);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        //root.left.left = new TreeNode(0);
        //root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(0);
        //root.right.right = new TreeNode(1);
        System.out.println(leetCode.increasingBST(root).val);
        //System.out.println(leetCode.isBalanced(root));
        // System.out.println(leetCode.findSecondMinimumValue(root));
    }


}
