package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPQuestions {

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int maxProfit1(int[] prices) {

        int min =Integer.MAX_VALUE;
        int profit=0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }

            if( prices[i]-min>profit){
                profit =prices[i]-min;
            }

        }

        return profit;
    }
    public int maxProfit(int[] prices) {

       int len = prices.length;
       int[][] dp = new int[len][2];
       dp[0][0]=0;
       dp[0][1]= - prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0]= Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],  -prices[i]);
            //dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        int res =dp[len-1][0]>dp[len-1][1]?dp[len-1][0]:dp[len-1][1];
        return res;

    }

    public int massage1(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = 0;
        //f(x) = Max(f(x-2)+nums[x],f(x-1))
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }

        return max;

    }


    public int massage(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return massage(nums, nums.length - 1);
    }

    public int massage(int[] nums, int n) {

        if (n < 0) {
            return 0;
        }
        /*if (n == 0) {
            return nums[0];
        }*/

        int max = 0;
        max = Math.max(massage(nums, n - 2) + nums[n], massage(nums, n - 1));
        return max;

    }

    public List<List<Integer>> generate(int numRows) {

        int len = numRows;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    list.add(dp[i][j]);
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    if (dp[i][j] != 0) list.add(dp[i][j]);
                }

            }
            ans.add(list);
        }
        return ans;
    }


    public int stealMaxValue(int capacity) {
        int[] W = {0, 2, 3, 4, 5};
        int[] V = {0, 3, 4, 5, 8};
        int len = 5;
        int[][] dp = new int[len][capacity + 1];


        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 9; j++) {
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        return dp[4][8];
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int[] dp = new int[nums.length];
        if (nums[0] % 2 == 0 && nums[0] <= threshold) {
            dp[0] = 1;
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] == 0) {
                if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                if (nums[i - 1] % 2 != nums[i] % 2 && nums[i] <= threshold) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                        dp[i] = 1;
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == s.length()) return true;
        return false;
     /*   for (int i = 0; i < s.length(); i++) {

            int index =t.indexOf(s.charAt(i));
            if(index>-1){
                t=t.substring(index+1);
            }else{
                return false;
            }

        }
        return true;*/
    }

    public int getMaximumGenerated(int n) {
        int res = -1;
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int t = i / 2;
            if (i % 2 == 0) {
                dp[i] = dp[t];
            } else {
                dp[i] = dp[t] + dp[t + 1];
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public List<Integer> getRow(int rowIndex) {

        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            dp[0][0] = 1;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }

            }
        }

        for (int i = 0; i < dp[rowIndex].length; i++) {
            list.add(dp[rowIndex][i]);
        }

        return list;
    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }

                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }


    public int waysToChange(int n) {

        // f(i) = f(i-w) 0<=1<=n 最多有多少种表示方法

        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = dp[i - coins[j]] + dp[i];
                }

            }
        }
        return dp[n];

    }

    public int minimumCoins(int[] prices) {

        int[][] dp = new int[prices.length][2];
        dp[0][0] = Integer.MAX_VALUE;
        dp[0][1] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + prices[i];
        }
        int len = prices.length - 1;
        int res = dp[len][0] < dp[len][1] ? dp[len][0] : dp[len][1];
        return res;
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, end = 0, max = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 > 2) {
                        if (dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                            if (j - i + 1 > max) {
                                start = i;
                                end = j;
                                max = j - i + 1;
                            }
                        }
                    } else if (j - i + 1 == 2) {
                        if (dp[i][j - 1] == true) {
                            dp[i][j] = true;
                            if (j - i + 1 > max) {
                                start = i;
                                end = j;
                                max = j - i + 1;
                            }

                        }
                    }

                }
            }
        }


        return s.substring(start, end + 1);
    }
    public int longestPalindromeSubseq(String s) {

        int len = s.length();
        if(len<2)
        {
            return 1;
        }
       int  max = 1;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else{
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > max) {

                    max = j - i + 1;

                }
            }
        }
        return max;
    }


    public String longestPalindrome1(String s) {

        int len = s.length();
        if(len<2)
        {
            return s;
        }
        int start = 0,   max = 1;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i + 1][j - 1] == true)
                            dp[i][j] = true;
                    }
                }
                else{
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;
                    System.out.println("start="+start);
                    System.out.println("max="+max);
                }
            }
        }
        return s.substring(start, start + max);
    }


    public boolean divisorGame(int n) {

        if(n==1)
        {
            return false;
        }
        return divisorGame(n-1);
    }


    public static void main(String[] args) {
        DPQuestions questions = new DPQuestions();

      /*  int[] price = {26, 18, 6, 12, 49, 7, 45, 45};
        System.out.println(questions.minimumCoins(price));*/

       // System.out.println(questions.longestPalindrome1("babad"));
        // System.out.println(questions.longestPalindrome("cbbd"));
       /* int[] coins = {1, 2, 5};
        System.out.println(questions.coinChange(coins, 4));*/
        /*int[] nums = {4, 10, 3};
        System.out.println(questions.longestAlternatingSubarray(nums, 10));
*/
       /* String s = "bb";
        String t = "ahbgdc";
        System.out.println(questions.isSubsequence(s, t));*/

        //System.out.println(questions.getMaximumGenerated(0));

        //int[] nums = {0, 1, 0, 3, 2, 3};
        //System.out.println(questions.lengthOfLIS(nums));
        //System.out.println(questions.stealMaxValue(8));

        //System.out.println(questions.generate(3));
        //int[] num = {2, 1, 4};
        //System.out.println(questions.massage(num));
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {1};
        //System.out.println(questions.maxSubArray(nums));
        //System.out.println(questions.climbStairs(3));
        //System.out.println(questions.uniquePaths(3, 7));
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(questions.maxProfit(prices));

    }

}
