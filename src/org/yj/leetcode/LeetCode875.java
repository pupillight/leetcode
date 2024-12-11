package org.yj.leetcode;

import org.yj.leetcode.amazon.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = Arrays.stream(piles).sum();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, h, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] piles, int h, int s) {
        if (s == 0) {
            return false;
        }
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            hours += pile / s;
            if (pile % s != 0) {
                hours++;
            }
        }
        if (hours <= h) {
            return true;
        }
        return false;
    }


    public boolean f(int[] weights, int days, int s) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > s) {
                count++;
                sum = 0;
            }
            sum += weights[i];
        }
        if (count + 1 <= days) {
            return true;
        }
        return false;
    }

    private boolean f1(int[] weights, int days, int s) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > s) {
                count++;
                sum = 0;
            }
            sum += weights[i];
        }
        if (count <= days) {
            return true;
        }
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (f(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    /*  dsfdfdfd  */

    public long minimumTime(int[] time, int totalTrips) {
        //Arrays.sort(time);
        // int l = Arrays.stream(time).min().getAsInt() * totalTrips;
        long l = 1;
        long r = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (verify(time, totalTrips, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean verify(int[] time, int totalTrips, long s) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            count += s / time[i];
        }
        return count >= totalTrips;
    }

    public static int computeClosestToZero(int[] ts) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");


        int diff = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ts.length; i++) {
            diff = Math.abs(ts[i] - 0);
            min = Math.min(min, diff);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int[] countFrequencies(String[] words) {
        // Write your code here
        // To debug: System.err.println("Debug messages...");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int[] arr = new int[map.size()];
        //List<Integer> list =  map.values().stream().sorted().collect(Collectors.toList());
        // map.values().stream().collect(Collectors.toList());


        Iterator<Integer> it = map.values().stream().collect(Collectors.toList()).iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }


    public int test(String input) {
        Set<String> set = new HashSet<>();
        int len = input.length();
        int i = len - 1;
        while (i >= 0) {

            if (Character.isDigit(input.charAt(i)) &&
                    Character.isDigit(input.charAt(i - 1)) &&
                    Character.isDigit(input.charAt(i - 2)) &&
                    Character.isDigit(input.charAt(i - 3))) {
                String str= input.substring(i-3,i+1);
                set.add(str);
            }
            i--;
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode875 leetCode = new LeetCode875();
       /* int[] piles = {3, 6, 7, 11};
        int h = 8;
        //System.out.println(leetCode.minEatingSpeed(piles, h));
        System.out.println(leetCode.minEatingSpeed(piles, h));*/
      /*  int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 3;


        System.out.println(leetCode.f(weights, days, 6));
        System.out.println(leetCode.shipWithinDays(weights, days));*/
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        // System.out.println(leetCode.minimumTime(time, totalTrips));

/*        String[] words = {"hello", "hello", "world"};
        System.out.println(countFrequencies(words));*/

        System.out.println(leetCode.test("dintou 12-25-1977. sdfd fd dfdf 10-01-1949"));


    }


}
