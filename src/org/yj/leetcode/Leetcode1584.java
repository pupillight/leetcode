package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode1584 {

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
            parents[qRoot] = pRoot;
            count--;
        }
    }

    class Edge {
        public int start;
        public int end;
        public int w;

        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int len = points.length;
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] pointA = points[i];
                int[] pointB = points[j];
                int w = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                Edge edge = new Edge(i, j, w);
                queue.add(edge);
            }

        }

        UnionFind uf = new UnionFind(len);
        int count = 0;
        int res = 0;
        while (!queue.isEmpty() && count <= len - 1) {

            Edge edge = queue.poll();
            int start = edge.start;
            int end = edge.end;
            if (!uf.isConnect(start, end)) {
                count++;
                uf.union(start, end);
                res += edge.w;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Leetcode1584 instance = new Leetcode1584();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(instance.minCostConnectPoints(points));

    }


}