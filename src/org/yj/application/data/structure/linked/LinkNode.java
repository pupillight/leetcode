package org.yj.application.data.structure.linked;

public class LinkNode {
    public  int value;
    public LinkNode next;


    public LinkNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "LinkNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
