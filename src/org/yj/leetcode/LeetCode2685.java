package org.yj.leetcode;

import java.util.*;

public class LeetCode2685 {

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            list[p].add(q);
            uf.union(p, q);
        }

        //每一个连通图有多少个点
        Map<Integer, Integer> nodeMap = new HashMap<>();
        Map<Integer, Integer> edgeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            nodeMap.put(root, nodeMap.getOrDefault(root, 0) + 1);
            edgeMap.put(root, edgeMap.getOrDefault(root, 0) + list[i].size());

        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : nodeMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int count = value * (value - 1) / 2;
            if (count == edgeMap.get(key)) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        LeetCode2685 instance = new LeetCode2685();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(instance.countCompleteComponents(n, edges));
    }
}

class UnionFind {
    int[] parents;

    int count;

    public UnionFind(int n) {
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
