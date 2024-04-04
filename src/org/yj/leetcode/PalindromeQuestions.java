package org.yj.leetcode;

import java.util.Map;
import java.util.function.IntBinaryOperator;

public class PalindromeQuestions {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int res = 0;
        while (x > 0) {
            int m = x % 10;
            x = x / 10;
            res = res * 10 + m;
        }
        return res == tmp;
    }

    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            char c1 = arr[l];
            char c2 = arr[r];
            if (arr[l] < arr[r]) {
                arr[r] = arr[l];
            }
            if (arr[l] > arr[r]) {
                arr[l] = arr[r];
            }
            l++;
            r--;
        }
        return new String(arr);
    }

    int count = 0;
    int[] arr = new int[9];

    private boolean isPalindromic() {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) return false;
        return true;
    }

    private void f(TreeNode node) {
        if (node == null) {
            return;
        }
        arr[node.val - 1]++;
        if (node.left == null && node.right == null) {
            if (isPalindromic()) {
                count++;
            }
            return;
        }
        if (node.left != null) {
            f(node.left);
            arr[node.left.val - 1]--;
        }
        if (node.right != null) {
            f(node.right);
            arr[node.right.val - 1]--;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        f(root);
        return count;
    }

    public int longestPalindromeSubseq(String s, int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (s.charAt(l) != s.charAt(r)) {

        } else {
            longestPalindromeSubseq(s, l + 1, r - 1);
        }

        return -1;
    }
   /* public int longestPalindromeSubseq(String s) {

    }*/

    public boolean isPalindromeNumber(int number) {
        int res = 0;
        int tmp = number;
        while (number > 0) {
            res = res * 10 + number % 10;
            number = number / 10;
        }
        if (res == tmp) {
            return true;
        }
        return false;
    }

    public boolean isPrime(int number) {
        if (number == 2) return true;
        if (number == 1 || number % 2 == 0) return false;
        for (int i = 3; i < number / 2; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int primePalindrome(int n) {

        if (n == 1) {
            return 2;
        }
        while (true) {
            boolean res = isPrime(n) && isPalindromeNumber(n);
            if (res) {
                return n;
            }
            if (n % 2 == 0) {
                n++;
            } else {
                n = n + 2;
            }

        }
    }

    public String breakPalindrome(String palindrome) {

        if(palindrome.length()==1) return "";
        char[] arr = palindrome.toCharArray();
        boolean flag = true;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                flag = false;
                break;
            }
        }
        if (flag) {
            arr[arr.length - 1] = 'b';
        }
        String res = new String(arr);
        return res;
    }


    public static void main(String[] args) {
        PalindromeQuestions instance = new PalindromeQuestions();

        System.out.println(instance.breakPalindrome("aa"));
        // System.out.println(instance.isPrime(3));
        //System.out.println(instance.primePalindrome(3503054));
        //System.out.println(instance.isPalindrome(121));
        //System.out.println(instance.makeSmallestPalindrome("egcfe"));


  /*      TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);*/
/*        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(1);*/
        //root.right.right = new TreeNode(1);

        //System.out.println(instance.pseudoPalindromicPaths(root));

        //System.out.println(instance.longestPalindromeSubseq("cbbd"));
    }
}
