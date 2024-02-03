package org.yj.leetcode;

import java.util.*;

public class LeetCode2914 {
    List<Integer>[] adj;
    boolean[] visited;

    int[] inDegree;

    public int findChampion(int n, int[][] edges) {

        adj = new List[n];
        inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                count++;
            }
        }

        if (count == 1) {
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i]==0) return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        LeetCode2914 instance = new LeetCode2914();
       /* int[][] edges= {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(instance.validPath(6, edges, 0, 5));*/
        /*int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(instance.validPath(3, edges, 0, 2));*/



        //int[][] edges = {{0, 2}, {1, 3}, {1, 2}};
        int[][] edges = {{0, 1}, {1, 2}};
        System.out.println(instance.findChampion( 3, edges));
    }
}
