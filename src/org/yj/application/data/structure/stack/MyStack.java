package org.yj.application.data.structure.stack;

public class MyStack<T> {

    public int top;
    public T[] data;

    public MyStack(int capacity) {
        top = -1;
        data = (T[]) new Object[capacity];
    }


    public void offer(T e) {
        data[++top] = e;
    }

    public T peek()
    {
        return data[top];
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(10);
        stack.offer(1);
        System.out.println(stack.peek());

    }
}
