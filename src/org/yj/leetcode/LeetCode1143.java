package org.yj.leetcode;

import java.util.*;

public class LeetCode1143 {


    public int findMaxValueIndex(int[] arr) {
        int index = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public long pickGifts(int[] gifts, int k) {

        Comparator<Integer> comparator = (e1, e2) -> e2 - e1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < gifts.length; i++) {
            queue.add(gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            int v = queue.poll();
            queue.add((int) Math.sqrt(v));
        }
        return queue.stream().mapToLong(e -> e).sum();

       /* long sum = 0l;
        for (int i = 0; i < k; i++) {
            int index = findMaxValueIndex(gifts);
            gifts[index] = (int) Math.sqrt(gifts[index]);
        }
        for (int i = 0; i < gifts.length; i++) {
            sum += gifts[i];
        }
        //sum = Arrays.stream(gifts).sum();
        return sum;*/

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

                // res = Math.max(res, dp[i][j]);
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        LeetCode1143 instance = new LeetCode1143();
        String text1 = "psnw";
        String text2 = "vozsh";


        //System.out.println(instance.longestCommonSubsequence(text1, text2));
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        System.out.println(instance.pickGifts(gifts, k));

    }
}
