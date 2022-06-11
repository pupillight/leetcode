package org.yj.offer;

import java.util.LinkedList;
import java.util.List;

public class BackTrack {


    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> paths = new LinkedList<>();


    public void allPermutations(int[] array, int n) {
        if (paths.size() == n) {
            res.add(new LinkedList<>(paths));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if(paths.contains(array[i])){
                continue;
            }

            paths.add(array[i]);
            allPermutations(array, n);
            paths.removeLast();
        }
    }


    public void allCombinations(int[] array, int n) {
        allCombinations(array, n, 0);
    }

    private void allCombinations(int[] array, int n, int index) {
        if (paths.size() == n) {
            res.add(new LinkedList<>(paths));
            return;
        }
        for (int i = index; i < array.length; i++) {
            paths.add(array[i]);
            allCombinations(array, n, i + 1);
            paths.removeLast();
        }
    }

    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
        int[] array = {1, 2, 3};
        //backTrack.allCombinations(array, 2);
        backTrack.allPermutations(array,3);
        System.out.println();
    }
}
