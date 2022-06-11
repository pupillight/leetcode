package org.yj.application.data.structure.linked;

import java.util.Stack;

public class CycleList {

    private Node first;

    public void addNode(int size) {
        if (size < 1) {
            System.out.println("size should be >= 1 .");
            return;
        }
        Node currentNode = null;
        for (int i = 0; i < size; i++) {
            Node node = new Node(i);

            if (first == null) {
                first = node;
            } else {
                currentNode.setNext(node);
            }
            currentNode = node;


//            if (i == 0) {
//                first = node;
//                first.setNext(first);
//                currentNode = first;
//            } else {
//                currentNode.setNext(node);
//                node.setNext(first);
//                currentNode = node;
//            }
        }
    }

    public void showNodes() {
        if (first == null) {
            System.out.println("empty list!");
            return;
        }
        Node tmpNode = first;
        while (true) {

            if (tmpNode.getNext() != null) {
                System.out.println(tmpNode.getNumber());
                tmpNode = tmpNode.getNext();
            }
        }
    }

    public void reverse() {
        if (first == null) {
            System.out.println("empty list!");
            return;
        }
        Node currentNode = first;

        java.util.Stack<Integer> stack = new Stack<Integer>();

        while (true) {
            if (currentNode != null) {
                System.out.println(currentNode.getNumber());
                stack.push(currentNode.getNumber());
                //preNode=currentNode;
                currentNode = currentNode.getNext();

            } else {
                break;
            }
        }

        while(!stack.empty())
        {
            int value = stack.pop();
            System.out.println(value);
        }

    }

    public static void main(String[] args) {
        CycleList cycleList = new CycleList();
        cycleList.addNode(5);
        // cycleList.showNodes();
        cycleList.reverse();
    }
}

class Node {
    private int number;
    private Node next;

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
