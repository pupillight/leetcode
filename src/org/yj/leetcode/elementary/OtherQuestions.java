package org.yj.leetcode.elementary;

import org.yj.leetcode.TreeNode;

import java.util.*;

public class OtherQuestions {


    public int hammingWeight1(int n) {
       /* int ret = 0;
        for (int i = 0; i < 32; i++) {

            if ((n >> i & 1) == 1) {
                ret++;
            }
        }
        return ret;*/
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(n & (1 << i));
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            System.out.println(n & (1 << i));
            if ((n & (1 << i)) > 0) {
                count++;
            }
        }
        return count;
    }

    public void printBinary(int n) {
        for (int i = 31; i >= 0; i--) {


            System.out.print((n & (1 << i)) != 0 ? 1 : 0);
        }
        System.out.println();
    }

    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res << 1;
            if ((n >> i & 1) == 1) {
                res = res + 1;
            }
        }
        return res;
    }

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }
        return res ^ nums.length;

     /*   Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length + 1; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }

        if (set.size() == 1) {
            return set.iterator().next();
        }
        return -1;*/
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((z & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) return false;
        return true;

    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (tmp.equals("+")) {
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = b + a;
                    stack.add(c);
                }

            } else if (tmp.equals("-")) {
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = b - a;
                    stack.add(c);
                }
            } else if (tmp.equals("*")) {
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = b * a;
                    stack.add(c);
                }
            } else if (tmp.equals("/")) {
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = b / a;
                    stack.add(c);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.size() == 1 ? stack.pop() : Integer.MIN_VALUE;
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i + 1];
                }
            }
        }
        return res;
    }

    public int majorityElement1(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.replace(num, map.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.append(s);

        return builder.toString().contains(goal);

//        int j = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == goal.charAt(j)) {
//                j++;
//            }
//        }
//        String a = s.substring(0, s.length() - j);
//        String b = goal.substring(j, goal.length());
//        return a.equalsIgnoreCase(b);
    }

    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];

    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            res = res ^ c1 ^ c2;
        }

        return res == 0;
    }


    /*  public int lengthOfLongestSubstring(String s) {
          if (s == null || s.length() == 0) {
              return 0;
          } else if (s.length() == 1) {
              return 1;
          }
          int len = 0;
          int l = 0, r = 0;
          Map<Character, Integer> map = new HashMap<>();
          while (r < s.length()) {
              char c = s.charAt(r);
              if (map.containsKey(c)) {
                  l = Math.max(map.get(c) + 1, l);
              }
              map.put(c, r);
              len = Math.max(len, r - l + 1);
              r++;
          }
          return len;
      }*/
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int len = 0;
        int l = 0, r = 0;
        Set<Character> set = new HashSet();
        while (r < s.length()) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }


    /*    public int fibonaci(int k){
            if(k==1 || k==2)
            {
                return k;
            }

            int res =fibonaci(k-1)+fibonaci(k-2);
            return res;

        }*/
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return fib(n, dp);
    }

    public int fib(int k, int[] dp) {
        if (k == 0) {
            dp[0] = 0;
            return k;
        }
        if (k == 1) {
            dp[1] = 1;
            return k;
        }
        if (dp[k] != 0) {
            return dp[k];
        }

        dp[k] = fib(k - 1, dp) + fib(k - 2, dp);
        dp[k] = (int) (dp[k] % (1e9 + 7));
        return dp[k];

    }


    private int count(int num) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            arr[i] = count(arr[i]);
        }
        return arr;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i + 1)) {
                res.add(i + 1);
            }
        }
        return res;
       /* Arrays.sort(nums);

        int length = nums.length;
        // int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            // arr[i] = i + 1;
            int val = i + 1;
            if (val != nums[i]) {
                res.add(val);
            }
        }*/

    }

    public static void main(String[] args) {
        OtherQuestions questions = new OtherQuestions();

        // System.out.println(questions.fib(5));

        //Arrays.stream(questions.countBits(3)).forEach(System.out::println);
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(questions.findDisappearedNumbers(nums));
        // questions.hammingWeight1(8);
        // System.out.println("-------------------------------");
        // questions.hammingWeight(8);

        //questions.printBinary(11);
        //System.out.println(questions.reverseBits(10));
        //int[] nums = {3, 0, 1};
        // System.out.println(questions.missingNumber(nums));
        //System.out.println(questions.hammingDistance(93, 73));
        //System.out.println(questions.isValid("()[){}"));

        //String[] token = {"2", "1", "+", "3", "*"};
        // String[] token = {"4","13","5","/","+"};
        // String[] token = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        //System.out.println(questions.evalRPN(token));

        //int[] array = {3, 2, 3};
        //int[] array = {2, 2, 1, 1, 1, 2, 2};
        //int[] array={1};
        // System.out.println(questions.majorityElement(array));
        //System.out.println(questions.rotateString("abcde", "abced"));
        //int[] array = {1,3,3};
        // int[] array = {3, 3, 1, 3};
        //System.out.println(questions.minArray(array));

        //System.out.println(questions.lengthOfLongestSubstring("dvdf"));
        //System.out.println(questions.lengthOfLongestSubstring("abba"));
        //System.out.println(questions.isAnagram("aa","bb"));

    }
}
