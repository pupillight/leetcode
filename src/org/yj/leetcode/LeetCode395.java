package org.yj.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class LeetCode395 {


    public int longestSubstring(String s, int k) {
        int len = s.length();
        int[][] arr = new int[len + 1][26];

        boolean[] flag = new boolean[len + 1];
        Arrays.fill(flag, true);
        char[] chars = s.toCharArray();
        for (int i = 1; i < len + 1; i++) {
            arr[i] = arr[i - 1].clone();
            arr[i][chars[i - 1] - 'a']++;
        }

        System.out.println(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] != 0 && arr[i][j] < k) {
                    flag[i] = false;
                }
            }
        }



      /*  for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {

                for (int l = 0; l < 26; l++) {
                    int diff = arr[j][l] - arr[i][l];
                    if(diff>=k){

                    }
                }

            }
        }*/

        return -1;
    }

    public static void main(String[] args) {
        LeetCode395 instance = new LeetCode395();
        String s = "aaabb";
        int k = 3;
        //System.out.println(instance.longestSubstring(s, k));

        System.out.println(instance.longestSubstring("ababbc", 2));
    }

}
