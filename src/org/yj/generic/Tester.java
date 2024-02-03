package org.yj.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Tester {

    List<Printer> printers;

    public <T> void addPrinter(List<RegularPrinter<T>> list) {

        list.add(new RegularPrinter<T>());
        //list.add(new CannonPrinter());

    }

    public static Number sum(List<? extends Number> nums) {
        double res = 0;
        for (Number num : nums) {
            res += num.doubleValue();
        }

        return res;
    }


    public static int bSearch(int[] arr, int target) {

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void printTriganle(int row) {

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printCircle1(int radius) {
        int total = radius * 2 + 1;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < radius + 2 * i && k < total; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = radius; i >= 0; i--) {
            for (int j = 0; j < radius - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < radius + 2 * i && k < total; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void printCircle(int radius) {
        int total = radius * 2 + 1;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < radius + 2 * i && k < total; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = radius; i >= 0; i--) {
            for (int j = 0; j < radius - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < radius + 2 * i && k < total; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void t() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }


    public static int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (A[mid] > 0) {
                j = mid - 1;
            } else if (A[mid] <= 0) {
                i = mid + 1;
            }
        }
        int index = i;
        if (i == A.length) {
            return 1;
        }
        if (A[index] > 1) {
            return 1;
        }
        int pre = 0;
        for (int k = index + 1; k < A.length; k++) {
            if (A[k] - A[k - 1] > 1) {
                pre = A[k - 1];
                break;
            }
            pre = A[k];

        }
        return pre + 1;
        //java.util.Prority
      /*  PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                queue.add(A[i]);
            }
        }
        if (queue.isEmpty()) {
            return 1;
        }
        int pre = -1;
        if (!queue.contains(0)) {
            queue.add(0);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (pre != -1 && curr - pre > 1) {
                break;
            }
            pre = curr;
        }
        return pre + 1;

        return -1;*/
    }
//
//    0,30
//    5,10
//    15,20

    public static int meetRooms(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new int[]{intervals[i][0], 1});
            list.add(new int[]{intervals[i][1], -1});
        }

        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int ans=0;
        int max= -1;
        for (int[] item : list) {
            ans+=item[1];
            max= Math.max(max,ans);
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] intervals={{0,30},{5,10},{15,20}};

        System.out.println(meetRooms(intervals));
        //int[] arr= {1,3,6,19,30};
        //System.out.println(bSearch(arr, 5));

        //printTriganle(5);
      /*  int[] array = {-1, -2, 1, 1, 1, 4};
        int res = solution(array);
        System.out.println(res);*/
        //printCircle(5);

        //t();


        /*Printer hpPinter = new HPPinter();
        hpPinter.print("aaa");

        Printer<Integer> cannonPrinter = new CannonPrinter<>();
        cannonPrinter.print(145);


        cannonPrinter.println("a",1,"c");*/
    }
}
