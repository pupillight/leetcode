package org.yj.application.data.structure.queue;

public class Queue {
    private int capacity;
    private int front;
    private int rear;

    private int[] array;

    public Queue(int size) {
        this.capacity = size;
        array = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (rear == capacity - 1) {
            return true;
        }
        return false;
    }


    public boolean add(int value) {
        if (!isFull()) {
            rear++;
            array[rear] = value;
            return true;
        }
        return false;
    }

    public void remove() {
        if (isEmpty()) {
            return;
        }

        front++;

    }

    public void print() {
        for (int i=front+1;i<capacity;i++) {
            System.out.println(array[i]);
        }
    }
}

