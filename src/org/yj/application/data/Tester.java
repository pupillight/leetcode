package org.yj.application.data;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 7, 9};

        //Arrays.stream(arr).sorted().forEach(System.out::println);
        Tester tester = new Tester();
        tester.mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid - 1);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int len = end - start + 1;
        int index = 0;
        int[] tmp = new int[len];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= end) {
            tmp[index++] = arr[j++];
        }
        for (int k = 0; k < len; k++) {
            arr[start + k] = tmp[k];
        }
    }
}
