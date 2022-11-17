package org.yj.application.data.algorithm;

public class DP {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            dp[0] = 0;
        } else if (n == 1) {
            dp[1] = 1;
        } else {
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
            }
        }
        return dp[n];
    }

    /* int[] res;
     public int fib(int n) {
         res = new int[n + 1];
         return fib(n, res);
     }

     private int fib(int n, int[] res) {
         if (res[n] > 0) {
             return res[n];
         }
         if (n == 0) {
             res[0] = 0;
         } else if (n == 1) {
             res[1] = 1;
         } else {
             res[n] = (fib(n - 1, res) + fib(n - 2, res))%1000000007;
         }
         return res[n];

     }
 */
    public static void main(String[] args) {
        DP dp = new DP();
        System.out.println(dp.fib(5));
    }
}
