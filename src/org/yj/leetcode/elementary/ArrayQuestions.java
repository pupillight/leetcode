package org.yj.leetcode.elementary;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayQuestions {

    public static int sumOddLengthSubarrays(int[] arr) {

        int left = 0, right = 0;
        int total = 0;
        int sum = 0;
        while (left <= right && right < arr.length) {
            if ((right - left + 1) % 2 == 1) {
                if (left == right) {
                    sum = sum + arr[right];
                } else {
                    sum = sum + arr[right - 1] + arr[right];
                }
                total = total + sum;
            }
            right++;
            if (right == arr.length) {
                left++;
                right = left;
                sum = 0;
            }
        }
        return total;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int a = res.get(res.size() - 1)[1];
            if (intervals[i][0] <= a) {
                int tmp = Math.max(a, intervals[i][1]);
                res.get(res.size() - 1)[1] = tmp;
            } else {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        int array[][] = res.toArray(new int[res.size()][2]);
        return array;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, "", res, 0, 0);
        return res;
    }

    private static void dfs(int n, String s, List<String> list, int left, int right) {
        if (right > left || left > n) {
            return;
        }
        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }

        dfs(n, s + "(", list, left + 1, right);
        dfs(n, s + ")", list, left, right + 1);
    }

    public static void main(String[] args) {
       /* int[] arr = {10, 11, 12};
        System.out.println(sumOddLengthSubarrays(arr));*/

      /*  int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);

        Arrays.stream(res).forEach(e -> {
            System.out.println(e[0]);
            System.out.println(e[1]);
        });*/


        List<String> list = generateParenthesis(2);
        list.stream().forEach(System.out::println);
    }
}
