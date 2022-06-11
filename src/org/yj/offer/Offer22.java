package org.yj.offer;

import org.yj.application.data.structure.linked.LinkList;
import org.yj.application.data.structure.linked.LinkNode;

import java.util.Stack;

public class Offer22 {

   /* public int getLastNode(LinkNode head, int position) {
        if (head == null) {
            System.out.println("The linked list is empty.");
            return -1;
        }
        if (position <= 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        LinkNode node = head;
        while (node != null) {
            stack.add(node.value);
            node = node.next;
        }

        int i = 1;
        while (i < position) {
            stack.pop();
            i++;
        }
        int value = stack.pop();
        return value;
    }
*/

    public int getLastNode(LinkNode head, int position) {
        LinkNode slow = head, fast = head;
        if (position <= 0) {
            return -1;
        }
        for (int i = 0; i < position; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        int value = slow.value;
        return value;
    }

    public static void main(String[] args) {
        Offer22 offer22 = new Offer22();
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        System.out.println(offer22.getLastNode(linkList.head, 4));
    }
}
