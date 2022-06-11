package org.yj.application.data.collections;

import org.yj.application.data.structure.array.MyArray;

import java.util.Arrays;
import java.util.Random;

public class MaxHeap<T extends Comparable<T>> {

    private MyArray<T> data;

    public MaxHeap() {
        data = new MyArray();
    }


    public MaxHeap(T[] array) {
        data = new MyArray<>(array);

        for (int i = parentIndex(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }


    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    private int parentIndex(int k) {
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    public void add(T t) {
        data.addLast(t);
        siftUp(data.size() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parentIndex(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public T max() {
        return data.get(0);
    }


    public T remove() {
        T res = this.max();
        data.swap(0, data.size() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private void siftDown(int index) {

        while (leftChild(index) < data.size()) {
            int leftIndex = this.leftChild(index);
            int rightIndex = this.rightChild(index);
            int i = leftIndex;
            if (rightIndex < data.size() && data.get(leftIndex).compareTo(data.get(rightIndex)) < 0) {
                i = rightIndex;
            }


            if (data.get(index).compareTo(data.get(i)) >= 0) {
                break;
            }
            data.swap(index, i);
            index = i;
        }
    }

    public static void main(String[] args) {

        Integer[] array = {10, 8, 167, 90, 34};
        MaxHeap<Integer> maxHeap = new MaxHeap(array);


/*
        MaxHeap<Integer> maxHeap = new MaxHeap();

        int n = 10;

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(100));
        }
*/

        // System.out.println(maxHeap.max());

        while (!maxHeap.isEmpty()) {

            System.out.println(maxHeap.remove().intValue());
        }

        System.out.println(maxHeap.isEmpty());

    }
}
