package org.yj.application.data;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.stream.Collectors;

public class Tester {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 7, 9};

        //Arrays.stream(arr).sorted().forEach(System.out::println);
        Tester tester = new Tester();
/*        tester.mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);*/

        //String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};

        String[] s = {"bdddddddddd", "bbbbbbbbbbc"};
        System.out.println(tester.groupAnagrams(s));
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid - 1);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int len = end - start + 1;
        int index = 0;
        int[] tmp = new int[len];
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= end) {
            tmp[index++] = arr[j++];
        }
        for (int k = 0; k < len; k++) {
            arr[start + k] = tmp[k];
        }
    }

    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'a']++;
            }

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (arr[j] > 0) {
                    char c = (char) (j + 'a');//还原
                    builder.append(c);
                    builder.append(arr[j]);
                }
            }

            List<String> list = map.getOrDefault(builder.toString(), new ArrayList<>());
            list.add(str);
            map.put(builder.toString(), list);
        }
        return new ArrayList<>(map.values());

      /*  int len = strs.length;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] arr = new int[26];
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                arr[c - 'a']++;
            }
            map.put(arr, i);
        }

        Map<String, List<String>> map2 = new HashMap<>();
        map.entrySet().stream().sorted((e1, e2) -> {
                    int[] arr1 = e1.getKey();
                    int[] arr2 = e2.getKey();
                    return Arrays.compare(arr1, arr2);

                }
        ).forEach(entry -> {
            int arr[] = entry.getKey();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                builder.append(arr[i]);
            }
            String key = builder.toString();
            List tmp = map2.getOrDefault(key, new ArrayList<String>());
            tmp.add(strs[entry.getValue()]);
            map2.put(key, tmp);
        });

        //System.out.println(map2);
        List<List<String>> res= new ArrayList<>();
        map2.entrySet().stream().forEach(entry->res.add(entry.getValue()));
        System.out.println(res);
        return res;*/
        /*Map<Character, Integer> map = new HashMap();
        ArrayList<List<String>> list = new ArrayList();
        if (strs.length == 0) {
            list.add(List.of(""));
            return list;
        }

        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (strs.length == 1) {
            list.add(List.of(str));
            return list;
        }
        String tmp = str;
        List<String> tmpList = List.of(tmp);
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
               // map.containsKey(s.charAt(j));
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
            if (map.isEmpty()) {
                tmpList.add(s);
            }
        }
*/


    }


}
