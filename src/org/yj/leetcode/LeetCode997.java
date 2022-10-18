package org.yj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode997 {
    List<Integer>[] adj;


    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for (int i = 0; i < trust.length; i++) {
            int a  =trust[i][0];
            int b =trust[i][1];
            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for (int i = 1; i < n+1; i++) {
            if (inDegree[i] == n-1 && outDegree[i]==0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LeetCode997 instance = new LeetCode997();
        int[][] trust = {{1,3},{2,3},{3,1}};

        System.out.println(instance.findJudge(3, trust));

    }
}
