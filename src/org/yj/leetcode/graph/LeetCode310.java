package org.yj.leetcode.graph;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode310 {

    List<Integer>[] adj;

    boolean[] visited;

    int min = Integer.MAX_VALUE;

    Set<Integer> ans = new HashSet<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, 0);
                // System.out.println(h);
            }
        }
        return ans.stream().collect(Collectors.toList());

    }

    private void dfs(int v, int height) {

        if (visited[v] == true) {
            return;
        }
        visited[v] = true;
        for (Integer w : adj[v]) {
            dfs(w, height + 1);
            if (height != 0 && min > height) {
                min = height;
                ans.add(v);
            } else if (min == height) {
                ans.add(v);
            }
        }
    }


    public int commonDivisor(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            return b;
        }
        return commonDivisor(b, a % b);
    }

    public int commonMultiple(int a, int b) {
        return a * b / commonDivisor(a, b);
    }

    public int commonMultiple(int[] arr) {

        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int res = commonMultiple(a, a + 1);
        for (int i = a + 2; i <= b; i++) {
            res = commonMultiple(res, i);
        }
        return res;

    }

    public String convertToRoman(int num) {
        int[] arabics = {1000,   900, 500,  400, 100,  90,   50,  40,  10,   9,   5,    4,    1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "Xl", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            while (num >= arabics[i]) {
                res.append(romans[i]);
                num = num - arabics[i];

            }
            if(num==0){
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode310 instance = new LeetCode310();

        System.out.println(instance.convertToRoman(44));
        System.out.println(instance.convertToRoman(45)); System.out.println(instance.convertToRoman(649));

        //System.out.println(instance.commonDivisor(6, 7));
        // System.out.println(instance.commonMultiple(6, 7));

        //System.out.println(instance.commonMultiple(new int[]{2, 10}));
        /*        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(instance.findMinHeightTrees(n, edges));*/
    }
}
