package org.yj.offer;

import org.yj.application.data.structure.linked.LinkList;
import org.yj.application.data.structure.linked.LinkNode;

public class Offer18 {

    public LinkNode deleteNode(LinkNode head, int value) {
        LinkNode dummyHead = new LinkNode(-1);

        dummyHead.next = head;

        LinkNode currNode = dummyHead;
        while (currNode.next != null) {

            int tmp = currNode.next.value;
            if (tmp == value) {
                currNode.next = currNode.next.next;

                break;
            }
            currNode = currNode.next;
        }

        head =dummyHead.next;
        return head;
    }


    public static void main(String[] args) {
        Offer18 offer = new Offer18();
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);

       LinkNode node= offer.deleteNode(linkList.head, 5);

       linkList.head = node;

       linkList.printNodes();

    }

}
