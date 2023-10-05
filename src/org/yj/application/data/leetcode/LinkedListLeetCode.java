package org.yj.application.data.leetcode;


import org.yj.application.data.structure.linked.LinkList;
import org.yj.application.data.structure.linked.LinkNode;
import org.yj.leetcode.amazon.ListNode;

import javax.annotation.processing.SupportedSourceVersion;

public class LinkedListLeetCode {


    public LinkNode reverse1(LinkNode head) {
        LinkNode pre = null;
        LinkNode cur = head;
        while (cur != null) {
            LinkNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }


        return pre;
    }


    public LinkNode reverse(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }


    public void mergeSortedLinkedList(LinkList l1, LinkList l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        LinkNode currNode1 = l1.head;


        LinkList l = new LinkList();


        while (currNode1 != null) {

            int v1 = currNode1.value;
            LinkNode currNode2 = l2.head;
            LinkNode preNode2 = null;
            while (currNode2 != null) {
                int v2 = currNode2.value;
                if (v1 < v2) {
                    if (preNode2 == null) {
                        preNode2 = new LinkNode(v1);
                        preNode2.next = currNode2;
                    } else {
                        preNode2.next = new LinkNode(v1);
                        preNode2.next.next = currNode2;
                    }


                    break;
                } else {
                    preNode2 = currNode2;
                    currNode2 = currNode2.next;
                }
            }

            if (currNode2 == null) {
                preNode2.next = new LinkNode(v1);
            }


            currNode1 = currNode1.next;
        }

    }


    public LinkNode sumNodes(LinkNode node1, LinkNode node2) {
        LinkNode dummyNode = new LinkNode(-1);
        LinkNode currNode = dummyNode;
        int carry = 0;

        while (node1 != null || node2 != null) {
            int v1 = node1 == null ? 0 : node1.value;
            int v2 = node2 == null ? 0 : node2.value;

            int sum = v1 + v2 + carry;
            carry = sum / 10;
            currNode.next = new LinkNode(sum % 10);
            currNode = currNode.next;

            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }

        }

        if (carry > 0) {
            currNode.next = new LinkNode(1);
        }


        return dummyNode.next;

    }

    public LinkNode sum(LinkNode node1, LinkNode node2) {

        LinkList linkList = new LinkList();
        LinkNode currNode1 = node1;
        LinkNode currNode2 = node2;


        int carry = 0;
        while (currNode1 != null && currNode2 != null) {
            int v1 = currNode1.value;
            int v2 = currNode2.value;
            int v3 = (v1 + v2) % 10 + carry;
            carry = (v1 + v2) / 10;

            linkList.add(v3);
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }


        while (currNode1 != null) {
            linkList.add(currNode1.value);
            currNode1 = currNode1.next;
        }
        while (currNode2 != null) {
            linkList.add(currNode2.value);
            currNode2 = currNode2.next;
        }

        return linkList.head;
    }


    public boolean isCircleLinkedList(LinkNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        LinkNode nodeSlow = head;
        LinkNode nodeFast = head;

        while (nodeSlow != null && nodeFast != null && nodeFast.next != null && nodeFast.next.next != null) {

            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
            if (nodeSlow.value == nodeFast.value) {
                return true;
            }
        }

        return false;

    }


    public ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode reversedNode = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return reversedNode;
    }

    public static void main(String[] args) {
        LinkedListLeetCode leetCode = new LinkedListLeetCode();
/*        LinkList l1 = new LinkList();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        LinkList l2 = new LinkList();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        LinkedListLeetCode leetCode = new LinkedListLeetCode();
        leetCode.mergeSortedLinkedList(l1, l2);
        System.out.println(l2);
        System.out.println(l1);*/

/*        LinkList l1 = new LinkList();
        l1.add(9);
        l1.add(9);
        l1.add(9);
        LinkList l2 = new LinkList();
        l2.add(9);
        l2.add(9);
        l2.add(9);
        LinkedListLeetCode leetCode = new LinkedListLeetCode();
        // leetCode.reversedPrint(l1.head);

        //leetCode.reverse(l1);


        LinkNode node = leetCode.sumNodes(l1.head, l2.head);*/

  /*      LinkList l1 = new LinkList();
        l1.add(1);
        l1.add(2);
        l1.add(3);*/

        //LinkNode node1=new LinkNode(1);
        // LinkNode node2=new LinkNode(1);

        //node1.next = node2;
        //node2.next =node1;

        //LinkNode node3=new LinkNode(1);
        // LinkNode node4=new LinkNode(1);

//        LinkNode node = leetCode.reverse1(l1.head);
//
//        while (node != null) {
//            System.out.println(node.value);
//            node = node.next;
//        }

        //System.out.println(leetCode.isCircleLinkedList(node1));



    }
}


