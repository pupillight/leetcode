package org.yj.leetcode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode388 {
    public int lengthLongestPath(String s) {

        Map<Integer, String> map = new HashMap<>();
        int n = s.length();
        String ans = null;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') isDir = false;
            }
            String cur = s.substring(i, j);
            String prev = map.getOrDefault(level - 1, null);
            String path = prev == null ? cur : prev + "/" + cur;
            if (isDir) map.put(level, path);
            else if (ans == null || path.length() > ans.length()) ans = path;
            i = j + 1;
        }
        return ans == null ? 0 : ans.length();

    }


    public String addBinary(String a, String b) {

        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int t1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int t2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = carry + t1 + t2;
            carry = sum / 2;
            sum = sum % 2;
            builder.append(sum);
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append("1");
        }

        return builder.reverse().toString();
    }

    public int singleNumber(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public int reverseBits(int n) {

      /*String a=  Integer.toBinaryString(n);

      StringBuilder builder = new StringBuilder();
      String b=builder.append(a).reverse().toString();
      System.out.println(b);
      Byte.toUnsignedInt(b)*/
        return -1;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) {
                if (i < s.length() - 1 && map.get(c) < map.get(s.charAt(i + 1))) {
                    ans = ans - map.get(c);
                } else {
                    ans = ans + map.get(c);
                }
            }
        }
        return ans;
      /*  for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = map.get(c);
            if (map.get(c) != null) {
                if (i > 0 && s.charAt(i - 1) == 'I' && (c == 'V' || c == 'X')) {
                    ans = ans + map.get(c) - 2;
                }
                else if (i > 0 && s.charAt(i - 1) == 'X' && (c == 'L' || c == 'C')) {
                    ans = ans + map.get(c) - 20;
                }
                else if (i > 0 && s.charAt(i - 1) == 'C' && (c == 'D' || c == 'M')) {
                    ans = ans + map.get(c) - 200;
                }
                else {
                    ans = ans + map.get(c);
                }
            }
        }*/

    }

    public String intToRoman(int num) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int tmp = num;
        int mod = 0;
        List<Integer> list = new ArrayList<>();
        while (tmp > 0) {
            mod = tmp % 10;
            list.add(mod);
            tmp = tmp / 10;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) * (int) Math.pow(10, i));
            int value = list.get(i) * (int) Math.pow(10, i);

           if(value>10){

           }

            if (value == 5) {
                builder.append(map.get(value));
            } else if (value > 5) {
                builder.append("V");
                value = value - 5;
                while (value > 0) {
                    builder.append("I");
                    value--;
                }
            }
        }
        return builder.toString();

    }

    public static void main(String[] args) {
        LeetCode388 leetCode = new LeetCode388();
        /*String input1 = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        String input2 = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";


        String[] paths = input2.split("[\r\n]+");
        leetCode.lengthLongestPath(input2);
        */

        //leetCode.reverseBits(43261596);
        /*System.out.println(leetCode.romanToInt("III"));
        System.out.println(leetCode.romanToInt("IV"));
        System.out.println(leetCode.romanToInt("IX"));
        System.out.println(leetCode.romanToInt("LVIII"));
        System.out.println(leetCode.romanToInt("MCMXCIV"));
        System.out.println(leetCode.romanToInt("XXVII"));*/

        System.out.println(leetCode.intToRoman(58));
        //System.out.println(leetCode.addBinary("11", "111"));
    }
}
