package org.yj.leetcode.dp;

import java.util.Arrays;

public class Leetcode2787 {
    public int numberOfWays1(int n, int x) {
        final int MODULO = 1000000007;
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < x; j++) {
                nums[i] *= i;
            }
        }

        int[] dp = new int[n + 1];
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = (int) nums[i];
            for (int j = n; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MODULO;
            }
        }
        ans = dp[n];
        return ans;
    }

    public int numberOfWays2(int n, int x) {
        final int MODULO = 1000000007;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < x; j++) {
                nums[i - 1] *= i;
            }
        }

/*        int arr[] = new int[n];
        final int MODULO = 1000000007;
        Arrays.fill(arr, 1);
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                arr[i - 1] = arr[i - 1] * i;
            }
            if (arr[i - 1] > n) {
                index = i - 1;
                break;
            }
        }
        int[] nums = arr;
        if (index > 0) {
            nums = Arrays.copyOfRange(arr, 0, index);
        }
*/
        int len = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0;
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= n; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - num]) % MODULO;
                }
            }
        }
        ans = dp[len][n];
        return ans;
    }

    public int numberOfWays(int n, int x) {
        final int MODULO = 1000000007;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < x; j++) {
                nums[i - 1] *= i;
            }
        }

        int len = nums.length;
        int[][] dp = new int[len + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - num]) % MODULO;
                }
            }
        }
        int ans = dp[n][n];
        return ans;
    }

    public int numberOfWays3(int n, int x) {
        final int MODULO = 1000000007;
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = (int) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - num]) % MODULO;
                }
               /* dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] =  (dp[i][j]+dp[i - 1][j - num])%MODULO;
                }*/
            }
        }
        int ans = dp[n][n];
        return ans;
    }

    public int numberOfWays34(int n, int x) {
        final int MODULO = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = (int) Math.pow(i, x);
            for (int j = n; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MODULO;
            }
        }
        int ans = dp[n];
        return ans;
    }

    public int numSquares2(int n) {
        int[] nums = new int[n + 1];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            nums[i] = i * i;
            if (nums[i] >= n) {
                index = i;
                break;
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= index; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        int index = 0;
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * i;
            if (nums[i] >= n) {
                index = i;
                break;
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= index; i++) {
            int num = nums[i];
            for (int j = 0; j <= n; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - num] + 1);
                }
            }
        }
        return dp[index][n];

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp/**/, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int t = (int) Math.pow(i, 2);
           // int t = i * i;
            for (int j = t; j <= n; j++) {
                if (t > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - t] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Leetcode2787 instance = new Leetcode2787();
        System.out.println(instance.numSquares1(12));
        System.out.println(instance.numSquares(12));
        //System.out.println(instance.numberOfWays2(74, 5));
        //System.out.println(instance.numberOfWays(7, 1));
        // System.out.println(instance.numberOfWays3(7, 1));

    }
}
