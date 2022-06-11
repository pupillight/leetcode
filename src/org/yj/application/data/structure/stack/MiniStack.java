package org.yj.application.data.structure.stack;

public class MiniStack<T extends Comparable<T>> {

    MyStack<T> myStack;

    public MiniStack() {
        myStack = new MyStack<>(10);
    }


    public void add(T e) {
        myStack.offer(e);
    }

    public T peek() {
        return myStack.peek();
    }

    public static void main(String[] args) {
        MiniStack<Integer> stack = new MiniStack<>();
        stack.add(12);
        System.out.println(stack.peek());

    }
}
