package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        int index = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + triangle.get(i).get(j));
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][j] + triangle.get(i).get(j + 1));
            }
        }

        int res = Arrays.stream(dp[len - 1]).min().getAsInt();
        return res;

    }


    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) {
                    dp[i][j - 1] = Math.min(dp[i][j - 1], dp[i - 1][j] + matrix[i][j - 1]);
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);

                if (j + 1 < n) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i - 1][j] + matrix[i][j + 1]);
                }
            }
        }


        int res = Arrays.stream(dp[n - 1]).min().getAsInt();
        return res;


    }

    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }


    public int maxVowels(String s, int k) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (set.contains(chars[i])) {
                count++;
            }
            builder.append(chars[i]);
        }

        int res = count;
        for (int i = k; i < chars.length; i++) {
            char start = chars[i - k];
            char end = chars[i];
            builder.deleteCharAt(0);
            if (set.contains(start)) {
                count--;
            }
            builder.append(chars[i]);
            if (set.contains(end)) {
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public long maximumSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            sum = sum + nums[i];
        }
        long res = 0;

        if (map.size() == k) {
            //sum = map.entrySet().stream().map(entry->entry.getKey()).collect(Collectors.summingInt(item->item.intValue())).intValue();

            res = sum;
        }


        for (int i = k; i < nums.length; i++) {

            if (map.containsKey(nums[i - k])) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum = sum - nums[i - k] + nums[i];
            if (map.size() == k) {
                // sum = map.entrySet().stream().map(entry->entry.getKey()).collect(Collectors.summingInt(item->item.intValue())).intValue();
                res = Math.max(res, sum);
            }

        }
        return res;
    }

    boolean compareArrays(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        int len = s1.length();
        if (s2.length() < len) {
            return false;
        }
        int arr1[] = new int[26];
        int[] arr2 = new int[26];


        for (int i = 0; i < len; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (compareArrays(arr1, arr2)) {
            return true;
        }

        for (int i = len; i < s2.length(); i++) {
            arr2[s2.charAt(i - len) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
            if (compareArrays(arr1, arr2)) {
                return true;
            }
        }
        return false;

    }
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum=0;
        int max=0;
        for (int i = len-k; i <len ; i++) {
            sum+=cardPoints[i];
        }
        max= sum;

        for (int i = len; i < len+k; i++) {
            sum = sum-cardPoints[i-k];
            sum = sum+cardPoints[i%len];

            max = Math.max(max,sum);
        }
        return max;
    }


    public int maxScore1(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] arr = new int[len * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cardPoints[i % len];
        }


        int mid = len;
        int sum=0;
        int max=0;
        for(int i= len-k;i<len;i++){
            sum+=arr[i];
        }
        max= sum;
        for (int i = len; i < len+k; i++) {
            sum = sum-arr[i-k];
            sum = sum+arr[i];

            max = Math.max(max,sum);
        }
        return max;
    }


    public static void main(String[] args) {
        LeetCode120 instance = new LeetCode120();

        //int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int[] cardPoints = {11, 49, 100, 20, 86, 29, 72};
        int k = 4;
        System.out.println(instance.maxScore(cardPoints, k));
        // System.out.println(instance.checkInclusion("ab", "eidbaooo"));
        //int[] nums = {9, 9, 9, 1, 2, 3};
      /*  int[] nums = {9, 9, 9};
        //int[] nums = { 3};
        int k = 3;
        System.out.println(instance.maximumSubarraySum(nums, k));*/
        //System.out.println(instance.maxVowels("abciiidef", 3));
/*

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(List.of(-1));
        triangle.add(List.of(2, 3));
        triangle.add(List.of(1, -1, -3));
        System.out.println(instance.minimumTotal(triangle));
*/


        //int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        //int[][] matrix = {{17, 82}, {1, -44}};
        //System.out.println(instance.minFallingPathSum(matrix));
    }
}
