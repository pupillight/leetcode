package org.yj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56 {

    public ArrayList<int[]> mergeInterval(int[][] array) {

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];

            }
        });

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int[] currArray = array[i];
            if (list.isEmpty()) {
                list.add(currArray);
            } else {
                int[] lastArray = list.get(list.size() - 1);
                //没有重叠
                if (lastArray[1] < currArray[0]) {
                    list.add(currArray);
                } else//有重叠
                {
                    lastArray[1] = Math.max(lastArray[1], currArray[1]);
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        LeetCode56 leetCode = new LeetCode56();

        int[][] array = {{2, 9}, {1, 3}, {1, 15}};
        leetCode.mergeInterval(array);
    }
}
