package org.yj.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MSTreePrim {


    public void calculateMST(int[][] array) {


        int len = array.length;
        boolean[] visited = new boolean[len];
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        visited[0] = true;
        // select O as the first vertex and then all edges to queue
        for (int i = 0; i < len; i++) {
            if (array[0][i] != 0) {
                queue.add(new Integer[]{0, i, array[0][i]});
            }
        }

        List<Integer[]> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            //select the shortest edge
            Integer[] edge = queue.poll();
            int end = edge[1];
            if (visited[end]) {
                continue;
            }
            visited[end] = true;
            list.add(edge);

            //find the end of shortest edge and put all edges into queue
            for (int i = 0; i < len; i++) {
                if (array[end][i] != 0) {
                    queue.add(new Integer[]{end, i, array[end][i]});
                }
            }
        }
        list.stream().sorted((e1, e2) -> e1[2] - e2[2]).forEach(e -> {
            System.out.println("start:" + e[0] + " end:" + e[1] + " dist:" + e[2]);
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
        MSTreePrim msTree = new MSTreePrim();
        msTree.calculateMST(arr);
    }
}
