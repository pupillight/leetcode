package org.yj.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.*;

public class StringQuestions {
    /* public int lengthOfLastWord(String s) {
         String text = s.trim();
         char[] chars = text.toCharArray();
         int count = 0;
         for (int i = chars.length - 1; i >= 0; i--) {
             if (chars[i] == ' ') {
                 break;
             }
             count++;
         }
         return count;
     }

     public String convertToTitle(int columnNumber) {

         String ans = "";
         StringBuilder builder = new StringBuilder();
         while (columnNumber != 0) {
             columnNumber--;
             char c = (char) (columnNumber % 26 + 'A');
             builder.append(c);
             columnNumber = columnNumber / 26;
         }
         ans = builder.reverse().toString();
         return ans;
     }

     public int str2Int(String str) {
         int ans = 0;
         int m = 0;
         char[] chars = str.toCharArray();
         while (m < str.length()) {
             ans = ans * 10 + (chars[m] - '0');
             m++;
         }
         return ans;
     }

     public int titleToNumber(String columnTitle) {

         char[] chars = columnTitle.toCharArray();
         int m = 0;
         int sum = 0;
         while (m < chars.length) {
             sum = sum * 26 + (chars[m] - 'A' + 1);
             m++;
         }
         return sum;
     }

     public boolean wordPattern(String pattern, String s) {
         char[] chars = pattern.toCharArray();
         String[] words = s.split(" ");
         if (chars.length != words.length) {
             return false;
         }
         Map<Character, String> map1 = new HashMap<>();
         Map<String, Character> map2 = new HashMap<>();

         int m = 0;
         int n = 0;
         map1.put(chars[m], words[n]);
         map2.put(words[n], chars[m]);
         for (int i = 1; i < chars.length; i++) {
             char c = chars[i];
             String word = words[i];
             if (c == chars[m] && !map1.get(c).equals(word)) {
                 return false;
             }
             if (map1.get(c) == null && map2.get(word) == null) {
                 map1.put(c, word);
                 map2.put(word, c);
             } else if (!map1.containsKey(c) || !map2.containsValue(word) && (!map1.get(c).equals(word) || !(map2.get(word) == c))) {
                 return false;
             }
             m++;
         }
         return true;
     }

     public boolean repeatedSubstringPattern(String s) {

         for (int m = 0; m < s.length() / 2; m++) {
             String pattern = s.substring(0, m + 1);
             int i = 0;
             int j = 0;

             while (i < pattern.length() && j < s.length()) {
                 char c1 = pattern.charAt(i);
                 char c2 = s.charAt(j);
                 if (c1 == c2) {
                     i++;
                     j++;
                 } else {
                     break;
                 }
                 if (i == pattern.length()) {
                     i = 0;
                 }
             }
             if (j == s.length() && i == 0) {
                 return true;
             }
         }
         return false;
     }

     public int largestRectangleArea(int[] heights) {

         if (heights.length == 1) {
             return heights[0];
         }
         int result = Integer.MIN_VALUE;
         int[] nums = new int[heights.length + 2];
         nums[0] = 0;
         for (int i = 0; i < heights.length; i++) {
             nums[i + 1] = heights[i];
         }
         nums[nums.length - 1] = 0;

         LinkedList<Integer> list = new LinkedList<>();
         list.add(0);


         for (int i = 1; i < nums.length; i++) {
             if (list.size() > 0 && nums[i] >= nums[list.getFirst()]) {
                 list.addFirst(i);
             } else {
                 while (list.size() > 0 && nums[i] < nums[list.getFirst()]) {
                     int mid = list.getFirst();
                     list.removeFirst();
                     int left = list.getFirst();
                     int right = i;
                     int s = nums[mid] * (right - left - 1);
                     result = Math.max(result, s);
                 }
                 list.addFirst(i);
             }
         }
         return result;
     }


     public int KMP(String text, String pattern) {

         int i = 0;
         int len1 = text.length();

         int j = 0;
         int len2 = pattern.length();

         int[] next = new int[pattern.length()];
         createNextArray(pattern, next);
         while (i < len1 && j < len2) {
             //char c1 = text.charAt(i);
             //char c2 = pattern.charAt(j);
             if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                 j++;
             } else {
                 j = next[j];
             }
             i++;
         }
         if (j == len2) {
             return i - j;
         }

         return -1;
     }

     private void createNextArray(String pattern, int[] next) {
         next[0] = -1;
         next[1] = 0;
         int i = 2, k = 0;

         while (i < pattern.length()) {
             if (k == -1 || pattern.charAt(i - 1) == pattern.charAt(k)) {
                 //next[i] = next[i - 1] + 1;
                 next[i] = k + 1;
                 i++;
                 k++;
             } else {
                 k = next[k];
             }
         }

     }

     public int[] numberOfLines(int[] widths, String s) {

         int sum = 0;
         int line = 1;
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             int width = widths[c - 'a'];
             if (sum + width <= 100) {
                 sum = sum + width;

             } else {
                 line++;
                 sum = width;
             }

         }
         int[] ans = {line, sum};
         return ans;
     }

     public static double average(int a, int b) {
         return a + b / 2;
     }

     public static String[] uniqueNames(String[] names1, String[] names2) {

         java.util.Set<String> set = new HashSet();
         for (String s : names1) {
             set.add(s);
         }
         for (String s : names2) {
             set.add(s);
         }
         String[] ans = set.toArray(new String[set.size()]);
         return ans;
         // throw new UnsupportedOperationException("Waiting to be implemented.");
     }

     private void addChar2Stack(String s, LinkedList<Character> list) {
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (list.size() > 0 && c >= list.getFirst()) {
                 while (list.size() > 0 && c >= list.getFirst()) {
                     list.removeFirst();
                 }
             }
             list.add(c);
         }
     }

     public boolean isIsomorphic(String s, String t) {

         Map<Character, Character> map1 = new HashMap<>();
         Map<Character, Character> map2 = new HashMap<>();
         for (int i = 0; i < s.length(); i++) {
             char c1 = s.charAt(i);
             char c2 = t.charAt(i);
             if (map1.containsKey(c1) && map1.get(c1) != c2 ||
                     map2.containsKey(c2) && map2.get(c2) != c1) {
                 return false;
             }
             map1.put(c1, c2);
             map2.put(c2, c1);
         }
         return true;
     }

     public int findTheLongestBalancedSubstring(String s) {

         int m = 0;
         int n = 0;
         int ans = 0;
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (c == '0') {
                 m++;
             } else if (c == '1') {
                 n++;
                 if (i + 1 < s.length() && s.charAt(i + 1) == '0' || i == s.length() - 1) {
                     int max = Math.min(m, n);
                     ans = Math.max(ans, max);
                     m = 0;
                     n = 0;
                 }
             }
         }
         return ans * 2;



     }

     public int maximumValue(String[] strs) {

         int ans = -1;
         for (int i = 0; i < strs.length; i++) {
             String str = strs[i];
             if (isNumber(str)) {
                 ans = Math.max(ans, Integer.valueOf(str));
             } else {
                 ans = Math.max(ans, str.length());
             }
         }
         return ans;
     }

     private boolean isNumber(String str) {

         for (int i = 0; i < str.length(); i++) {
             if (!Character.isDigit(str.charAt(i))) {
                 return false;
             }
         }
         return true;
     }


     @Test
     public void testMethod() {
         System.out.println(6 / 3);
         Assert.assertEquals(false, true);
     }


     private boolean compareStr(String text, String pattern) {
         int m = 0;
         int lenM = text.length();
         int n = 0;
         int lenN = pattern.length();

         int countM = 0;
         int countN = 0;
         while (m < lenM) {
             char c1 = text.charAt(m);
             if (Character.isUpperCase(c1)) countM++;
             if (n < lenN) {
                 char c2 = pattern.charAt(n);
                 if (c1 == c2) {
                     if (Character.isUpperCase(c2)) countN++;
                     n++;
                 }
             }
             m++;
         }
         if (countM == countN && n == lenN) {
             return true;
         }
         return false;
     }

     public List<Boolean> camelMatch(String[] queries, String pattern) {

         List<Boolean> list = new ArrayList<>();
         for (int i = 0; i < queries.length; i++) {
             String query = queries[i];
             boolean res = compareStr(query, pattern);
             list.add(res);
         }
         return list;

     }


     public boolean isCircularSentence(String sentence) {

         String[] words = sentence.split(" ");
         for (int i = 0; i < words.length; i++) {
             char end = words[i].charAt(words[i].length() - 1);
             int j = (i + 1) % words.length;
             char start = words[j].charAt(0);
             if (end != start) {
                 return false;
             }
         }
         return true;
     }

     private boolean isEqual(String a, String b) {
         int v = a.charAt(0) - b.charAt(0);
         for (int i = 0; i < a.length(); i++) {
             if ((a.charAt(i) - b.charAt(i)) != v) {
                 return false;
             }
         }
         return true;
     }

     public String oddString(String[] words) {
         boolean[] diffs = new boolean[words.length];
         diffs[0] = true;
         for (int i = 1; i < words.length; i++) {
             diffs[i] = isEqual(words[0], words[i]);
         }

         if (diffs[1] == false && diffs[2] == false) {
             return words[0];
         }
         for (int i = 1; i < diffs.length; i++) {
             if (diffs[i] == false) {
                 return words[i];
             }
         }
         return words[0];
     }

     public int minNumBooths(String[] demand) {
         int[] res = new int[26];
         for (int i = 0; i < demand.length; i++) {
             String str = demand[i];
             int[] array = new int[26];
             for (int j = 0; j < str.length(); j++) {
                 char c = str.charAt(j);
                 array[c - 'a']++;
             }
             for (int j = 0; j < 26; j++) {
                 res[j] = Math.max(res[j], array[j]);
             }
         }
         return Arrays.stream(res).sum();
     }

     public int minNumBooths1(String[] demand) {
         List<int[]> list = new ArrayList<>();
         for (int i = 0; i < demand.length; i++) {
             int[] array = new int[26];
             String str = demand[i];
             for (int j = 0; j < str.length(); j++) {
                 char c = str.charAt(j);
                 array[c - 'a'] = array[c - 'a'] + 1;
             }
             list.add(array);
         }
         int[] res = new int[26];
         for (int m = 0; m < 26; m++) {
             for (int i = 0; i < list.size(); i++) {
                 res[m] = Math.max(list.get(i)[m], res[m]);
             }
         }
         return Arrays.stream(res).sum();
     }

     public String oddString1(String[] words) {

         Map<String, List<Integer>> map = new HashMap<>();
         for (int i = 0; i < words.length; i++) {
             String cur = diff(words[i]);
             if (!map.containsKey(cur)) {
                 List<Integer> list = new ArrayList<>();
                 list.add(i);
                 map.put(cur, list);
             } else {
                 map.get(cur).add(i);
             }
         }

         int index = map.values().stream().filter(e -> e.size() == 1).mapToInt(e -> e.get(0)).findFirst().getAsInt();
         return words[index];
     }

     private String diff(String word) {
         StringBuilder builder = new StringBuilder();
         for (int i = 1; i < word.length(); i++) {
             int v = word.charAt(i) - word.charAt(i - 1);
             builder.append(v);
             builder.append("-");
         }
         return builder.toString().substring(0, builder.length() - 1);
     }

     public String licenseKeyFormatting(String s, int k) {

         int m = s.length() - 1;
         StringBuilder builder = new StringBuilder();
         int index = 0;
         while (m >= 0) {
             if (index == k) {
                 index = 0;
                 builder.append("-");
             }
             char c = s.charAt(m);
             if (index < k && c != '-') {
                 builder.append(c);
                 index++;
             }
             m--;
         }

         String ans = builder.reverse().toString().toUpperCase();
         if (ans.startsWith("-")) {
             return ans.substring(1, ans.length());
         }
         return ans;
     }

     public String addStrings(String num1, String num2) {

         int i = num1.length() - 1;
         int j = num2.length() - 1;
         int carry = 0;
         StringBuilder builder = new StringBuilder();
         while (i >= 0 || j >= 0) {
             int c1 = (i < 0) ? 0 : num1.charAt(i) - '0';
             int c2 = (j < 0) ? 0 : num2.charAt(j) - '0';
             int c = c1 + c2 + carry;
             builder.append(c % 10);
             carry = c / 10;
             i--;
             j--;
         }

         if (carry > 0) {
             builder.append(carry);
         }
         return builder.reverse().toString();
     }

     public String reverseWords(String s) {

         s = s.trim();
         int i = s.length() - 1;
         int j = s.length();
         StringBuilder builder = new StringBuilder();
         while (i >= 0) {
             char c = s.charAt(i);
             if (c == ' ') {
                 String word = s.substring(i + 1, j);
                 if (word != null && word.trim().length() > 0) {
                     builder.append(word);
                     builder.append(" ");
                 }
                 j = i;
             }
             i--;
         }
         builder.append(s.substring(i + 1, j));
         return builder.toString().trim();
     }

     public String reverseLeftWords(String s, int n) {

         if (s == null || s.length() == 0) return s;
         if (n <= 0) return s;
         StringBuilder builder = new StringBuilder();
         for (int i = n; i < s.length(); i++) {
             builder.append(s.charAt(i));
         }
         for (int i = 0; i < n; i++) {
             builder.append(s.charAt(i));
         }
         return builder.toString();
     }

     public boolean validPalindrome(String s) {
         int m = s.length();
         int mid = m / 2;
         int i = 0;
         int j = s.length() - 1;
         int index = 0;
         if (m % 2 == 0) {
             while (i <= mid - 1 && j >= mid) {

                 if (i == mid - 1 && j == mid) {
                     break;
                 }
                 if (s.charAt(i) != s.charAt(j)) {
                     return false;
                 }
                 i++;
                 j--;
             }
         } else {
             while (i < mid && j > mid) {
                 if (s.charAt(i) != s.charAt(j)) {
                     return false;
                 }
                 i++;
                 j--;
             }
         }
         return true;
     }


     public boolean isPalindrome(String s) {

         int i = 0;
         int j = s.length() - 1;
         while (i < j) {
             while (i < j && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) i++;
             while (i < j && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))) j--;
             if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
             i++;
             j--;
         }
         return true;

     }

     public int closetTarget(String[] words, String target, int startIndex) {

         if (words == null || words.length == 0) {
             return -1;
         }
         int ans = Integer.MAX_VALUE;
         int len = words.length;
         for (int i = startIndex; i < words.length + startIndex; i++) {
             String word = words[i % len];
             if (word.equals(target)) {
                 int rMin = i - startIndex;
                 int lMin = len + startIndex - i;
                 int curMin = Math.min(lMin, rMin);
                 ans = Math.min(ans, curMin);
             }
         }
         return ans;


     }

     public List<String> cellsInRange(String s) {
         List<String> res = new ArrayList<>();
         for (char i = s.charAt(0); i <= s.charAt(3); i++) {
             for (char j = s.charAt(1); j <= s.charAt(4); j++) {
                 res.add(new String(new char[]{i, j}));
             }
         }
         return res;

     }

     private int compareTimes(String t1, String t2) {

         int h1 = Integer.valueOf(t1.substring(0, 2));
         int min1 = Integer.valueOf(t1.substring(3, 5));
         int h2 = Integer.valueOf(t2.substring(0, 2));
         int min2 = Integer.valueOf(t2.substring(3, 5));

         int diff = 0;
         if (min2 >= min1) {
             diff += min2 - min1;
             diff += (h2 - h1) * 60;

         } else {
             diff += 60 + min2 - min1;
             diff += (h2 - h1 - 1) * 60;
         }
         int step = 0;
         step = diff / 60;
         int a = diff % 60;
         if (a >= 15) {
             step += a / 15;
             int b = a % 15;
             if (b >= 5) {
                 step += b / 5;
                 step += b % 5;
             } else {
                 step += b;
             }

         } else if (a >= 5 && a < 15) {
             step += a / 5;
             int b = a % 5;
             step += b;
         } else {
             step += a;
         }

         return step;
     }

     public int convertTime(String current, String correct) {
         return compareTimes(current, correct);
     }

     public boolean isAnagram(String s, String t) {

         if (s.length() != t.length()) {
             return false;
         }
         if (s.equals(t)) return false;
         int[] arr1 = new int[26];
         int[] arr2 = new int[26];
         for (int i = 0; i < s.length(); i++) {
             arr1[s.charAt(i) - 'a']++;
             arr2[t.charAt(i) - 'a']++;
         }
         for (int i = 0; i < 26; i++) {
             if (arr1[i] != arr2[i]) return false;
         }
         return true;


     }

     public String digitSum(String s, int k) {

         int len = s.length();
         if (k >= len) {
             return s;
         }
         int i = 0;
         int sum = 0;
         StringBuilder builder = new StringBuilder();
         List<Integer> list = new ArrayList<>();
         while (i < len) {
             list.add(s.charAt(i) - '0');
             i++;
             if (i % k == 0) {
                 sum = list.stream().mapToInt(e -> e).sum();
                 builder.append(sum);
                 list.clear();
             }
         }
         if (list.size() > 0) {
             sum = list.stream().mapToInt(e -> e).sum();
             builder.append(sum);
         }
         return digitSum(builder.toString(), k);

     }


     private int compareStrs(String s1, String s2) {
         if (s1.length() != s2.length()) return -1;
         for (int i = 0; i < s1.length(); i++) {
             char c1 = s1.charAt(i);
             char c2 = s2.charAt(i);
             if (c1 - c2 > 0) {
                 return 1;
             } else if (c1 - c2 == 0) {
                 continue;
             } else {
                 return -1;
             }

         }
         return 0;
     }

     private String max(String s1, String s2) {
         int value = s1.compareTo(s2);
         if (value >= 0) {
             return s1;
         }
         return s2;

     }

     public String removeDigit(String number, char digit) {
         String pre = null;
         String ans = null;
         for (int i = 0; i < number.length(); i++) {
             char c = number.charAt(i);
             if (c == digit) {
                 StringBuilder builder = new StringBuilder();
                 builder.append(number.substring(0, i));
                 if (i != number.length() - 1) builder.append(number.substring(i + 1, number.length()));
                 if (ans != null) {
                     ans = max(ans, builder.toString());
                     continue;
                 }
                 ans = builder.toString();
             }
         }
         return ans;
     }


     private boolean compareTimes1(String t1, String t2) {

         int v = t1.compareTo(t2);
         if (v < 0) {
             return true;
         }
         return false;


     }

     public boolean haveConflict(String[] event1, String[] event2) {
         if (!compareTimes1(event1[0], event2[0])) {
             if (compareTimes1(event2[1], event1[0])) {
                 return false;
             }
         } else {
             if (compareTimes1(event1[1], event2[0])) {
                 return false;
             }
         }
         return true;
     }

     public boolean digitCount(String num) {

         int[] arr = new int[10];
         for (int i = 0; i < num.length(); i++) {
             char c = num.charAt(i);
             arr[c - '0']++;
         }

         for (int i = 0; i < num.length(); i++) {
             int v = num.charAt(i)-'0';
             if(v!= arr[i]){
                 return false;
             }
         }
         return true;
     }


     public int percentageLetter(String s, char letter) {
         int count=0;
         for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i) == letter) count++;
         }
         int ans =count*100/s.length() ;
         return ans;
     }
 */

   /* public int KMP(String text, String pattern) {

        int i = 0;
        int len1 = text.length();

        int j = 0;
        int len2 = pattern.length();

        int[] next = new int[pattern.length()];
        createNextArray(pattern, next);
        while (i < len1 && j < len2) {
            //char c1 = text.charAt(i);
            //char c2 = pattern.charAt(j);
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                j = next[j];
            }
            i++;
        }
        if (j == len2) {
            return i - j;
        }

        return -1;
    }*/

  /*  private void createNextArray(String pattern, int[] next) {
        next[0] = -1;
        next[1] = 0;
        int i = 2, k = 0;

        while (i < pattern.length()) {
            if (k == -1 || pattern.charAt(i - 1) == pattern.charAt(k)) {
                //next[i] = next[i - 1] + 1;
                next[i] = k + 1;
                i++;
                k++;
            } else {
                k = next[k];
            }
        }

    }*/

    private void nextArray(String pattern, int[] next) {
        int k = 0;
        int i = 2;
        next[0] = -1;
        next[1] = 0;
        while (i < pattern.length()) {
            if (k == -1 || pattern.charAt(i - 1) == pattern.charAt(k)) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
    }

    public int kmp(String text, String pattern) {
        int i = 0;
        int j = 0;

        int[] next = new int[pattern.length()];
        this.nextArray(pattern, next);
        while (i < text.length() && j < pattern.length()) {

            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                j = next[j];
            }
            i++;
        }

        if (j == pattern.length()) {
            return i - j;
        }
        return -1;

    }

    public int countPrefixes(String[] words, String s) {

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (s.startsWith(word)) count++;
        }
        return count;
    }

    public String replaceSpace(String s) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == ' ') {
                builder.append("%20");
                continue;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == 1) return c;
        }
        return ' ';
    }

    public boolean checkString(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'a') {
                    return false;
                }
            }
        }
        return true;
    }

    public String[] divideString(String s, int k, char fill) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            builder.append(c);
            if ((i + 1) % k == 0) {
                list.add(builder.toString());
                builder = new StringBuilder();
            }
        }

        int len = builder.length();
        while (builder.length() > 0 && len <= k) {
            builder.append(fill);
            len++;
        }
        if (builder.length() > 0) {
            list.add(builder.toString());
        }

        return list.toArray(new String[list.size()]);
    }

    public String largestGoodInteger(String num) {

        int i = 0, j = 1, count = 1;
        int len = num.length();
        String ans = "";

        while (i <= j && j < len) {
            if (num.charAt(i) == num.charAt(j)) {
                count++;
                if (count == 3) {
                    String tmp = num.substring(i, j + 1);
                    ans = ans.compareTo(tmp) > 0 ? ans : tmp;
                    i = j;
                }
            } else {
                count = 1;
                i = j;
            }
            j++;
        }

        return ans;
    }

    public boolean equalFrequency(String word) {

        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            arr[c - 'a']++;
        }
        List<Integer> list = new ArrayList();

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 26; j++) {
                    if (arr[j] > 0) {
                        set.add(arr[j]);
                    }
                }
                if (set.size() == 1) {
                    return true;
                }
                arr[i]++;
            }
        }


        return false;


/*
        if (list.get(0) == list.get(list.size() - 1)) {
            if (list.get(0) == 1) {
                return true;
            } else if (list.get(0) > 1) {
                return false;
            }
        } else {
            for (int i = list.size() - 2; i >= 0; i--) {
                int diff = list.get(list.size() - 1) - list.get(i);
                if (diff != 1) {
                    return false;
                }
            }
        }


        return true;*/
    }

    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        List<String> list = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            String name = map.get(heights[i]);
            list.add(name);
        }
        return list.toArray(new String[names.length]);
    }

    private int calculate(String arrive, String leave, int[] arr) {
        int diff = 0;
        int month1 = Integer.valueOf(arrive.substring(0, 2));
        int day1 = Integer.valueOf(arrive.substring(3, 5));
        int month2 = Integer.valueOf(leave.substring(0, 2));
        int day2 = Integer.valueOf(leave.substring(3, 5));
        if (month1 == month2) {
            if (day2 >= day1) {
                diff = day2 - day1 + 1;
            }
        } else if (month1 < month2) {
            int sum = arr[month1] - day1 + 1;
            for (int i = month1 + 1; i < month2; i++) {
                sum += arr[i];
            }
            diff = sum + day2;
        }
        return diff;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;
        if (arriveBob.compareTo(leaveAlice) > 0) {
            ans = 0;
        } else if (arriveAlice.compareTo(leaveBob) > 0) {
            ans = 0;
        } else {
            String arrive = arriveBob;
            if (arriveAlice.compareTo(arriveBob) > 0) {
                arrive = arriveAlice;
            }
            String leave = leaveAlice;
            if (leaveAlice.compareTo(leaveBob) > 0) {
                leave = leaveBob;
            }
            //calculate
            ans = calculate(arrive, leave, arr);
        }
        return ans;
    }

    public char repeatedCharacter(String s) {

        int[] arrCount = new int[26];
        int[] arrIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arrCount[c - 'a'] < 2) {
                arrCount[c - 'a']++;
                arrIndex[c - 'a'] = i;
            }
        }
        int index = s.length() - 1;
        for (int i = 0; i < 26; i++) {
            if (arrCount[i] == 2) index = Math.min(index, arrIndex[i]);
        }
        return s.charAt(index);
       /* int index = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arrCount[c - 'a'] == 2) {
                index = Math.min(index, i);
            }
        }*/

    }

    public int rearrangeCharacters(String s, String target) {
        int count = Integer.MAX_VALUE;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }

        int[] targetArr = new int[26];
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetArr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (targetArr[i] != 0) {
                count = Math.min(count, arr[i] / targetArr[i]);
            }
        }
        return count;

    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) return false;
        }

        return true;
    }

    public List<String> removeAnagrams(String[] words) {

        String word = words[words.length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = words.length - 2; i >= 0; i--) {
            if (isAnagram(words[i], word)) {
                set.add(i + 1);
            }
            word = words[i];
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!set.contains(i)) {
                list.add(words[i]);
            }
        }
        return list;
    }

    public int similarPairs(String[] words) {

        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int t = 0;
            for (int j = 0; j < words[i].length(); j++) {
                t = t | 1 << (words[i].charAt(j) - 'a');
            }
            arr[i] = t;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    ans++;
                }
            }
        }
        return ans;

    }

    public int similarPairs1(String[] words) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int t = 0;
            for (int j = 0; j < words[i].length(); j++) {
                t = t | 1 << (words[i].charAt(j) - 'a');
            }
            list.add(t);
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    ans++;
                }
            }
        }
        return ans;

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] arr = new int[26];
            StringBuilder builder = new StringBuilder();
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    builder.append((char) ('a' + j));
                    //builder.append(arr[j]);
                }
            }
            String key = builder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


    public String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, t++);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                builder.append(c);
                continue;
            }
            int index = map.get(c);
            builder.append((char) ('a' + index));
        }
        return builder.toString();
    }

    public boolean strongPasswordCheckerII(String password) {

        int len = password.length();
        if (len < 8) return false;
        int i = 0;
        Set<Character> set = new HashSet<>();
        set.add('!');
        set.add('@');
        set.add('#');
        set.add('$');
        set.add('%');
        set.add('^');
        set.add('&');
        set.add('*');
        set.add('(');
        set.add(')');
        set.add('-');
        set.add('+');

        boolean hasNumber = false, hasLowerCase = false, hasUpperCase = false, hasSpecialCharacter = false;
        while (i < len) {
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false;
            char c = password.charAt(i);
            if (Character.isDigit(c)) hasNumber = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (set.contains(c)) hasSpecialCharacter = true;
            i++;
        }

        return hasNumber && hasLowerCase && hasSpecialCharacter && hasUpperCase;

    }

    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c != '/') {
                StringBuilder builder = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    builder.append(path.charAt(i));
                    i++;
                }
                if (builder.toString().equals("..")) {
                    if (!list.isEmpty()) list.removeLast();
                } else if (!builder.toString().equals(".")) {
                    list.add(builder.toString());
                }
                continue;
            }
            i++;
        }

        StringBuilder ans = new StringBuilder();
        while (!list.isEmpty()) {
            ans.append("/");
            ans.append(list.removeFirst());
        }
        return ans.toString().length() == 0 ? "/" : ans.toString();
    }


    public int maxRepeating(String sequence, String word) {

        int count = 0;
        String tmp = word;
        while (sequence.indexOf(tmp) > -1) {
            count++;
            tmp += word;
        }
        return count;
        /*int i = 0;
        int j = 0;
        int count = 0;
        for (; i < sequence.length(); i++) {

            char c1 = sequence.charAt(i);
            char c2 = word.charAt(j);
            if (c1 != c2) {
                i=i-j;
                j = 0;
                continue;
            } else if (c1 == c2) {
                j++;
            }
            if (j == word.length()) {
                j = 0;
                count++;
            }

        }
        return count-1;*/

    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int max = releaseTimes[0];
        int index = 0;
        for (int i = 1; i < keysPressed.length(); i++) {
            char c = keysPressed.charAt(i);
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > max) {
                max = diff;
                index = i;
            } else if (diff == max) {
                if (keysPressed.charAt(i) > keysPressed.charAt(index)) {
                    max = diff;
                    index = i;
                }
            }
        }

        return keysPressed.charAt(index);
    }


    public String removeKdigits(String num, int k) {

        if (num.length() == k) {
            return "0";
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            int v = num.charAt(i) - '0';
            if (!list.isEmpty()) {
                while (k > 0 && !list.isEmpty() && v < list.getFirst()) {
                    list.removeFirst();
                    k--;
                }
            }
            list.addFirst(v);
        }

        for (int i = 0; i < k; i++) {
            list.removeFirst();
        }
        StringBuilder builder = new StringBuilder();
        boolean startWithZero = true;
        while (!list.isEmpty()) {
            int t = list.removeLast();
            if (startWithZero && t == 0) {
                continue;
            }
            startWithZero = false;
            builder.append(t);
        }

        String ans = builder.toString();
        return ans == "" ? "0" : ans;
    }

    /*public void removeKdigitsBackTrack(String num, int count, StringBuilder builder) {
        if (builder.length() == count) {
            arrayList.add(builder.toString());
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            builder.append(c);
            removeKdigitsBackTrack(num.substring(i + 1), count,builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
*/

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);
            int cur = map.get(curLetter);
            if (i == 0) {
                sum += cur;
                continue;
            }

            char preLetter = s.charAt(i - 1);
            int pre = map.get(preLetter);
            if (cur <= pre) {
                sum += cur;
            } else {
                sum += cur - 2 * pre;
            }
        }
        return sum;
    }

    public int romanToInt1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);
            int cur = map.get(curLetter);
            sum += cur;
            if (i == 0) continue;

            char preLetter = s.charAt(i - 1);
            int pre = map.get(preLetter);
            if ((curLetter == 'V' || curLetter == 'X') && preLetter == 'I') {
                sum = sum - 2 * pre;
            }
            if ((curLetter == 'L' || curLetter == 'C') && preLetter == 'X') {
                sum = sum - 2 * pre;
            }
            if ((curLetter == 'D' || curLetter == 'M') && (preLetter == 'C')) {
                sum = sum - 2 * pre;
            }
        }
        return sum;
    }

    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        List<Integer> values = new ArrayList<>();
        map.keySet().stream().sorted((e1, e2) -> e2 - e1).forEach((e) -> values.add(e));

        int t = num;
        StringBuilder builder = new StringBuilder();
        while (t > 0) {
            for (int i = 0; i < values.size(); i++) {

                int v = values.get(i);
                int captain = t / v;
                int mod = t % v;
                char c = map.get(v);

                if (v / 10 >= v - t) {
                    builder.append(map.get(v / 10));
                    builder.append(c);
                    t = t % (v / 10);
                    if (t == 0) {
                        break;
                    }

                }
                


                /*if (captain == 0) {
                    if ((mod == 4 || mod == 9) && v - t == 1) {
                        builder.append(map.get(v - mod));
                        builder.append(c);
                        t = 0;
                    } else {
                        continue;
                    }
                } else {
                    if (mod == 0) {
                        for (int j = 0; j < captain; j++) {
                            builder.append(c);
                        }
                    } else if (captain >= 1) {
                        for (int j = 0; j < captain; j++) {
                            builder.append(c);
                        }

                    }
                    t = mod;
                }*/
            }
        }

        return builder.toString();
    }


    public int longestSubstring(String s, int k) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'] != 0 && arr[c - 'a'] < k) {
                String left = s.substring(0, i);
                int l = longestSubstring(left, k);
                String right = s.substring(i + 1, s.length());
                int r = longestSubstring(right, k);
                return Math.max(l, r);
            }
        }

        return s.length();
      /*  Map<Character, Integer> map = new HashMap<>();
        Map<Character, List<Integer>> mapIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            List<Integer> list = mapIndex.getOrDefault(c, new ArrayList<>());
            list.add(i);
            mapIndex.put(c, list);
        }
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            int count = entry.getValue();
            if (count >= k) {
                list.addAll(mapIndex.get(entry.getKey()));
            }
        }
        list.sort((e1, e2) -> e1 - e2);

        if (list.isEmpty()) return 0;
        int start = list.get(0);
        int end = list.get(list.size() - 1);

        String ans = s.substring(start, end + 1);
        System.out.println(ans);
        return ans.length();*/

    }


    public static void main(String[] args) {
        StringQuestions instance = new StringQuestions();
        //System.out.println(instance.removeKdigits("10", 1));
        System.out.println(instance.intToRoman(1));
        //System.out.println(instance.removeKdigits("10001", 4));

/*        String s = "aaacbb";
        int k = 2;
        System.out.println(instance.longestSubstring(s, k));*/
/*
        System.out.println(instance.simplifyPath("/../"));
        System.out.println(instance.simplifyPath("/a/./b/../../c/"));*/

        /*int[] releaseTimes = {10, 19, 20, 21, 22, 32};
        String pressedKey = "abodzo";
        System.out.println(instance.slowestKey(releaseTimes, pressedKey));*/
        //System.out.println(instance.kmp("abcd", "bc"));
     /*   System.out.println(instance.largestGoodInteger("6777133339"));
        System.out.println(instance.largestGoodInteger("1221000"));*/
       /* String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        instance.sortPeople(names, heights);
        String arriveAlice = "04-20", leaveAlice = "06-18", arriveBob = "04-12", leaveBob = "12-19";
        System.out.println(instance.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));

        System.out.println(instance.repeatedCharacter("abccbaacz"));
*/

    /*    System.out.println(instance.isAnagram("anagram", "nagaram"));
        //System.out.println(instance.rearrangeCharacters("abbaccaddaeea", "aaaaa"));

        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(instance.removeAnagrams(words));*/

        //System.out.println(instance.equalFrequency("abc"));
        //String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        //String[] words = {"aabb","ab","ba"};
        //String[] words = {"ofwqemdbhrcckcnqvovyjwnbqxckhfohlripwumugcirazdtwo", "hsrmuokwhksqkkjblkomibcifqilkwobwcpwwkjlzohffsajrt", "uzvsxxbdwfohaujijxmeijbwyydgjiifcqvxfzmkqgwnkpxlpp", "ksdoiwhffhymsxebloadgyigkveizbahnbmvmxsuuxaaegxmpe", "fcsjnezuizcnfsuaxpmxpdivamaijvvyyqlsjsqlkifahjuanb", "odfwurhxumkpwndsppoflaualeghyscdqqwpntxokxviqmjhyq", "jbahicbweamnlfbljwyloparlmgqlwiootzoeqovytpapzjezn", "vsjxngyknxpkjfexdvmoikjaiccplcwtxcfrljqavatpcoeaqe", "lxiztvpppvsjmnnuunvdxalvzuvxlxbdnipexklmgsssyzlesb", "kbmiambdsahiptndziqysctinvdekysrsslssusqwhshpwehco", "wuwkvgrrshrmbtpyozgzzwiyflpiuklsepljvthmxnppaspuqt", "lkajvmdzpsxoaqzrgrhuhhmwlgwfnruxsrjolnielwcyjvvhaa", "imvgnslsxyqfshgmgecdrignarewusftipgjpteocnlqsfkdcy"};
        //String[] words = {"nba", "cba", "dba"};
        //System.out.println(instance.similarPairs(words));

        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        //System.out.println(instance.groupAnagrams(strs));

        //System.out.println(instance.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));

        //System.out.println(instance.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        //System.out.println(instance.maxRepeating("aaaaa", "a"));
        //System.out.println(instance.maxRepeating("ababc", "ab"));
//        // System.out.println(instance.lengthOfLastWord("hello world ") );
//        //System.out.println(instance.str2Int("123"));
//        //System.out.println(instance.titleToNumber("AB"));
//        //System.out.println(instance.convertToTitle(701));
//
//        //System.out.println(instance.wordPattern("abc", "dog cat dog"));
//        //System.out.println(instance.repeatedSubstringPattern("aabaaba"));
//        //System.out.println(instance.KMP("abcabc", "cab"));
//
//        //int[] heights = {2, 1, 5, 6, 2, 3};
//        //System.out.println(instance.largestRectangleArea(heights));
//        //int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
//        //String S = "abcdefghijklmnopqrstuvwxyz";
//
//        //Arrays.stream(instance.numberOfLines(widths, S)).forEach(System.out::println);
//
//
//        //System.out.println(instance.isIsomorphic("paper", "title"));
//
//        //System.out.println(instance.findTheLongestBalancedSubstring("01000111"));
//      /*  String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
//        String pattern = "FoBa";
//        // System.out.println(instance.camelMatch(queries, pattern));
//        System.out.println(instance.isCircularSentence("leetcode exercises sound delightful"));*/
//        //["abm","bcn","alm"]
////        String[] words = {"alm", "abm", "bcn"};
////        System.out.println(instance.oddString(words));
//
//        //String[] demand = {"acd", "bed", "accd"};
//        //System.out.println(instance.minNumBooths(demand));
//
//        //String s = "2-5g-3-J";
//        //int k = 2;
//        //System.out.println(instance.licenseKeyFormatting(s, k));
//
//        //System.out.println(instance.addStrings("11", "123"));
//        //System.out.println(instance.reverseWords("a good   example"));
//        //System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
//        //instance.validPalindrome("abca");
//        /*String[] words = {"hello","i","am","leetcode","hello"};
//        String target = "hello";
//        int startIndex = 1;
//        System.out.println(instance.closetTarget(words, target, startIndex));*/
//
//        //System.out.println(instance.convertTime("09:41", "10:34"));
//
//        //System.out.println(instance.isAnagram("rat", "car"));
//        //String s = "00000000";
//        //System.out.println(instance.digitSum(s, 3));
//        //System.out.println(instance.removeDigit("43553327", '3'));
//        /*String[] s1 = {"16:53", "19:00"};
//        String[] s2 = {"10:33", "18:15"};
//        System.out.println(instance.haveConflict(s1, s2));*/
//
//
//        //System.out.println(instance.digitCount("1210"));
//
//        System.out.println(instance.percentageLetter("foobar", 'o'));

    }
}
