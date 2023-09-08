package org.yj.leetcode.graph;

import java.util.*;

public class MSTree {

    private int find(int p, int[] parents) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return parents[p];
    }

    private boolean isConnected(int p, int q, int[] parents) {
        return find(p, parents) == find(q, parents);
    }

    private void union(int p, int q, int[] parents) {
        int pRoot = find(p, parents);
        int qRoot = find(q, parents);
        if (pRoot == qRoot) return;
        parents[pRoot] = qRoot;
    }

    public void calculateMST(int[][] array) {
        int len = array.length;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
        int[] parents = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (array[i][j] != 0) {
                    queue.add(new Integer[]{array[i][j], i, j});
                }
            }
        }
        for (int i = 0; i < len; i++) {
            parents[i] = i;
        }

        List<Integer[]> list = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty() && count != len - 1) {
            Integer[] edge = queue.poll();
            int start = edge[1];
            int end = edge[2];
            if (isConnected(start, end, parents)) continue;
            union(start, end, parents);
            count++;
            list.add(edge);
        }

        list.forEach(e -> {
            System.out.println("start:" + e[1] + " end:" + e[2] + " dist:" + e[0]);
        });
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                // 0  1  2  3  4  5  6  7  8
                {-0, 4, 0, 0, 0, 0, 0, 7, 0},
                {4, -0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, -0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, -0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, -0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, -0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, -0, 1, 6},
                {7, 11, 0, 0, 0, 0, 1, -0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, -0}
        };
        MSTree msTree = new MSTree();
        msTree.calculateMST(arr);
    }
}
