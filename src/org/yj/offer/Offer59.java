package org.yj.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer59 {

    public int[] maxValue(int[] array, int k) {
        int[] res = new int[array.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        // 窗口未形成
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < array[i]) {
                deque.pollLast();
            }
            deque.offerLast(array[i]);
        }
        res[0] = deque.peekFirst();

        //窗口已经形成
        for (int i = k; i < array.length; i++) {
            //出去1个
            if (array[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            //进去1个
            while (!deque.isEmpty() && deque.peekLast() < array[i]) {
                deque.pollLast();
            }
            deque.offerLast(array[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {
        Offer59 offer = new Offer59();
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = offer.maxValue(array, 3);
        for (int v : res) {
            System.out.println(v);
        }
    }

}
