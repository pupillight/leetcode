package org.yj.application.data.structure.tree;

import org.yj.application.data.structure.array.MyArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;


public class HeapTree<T extends Comparable> {

    public MyArray<T> array;

    public HeapTree() {
        array = new MyArray();
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int parentIndex(int index) {
        if (index <= 0 || index >= array.size()) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public int leftIndex(int index) {
        return 2 * index + 1;
    }

    public int rightIndex(int index) {
        return 2 * index + 2;
    }

    public void print() {
        array.print();
    }

    public void add(T e) {
        array.addLast(e);
        int k = size() - 1;
        siftUp(k);

    }

    public void siftUp(int k) {

        while (k > 0 && array.get(k).compareTo(array.get(parentIndex(k))) > 0) {
            array.swap(k, parentIndex(k));
            k = parentIndex(k);
        }
    }

    public T poll() {
        T result = array.get(0);
        array.swap(0, size() - 1);
        array.removeLast();
        siftDown(0);
        return result;
    }

    public void siftDown(int k) {
        // TODO Auto-generated method stub
        while (this.leftIndex(k) < size()) {
            int j = this.leftIndex(k);
            if (j + 1 < size() && array.get(j).compareTo(array.get(j + 1)) < 0) {
                j++;
            }
            if (array.get(k).compareTo(array.get(j)) > 0) {
                break;
            } else {
                array.swap(k, j);
                k = j;
            }
        }
    }

    public T replace(T e) {
        T res = array.get(0);
        array.set(0, e);
        siftDown(0);
        return res;
    }

    public void heapify(T[] data) {

        // this.array = null;
        for (T t : data) {
            array.addLast(t);
        }

        int firstNodeIndex = this.parentIndex(array.size() - 1);

        for (int i = firstNodeIndex; i >= 0; i--) {
            siftDown(i);
        }
    }


    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int i = 0;
        while (i < k) {
            int t = queue.poll();
            queue.add(t + 1);
            i++;
        }
        long ans = 1;
        long exp = (long) (1e9+ 7);
        while (!queue.isEmpty()) {
            ans = ans * queue.poll();
            ans = ans % exp;
        }

        return (int) ans;
    }


    public static void main(String[] args) {
        HeapTree<Integer> tree = new HeapTree();

        //int[] nums = {92, 36, 15, 84, 57, 60, 72, 86, 70, 43, 16};
        int[] nums = {6,3,3,2};
        System.out.println(tree.maximumProduct(nums, 2));


        Integer[] tmp = {18, 7, 13, 74, 4, 89};

/*        for(int i=0;i<tmp.length;i++)
        {
            tree.add(tmp[i]);
        }

        tree.print();
        int t= tree.size();
        for (int i=0;i< t;i++){
            System.out.println(tree.poll());
        }*/

        tree.heapify(tmp);
        tree.print();
        System.out.println("------------------------");

        int t = tree.size();
        for (int i = 0; i < t; i++) {
            System.out.println(tree.poll());
        }
    }
}
