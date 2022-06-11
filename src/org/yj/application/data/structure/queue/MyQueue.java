package org.yj.application.data.structure.queue;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class MyQueue {
    private int front;
    private int rear;

    private Object[] elements;
    private int size;

    public MyQueue(int size) {
        elements = new Object[size+1];
    }

    public boolean isFull() {
        return (rear + 1) % elements.length == 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }


    public void enQueue(Object o) {
        if (isFull()) {
            System.out.println("the queue is full.");
            throw new RuntimeException("the queue is full.");
        }
        elements[rear] = o;
        rear = (rear + 1) % elements.length;
        size++;
    }

    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("the queue ie empty.");
            throw new RuntimeException("the queue is empty.");

        }

        Object obj = elements[front];
       // System.out.println(obj);
        front++;
        size--;
        return obj;
    }

    public void showElement() {
        for (int i = front; i < elements.length-1; i++) {
            System.out.println(elements[i]);
        }
    }
}
