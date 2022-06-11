package org.yj.leetcode;

import javax.swing.event.ListDataEvent;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCode {

    public String[] findRelativeRanks1(int[] score) {
        Map<Integer, Integer> map = new TreeMap<>();
        String[] answer = new String[score.length];
        Integer[] sortedScore = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
            sortedScore[i] = score[i];
        }
        Arrays.sort(sortedScore, (e1, e2) -> e2 - e1);

        for (int i = 0; i < sortedScore.length; i++) {
            int index = map.get(sortedScore[i]);
            switch (i) {
                case 0:
                    answer[index] = "Gold Medal";
                    break;
                case 1:
                    answer[index] = "Silver Medal";
                    break;
                case 2:
                    answer[index] = "Bronze Medal";
                    break;
                default:
                    answer[index] = i + 1 + "";
                    break;
            }
        }
        return answer;
    }

    //506
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new TreeMap<>((e1, e2) -> e2 - e1);
        String[] answer = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            int index = map.get(key);
            switch (i) {
                case 0:
                    answer[index] = "Gold Medal";
                    break;
                case 1:
                    answer[index] = "Silver Medal";
                    break;
                case 2:
                    answer[index] = "Bronze Medal";
                    break;
                default:
                    answer[index] = (i + 1) + "";
                    break;
            }
            i++;
        }

        for (int j = 0; j < score.length; j++) {

            System.out.println(map.get(score[j]));
        }


        return answer;
    }

    //2099
    public List<Integer> maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>((e1, e2) -> e2 - e1);
        Integer[] res = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int i = 0;
        for (Integer key : map.keySet()) {
            if (i >= k) {
                break;
            }
            res[map.get(key)] = key;
            i++;
        }

        List<Integer> list = Arrays.stream(res).filter(e -> e != null).collect(Collectors.toList());
        return list;
    }

    public int maxProduct(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int num : nums) {
            queue.add(num);
        }

        int num1 = queue.poll();
        int num2 = queue.poll();
        return num1 * num2;
    }

    //2231. 按奇偶性交换后的最大数字
    public int largestInteger(int num) {


        PriorityQueue<Integer> oddQueue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        PriorityQueue<Integer> evenQueue = new PriorityQueue<>((e1, e2) -> e2 - e1);
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) {
            int t = c - '0';
            if (t % 2 == 1) {
                oddQueue.add(t);
            } else {
                evenQueue.add(t);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            int t = c - '0';
            if (t % 2 == 1) {
                builder.append(oddQueue.poll());
            } else {
                builder.append(evenQueue.poll());
            }
        }
        return Integer.parseInt(builder.toString());

    }


    //347. 前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Frequence> queue = new PriorityQueue<>((e1, e2) -> e1.count - e2.count);
        int index = 0;
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(new Frequence(key, map.get(key)));
            } else {
                int top = queue.peek().count;
                if (map.get(key) > top) {
                    queue.poll();
                    queue.add(new Frequence(key, map.get(key)));
                }
            }
            index++;
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().num;
        }

        return res;
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }
        Collections.sort(list, (e1, e2) -> e2 - e1);

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
            ans++;
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return ans;
    }

    public String kthLargestNumber(String[] nums, int k) {

        /*PriorityQueue<Integer> queue = new PriorityQueue<>((e1,e2)->e2-e1);
        for(String num:nums){
            queue.add(Integer.parseInt(num));
        }
        int i=0;
        String res =null;
        while(i<k)
        {
            res =queue.poll()+"";
            i++;
        }
        return res;*/


        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    return -o1.compareTo(o2);
                }
            }
        });
        for (String num : nums) {
            queue.add(num);
        }
        int i = 0;
        String res = null;
        while (i < k) {
            res = queue.poll();
            i++;
        }
        return res;

    }

    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();

        //int[] score = {-1, -2, 3, 4};
        //int[] score = {10, 3, 8, 9, 4};
        //Arrays.stream(leetCode.findRelativeRanks(score)).forEach(System.out::println);
        //System.out.println(leetCode.maxSubsequence(score, 3));
        // System.out.println(leetCode.maxProduct(score));

        //System.out.println(leetCode.largestInteger(1234));
        // int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        //int[] nums = {7,7,7,7,7,7,7};

        //int[] nums = {4, 1, -1, 2, -1, 2, 3};
        //int[] nums = {1, 1};
        //Arrays.stream(leetCode.topKFrequent(nums, 2)).forEach(System.out::println);

        //System.out.println( leetCode.minSetSize(nums));
        String[] arr = {"3", "6", "7", "10"};
        System.out.println(leetCode.kthLargestNumber(arr, 1));

    }

}

class Frequence {
    int num;
    int count;

    public Frequence(int num, int count) {
        this.num = num;
        this.count = count;
    }
}
