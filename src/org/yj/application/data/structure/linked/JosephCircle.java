package org.yj.application.data.structure.linked;

public class JosephCircle {


    private LinkNode createCircle(int[] array) {
        LinkNode head = new LinkNode(-1);
        LinkNode curNode = head;
        for (int i = 0; i < array.length; i++) {
            curNode.next = new LinkNode(i + 1);
            curNode = curNode.next;
        }
        head = head.next;
        curNode.next = head;
        return head;
    }

    public int solution(int[] array, int m) {
        LinkNode head = createCircle(array);
        LinkNode currNode = head;
        int count = 0;
        while (true) {
            if (currNode.next == currNode) {
                break;
            }
            count++;
            if (count == m-1) {
                currNode.next = currNode.next.next;
                count=0;
            }
            currNode = currNode.next;
        }
        int res = currNode.value;
        System.out.println();
        return res;
    }


    public static void main(String[] args) {
        JosephCircle josephCircle = new JosephCircle();

       // int[] array = {1};
        //int m = 3;
        int[] array = {1,2,3,4,5};
        int m = 5;
        //josephCircle.solution(array, m);
        System.out.println(josephCircle.solution(array, m));
    }

}
