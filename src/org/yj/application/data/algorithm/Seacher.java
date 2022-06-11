package org.yj.application.data.algorithm;

public class Seacher {

    /*    public int binarySearch(int[] array, int value) {
            int index = -1;

            if (array == null || array.length == 0) {
                return index;
            }

            int left = 0;
            int right = array.length - 1;
            int pivot = (left + right) / 2;


            if (value > array[pivot]) {
                binarySearch()
            } else if (value < array[pivot]) {

            } else {
                return pivot;
            }


            return index;
        }*/
    public int binarySearch(int[] array, int value, int left, int right) {
        int index = -1;

        if (array == null || array.length == 0) {
            return index;
        }
        if (left > right) {
            return index;
        }
        int pivot = (left + right) / 2;
        if (value > array[pivot]) {
            return binarySearch(array, value, pivot + 1, right);
        } else if (value < array[pivot]) {
            return binarySearch(array, value, left, pivot - 1);
        } else {
            return pivot;
        }
    }

    public static void main(String[] args) {

        Seacher seacher = new Seacher();
        int[] array = {1, 2, 5, 9, 19};
        int index = seacher.binarySearch(array, 19, 0, array.length - 1);
        System.out.println(index);
        System.out.println(array[index]);
    }
}
