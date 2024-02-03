package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode685 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        // List<Integer>[] adj = new List[len + 1];

        int[] inDegree = new int[len + 1];
        int[] outDegree = new int[len + 1];
        UFind uf = new UFind(len + 1);
        List<int[]> res = new ArrayList<>();
        for (int[] edge : edges) {
            // adj[edge[0]].add(edge[1]);
            // adj[edge[1]].add(edge[0]);
            int p = edge[0];
            int q = edge[1];
            outDegree[p]++;
            inDegree[q]++;
            if (!uf.isConnect(p, q)) {
                uf.union(p, q);
            } else {
                inDegree[q]--;
                outDegree[p]--;

                res.add(new int[]{p, q});
            }
        }

        int count = 0;
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) count++;
        }
        if (count == 1) {
            return res.get(res.size() - 1);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        LeetCode685 instance = new LeetCode685();
        //int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[][] edges = {{ 2,1}, { 3,1}, { 4,2}, { 1,4}};
        Arrays.stream(instance.findRedundantDirectedConnection(edges)).forEach(System.out::println);
    }
}

class UFind {
    int[] parents;

    int count;

    public UFind(int n) {
        count = n;
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;

        }
    }

    public int find(int p) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return p;
    }

    public boolean isConnect(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        parents[pRoot] = qRoot;

        count--;
    }

}
