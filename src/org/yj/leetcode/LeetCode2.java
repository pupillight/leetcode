package org.yj.leetcode;

import org.yj.application.data.structure.linked.LinkList;
import org.yj.application.data.structure.linked.LinkNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode2 {


    public String binarySum(String a, String b) {

        String res = null;
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int c1 = i < 0 ? 0 : a.charAt(i) - '0';
            int c2 = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = (c1 + c2 + carry);
            builder.append(sum % 2);
            carry = (sum / 2);
            i--;
            j--;
        }

        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();

    }


    public LinkNode sum1(LinkNode node1, LinkNode node2) {
        LinkNode res = new LinkNode(-1);
        LinkNode curNode = res.next;
        int carry = 0;


        while (node1 != null || node2 != null) {

            int v1 = node1 == null ? 0 : node1.value;
            int v2 = node2 == null ? 0 : node2.value;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curNode = new LinkNode(sum);

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
            curNode = curNode.next;

        }

        if (carry == 1) {
            curNode.next = new LinkNode(1);
        }
        return res.next;
    }

    public LinkNode sum(LinkNode node1, LinkNode node2) {
        LinkNode res = new LinkNode(-1);
        LinkNode curNode = res;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int v1 = node1 == null ? 0 : node1.value;
            int v2 = node2 == null ? 0 : node2.value;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            curNode.next = new LinkNode(sum);

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
            curNode = curNode.next;
        }
        if (carry == 1) {
            curNode.next = new LinkNode(1);
        }
        return res.next;
    }


    public int[] twoNumberSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int tmp = target - arr[i];
            if (!map.containsValue(target - arr[i])) {
                map.put(i, arr[i]);
            } else {
                return new int[]{target - arr[i], arr[i]};
            }
        }
        return null;
    }


/*    private int find(int[] arr,int left, int right,int target)
    {



    }*/

    public List<List<Integer>> threeNumbersSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int tmp = target - arr[i];
            // 二分查找
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {

                if (arr[left] + arr[right] < tmp) {
                    left++;
                } else if (arr[left] + arr[right] > tmp) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(list);

                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }


    List<LinkedList<Integer>> result = new ArrayList<>();

    LinkedList<Integer> paths = new LinkedList<>();

    public List<LinkedList<Integer>> threeNumberSum(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        threeNumbersSum(arr, target, 0);
        return result;

    }

    private void threeNumbersSum(int[] arr, int target, int index) {
        if (paths.size() == 3) {
            result.add(new LinkedList<>(paths));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            //if(!paths.contains(arr[i]) ){
            paths.add(arr[i]);
            // }
            threeNumbersSum(arr, target, i + 1);
            paths.removeLast();
        }
    }


    public static void main(String[] args) {
        LeetCode2 leetCode = new LeetCode2();

        LinkNode node1 = new LinkNode(0);
        node1.next = new LinkNode(9);
        node1.next.next = new LinkNode(9);

        LinkNode node2 = new LinkNode(0);
        node2.next = new LinkNode(9);

        // LinkNode node = leetCode.sum(node1, node2);
        // System.out.println(node);

        //System.out.println(leetCode.binarySum("100", "1000000000"));

        //String s="abcdefghi";
/*
        String s = "01";

        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            System.out.print("=");
            System.out.println(s.charAt(i) - '0');
        }*/

        int[] arr = {2, 4, 7};
//        int[] res = leetCode.twoNumberSum(arr, 8);
//        if (res != null) {
//            Arrays.stream(res).forEach(System.out::println);
//        }

       /* List<List<Integer>> list = leetCode.threeNumbersSum(arr, 10);

        System.out.println(list);
        list.stream().flatMap(element -> element.stream()).forEach(System.out::println);*/

        //list.stream().map(element->Arrays.stream(element.toArray()).map(stream->stream.toString()).forEach(System.out::println);
        leetCode.threeNumberSum(arr, 10);
        System.out.println(leetCode.result);


        //List<Integer> list =Arrays.asList(new Integer[]{1, 2, 3});
        //System.out.println( list .stream().mapToInt(element->element).sum());
       /* leetCode.result.stream()
                .flatMap(paths-> paths.stream()).mapToInt(element->element).forEach(System.out::println);*/

        leetCode.result.stream().map(list -> list.stream().mapToInt(element -> element).sum()).forEach(System.out::println);

    }
}
