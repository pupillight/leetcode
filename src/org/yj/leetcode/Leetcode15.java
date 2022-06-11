package org.yj.leetcode;

import java.util.*;

public class Leetcode15 {


    public static ArrayList<Integer> threeNumbSum1(int[] array, int value) {

        ArrayList res;
        Set<String> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == value) {
                        List<Integer> list = Arrays.asList(array[i], array[j], array[k]);
                        Collections.sort(list);
                        set.add(list.toString());
                    }
                }
            }
        }
        return res = new ArrayList(set);
    }

    public static ArrayList<Integer> threeNumbSum(int[] array, int value) {

        ArrayList res = new ArrayList();
        Set<String> set = new HashSet();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {

            if (i > 1 && array[i] == array[i - 1]) {
                continue;
            }
            int target = value - array[i];
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target) {
                    List<Integer> list = Arrays.asList(array[i], array[left], array[right]);
                    System.out.println(list);
                    res.add(list);
                    //set.add(list.toString());
                    while (array[left] == array[++left]) ;
                    while (array[right] == array[--left]) ;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            /*for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == value) {
                        List<Integer> list = Arrays.asList(array[i], array[j], array[k]);
                        Collections.sort(list);
                        set.add(list.toString());
                    }
                }
            }*/
        }
        //return res = new ArrayList(set);
        return res;
    }

    public static void main(String[] args) {
        //int[] array = {3, 1, 6, 0, 23, 6, 9, 4, 3, 5};
        int[] array = {4,9,1};
        Leetcode15 leetcode = new Leetcode15();


//        for (int i = 0; i < array.length; i++) {
//            Random random = new Random();
//            array[i] = random.nextInt(100);
//        }
//        for (int v : array) {
//            System.out.println(v);
//        }
        //int[] array = {-1, 0, 1, 2, -1, -4, 1, 1, 0};
        //System.out.println(threeNumbSum(array, 0));
        System.out.println("vvvvvvvvvvvv----------");
        // quickSort(array);
        leetcode.mergeSort(array);

        for (int v : array) {
            System.out.println(v);
        }
    }


    public void mergeSort(int[] array) {

        int[] tmpArray = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);

    }

    private void merge(int[] array, int left, int mid, int right) {
        //copy from array to tmpArray
        //int[] tmpArray= new int[array.length];
        int[] tmpArray = Arrays.copyOf(array, array.length);


        for (int i = left; i <= right; i++) {
            tmpArray[i] = array[i];
        }
        int a = left;
        int b = mid + 1;
        int i = left;

        while (a < mid + 1 && b < right + 1) {
            if (tmpArray[a] < tmpArray[b]) {
                array[i] = tmpArray[a++];
            } else {
                array[i] = tmpArray[b++];
            }
            i++;
        }

        while (a < mid + 1) {
            array[i++] = tmpArray[a++];
        }
        while (b < right + 1) {
            array[i++] = tmpArray[b++];
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
