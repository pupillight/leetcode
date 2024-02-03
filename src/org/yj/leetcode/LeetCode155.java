package org.yj.leetcode;

import org.w3c.dom.html.HTMLMapElement;

import java.util.*;

public class LeetCode155 {


    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
       // minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> miniStack;

    public MinStack() {
        stack = new Stack<>();
        miniStack = new Stack<>();
        miniStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        int top = miniStack.peek();
        int mini = Math.min(top, val);
        miniStack.push(mini);
    }

    public void pop() {

        stack.pop();
        miniStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return miniStack.peek();
    }
}
/*
class MinStack {

    Stack<Integer> stack;
    ArrayList<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new ArrayList<>();
    }

    public void push(int val) {

        stack.push(val);
        if (queue.isEmpty()) {
            queue.add(val);
        } else {
            int index=0;
            for (int i = queue.size()-1; i >=0 ; i--) {
              int curr=  queue.get(i);
              if(curr<val)
              {
                  index=i+1;
                  break;
              }
            }
            queue.add(index,val);
           */
/* ArrayList<Integer> list  = new ArrayList();
            while (!queue.isEmpty() && queue.getLast() > val) {

                int last =queue.removeLast();
                list.add(last);
            }
            queue.addLast(val);
            for (int i = list.size()-1; i>=0; i--) {
                queue.add(list.get(i));
            }*//*

        }

    }

    public void pop() {
        int top = stack.pop();

        for (int i = 0; i < queue.size(); i++) {

            if(queue.get(i) == top){
                queue.remove(i);
            }
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {

        return queue.get(0);
    }
}*/
