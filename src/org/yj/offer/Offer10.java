package org.yj.offer;

public class Offer10 {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
        public int[] calculate(int n)
        {
            int[] array=null;

            calculate(n)= calculate(n)+1
        }*/
    public int plus(int n) {
        if (n == 0) {
            return 0;
        }
        return n + plus(n - 1);
    }

    public static void main(String[] args) {
        Offer10 offer = new Offer10();

        //System.out.println(offer.fibonacci(4));
        System.out.println(offer.plus(5));



    }
}
