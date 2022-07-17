package org.yj.leetcode;

import java.util.Arrays;

public class DPQuestions {

    /* public int fib(int n) {
         if (n == 0) {
             return 0;
         }
         int[] dp = new int[n + 1];
         dp[0] = 0;
         dp[1] = 1;

         for (int i = 2; i <= n; i++) {
             dp[i] = dp[i - 1] + dp[i - 2];
         }

         return dp[n];
     }*/

    public int fib(int n) {
        int[] dp = new int[n + 1];
        return fib(n, dp);
    }

    private int fib(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        if (n == 0) {
            ans = 0;
        } else if (n == 1) {
            ans = 1;
        } else {
            ans = fib(n - 1, dp) + fib(n - 2, dp);
        }
        dp[n] = ans;
        return ans;
    }


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];
                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }
    /*public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        return max;
    }*/


    public int robotWalk1(int start, int end, int k, int n) {
        return process1(start, end, k, n);
    }

    /**
     * @param start 出发点
     * @param end   目标点
     * @param k     剩余步数
     * @param n     多少个数
     * @return
     */
    private int process1(int start, int end, int k, int n) {
        if (k == 0) {
            return start == end ? 1 : 0;
        }
        if (start == 1) {
            return process1(2, end, k - 1, n);
        }
        if (start == n) {
            return process1(n - 1, end, k - 1, n);
        }
        return process1(start - 1, end, k - 1, n) + process1(start + 1, end, k - 1, n);
    }


    public int robotWalk(int start, int end, int k, int n) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process(start, end, k, n, dp);
    }

    private int process(int start, int end, int k, int n, int[][] dp) {
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        if (k == 0) {
            dp[start][k] = start == end ? 1 : 0;
            return dp[start][k];
        }
        if (start == 1) {
            dp[start][k] = process(2, end, k - 1, n, dp);
            return dp[start][k];
        }
        if (start == n) {
            dp[start][k] = process(n - 1, end, k - 1, n, dp);
            return dp[start][k];
        }
        dp[start][k] = process(start - 1, end, k - 1, n, dp) + process(start + 1, end, k - 1, n, dp);
        return dp[start][k];
    }
   /* private int process(int start, int end, int k, int n, int[][] dp) {
//       if (start < 1 || k < 0 || end > n || end < 1 || n < 1) {
//            return 0;
//        }

        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int ans = 0;
        if (k == 0) {
            ans = start == end ? 1 : 0;
        } else if (start == 1) {
            ans = process(2, end, k - 1, n, dp);
        } else if (start == n) {
            ans = process(n - 1, end, k - 1, n, dp);
        } else {
            ans = process(start - 1, end, k - 1, n, dp) + process(start + 1, end, k - 1, n, dp);
        }
        dp[start][k] = ans;
        return ans;
    }*/

    public static void main(String[] args) {
        DPQuestions questions = new DPQuestions();

        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {1};
        //System.out.println(questions.maxSubArray(nums));
        System.out.println(questions.fib(2));
        System.out.println(questions.robotWalk1(2, 4, 4, 4));
        System.out.println(questions.robotWalk(2, 4, 4, 4));
    }

}
