package org.yj.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer48 {


    public int theLongestStr(String text) {
        int len = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < text.length()) {
            char c = text.charAt(i);
            while (set.contains(c)) {
                set.remove(text.charAt(j));
                j++;
            }
            set.add(c);
            len = Math.max(len, i - j + 1);
            i++;
        }


        return len;
    }

    List<Integer> list = new ArrayList<>();

    public void uglyNumbers(int count) {
        uglyNumbers(count, 1, list);
    }

    private void uglyNumbers(int count, int n, List<Integer> nums) {
        if (count == 0) {
            return;
        }
        if (isUglyNumber(n)) {
            nums.add(n);
            count--;
        }
        uglyNumbers(count , n + 1, nums);
    }

    private boolean isUglyNumber(int num) {
        if (num == 1 || num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        Offer48 offer = new Offer48();

        System.out.println(offer.theLongestStr("pwwkew"));
        offer.uglyNumbers(10);
        System.out.println();

    }
}
