package org.yj.offer;

public class Offer21 {

    /**
     * 奇数在前，偶数在后
     *
     * @param array
     */
    public void resortArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && !(array[left] % 2 == 0)) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }

            if (left < right) {
                swap(array, left, right);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        Offer21 offer = new Offer21();
        int[] array = {0, 12, 18, 0, 19, 3};
        offer.resortArray(array);
        for (int t : array) {
            System.out.println(t);
        }
    }

}
