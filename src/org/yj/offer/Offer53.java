package org.yj.offer;

public class Offer53 {


    public int numberCount(int[] array, int target) {
        int i = 0, j = array.length - 1;
        int index = -1;
        int count = 0;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (array[mid] == target) {
                index = mid;
                count = 1;
                break;
            } else if (array[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        i = index - 1;
        j = index + 1;

        while (i >= 0 && array[index] == array[i]) {
            count++;
            i--;
        }
        while (j < array.length && array[index] == array[j]) {
            count++;
            j++;
        }
        return count;
    }


    public int findLostNumber(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            int m = (i + j) / 2;

            if (array[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }

        }

        return i;


    }

/*    public int findLostNumber(int[] array) {
        int res = -1;
        for (int i = 0; i < array.length; i++) {
            res = array[i] ^ i;
            if (res != 0) {
                return i;
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        Offer53 offer = new Offer53();
//        int[] array = {0, 2, 3, 4};
//        System.out.println(offer.findLostNumber(array));

        int[] nums = {8, 8,8, 8, 8, 8, 8, 8};
        System.out.println(offer.numberCount(nums, 8));
    }
}
