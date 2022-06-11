package org.yj.offer;

import org.yj.application.data.structure.linked.LinkNode;

public class LinkedListQuestions {

    public LinkNode removeElements(LinkNode head, int value) {
        LinkNode dummyHead = new LinkNode(-1);
        dummyHead.next = head;
        LinkNode currNode = dummyHead;

        while (currNode != null && currNode.next != null) {
            if (currNode.next.value == value) {
                currNode.next = currNode.next.next;
                continue;
            }
            currNode = currNode.next;
        }
        return dummyHead.next;
    }

    public LinkNode removeElements1(LinkNode head, int value) {
        if (head == null) {
            return null;
        }
        head.next = removeElements1(head.next, value);
        if (head.value == value) {
            return head.next;
        } else {
            return head;
        }
    }


    public LinkNode removeElements2(LinkNode head, int value) {
        if (head == null) {
            return null;
        }
        LinkNode node = removeElements2(head.next, value);
        if (head.value == value) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }


    public LinkNode reverse(LinkNode head){

        if(head ==null || head.next ==null){
            return head;
        }

        LinkNode node =reverse(head.next);
        head.next.next = head;
        head.next=null;
        return  node;
    }

    public static void main(String[] args) {

        LinkedListQuestions instance = new LinkedListQuestions();
        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(2);
        head.next.next.next = new LinkNode(3);

        LinkNode node = instance.removeElements1(head, 3);
        System.out.println(node);
    }
}
