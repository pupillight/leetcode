package org.yj.leetcode;

import java.util.Stack;

public class MiniStack<T extends Comparable<T>> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public MiniStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(T t) {
        stack1.push(t);
        if (stack2.isEmpty()) {
            stack2.push(t);
        } else if (t.compareTo(stack2.peek()) <= 0) {
            stack2.push(t);
        }
    }

    public T peek() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("stack is empty");
        }
        return stack1.peek();
    }

    public T pop() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("stack is empty");
        }
        T v1 = stack1.pop();
        if (v1.compareTo(stack2.peek()) == 0) {
            stack2.pop();
        }
        return v1;
    }


    public T min() throws Exception {
        if (stack2.isEmpty()) {
            throw new Exception("stack is empty");
        }

        return stack2.peek();
    }

    public static void main(String[] args) {
        MiniStack<Integer> miniStack = new MiniStack();
        try {
            miniStack.push(5);
            miniStack.push(5);
            miniStack.push(1);
            miniStack.push(9);
            System.out.println(miniStack.min());
            miniStack.pop();
            miniStack.pop();
            miniStack.pop();
            System.out.println(miniStack.min());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
