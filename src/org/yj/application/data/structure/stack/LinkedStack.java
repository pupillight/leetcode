package org.yj.application.data.structure.stack;

public class LinkedStack {


    private int top = -1;
    private Node first;
    private int size;
    private int capacity;

    public LinkedStack(int size) {
        this.capacity = size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public void add(int value) {
        if (isFull()) {
            System.out.println("linked list is full.");
            return;
        }

        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
            size++;
            return;
        } else {
            Node temp = first;
            while (true) {
                if (temp.getNext() == null) {
                    temp.setNext(node);
                    size++;
                    break;
                }
                temp = temp.getNext();
            }


        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("the linked list is empty.");
            return;
        }

        Node node = first;
        Node preNode = null;
        if (node.getNext() == null) {
            first = null;
            size--;
            return;
        }
        while (true) {
            if (node.getNext() == null) {
                /**/
                preNode.setNext(null);
                size--;
                break;
            }
            preNode = node;
            node = node.getNext();
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("the linked list is empty.");
            return;
        }
        Node node = first;
        while (true) {
            System.out.println(node.getValue());
            if (node.getNext() == null) {
                break;
            }
            node = node.getNext();
        }
    }


    public void push(int value) {
        add(value);
        top++;
    }

    public int pop() {

        Node node = first;
        Node preNode = null;
        if (first.getNext() == null) {
            top--;
            size--;
            int value=first.getValue();
            first=null;
            return value;
        }
        while (true) {
            if (node.getNext() == null) {
                preNode.setNext(null);
                size--;
                top--;
                return node.getValue();
            }
            preNode = node;
            node = node.getNext();
        }

    }


    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);

        stack.show();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.show();

    }
}

