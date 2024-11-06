package org.yj.leetcode;

import java.util.Arrays;

public class LeetCode2389 {

    //the first element which is bigger or equal the target
    public int findIndex(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (array[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int len = nums.length;
        int[] preSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            //find the index in presum array;

            int index = findIndex(preSum, query + 1);

            index = index - 1;
            res[i] = index;
        }
        return res;
    }


    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int c = success % spells[i] == 0 ? 0 : 1;
            //long t = success / spells[i] + c;

            long t = (success + spells[i] - 1) / spells[i] - 1;
            int index = findIndex(potions, (int) t);

            res[i] = potions.length - index;
        }
        return res;
    }


    public int getNumber(String str) {

        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return arr[i];
            }
        }
        return -1;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] arr2 = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int t = getNumber(words[i]);
            arr2[i] = t;
        }
        Arrays.sort(arr2);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int t = getNumber(query);
            int d = findIndex(arr2, t + 1);
            res[i] = arr2.length - d;
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode2389 instance = new LeetCode2389();

        //int[] nums = {4, 5, 2, 1};
        // int[] queries = {3, 10, 21};

        // int[] res = instance.answerQueries(nums, queries);

        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        instance.numSmallerByFrequency(queries, words);

    }
}
