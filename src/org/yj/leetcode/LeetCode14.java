package org.yj.leetcode;

import java.util.Arrays;

public class LeetCode14 {

    public String getLongestCommonPrefix1(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        return getLongestCommonPrefix1(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array) {

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        sort(array, left, mid, right);

    }

    private void sort(int[] array, int left, int mid, int right) {
        //int k = right - left + 1;
        int k = array.length;
        int[] tmp = new int[k];
        //Arrays.copyOfRange(array,left,right);
        for (int i = 0; i <k; i++) {
            tmp[i] = array[i];
        }

        int a = left, b = mid + 1;
        int i = left;
        while (a < mid + 1 && b < right + 1) {
            if (tmp[a] < tmp[b]) {
                array[i++] = tmp[a++];

            } else {
                array[i++] = tmp[b++];
            }
        }

        while(a<mid+1)
        {
            array[i++] =tmp[a++];
        }
        while(b<right+1)
        {
            array[i++] =tmp[b++];
        }

    }


    private String getLongestCommonPrefix1(String[] array, int left, int right) {
        if (left >= right) {
            return array[left];
        }
        String res = "";
        int mid = (left + right) / 2;
        String strA = getLongestCommonPrefix1(array, left, mid);
        String strB = getLongestCommonPrefix1(array, mid + 1, right);
        res = getCommonPrefix(strA, strB);
        return res;
    }


    public String getLongestCommonPrefix(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        String res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = getCommonPrefix(res, array[i]);
            if (res.length() == 0) {
                break;
            }
        }
        return res;
    }

    private String getCommonPrefix(String a, String b) {
        String res = "";
        int i = Math.min(a.length(), b.length());

        int j = 0;
        while (j < i && a.charAt(j) == b.charAt(j)) {
            j++;
        }
        res = a.substring(0, j);
        return res;
    }

    public static void main(String[] args) {
        LeetCode14 leetCode = new LeetCode14();
        String[] array = {"flight", "fly", "film"};
       // System.out.println(leetCode.getLongestCommonPrefix1(array));


        int[] array1={10,5,6,9,-1,5};
       // int[] array1={9,34,5,10,5};
        leetCode.mergeSort(array1);
        System.out.println(Arrays.toString(array1));

    }
}
