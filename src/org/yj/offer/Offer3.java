package org.yj.offer;

import org.yj.application.data.structure.linked.LinkNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Offer3 {

    public int minNumber(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0, right = array.length - 1;


        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            }
        }
        return array[left];
    }

    public int minNumber2(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        return minNumber(array, 0, array.length - 1);
    }

    private int minNumber(int[] array, int left, int right) {
        if (left >= right) {
            return Integer.MIN_VALUE;
        }
        int mid = (left + right) / 2;
        if (array[mid] >= array[mid - 1]) {
            return minNumber(array, mid + 1, right);
        } else {
            return array[mid];
        }
    }

    public int minNumber1(int[] array) {
        int res = Integer.MIN_VALUE;
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (array[i] > array[j]) {
                j--;
            } else {
                break;
            }
        }

        if (j == array.length - 1) {
            res = array[j];
        } else {
            res = array[j + 1];
        }


        return res;


    }

    public String replaceBlank(String text) {
        StringBuilder builder = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }


    public int[][] findRepeatableNumbers(int[] array) {
        int[][] res = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.replace(array[i], (map.get(array[i]) + 1));
            } else {
                map.put(array[i], 1);
            }
        }
        int i = 0;
        res = new int[map.keySet().size()][2];

        for (Object key : map.keySet().stream().toArray()) {
            res[i][0] = (int) key;
            res[i][1] = map.get(key);
            i++;
        }

        return res;
    }


    public void printBinary(int value) {
        for (int i = 31; i >= 0; i--) {
            int j = (value & (1 << i)) == 0 ? 0 : 1;
            System.out.print(j);
        }
    }

    public int getCount(int value) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if ((value & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }


    public LinkNode getRearNode(LinkNode root, int k) {
        LinkNode curNode = root;
        LinkNode res = new LinkNode(-1);
        int i = 0;

        while (i < k && curNode != null) {
            curNode = curNode.next;
            i++;
        }

        LinkNode slowNode = root;
        while (curNode != null && slowNode != null) {

            slowNode = slowNode.next;
            curNode = curNode.next;
        }

        res = slowNode;
        return res;
    }

    public LinkNode deleteNode(LinkNode root, int target) {
        LinkNode tmpNode = new LinkNode(-1);
        tmpNode.next = root;
        LinkNode curNode = tmpNode;
        while (curNode != null && curNode.next != null) {
            if (curNode.next.value == target) {
                curNode.next = curNode.next.next;
                continue;
            }
            curNode = curNode.next;
        }

        LinkNode res = tmpNode.next;
        return res;
    }


    public void printLinkNode(LinkNode root) {
        LinkNode curNode = root;
        while (curNode != null) {

            System.out.println(curNode.value);
            curNode = curNode.next;
        }
    }

    public static void main(String[] args) {
        Offer3 offer = new Offer3();
     /*   int[] array = {2, 3, 1, 0, 2, 5, 3};
        offer.findRepeatableNumbers(array);
        System.out.println(offer.replaceBlank("we are happy."));*/


        //int[] array = {9, 1, 2, 3, 4, 5, 7, 8,};
        //int[] array = {2, 2, 2, 0,1};
        //System.out.println(offer.minNumber(array));

        // System.out.println(offer.getCount(128));
        // offer.printBinary(128);

        LinkNode root = new LinkNode(1);
        root.next = new LinkNode(2);
        root.next.next = new LinkNode(3);
        root.next.next.next = new LinkNode(4);
        root.next.next.next.next = new LinkNode(5);
        offer.printLinkNode(root);

        System.out.println("--------------");
        // LinkNode node = offer.deleteNode(root, 1);
        // offer.printLinkNode(node);

        LinkNode node = offer.getRearNode(root, 3);
        offer.printLinkNode(node);
    }
}
