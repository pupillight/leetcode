package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode721 {

    class UnionFind {
        int[] parents;
        int count;

        public UnionFind(int n) {
            count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int p) {
            while (parents[p] != p) {
                p = parents[p];
            }
            return p;
        }

        public boolean isConnect(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            parents[qRoot] = pRoot;
            count--;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    int p = map.get(email);
                    uf.union(p, i);
                }
            }
        }

        Map<Integer, List<String>> idEmailsMap = new HashMap<>();
        idEmailsMap = map.entrySet().stream().collect(
                Collectors.groupingBy(item -> {
                    int id = item.getValue();
                    id = uf.find(id);
                    return id;
                }, Collectors.mapping(item -> item.getKey(), Collectors.toList())));


        List<List<String>> res = new ArrayList<>();
        idEmailsMap.entrySet().stream().forEach(
                (entry) -> {
                    int id = entry.getKey();
                    List<String> account = entry.getValue();
                    Collections.sort(account);
                    String name = accounts.get(id).get(0);
                    account.add(0, name);
                    res.add(account);
                }

        );
        res.stream().forEach(System.out::println);
               /* for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int id = entry.getValue();
            id = uf.find(id);
            List<String> emails = idEmailsMap.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idEmailsMap.put(id, emails);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : idEmailsMap.entrySet()) {

            int id = entry.getKey();
            List<String> account = entry.getValue();
            Collections.sort(account);
            String name = accounts.get(id).get(0);
            account.add(0, name);
            res.add(account);
        }
        res.stream().forEach(System.out::println);*/
        return res;

    }


    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};
        Leetcode721 instance = new Leetcode721();

        List<String> list1 = List.of("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> list2 = List.of("John", "johnnybravo@mail.com");
        List<String> list3 = List.of("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> list4 = List.of("Mary", "mary@mail.com");
        List<List<String>> list = List.of(list1, list2, list3, list4);

        instance.accountsMerge(list);

    }


}