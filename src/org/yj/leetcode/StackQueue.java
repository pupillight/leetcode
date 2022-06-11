package org.yj.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue<T extends Comparable<T>> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    public void push(T value) {
        stack1.push(value);

    }

    public T pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public T peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public static  void main(String[] args)
    {
       /* StackQueue stackQueue= new StackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);
        stackQueue.push(4);
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        stackQueue.push(5);
        System.out.println(stackQueue.peek());
        System.out.println(stackQueue.pop());*/



        int[] array = new int[26];
        String str="hello";

        for(char c:str.toCharArray())
        {
            array[c-'a']=1;
            //i++;
        }
        System.out.println(Arrays.toString(array));

        int i=0;
        int[] array1=new int[26];
        for(char c:str.toCharArray())
        {
            array1[i]=c-'a';
            i++;
        }
        System.out.println(Arrays.toString(array1));
    }

}
