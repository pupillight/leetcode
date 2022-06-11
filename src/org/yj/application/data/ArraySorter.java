package org.yj.application.data;

public class ArraySorter {

    public static void main(String[] args) {
        ArraySorter sorter
                = new ArraySorter();
        //int[] nums = {4, 9, 3};
        int[] nums={ 1, 6, 4, 5, 2, 9, 7, 23, 56, 43, 99 };
        sorter.mergeSort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        mergeElements(array, left, mid, right);
    }

    private void mergeElements(int[] array, int left, int mid, int right) {
        int[] tmpArray = new int[array.length];
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmpArray[t++] = array[i++];
            } else {
                tmpArray[t++] = array[j++];
            }
        }
        while (i <= mid) {
            tmpArray[t++] = array[i++];
        }
        while (j <= mid) {
            tmpArray[t++] = array[j++];
        }
        for (int m = 0; m < t; m++) {
            array[left + m] = tmpArray[m];
        }
/*
        //int[] tmpArray = new int[right-left+1];
        int[] tmpArray = new int[array.length];
        int t = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmpArray[t++] = array[i++];
            } else {
                tmpArray[t++] = array[j++];
            }
        }
        while (i <= mid) {
            tmpArray[t++] = array[i++];
        }
        while (j <= right) {
            tmpArray[t++] = array[j++];
        }

        for (int m = 0; m < t; m++) {
            array[m + left] = tmpArray[m];
        }*/
    }

}
