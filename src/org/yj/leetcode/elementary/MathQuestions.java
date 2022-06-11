package org.yj.leetcode.elementary;

import java.util.*;

public class MathQuestions {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                res.add("Fizz");
                continue;
            }
            if (i % 5 == 0) {
                res.add("Buzz");
                continue;
            }
            res.add(i + "");
        }
        return res;
    }

    public int countPrimes(int n) {

        if (n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }


    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }

        return true;
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
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(c)) {
                sum = sum - map.get(c);
            } else {
                sum = sum + map.get(c);
            }
        }
        return sum;
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int mySqrt(int x) {
        int res = -1;
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long target = (long) mid * mid;
            if (target == x) {
                return mid;
            } else if (target > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        res = r;
        return res;
    }


    public String[] reorderLogFiles(String[] logs) {
        List<String> digitalLogs = new ArrayList<>();
        List<String> textLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            String[] array = log.split(" ");
            if (Character.isDigit(array[1].charAt(0))) {
                digitalLogs.add(log);
            } else {
                textLogs.add(log);
            }
        }
        textLogs.sort((e1, e2) -> {
            int i = 0, j = 0;
            while (e1.charAt(i) != ' ') i++;
            String e1Sub = e1.substring(i + 1, e1.length());
            while (e2.charAt(j) != ' ') j++;
            String e2Sub = e2.substring(j + 1, e2.length());
            if (e1Sub.equalsIgnoreCase(e2Sub)) {
                return e1.substring(0, i).compareTo(e2.substring(0, j));
            }
            return e1Sub.compareTo(e2Sub);
        });
        List<String> reorderLogs = new ArrayList<>(textLogs);
        reorderLogs.addAll(digitalLogs);
        return reorderLogs.toArray(new String[reorderLogs.size()]);
    }


    public void sortColors(int[] nums) {

        int[] array = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                deque.addFirst(nums[i]);
            } else if (nums[i] == 2) {
                deque.addLast(nums[i]);
            }
        }
        int index = array.length - deque.size();
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                nums[i] = 0;
            } else {
                nums[i] = deque.poll();
            }
        }

    }

    public static void main(String[] args) {
        MathQuestions questions = new MathQuestions();
        //System.out.println(questions.countPrimes(10));
        // System.out.println(questions.isPrime(499979));
        //System.out.println(questions.isPowerOfThree(15));
        //System.out.println(questions.romanToInt("MCMXCIV"));
        //System.out.println(questions.getSum(4, 5));
        //System.out.println(questions.mySqrt(10));

        // String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        //String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        //String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        //Arrays.stream(questions.reorderLogFiles(logs)).forEach(System.out::println);

        int[] nums = {2, 0, 2, 1, 1, 0};
        questions.sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }
}
