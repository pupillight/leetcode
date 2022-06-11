package org.yj.application.data.structure.tree;

import java.util.Map;
import java.util.TreeMap;

public class Trie {

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> next;

        public TrieNode() {
            isWord = false;
            next = new TreeMap<>();
        }
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        add(root, word);
    }

    private void add(TrieNode node, String word) {
        add(node, word, 0);
    }

    private void add(TrieNode node, String word, int i) {
        if (i == word.length()) {
            node.isWord = true;
            return;
        }
        char c = word.charAt(i);
        if (!node.next.containsKey(c)) {
            node.next.put(c, new TrieNode());
        }
        add(node.next.get(c), word, i + 1);
    }

    public void add1(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            if (!curNode.next.containsKey(c))
                curNode.next.put(c, new TrieNode());
            curNode = curNode.next.get(c);
        }
        curNode.isWord = true;
    }


    public boolean contains(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
        }
        return node.isWord;
    }

    public boolean startWith(String prefix) {
        return startWith(root, prefix, 0);
    }

    private boolean startWith(TrieNode node, String prefix, int index) {
        if (index == prefix.length()) {
            return true;
        }
        if (node.next.get(prefix.charAt(index)) == null) {
            return false;
        }
        return startWith(node.next.get(prefix.charAt(index)), prefix, index + 1);
    }

    public boolean startWith1(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next.get(c) == null) {
                return false;
            }
            node = node.next.get(c);
        }
        return true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            Map<Character, TrieNode> map = node.next;
            for (Character key : map.keySet()) {
                if (match(map.get(key), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("hello");
        trie.add("cat");
        trie.add("dog");
        trie.add("hot");
        trie.add("panda");
        System.out.println(trie);

        System.out.println(trie.contains("hello"));
        System.out.println(trie.contains("dog"));
        System.out.println(trie.contains("hot"));
        System.out.println(trie.contains("psnda"));
        System.out.println(trie.startWith("hat"));


    }
}
