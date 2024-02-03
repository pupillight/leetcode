package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode1319 {

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (len < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        int lineCount = 0;
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            if (unionFind.isConnect(p, q)) {
                lineCount++;
            } else {
                unionFind.union(p, q);
            }
        }
        int count = unionFind.count;
        if (lineCount == count - 1) {
            return count - 1;
        }
        return -1;
       // int res = lineCount >= count - 1 ? count - 1 : -1;
        //return res;
        /*if ((count - 1) == lineCount) {
            return lineCount;
        }sss
        return -1;*/
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int count;

        public UnionFind(int n) {
            count = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
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
            if (size[pRoot] >= size[qRoot]) {
                parents[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parents[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            count--;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        Leetcode1319 instance = new Leetcode1319();
        System.out.println(instance.makeConnected(n, connections));
    }


}