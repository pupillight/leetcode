package org.yj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StockSpanner {

    LinkedList<Integer> idx = new LinkedList<>();
    LinkedList<Integer> costs = new LinkedList<>();
    int k = 0;

    public StockSpanner() {

        idx.push(-1);
        costs.push(Integer.MAX_VALUE);
    }

    public int next(int price) {

        while (price >= costs.peek()) {
            costs.pop();
            idx.pop();
        }
        int res = k- idx.peek();

        costs.push(price);
        idx.push(k);
        k++;
        return  res;
    }

 /*   LinkedList<Integer> list;

    public StockSpanner() {
        list = new LinkedList<>();
    }

    private void repush(List<Integer> tmps) {
        for (int i = tmps.size() - 1; i >= 0; i--) {
            int tmp = tmps.get(i);
            this.list.push(tmp);
        }
    }

    public int next(int price) {
        if (list.isEmpty()) {
            list.push(price);
            return 1;
        } else {
            if (price <= list.peek()) {
                list.push(price);
                return 1;
            } else {
                List<Integer> tmpList = new ArrayList<>();
                while (!list.isEmpty() && price > list.peek()) {
                    int v = list.pop();
                    tmpList.add(v);
                }
                tmpList.add(price);
                repush(tmpList);
                return tmpList.size();
            }
        }*/


    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(14));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(35));
     /*   System.out.println(stockSpanner.next(29));
        System.out.println(stockSpanner.next(91));
        System.out.println(stockSpanner.next(62));
        System.out.println(stockSpanner.next(76));
        System.out.println(stockSpanner.next(51));*/
        //System.out.println(stockSpanner.next(75));
        //System.out.println(stockSpanner.next(85));

    }
}
