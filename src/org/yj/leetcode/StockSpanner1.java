package org.yj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class StockSpanner1 {

    LinkedList<Integer> list1;
    LinkedList<Integer> list2;
    int k = -1;

    public StockSpanner1() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    public int next(int price) {
        int end = -1;
        list1.addLast(price);
        k++;
        if (!list2.isEmpty() && price >= list1.get(list2.getFirst())) {
            while (!list2.isEmpty() && price >= list1.get(list2.getFirst())) {
                list2.removeFirst();
            }
        }
        if (!list2.isEmpty()) {
            end = list2.getFirst();
        }
        list2.addFirst(k);
        return k - end;
    }

    public static void main(String[] args) {
        StockSpanner1 stockSpanner = new StockSpanner1();
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(14));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(35));
    /*    System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));*/
        //System.out.println(stockSpanner.next(75));
        //System.out.println(stockSpanner.next(85));

    }
}
