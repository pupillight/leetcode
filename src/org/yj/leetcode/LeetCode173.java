package org.yj.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode173 {


    public List<Integer> generate(int k) {

        List<Integer> list = new ArrayList<>();

        int num=0;
        for (int i = 1; i <= k; i<<=1) {

            num++;
            list.add(i);
            k= k-i;
        }

        if(k>0){
            list.add(k);
            num++;
        }


        System.out.println(num);

        return list;
    }

    public String longestNiceSubstring(String s) {

        int len = s.length();
        int[][] arr = new int[len + 1][128];

        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i - 1);
            arr[i] = arr[i - 1].clone();
            arr[i][c - 'A']++;
        }

        String ans = "";

        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                boolean flag = check(arr[i], arr[j + 1]);
                if (flag) {
                    if (j - i > max) {
                        max = j - i;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    boolean check(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            int m = b[i] - a[i];
            int n = b[i + 32] - a[i + 32];
            if (m == 0 && n > 0) {
                return false;
            }
            if (m > 0 && n == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode173 instance = new LeetCode173();

       // System.out.println(instance.longestNiceSubstring("a"));

        System.out.println(instance.generate(5));
    }

}
