package org.yj.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class StockSpanner2 {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> dp = new ArrayList<>();
    int k = 0;

    public StockSpanner2() {

    }

    public int next(int price) {
        list.add(price);
        dp.add(1);

/*        if(k-1>-1 && list.get(k)<list.get(k-1)) {
            k++;
            return 1;
        }*/

        if (k - 1 > 0 && list.get(k) >= list.get(k - 1)) {
            dp.set(k, dp.get(k - 1) + 1);
        }
      /*  for (int i = k-1; i>=0; i--) {
            if (list.get(k) >= list.get(i)) {
                dp.set(k, dp.get(k) + 1);
            }else{
                break;
            }
        }*/
        k++;
        return dp.get(k - 1);
    }

    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int len = s.length();
        int res = 1;
        Set<Character> set = new HashSet<>();

        while (l <= r && r < len) {
            while (set.size() > 0 && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;

    }

    public static void main(String[] args) {
        StockSpanner2 stockSpanner = new StockSpanner2();
        System.out.println(stockSpanner.lengthOfLongestSubstring("bbb"));


     /*   System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(14));
        System.out.println(stockSpanner.next(28));
        System.out.println(stockSpanner.next(35));*/
       /* System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));*/
        //System.out.println(stockSpanner.next(75));
        //System.out.println(stockSpanner.next(85));

    }
}
