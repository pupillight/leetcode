package org.yj.leetcode.amazon;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                int t = map.get(target - nums[i]);
                int[] res = {t, i};
                return res;
            }
        }
        return null;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = new ListNode();
        ListNode currNode = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            currNode = currNode.next;
        }

        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return node.next;
    }

    /*public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ans = Integer.max(ans, i - l + 1);
        }
        return ans;
    }*/
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                l = Integer.max(l, map.get(c) + 1);
            }
            map.put(c, i);
            ans = Integer.max(ans, i - l + 1);
        }
        return ans;
    }

    int count = 0;

    public int numberOfSteps(int num) {
        if (num == 0) {
            return count;
        }
        count++;
        if (num % 2 == 0) {
            num = num / 2;
        } else {
            num = num - 1;
        }
        return numberOfSteps(num);
    }

    public int myAtoi(String s) {
        String text = s.trim();
        if (text.length() == 0) {
            return 0;
        }
        int sign = 1;
        int res = 0;
        int index = 0;
        char c = text.charAt(index);
        if (c == '-') {
            sign = -1;
            index++;
        } else if (c == '+') {
            index++;
        } else if (Character.isLetter(c)) {
            return res;
        }
        while (index < text.length()) {
            c = text.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            } else {
                if (sign == -1) {
                    if (-1 * res < Integer.MIN_VALUE / 10) {
                        return Integer.MIN_VALUE;
                    } else if (-1 * res == Integer.MIN_VALUE / 10) {
                        if (-(c - '0') <= Integer.MIN_VALUE % 10) {
                            return Integer.MIN_VALUE;
                        }
                    }
                } else {
                    if (res > Integer.MAX_VALUE / 10) {
                        return Integer.MAX_VALUE;
                    } else if (res == Integer.MAX_VALUE / 10) {
                        if (c - '0' >= Integer.MAX_VALUE % 10) {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
                res = res * 10 + (c - '0');
                index++;
            }
        }
        return sign * res;
    }
    //2147483648
    //2147483647


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> list = connections.get(i);
            union(list.get(0), list.get(1), parent);
        }

        Arrays.stream(parent).forEach(System.out::println);
        return null;

    }

    public int find(int p, int[] parent) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q, int[] parent) {
        int pRoot = find(p, parent);
        int qRoot = find(q, parent);

        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode currNode = node;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int v1 = list1.val;
                int v2 = list2.val;
                if (v1 < v2) {
                    currNode.next = new ListNode(v1);
                    list1 = list1.next;
                } else {
                    currNode.next = new ListNode(v2);
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                currNode.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                currNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            currNode = currNode.next;
          /*  int v1 = list1 == null ? 0 : list1.val;
            int v2 = list2 == null ? 0 : list2.val;

            if (v1 < v2) {
                currNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                currNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
        }*/
        }
        return node.next;
    }

    /*  public int sumEvenGrandparent(TreeNode root) {
          if (root == null) {
              return 0;
          }
          if (root.val % 2 == 0) {
              sumEvenGrandparent(root.left);
              sumEvenGrandparent(root.right);
          }
      }

      public int evenGrandparent(TreeNode node, int index) {
          if (node == null) {
              return 0;
          }

          if (node.val % 2 == 0) {
              evenGrandparent(node.left, index++);
              evenGrandparent(node.right, index++);
          }
      }
  */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int[] range = new int[2];
        for (int i = 1; i < arr.length; i++) {
            isPalindrome(arr, i, i, range);
            isPalindrome(arr, i - 1, i, range);
        }
        return s.substring(range[0], range[1]);
    }

    private void isPalindrome(char[] arr, int l, int r, int[] range) {
        while (l >= 0 && r <= arr.length - 1) {
            if (arr[l] != arr[r]) {
                break;
            } else {
                l--;
                r++;
            }
        }
        if (r - (l + 1) > range[1] - range[0]) {
            range[0] = l + 1;
            range[1] = r;
        }
    }

    List<String> res = new ArrayList<>();



    /*public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l]==nums[++l]);
                    while(l<r && nums[r]==nums[--r]);
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }*/

    public static void fizzBuzz(int n) {
        // Write your code here

        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        generateParenthesis("(", n, builder);
        generateParenthesis(")", n, builder);
        //builder.toString();
        return res;

    }

    private void generateParenthesis(String s, int i, StringBuilder builder) {
        if (i == 0) {
            builder.append(s);
            res.add(builder.toString());
            return;
        }

        generateParenthesis(s + s, i - 1, builder);
    }

    public List<String> generateParenthesis2(int n) {

        List<String> res = new ArrayList<>();

        //String[] array = {"(", ")"};
        //StringBuilder builder = new StringBuilder();
        dfs("", n, res, 0, 0);
        System.out.println(res);
        return res;
    }

    private void dfs(String path, int n, List<String> res, int l, int r) {
        if (r > l || l > n) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(path + "(", n, res, l + 1, r);
        dfs(path + ")", n, res, l, r + 1);
    }

    public List<String> generateParenthesis1(int n) {

        List<String> res = new ArrayList<>();
        String[] array = {"(", ")"};
        StringBuilder builder = new StringBuilder();
        backTrack(array, builder, n, res, 0, 0);
        System.out.println(res);
        return res;
    }

    private void backTrack(String[] array, StringBuilder builder, int n, List<String> list, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (builder.toString().length() == 2 * n) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (array[i].equalsIgnoreCase("(")) {
                backTrack(array, builder, n, list, left + 1, right);

            } else if (array[i].equalsIgnoreCase(")")) {
                backTrack(array, builder, n, list, left, right + 1);
            }
            builder.deleteCharAt(builder.toString().length() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(nums, path, res);
        return res;
    }

    private void backTracking(int[] nums, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, path, res);
            path.removeLast();
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs4PathSum(root, path, targetSum, 0, res);
        return res;
    }

    private void dfs4PathSum(TreeNode node, LinkedList<Integer> path, int targetSum, int currSum, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        currSum += node.val;
        if ((node.left == null && node.right == null) && currSum == targetSum) {
            res.add(new ArrayList<>(path));

        }
        dfs4PathSum(node.left, path, targetSum, currSum, res);
        dfs4PathSum(node.right, path, targetSum, currSum, res);
        path.removeLast();
    }

    public List<Integer> getRow(int rowIndex) {
        int rows = rowIndex + 1;
        int[][] dp = new int[rows][rows];
        dp[0][0] = 1;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            if (i == rowIndex) {
                for (int j = 0; j < rows; j++) {
                    if (dp[i][j] != 0) {
                        list.add(dp[i][j]);
                    }
                }
            }
        }
        return list;

    }

    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {

            int a = Math.min(height[l], height[r]);
            int b = r - l;
            ans = Math.max(ans, a * b);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        String[] sortedProducts = Arrays.stream(products).sorted((p1, p2) -> p1.compareTo(p2)).toArray(size -> new String[size]);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            //char c=searchWord.charAt(i);
            String prefix = searchWord.substring(0, i + 1);

            List<String> list = new ArrayList<>();
            for (int j = 0; j < sortedProducts.length; j++) {

                String product = sortedProducts[j];

                if (product.indexOf(prefix) > -1 && list.size() < 3) {
                    list.add(product);
                }
                if (list.size() == 3) {
                    break;
                }
            }
            res.add(list);
        }
        return res;
    }


    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        Set<Integer> set = new HashSet<>();
        int res = Integer.MIN_VALUE;
        int sum = 0;
        while (l <= r && r < nums.length) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            res = Math.max(res, sum);
            r++;

        }
        return res;
    }

    public String reformatNumber(String number) {

        String text = number.trim();
        int i = 0;
        int len = text.length();
        StringBuilder builder = new StringBuilder();
        while (i < len) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
            i++;
        }
        len = builder.length();
        int j = 0;
        String res = "";
        while (len > 0) {
            String subStr = "";
            if (len < 3) {
                res = builder.substring(0);
                return res;
            }

            if (len == 4) {
                subStr = builder.substring(j, j + 2);
                res += subStr;
                res += "-";
                res += builder.substring(j + 2);
                len = len - 4;
                continue;
            } else if (len == 5) {
                subStr = builder.substring(j, j + 3);
                res += subStr;
                res += "-";
                res += builder.substring(j + 3);
                len = len - 5;
                continue;
            } else {
                subStr = builder.substring(j, j + 3);
                res += subStr;
                res += "-";
                j = j + 3;
                len = len - 3;
            }
        }

        if (res.endsWith("-")) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new TreeMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            StringBuilder builder = new StringBuilder();
            for (char c : array) {
                builder.append(c);
            }
            String key = builder.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(key, list);

        }
        List<List<String>> res = new ArrayList<>();
        res = map.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        return res;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(cloned, target);
    }

    private TreeNode dfs(final TreeNode node, final TreeNode target) {

        if (node == null) {
            return null;
        }
        if (node.val == target.val) {
            return node;
        }
        TreeNode res = dfs(node.left, target);
        if (res != null) {
            return res;
        } else {
            return dfs(node.right, target);
        }

      /*  TreeNode res = null;
        if (node == null) {
            res = node;
        }
        if (node!=null && node.val == target.val) {
            res = node;
        }
        if(node!=null){
            dfs(node.left, target);
            dfs(node.right, target);
        }

        return res;*/
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> numbers = new ArrayList<>();
        dfs(root, numbers);
        Integer[] nums = numbers.toArray(new Integer[numbers.size()]);
        int len = nums.length;
        int[] subfixSums = new int[len];
        subfixSums[len - 1] = nums[len - 1];

        int index = root.val == nums[len - 1] ? len - 1 : -1;

        for (int i = len - 2; i >= 0; i--) {
            subfixSums[i] = subfixSums[i + 1] + nums[i];
            if (index < 0) {
                index = root.val == nums[i] ? i : -1;
            }
        }
        //convert array to bst
        TreeNode newRoot = new TreeNode(subfixSums[index]);
        TreeNode leftNode = convertArray2Bst(subfixSums, 0, index - 1);
        TreeNode rightNode = convertArray2Bst(subfixSums, index + 1, subfixSums.length - 1);
        newRoot.left= leftNode;
        newRoot.right= rightNode;
        return newRoot;
    }

    private TreeNode convertArray2Bst(int[] array, int left, int right) {
        if (array == null || left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = convertArray2Bst(array, left, mid - 1);
        root.right = convertArray2Bst(array, mid + 1, right);
        return root;
    }

    private void dfs(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        dfs(node.left, nums);
        nums.add(node.val);
        dfs(node.right, nums);
    }


    public static void main(String[] args) {
        Questions instance = new Questions();
       /* ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(9);
        System.out.println(instance.addTwoNumbers(l1, l2));*/

 /*       String s = "abba";
        System.out.println(instance.lengthOfLongestSubstring(s));*/

//        String s = "-91283472332";
//        System.out.println(instance.myAtoi(s));

       /* List<List<Integer>> connections = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        connections.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        connections.add(list);
        list = new ArrayList<>();
        list.add(2);
        list.add(0);
        connections.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(3);
        connections.add(list);

        instance.criticalConnections(4, connections);*/

  /*      ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(instance.mergeTwoLists(l1, l2));*/

        //System.out.println(instance.generateParenthesis(2));

        //int[] num = {-1, 0, 1, 2, -1, -4};
        //int[] num = {4, -8, -9, 9, 10, -3, 13, 12, 9, 8, 9, 5, -4, -8, 7, -12, -14, -11, -10, -6, 2, 7, -3, 9, -8, 9, -2, 11, 3, 8, 7, -8, -15, 13, 9, 3, -5, -1, 0, -11, -7, -5, 1, 4, -6, -7, -1, -13, -11, 4, -4, -2, -12, 0, -7, -5, -13, 6, 13, -3, -9, 5, -4, -8, 3, -10, 10, 5, 5, -13, 1, 13, -11, -13, -6, -10, -4, 1, -8, -8, -10, -4, 6, -6, 3, 14, -4, 5, -3, -5, 9, 4, -15, -9, 3, -4, -4, -10, 8, 8, -8, -5, -2, -11};
        //System.out.println(instance.threeSum(num));

        //System.out.println(instance.generateParenthesis(2));

        //int[] nums = {1, 2, 3};
        //System.out.println(instance.permute(nums));

       /* TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(instance.pathSum(root, 22));*/

        //System.out.println(instance.getRow(3));

        //String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
/*        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        List<List<String>> res = instance.suggestedProducts(products, searchWord);

        System.out.println(res);*/
//
//        res.stream().forEach(System.out::println);
//
//        List<String> productList = res.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
//        productList.forEach(System.out::println);


        //int[] nums = {4, 2, 4, 5, 6};
        // int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        // System.out.println(instance.maximumUniqueSubarray(nums));

        // System.out.println(instance.reformatNumber("9964-"));

       /* String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"ac", "c"};
        instance.groupAnagrams(strs);*/
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(4);
        instance.bstToGst(node);
    }
}
