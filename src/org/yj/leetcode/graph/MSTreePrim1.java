package org.yj.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MSTreePrim1 {


    public void calculateMST(int[][] array) {

        //set 0 as the start vertex
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int len = array.length;
        boolean[] visited = new boolean[len];

        int start =0;
        for (int m = 0; m < len; m++) {
            list.add(start);
            visited[m]=true;
            int val = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < len; j++) {
                    if (!visited[j] && array[list.get(i)][j] > 0 && array[list.get(i)][j] < val) {
                        start =j;
                        val = array[list.get(i)][j];
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

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
        MSTreePrim1 msTree = new MSTreePrim1();
        msTree.calculateMST(arr);
    }
}
