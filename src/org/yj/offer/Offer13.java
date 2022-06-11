package org.yj.offer;

public class Offer13 {


    public int sum(int n) {
        int res = 0;
        while (n > 0) {
            res = res + n % 10;
            n = n / 10;
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
        int[][] array = new int[m][n];
        int res = 0, value = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int row = i;
                int col = j;
                int sum = sum(row) + sum(col);
                if (sum <= k) {
                    res++;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Offer13 offer = new Offer13();
        System.out.println(offer.sum(1000));
        //System.out.println(offer.movingCount(3, 1, 0));

    }
}
