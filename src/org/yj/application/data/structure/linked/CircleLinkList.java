package org.yj.application.data.structure.linked;

public class CircleLinkList {

    public LinkNode head;

    public void addNode(int num) {
        if (num < 1) {
            return;
        }
        LinkNode curNode = null;
        for (int i = 1; i <= num; i++) {
            LinkNode node = new LinkNode(i);
            if (i == 1) {
                head = node;
                head.next = head;
                curNode = node;
            }else
            {
                curNode.next=node;
                node.next =head;
                curNode =node;
            }
        }
    }


    public static void main(String[] args) {
        CircleLinkList circleLinkList = new CircleLinkList();


        circleLinkList.addNode(3);
        System.out.println();
    }
}
