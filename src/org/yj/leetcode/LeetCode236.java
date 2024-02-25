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
        if (node.left != null) {
            depth++;
            findBottomLeftValueDfs(node.left, depth);
            depth--;
        }
        if (node.right != null) {
            depth++;
            findBottomLeftValueDfs(node.right, depth);
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

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : s.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public int maximum69Number1(int num) {

        int res = num;
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '6') {
                chars[i] = '9';
                break;
            }
        }
        res = Integer.parseInt(String.valueOf(chars));

        return res;
    }

    public int maximum69Number(int num) {

        int res = num;
        int mod = 0;
        while (num > 0) {
            mod = num % 10;
            num = num / 10;

        }
        return res;
    }

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }


    public boolean lemonadeChange(int[] bills) {

        LinkedList<Integer> stack5 = new LinkedList<>();
        LinkedList<Integer> stack10 = new LinkedList<>();
        LinkedList<Integer> stack20 = new LinkedList<>();

        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) {
                stack5.add(bills[i]);
            }
            if (bills[i] == 10) {
                if (stack5.isEmpty()) {
                    return false;
                }
                stack5.pop();
                stack10.add(bills[i]);
            }
            if (bills[i] == 20) {
                if (!stack10.isEmpty()) {
                    stack10.pop();
                    if (stack5.isEmpty()) {
                        return false;
                    }
                } else {
                    if (stack5.size() < 3) {
                        return false;
                    }
                    stack5.pop();
                    stack5.pop();
                }
                stack5.pop();
                stack20.add(bills[i]);
            }
        }

        return true;
    }

    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {

            while (j < s.length) {
                if (g[i] <= s[j]) {
                    res++;
                    j++;
                    break;
                }
                j++;
            }

        }
        return res;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < g.length && g[j] <= s[i]) {
                j++;
                res++;

            }
        }
        return res;
    }

    public int[] diStringMatch1(String s) {

        int l = 0;
        int r = s.length();

        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                list.add(l);
                l++;
            } else if (c == 'D') {
                list.add(r);
                r--;
            }
        }
        if (l == r) {
            list.add(l);
        }
        System.out.println(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] diStringMatch(String s) {

        int l = 0;
        int r = s.length();
        int[] res = new int[s.length() + 1];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == 'I') {
                res[index++] = l;
                l++;
            } else if (c == 'D') {
                res[index++] = r;
                r--;
            }
        }
        res[index] = l;
        return res;
    }


    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 1; j--) {
                int sum = nums[j] + nums[j - 1];
                if (sum > nums[i]) {
                    res = sum + nums[i];
                    return res;
                }
            }
        }
        return res;
    }

    public int findContentChildren2(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int j = g.length - 1;
        int res = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            while (j >= 0 && s[i] >= g[j]) {
                res++;
                j--;
            }

        }
        return res;
    }

    public String maximumOddBinaryNumber(String s) {
        int count = (int) s.chars().filter(c -> c == '1').count();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (count > 1) {
                builder.append('1');
                count--;
            } else {
                builder.append('0');
            }
        }
        builder.append('1');
        return builder.toString();

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i; j <= i + k; j++) {
                if (set.contains(nums[j])) {
                    return true;
                }
                set.add(nums[j]);
            }
            set.clear();
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        for (int i = k + 1; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public boolean isIsomorphicSub(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (map.containsKey(x) && map.get(x) != y) {
                return false;
            }
            map.put(x, y);
        }
        return true;

    }

    public boolean isIsomorphic(String s, String t) {

        return isIsomorphicSub(s, t) && isIsomorphicSub(t, s);

    }

    public boolean isIsomorphic1(String s, String t) {

        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((maps.containsKey(x) && maps.get(x) != y) || (mapt.containsKey(y) && mapt.get(y) != x)) {
                return false;
            }
            maps.put(x, y);
            mapt.put(y, x);
        }
        return true;
    }


    public static void main(String[] args) {
/*        TreeNode r1 = new TreeNode(6);
        r1.left = new TreeNode(2);
<<<<<<< HEAD
<<<<<<< HEAD
        //r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);
=======
=======

>>>>>>> f177965 (pull)
        r1.left.left = new TreeNode(0);
        r1.left.left.left = new TreeNode(4);
        //r1.left.right = new TreeNode(4);
>>>>>>> 130e6cc (kkkk)

        //r1.left.left = new TreeNode(0);
        r1.left.right = new TreeNode(4);


        //r1.right = new TreeNode(8);
        //r1.right.left = new TreeNode(7);
        //r1.right.right = new TreeNode(9);

        LeetCode236 question = new LeetCode236();
<<<<<<< HEAD

        System.out.println(question.isIsomorphic("badc", "baba"));
       *//* int[] nums = {2, 2};
        //int[] nums = {1, 2, 3, 1};
        int k = 2;
        System.out.println(question.containsNearbyDuplicate(nums, k));*//*

        // System.out.println(question.maximumOddBinaryNumber("0101"));
        // int[] nums = {1, 2, 1, 10};
        //System.out.println(question.largestPerimeter(nums));
        // System.out.println(question.diStringMatch("IDID"));
       *//* int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(question.findContentChildren1(g, s));*//*
       *//* int[] bills = {5, 5, 10, 10, 20};
        System.out.println(question.lemonadeChange(bills));*//*
        //int[] nums = {1, 4, 3, 2};
        //System.out.println(question.arrayPairSum(nums));
        //System.out.println(question.maximum69Number(9669));
=======
        System.out.println(question.minDepth(r1));
>>>>>>> 130e6cc (kkkk)
        //System.out.println(question.lowestCommonAncestor(r1, new TreeNode(7), new TreeNode(8)).val);
<<<<<<< HEAD
        //int[] arr = {4, 3, 1, 1, 3, 3, 2};
        //int k = 3;
        //System.out.println(question.findLeastNumOfUniqueInts(arr, k));
        //System.out.println(question.binaryTreePaths(r1));


<<<<<<< HEAD
        //int[] arr = {1, 2, 3, 4, 6, 7, 5};
        //int result = sumArray(arr);
        //System.out.println(result); // Output: 15
        //System.out.println(question.countNodes(r1));
=======
        // System.out.println(question.countNodes(r1));


        //System.out.println(question.removePalindromeSub("ababb"));
>>>>>>> 130e6cc (kkkk)*/


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
