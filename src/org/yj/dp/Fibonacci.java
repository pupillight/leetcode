package org.yj.dp;

public class Fibonacci {

    public int function(int n) {
        if (n == 1) {
            return 1;
        }
        return n * function(n - 1);
    }


    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = fibonacci(n - 1) + fibonacci(n - 2);
        return res;
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public int climbStairs1(int n) {

        int[] result = new int[n];
        return climbStairs(n, result);


    }

    private int climbStairs(int n, int[] result) {

        if (n == 1) {
            result[n - 1] = 1;
            return 1;
        }
        if (n == 2) {
            result[n - 1] = 2;
            return 2;
        }

        if (result[n - 1] == 0) {
            result[n - 1] = climbStairs(n - 1, result) + climbStairs(n - 2, result);
        } else {
            return result[n - 1];
        }

        return result[n - 1];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        // System.out.println(fibonacci.function(10));
        //System.out.println(fibonacci.fibonacci(4));

        System.out.println(fibonacci.climbStairs(5));
    }
}
