package org.yj.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MovingTotal {

    LinkedList<Integer> myList = new LinkedList<>();
    Set<Integer> results = new HashSet();

    private void calSum() {
        int sum = myList.stream().mapToInt(e -> e).sum();
        results.add(sum);
    }

    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {

        if (list == null || list.length == 0) {
            return;
        }

        for (int i = 0; i < list.length; i++) {
            myList.addLast(list[i]);
            if (myList.size() == 3) {
                //calculate total
                this.calSum();
                //remove first
                myList.removeFirst();
            }
        }

        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        if (results.contains(total)) {
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3, 4});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[]{5});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}
