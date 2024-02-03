package org.yj.leetcode;

import java.sql.Array;
import java.util.*;

public class LeetCode5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;

                }
            }
        }
        return s.substring(start, start + max);


    }

    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        String ans = "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        ans = s.substring(start, end + 1);
        return ans;
    }

    public int expandPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }

        }
        return right - left - 1;

/*        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ){
            left--;
            right++;

        }
        return right - left - 1;*/
    }

    public String solution(String text) {
        int fast = 0, slow = 0;
        //Set<String> set = new HashSet<>();

        Map<String, Integer> map = new HashMap<>();

 /*       java.util.SortedMap<String,Integer> map= new TreeMap(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }) ;*/

        int len = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String tmp = text.substring(i, j);
                if (isReversable(tmp)) {
                    //System.out.println(tmp);
                    if (map.containsKey(tmp)) {
                        map.put(tmp, Math.max(tmp.length(), map.get(tmp)));
                    }
                    map.put(tmp, tmp.length());
                }
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>((Collection<? extends Map.Entry<String, Integer>>) map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        //System.out.println(map);

        return list.get(list.size() - 1).getKey();

    }


    private boolean isReversable(String text) {
        StringBuilder builder = new StringBuilder();
        builder.append(text);
        return builder.reverse().toString().equals(text);
    }


    ////-2147483648 2147483647
    public int reverseInteger(int value) {
        int res = 0;
        while (value != 0) {

            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + value % 10;
            value = value / 10;
        }

        return res;
    }

    boolean isStop = false;


    public boolean isValidSudoku(char[][] board) {

        int len = board.length;
        int[][] rows = new int[len][9];
        int[][] cols = new int[len][9];
        int[][][] subBox = new int[3][3][9];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    rows[i][index]++;
                    cols[j][index]++;

                    subBox[i / 3][j / 3][index]++;
                    System.out.println("---"+i / 3);
                    System.out.println("---"+j / 3);
                    System.out.println("------------");
                    if (rows[i][index] > 1 || cols[j][index] > 1 || subBox[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String []args){
        LeetCode5 leetCode = new LeetCode5();

        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        leetCode.isValidSudoku(board);
        ////System.out.println(leetCode.longestPalindrome("babad"));
        //System.out.println(leetCode.longestPalindrome("cbbd"));
    }

}

//System.out.println(leetCode.reverseInteger(123));
        //System.out.println(leetCode.reverseInteger(Integer.MIN_VALUE));


      /*  Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // if(!isStop){
                while (!leetCode.isStop) {
                    try {
                        //Thread.sleep(1000);
                        // System.out.println("---");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       *//* Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                leetCode.isStop = true;
            }
        });
        thread2.start();*//*


        leetCode.isStop = true;

        System.out.println("exit");*/
