package org.yj.leetcode;

import java.util.*;

public class LeetCode316 {
    //O(n^2+n*m)
    public int maxMultiplyResult(String[] array) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            int bitmap = 0;
            for (char c : word.toCharArray()) {
                bitmap = bitmap | 1 << c - 'a';
            }
            map.put(bitmap, Math.max(map.getOrDefault(bitmap, 0), word.length()));
        }
        for (int bitmap1 : map.keySet()) {
            for (int bitmap2 : map.keySet()) {
                if ((bitmap1 & bitmap2) == 0) {
                    res = Math.max(res, map.get(bitmap1) * map.get(bitmap2));
                }
            }
        }

        return res;
    }

    //O(n^2+n*m)
    public int maxMultiplyResult2(String[] array) {
        int res = 0;
        int[] bitmaps = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            for (char c : word.toCharArray()) {
                bitmaps[i] = bitmaps[i] | 1 << c - 'a';
            }
        }
        for (int i = 0; i < bitmaps.length; i++) {
            for (int j = i + 1; j < bitmaps.length; j++) {
                if ((bitmaps[i] & bitmaps[j]) == 0) {
                    res = Math.max(res, array[i].length() * array[j].length());
                }
            }
        }
        return res;
    }

    //O(n^2*m)
    public int maxMultiplyResult1(String[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            String word1 = array[i];
            for (int j = i + 1; j < array.length; j++) {
                String word2 = array[j];
                if (!hasSameCharacter(word1, word2)) {
                    res = Math.max(res, word1.length() * word2.length());
                }
            }
        }
        return res;
    }


    //O(m)
    private boolean hasSameCharacter(String word1, String word2) {
        int bitmap1 = 0;
        for (char c : word1.toCharArray()) {
            bitmap1 = bitmap1 | 1 << (c - 'a');
        }
        int bitmap2 = 0;
        for (char c : word2.toCharArray()) {
            bitmap2 = bitmap2 | 1 << (c - 'a');
        }
        if ((bitmap1 & bitmap2) > 0) {
            return true;
        }
        return false;
    }

    //o(m)
    private boolean hasSameCharacter2(String word1, String word2) {
        int[] array = new int[26];

        for (char c : word1.toCharArray()) {
            array[c - 'a'] = 1;
        }
        for (char c : word2.toCharArray()) {
            if (array[c - 'a'] == 1) {
                return true;
            }
        }
        return false;
    }

    //0(m^2)
    private boolean hasSameCharacter1(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) > -1) {
                return true;
            }
        }
        return false;
    }


    List<List<Character>> list = new ArrayList<>();
    LinkedList<Character> characters = new LinkedList<>();

    public void availableParentheses(int n) {
        String str = "()";
        availableParentheses(n, str, 0, 0);

    }

    private void availableParentheses(int n, String text, int left, int right) {
        if (characters.size() == 2 * n) {
            list.add(new LinkedList<>(characters));
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
          /*  if (left > n) {
                continue;
            }
            if (c == '(') {
                left++;
            } else {
                right++;
            }*/


            characters.add(c);
            availableParentheses(n, text, left, right);
            characters.removeLast();
        }

    }


    public List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, "", list, 0, 0);
        return list;
    }


    public void dfs(int n, String path, List<String> list, int left, int right) {
        if (right > left) {
            return;
        }
        if(left>n)
        {
            return;
        }
        if (path.length() == 2 * n) {
            list.add(path);
            return;
        }


        dfs(n, path + "(", list, left + 1, right);
        dfs(n, path + ")", list, left, right + 1);
    }

    public static void main(String[] args) {
        LeetCode316 leetCode = new LeetCode316();

        //String[] array = {"abc", "bcd", "efgi", "ppabeppp"};
        //System.out.println(leetCode.maxMultiplyResult(array));
        //leetCode.availableParentheses(2);
        //leetCode.list.stream().forEach(System.out::println);

        List<String> res = leetCode.generateParentheses(3);
        res.stream().forEach(System.out::println);

    }


}
