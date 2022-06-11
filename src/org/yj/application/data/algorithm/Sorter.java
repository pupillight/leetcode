package org.yj.application.data.algorithm;

import java.util.Arrays;

public class Sorter {


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
        int[] tmpArray = Arrays.copyOf(array, array.length);
/*        for (int i = left; i <= right; i++) {
            tmpArray[i] = array[i];
        }*/
        int a = left;
        int b = mid + 1;
        int i = left;

        while (a < mid + 1 && b < right + 1) {
            if (tmpArray[a] <= tmpArray[b]) {
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
/*
    public int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);

    }

    public int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
             return new int[]{array[left]};
        }
        int mid = (left + right) / 2;
        int[] leftArray= mergeSort(array, left, mid);
        int[] rightArray= mergeSort(array, mid + 1, right);

        return  sort(leftArray,rightArray);

        //sort(array, left, right);


    }

    private int[] sort(int[] arrayA, int[] arrayB) {
        int i = 0, j = 0, m = 0;
        int[] array = new int[arrayA.length + arrayB.length];
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] < arrayB[j]) {
                array[m] = arrayA[i];
                i++;
            } else {
                array[m] = arrayB[j];
                j++;
            }
            m++;
        }


        while (i < arrayA.length) {
            array[m] = arrayA[i];
            i++;
            m++;
        }
        while (j < arrayB.length) {
            array[m] = arrayB[j];
            j++;
            m++;
        }

        return array;

    }*/


    public void selectSort(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int firstElement = array[j];
            int minElement = array[j];
            int minElementIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (minElement > array[i]) {
                    minElement = array[i];
                    minElementIndex = i;
                }
            }
            array[j] = array[minElementIndex];
            array[minElementIndex] = firstElement;
            System.out.println(minElement);
            //System.out.println(minElementIndex);
            // System.out.println(Arrays.toString(array));
        }
    }


    public int minElement(int[] array) {
        return minElement(array, 0);
    }

    private int minElement(int[] array, int i) {
        if (i == array.length - 1) {
            return array[array.length - 1];
        }
        int tmp = minElement(array, i + 1);
        if (array[i] < tmp) {
            return array[i];
        } else {
            return tmp;
        }
    }


    public int[] plusOne(int[] array) {
        int carry = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int tmp = array[i] + carry;
            if (i == array.length - 1) {
                tmp++;
            }
            if (tmp == 10) {
                carry = 1;
                array[i] = 0;
            } else {
                array[i] = tmp;
                return array;
            }
        }

        //int[] newArray= new int[array.length+1];
        array = new int[array.length + 1];

        array[0] = 1;


        return array;


    }
//
//    public int sum(int[] array) {
//        return sum(array, 0);
//    }
//
//    private int sum(int[] array, int i) {
//        if (i == array.length) {
//            return 0;
//        }
//        int tmp = sum(array, i + 1);
//        return array[i] + tmp;
//
//
//    }


    public int binarySearch(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        Arrays.sort(array);
        return binarySearch(array, left, right, target);
    }

    private int binarySearch(int[] array, int left, int right, int target) {

        if (left > right) {
            return -1;
        }
        int m = (left + right) / 2;
        if (array[m] > target) {
            right = m - 1;
            return binarySearch(array, left, right, target);
        } else if (array[m] < target) {
            left = m + 1;
            return binarySearch(array, left, right, target);
        } else {
            return m;
        }
    }


//    public int binarySearch(int[] array, int target) {
//        if (array == null || array.length == 0) {
//            return -1;
//        }
//        Arrays.sort(array);
//        int i = 0;
//        int j = array.length - 1;
//
//        while (i <= j) {
//            int m = (i + j) / 2;
//
//            if (array[m] == target) {
//                return m;
//            } else if (array[m] > target) {
//                j = m - 1;
//            } else {
//                i = m + 1;
//            }
//        }
//        return -1;
//    }


    public int sum(int[] array) {

        return sum(1, array);
    }

    private int sum(int i, int[] array) {

        if (i == array.length) {
            return 0;
        }

        int res = array[i] + sum(i + 1, array);
        return res;

    }


    public int arraySum(int[] array) {
        return arraySum(array, array.length - 1);
    }

    private int arraySum(int[] array, int i) {

        if (i < 0) {
            return 0;
        }
        return array[i] + arraySum(array, i - 1);

    }


    public String strSum(String s1, String s2) {
        StringBuilder builder = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int c1 = i < 0 ? 0 : s1.charAt(i) - '0';
            int c2 = j < 0 ? 0 : s2.charAt(j) - '0';
            int sum = (c1 + c2 + carry);
            carry = sum / 2;
            builder.append(sum % 2);
            i--;
            j--;

        }
        if (carry == 1) {
            builder.append(1);
        }

//
//        while (i >= 0) {
//            int c1 = s1.charAt(i) - '0' + carry;
//            carry = c1 / 10;
//            c1 = c1 % 10;
//            builder.append(c1);
//            i--;
//        }
//        while (j >= 0) {
//            int c2 = s2.charAt(j) - '0' + carry;
//            carry = c2 / 10;
//            c2 = c2 % 10;
//            builder.append(c2);
//            j--;
//        }


        return builder.reverse().toString();
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = array[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            if (i != j) {
                swap(array, i, j);
            }
        }
        swap(array, left, i);
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        // System.out.println(sorter.strSum("101", "1"));
        //

        int[] b = {1, 9, 5, 4, 7, -1, 19, 2};
        //int[] b = {1, 9, 5};
        //System.out.println(sorter.sort(a,b));
        //sorter.mergeSort(b);
        sorter.quickSort(b);
        for (int v : b) {
            System.out.println(v);
        }
        //System.out.println();
    }

}
