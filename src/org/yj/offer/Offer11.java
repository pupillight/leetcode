package org.yj.offer;

public class Offer11 {

    public int findMiniNumber(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int res=Integer.MIN_VALUE;
        int i = 0, j = array.length - 1;
        int value = array[j];
        while (i < j) {
            int mid = (i + j) / 2;
            if (array[mid] > value) {
                i = mid + 1;
            } else if (array[mid] < value) {
                j = mid ;
            } else {
                j--;
                //return array[mid];
            }
        }

        return  array[i];
    }

    public static void main(String[] args) {

        Offer11 offer= new Offer11();
        int[] array = {3,4,5,1,2};
        System.out.println(offer.findMiniNumber(array));
    }
}
