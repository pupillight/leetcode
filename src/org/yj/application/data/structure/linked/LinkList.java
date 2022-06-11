package org.yj.application.data.structure.linked;

public class LinkList {

    public LinkNode head;


    public void addElement(int value) {

        if (head == null) {
            head = new LinkNode(value);
            return;
        }
        LinkNode dummyHead = new LinkNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        head = addElement(dummyHead, value).next;
    }

    public LinkNode addElement(LinkNode node, int value) {
        if (node == null) {
            return new LinkNode(value);
        }
        if (node.next != null && value <= node.next.value) {
            LinkNode tmp = new LinkNode(value);
            tmp.next = node.next;
            node.next = tmp;
            return node;
        }
        node.next = addElement(node.next, value);
        return node;

    }


    public void addElement1(int value) {
        if (head == null) {
            head = new LinkNode(value);
            return;
        }
        LinkNode dummyHead = new LinkNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        LinkNode curNode = dummyHead;
        LinkNode tmpNode = new LinkNode(value);
        while (curNode != null && curNode.next != null) {
            if (curNode.next.value >= value) {
                tmpNode.next = curNode.next;
                break;
            }
            curNode = curNode.next;
        }
        curNode.next = tmpNode;
        head = dummyHead.next;
    }


    public void add1(int value) {
        LinkNode node = new LinkNode(value);

        if (head == null) {
            head = node;
            return;
        }
        LinkNode currentNode = head;
        while (true) {
            if (currentNode.getNext() == null) {
                currentNode.setNext(node);
                break;
            }
            currentNode = currentNode.getNext();
        }
    }

    public void add(int value) {
        head = add(head, value);
    }

    public LinkNode add(LinkNode node, int value) {
        if (node == null) {
            return new LinkNode(value);
        }

        node.next = add(node.next, value);
        return node;
    }

    public void printNodes() {
        if (head == null) {
            System.out.println("this linkList is empty.");
            return;
        }
        LinkNode node = head;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }

    }

    public void printNodes2() {
        printNodes(head);
    }

    private void printNodes(LinkNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);

        printNodes(node.next);

    }

    public boolean remove(int value) {
        if (head == null) {
            System.out.println("linkList is empty.");
            return false;
        }

        LinkNode node = head;

        if (node.getValue() == value) {
            head = node.getNext();
            return true;
        }

        LinkNode preNode = null;
        while (true) {
            if (node != null && node.getNext().getValue() == value) {
                node.setNext(node.getNext().getNext());
                return true;
            }

            node = node.getNext();
        }
    }


    public LinkNode reverse() {
        return reverse(head);
    }

    public LinkNode reverse(LinkNode node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        LinkNode newNode = reverse(node.getNext());

        node.getNext().setNext(node);
        node.setNext(null);

        return newNode;
    }


//    public LinkNode reverse(LinkNode head) {
//        if (head == null || head.getNext() == null) {
//            return head;
//        }
//
//        LinkNode cur = head;
//        LinkNode pre = null;
//        LinkNode next = null;
//        while (cur!=null) {
//            next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        return pre;
//    }


    public void removeDuplicateElements() {
        if (head == null || head.next == null) {
            return;
        }


        LinkNode curNode = head;
        LinkNode nextNode = null;
        LinkNode preNode = null;

        while (true) {
            if (curNode == null || curNode.next == null) {
                return;
            }
            if (curNode.value == curNode.next.value) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.getNext();
            }
        }
    }

    public void removeElements(int value) {

        this.head = removeElements(head, value);
    }

    public LinkNode removeElements(LinkNode node, int value) {
        if (node == null) {
            return null;
        }

        //LinkNode res = removeElements(node.next, value);
        node.next = removeElements(node.next, value);
//        if (node.value == value) {
//            return res;
//        } else {
//            node.next = res;
//            return node;
//        }

        return node.value == value ? node.next : node;

    }

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();


        linkList.addElement(10);
        linkList.addElement(71);
        linkList.addElement(1);
        linkList.addElement(7);
        linkList.addElement(3);


        linkList.addElement1(9);
        linkList.addElement1(2);
        linkList.addElement1(5);
        linkList.addElement(6);
        linkList.addElement(10);
//        linkList.add(2);
//        linkList.add(2);
//        linkList.add(2);
//        linkList.add(3);
//        linkList.add(3);
        //linkList.add(4);
        //linkList.add(5);
        //linkList.add(9);

        //linkList.reverse(linkList.head);
        //linkList.printNodes2();
        //System.out.println("-------------------");

        //linkList.removeElements(2);
        linkList.printNodes();
      /*  linkList.printNodes();
        System.out.println("-------------------------");

//        linkList.remove(4);
//        linkList.printNodes();


        LinkNode newNode = linkList.reverse(linkList.head);
        linkList.head = newNode;

       // linkList.removeDuplicateElements();
        linkList.printNodes();*/
    }

}
