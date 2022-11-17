package org.yj.leetcode.elementary;

import org.yj.application.data.structure.linked.LinkNode;
import org.yj.offer.LinkedListQuestions;

import java.util.*;

public class LInkedListQuestions {

    public boolean isPalindrome(ListNode head) {
        ListNode currNode = head;
        StringBuilder builder = new StringBuilder();
        while (currNode != null) {
            builder.append(currNode.val);
            currNode = currNode.next;
        }
        String a = builder.toString();
        String b = builder.reverse().toString();
        if (a.equalsIgnoreCase(b)) {
            return true;
        }
        return false;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedNode;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while (slowNode != fastNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;

//        Set<ListNode> set = new HashSet<>();
//        ListNode currNode = head;
//        while (currNode != null) {
//            if (!set.add(currNode)) {
//                return true;
//            }
//            currNode = currNode.next;
//        }
//        return false;

//        ListNode slowNode = head;
//        ListNode fastNode = head.next;
//        while (slowNode != null && fastNode != null && fastNode.next!=null && fastNode.next.next!=null) {
//            if (slowNode == fastNode) {
//                return true;
//            }
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//        }
//        return false;

//        while (slowNode != null && fastNode.next != null && fastNode.next.next != null) {
//
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//            if (slowNode == fastNode) {
//                return true;
//            }
//        }
//
//        return false;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode node = dummyNode;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = carry + v1 + v2;
            carry = sum / 10;
            int newValue = sum % 10;
            node.next = new ListNode(newValue);

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        print(head.next);

    }

    public ListNode oddEvenList(ListNode head) {

        ListNode dummyOddNode = new ListNode(Integer.MIN_VALUE);
        ListNode dummyEvenNode = new ListNode(Integer.MIN_VALUE);
        ListNode oddNode = dummyOddNode;
        ListNode evenNode = dummyEvenNode;
        ListNode currNode = head;
        int i = 1;
        while (currNode != null) {
            if (i % 2 == 0) {
                evenNode.next = new ListNode(currNode.val);
                evenNode = evenNode.next;
            } else {
                oddNode.next = new ListNode(currNode.val);
                oddNode = oddNode.next;
            }
            i++;
            currNode = currNode.next;
        }

        oddNode.next = dummyEvenNode.next;
        print(dummyOddNode.next);
        return dummyOddNode.next;
        /*while (oddNode != null && evenNode != null) {
            //oddNode.next= oddNode.next.next;
            System.out.println(oddNode.val);
            System.out.println(evenNode.val);
            oddNode = oddNode.next.next;
            evenNode = evenNode.next.next;
        }*/

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;

        }
        return nodeA;



/*        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;*/


//        while (nodeA != null && nodeB != null) {
//            if (nodeA == nodeB) {
//                return nodeA;
//            }
//            nodeA = nodeA.next;
//            if (nodeA == null) nodeA = headB;
//
//            nodeB = nodeB.next;
//            if (nodeB == null) nodeB = headA;
//        }
//        return null;
    }


    public int mostRightIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int mostLeftIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public boolean find(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode midNode = getMiddleNode(head);
        ListNode reversedNode = reverseListNode(midNode.next);
        midNode.next = null;
        merge(head, reversedNode);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null && node2 != null) {
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;
            node1.next = node2;
            node2.next = next1;
            node1 = next1;
            node2 = next2;
        }
    }

    private ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseNode = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private int getCount(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode currNode = head;
        int count = 0;
        while (currNode != null) {
            currNode = currNode.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        int i = 0;
        currNode = head;
        while (currNode != null && i < k) {
            currNode = currNode.next;
            i++;
        }
        ListNode node1 = head;
        ListNode node2 = new ListNode(-1);
        ListNode node3 = node2;
        while (node1 != null && currNode != null) {
            node2.next = new ListNode(node1.val);
            node2 = node2.next;
            currNode = currNode.next;
            node1 = node1.next;
        }

        ListNode res = node1;
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = node3.next;
        return res;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode currNode = head;
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        while (k > 0) {
            int v=list.pollLast();
            list.push(v);
            k--;
        }
        ListNode res = new ListNode(-1);
        ListNode node = res;
        while(!list.isEmpty()){
           node.next= new ListNode(list.pop());
           node = node.next;
        }
        return res.next;
    }
  /*  public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int count = getCount(head);
        int t = k;
        t = t % count;
        if (t == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode currNode = dummyHead;
        while (fast != null && t > 0) {
            fast = fast.next;
            t--;
        }

        while (fast != null) {
            currNode.next = new ListNode(slow.val);
            slow = slow.next;
            fast = fast.next;
            currNode = currNode.next;

        }
        union(slow, dummyHead.next);
        return slow;
    }*/

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reversPrint(head, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void reversPrint(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        reversPrint(node.next, list);
        list.add(node.val);
    }


    private void union(ListNode l1, ListNode l2) {
        ListNode node = l1;
        while (node.next != null) {
            node = node.next;
        }
        node.next = l2;

    }


    public static void main(String[] args) {
        LInkedListQuestions questions = new LInkedListQuestions();

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        questions.reverseList(head);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//
//        head.next.next.next = new ListNode(4);

      /*  ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);


        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        ListNode node = questions.getIntersectionNode(headA, headB);
        System.out.println(node.val);
*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
         head.next.next.next = new ListNode(4);
         head.next.next.next.next = new ListNode(5);
        //questions.reorderList(head);
        // questions.print(head);


        questions.print(questions.rotateRight(head, 2));
        //questions.reverseList(head);

        //System.out.println(questions.hasCycle(head));
        //System.out.println(questions.oddEvenList(head));

       /* int[] nums = {1, 2, 2, 2, 2, 9};
        System.out.println(questions.mostLeftIndex(nums, 2));
        System.out.println(questions.mostRightIndex(nums, 2));*/

       /* ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);
        // l2.next = new ListNode();
        //l2.next.next = new ListNode(1);

        ListNode node =questions.addTwoNumbers(l1, l2);
        questions.print(node);*/
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}