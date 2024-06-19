package org.yj.leetcode;

import java.util.*;

public class LeetCode1177 {








    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();
        int arr[][] = new int[len+1][26];
        for (int i = 1; i <= len; i++) {
            arr[i]= arr[i-1].clone();
           // arr[i] = Arrays.copyOfRange(arr[i - 1], 0, arr[i - 1].length);
         /*   for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i-1][j];
            }*/
            arr[i][s.charAt(i-1)-'a']++;
        }
        System.out.println(arr);

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int count=0;
            for (int i = 0; i < 26; i++) {
               count+= (arr[r+1][i]-arr[l][i])%2;
            }
            if(count<=2*k+1){
                res.add(true);
            }else{
                res.add(false);
            }


        }
        return res;
    }



    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }



    public void sort(int[] arr){

        int len= arr.length;
        for (int i = len-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1177 instance = new LeetCode1177();

        int[] arr = {5,8,2};

        instance.sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
        //System.out.println(instance.hammingWeight(11));

        String s = "abcda";


        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        //int[][] queries = {{0, 3, 1}};
        //System.out.println(instance.canMakePaliQueries(s, queries));

        // String a = "abdef", b = "fecab";
        //System.out.println(instance.checkPalindromeFormation(a, b));
    }

    /*ArrayList<Deque<Integer>> res = new ArrayList<>();
    Deque<Integer> paths = new LinkedList();
    public void allCombinations(int n, int k) {
        allCombinations(n, k, 1);
    }

    private void allCombinations(int n, int k, int index) {
        if (paths.size() == k) {
            res.add(new LinkedList<Integer>(paths));
            return;
        }
        for (int i = index; i <= n; i++) {
            paths.offer(i);
            allCombinations(n, k, i + 1);
            paths.removeLast();
        }
    }*/


}
