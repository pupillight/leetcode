package org.yj.leetcode;

import java.util.Arrays;

public class LeetCode416 {

    /*private boolean f1(int target, int[] nums, int n, int[][] dp) {
        if (n >= nums.length && target != 0) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dp[n][target] != -1) {
            return dp[n][target] == 1;
        }
        boolean left = f1(target - nums[n], nums, n + 1, dp);
        boolean right = f1(target, nums, n + 1, dp);
        boolean res = left || right;
        dp[n][target] = res ? 1 : 0;
        return res;
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        int[][] memo = new int[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        boolean res = f1(target, nums, 0, memo);
        return res;

    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        int[][] dp = new int[len + 1][target + 1];
        for (int i = 1; i < len; i++) {//item
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                if (dp[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartition1(int[] nums) {

        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;

        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++) {//item
            for (int j = target; j >= nums[i]; j--) { //pack
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
*/

    public boolean canPartition5(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[][] dp = new boolean[len+1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < len; i++) {//item
            for (int j = 0; j <= target ; j++) {

                if(nums[i]>j){
                    dp[i+1][j]= dp[i][j];
                }else{
                    dp[i+1][j] = dp[i][j] || dp[i][j-nums[i]];
                }
            }
        }
        return dp[len][target];
    }
    public boolean canPartition4(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {//item
            for (int j = target; j >= nums[i]; j--) { //pack
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        int res = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        int t = dp[target];
        res = sum - t - t;
        return res;

    }

//    f(i,j)// i个数字是否可以找到和为j的子数组
//    f(i,j) = f(i-1, j-num[1]) || f(i-1,j)

    private boolean f(int[] nums, int i, int target, int[][] dp) {
        if (i < 0 && target != 0) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }
        boolean a = f(nums, i - 1, target - nums[i], dp); //selected
        boolean b = f(nums, i - 1, target, dp); // not select

        boolean res = a || b;
        dp[i][target] = res ? 1 : 0;
        return res;
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        int[][] memo = new int[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        boolean res = f(nums, len - 1, target, memo);
        return res;
    }

    public static void main(String[] args) {

        LeetCode416 instance = new LeetCode416();
        int[] nums = {1,5,11,5};
        //int[] nums = {1, 2, 3, 5, 17, 6, 14, 12, 6};
        // int[] nums = {1, 2, 3, 5};
        System.out.println(instance.canPartition5(nums));
        System.out.println(instance.canPartition4(nums));

        int[] stones = {31, 26, 33, 21, 40};
        //System.out.println(instance.lastStoneWeightII(stones));

    }
}
