package org.yj.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayQuestions {

    /* public List<List<String>> groupAnagrams(String[] strs) {

         List<List<String>> res = new ArrayList<>();
         List<String> list = new ArrayList<>();
         if (strs.length == 1) {
             list.add(strs[0]);
             res.add(new ArrayList<>(list));
             return res;
         }

         Map<Integer, List<String>> map = new HashMap<>();
         int[] array = new int[strs.length];
         for (int i = 0; i < strs.length; i++) {
             String str = strs[i];
             int value = 0;
             for (char c : str.toCharArray()) {
                 int t = c - 'a';
                 value = value | (1 << c - 'a');
             }
             array[i] = value;

             if (!map.containsKey(array[i])) {
                 list = new ArrayList<>();
                 list.add(strs[i]);
                 map.put(array[i], list);
             } else {
                 map.get(array[i]).add(strs[i]);
             }
         }
         for (Integer key : map.keySet()) {
             res.add(map.get(key));
         }
         return res;

      *//*   for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(array[i], list);
            } else {
                map.get(array[i]).add(strs[i]);
            }
        }*//*


    }*/
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String strKey = new String(chars);
            if (!map.containsKey(strKey)) {
                map.put(strKey, new ArrayList<>());
            }
            map.get(strKey).add(strs[i]);
        }
        return new ArrayList<>(map.values());

    }


    public boolean isPalindrome(String text) {
        if (text.length() == 0) {
            return false;
        }
        int left = 0;
        int right = text.length() - 1;
        while (left <= right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public String longestPalindrome(String s) {

        int k = s.length();
        if (s.length() == 1) return s;
        String ans = "";
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j <= k; j++) {
                String tmp = s.substring(i, j);
                if (isPalindrome(tmp)) {
                    if (ans.length() == 0) {
                        ans = tmp;
                    } else {
                        if (tmp.length() > ans.length()) {
                            ans = tmp;
                        }
                    }
                }
            }
        }
        return ans;
    }


    public int sum(int[] array) {
        return sum(array, 0);
        //return sum(array, 0, array.length - 1);
    }

    public int sum(int[] array, int index) {
        if (index == array.length) {
            return 0;
        }
        return array[index] + sum(array, index + 1);
    }

    public int sum(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }
        return array[i] + sum(array, i + 1, j);
    }
/*

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = sum;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSum-nums[i]) {
                return i;
            }
            leftSum = leftSum + nums[i];
            rightSum = rightSum - nums[i];
        }
        return -1;
    }
*/


    public int searchInsert(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (res.isEmpty()) {
                res.add(interval);
            }
            int[] preInterval = res.get(res.size() - 1);

            if (preInterval[1] < interval[0]) {
                res.add(interval);
            } else if (preInterval[1] > interval[1]) {
                //do nothing
            } else {
                preInterval[1] = interval[1];
            }
        }

        return res.toArray(new int[res.size()][]);

    }


    public String reverseWords(String s) {

        String text = s.trim();
        int i = text.length() - 1;
        int j = i;
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && (Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i)))) {
                i--;
            }
            String tmp = text.substring(i + 1, j + 1);
            builder.append(tmp);
            builder.append(" ");
            while (i >= 0 && text.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return builder.toString().trim();
    }


    public String reverseWordsII(String s) {
        String text = s.trim();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int t = text.length();
        StringBuilder builder = new StringBuilder();
        while (i < t) {
            while (i < t && text.charAt(i) == ' ') {
                i++;
            }
            while (i < t && text.charAt(i) != ' ') {
                stack.push(text.charAt(i));
                i++;
            }
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }
            builder.append(" ");
        }

        return builder.toString().trim();
    }


    public void twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                System.out.println(nums[left]);
                System.out.println(nums[right]);
                left++;
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    res.add(tmpList);
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int len = 0;
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                i++;
            } else {
                len = Math.max(len, i - j);
                while (!set.isEmpty() && set.contains(c)) {
                    set.remove(s.charAt(j));
                    j++;
                }
            }
        }
        len = Math.max(len, i - j);
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            len = Math.max(len, i - j + 1);
            i++;
        }
        return len;
    }


    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (index == -1) {
            return res;
        }
        l = r = index;
        while (l >= 0 && nums[l] == target) l--;
        while (r < nums.length && nums[r] == target) r++;

        res[0] = l + 1;
        res[1] = r - 1;
        return res;
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int t = 0;
        while (t < k) {
            queue.add(nums[t]);
            t++;
        }

        for (int i = t; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();
    }

    List<Integer> res = new ArrayList<>();

/*    public int findPeakElement(int[] nums) {
        findPeakElement(nums, 0, nums.length - 1);
        return res.get(0);
    }

    private void findPeakElement(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int left = l;
        int right = r;
        int mid = left + (right - left) / 2;
        findPeakElement(nums, left, mid);
        findPeakElement(nums, mid + 1, right);
        if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
            res.add(nums[mid]);

        }
    }*/


    private int bSearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                j++;
            } else {
                break;
            }
        }
        System.out.println(j);
        int l = 0;
        int r = j;
        int res = bSearch(nums, l, r, target);
        if (res > -1) {
            return res;
        } else {
            res = bSearch(nums, j + 1, nums.length - 1, target);
        }

        return res;
    }


    public boolean bSearchByRow(int[][] matrix, int target, int row) {
        int l = row;
        int r = matrix[row].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) {

                System.out.println("row=" + row);
                System.out.println("col=" + mid);
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean bSearchByColumn(int[][] matrix, int target, int col) {
        int l = col;
        int r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][col] == target) {

                System.out.println("row=" + mid);
                System.out.println("col=" + col);
                return true;
            } else if (matrix[mid][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int t = Math.min(m, n);
        for (int i = 0; i < t; i++) {
            boolean isFoundRow = bSearchByRow(matrix, target, i);
            boolean isFoundCol = bSearchByColumn(matrix, target, i);
            if (isFoundRow || isFoundCol) {
                return true;
            }
        }

        return false;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        System.out.println(l);
        System.out.println(r);
        return l;
    }
/*
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length-2;
        while (l < r) {
            int mid = l+((r-l+1)>>1);   // 找右端点
            if (arr[mid] > arr[mid-1]) l = mid;
            else if (arr[mid] < arr[mid-1]) r = mid-1;
        }
        return l;
    }
*/

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
        System.out.println(r);
        return l;
    }

    public int searchRotateArray(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
        System.out.println(r);
        int res = this.bSearch(nums, 0, l, target);
        if (res == -1) {
            res = this.bSearch(nums, l + 1, nums.length - 1, target);
        }


        return res;
    }

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                third = num;
                System.out.println(first);
                System.out.println(second);
                System.out.println(third);
                return true;
            }
        }
        return false;
    }

    public int findPeakElement(int[] nums) {
        int ans = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid - 1] < nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        ans = l;
        return ans;
    }

    public int findPeakElement2(int[] nums) {
        int ans = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        ans = l;
        // System.out.println(l);
        // System.out.println(r);
        return ans;
    }

    public int findPeakElement1(int[] nums) {
        int ans = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }


  /*  public int findPeakElement(int[] nums) {
        int ans = -1;
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length ; i++) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            } else if (i > 0 && i < len - 1 && nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            } else if (i == len - 1 && nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return ans;
    }*/


    public int maxProfit(int[] prices) {
        int ans = 0;

        int len = prices.length;
        if (len == 1) {
            return 0;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int a = prices[i] - prices[j];
                System.out.println(a);
                ans = Math.max(ans, prices[i] - prices[j]);
            }
        }
        return ans;
    }


    public int countPrimes1(int n) {
        int[] array = new int[n];
        for (int i = 2; i * i < n; i++) {
            if (array[i] == 0) {
                for (int j = i; j * i < n; j++) {
                    array[i * j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (array[i] == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int countPrimes(int n) {
        int ans = 0;
        int[] array = new int[n];
        for (int i = 2; i * i < n; i++) {
            if (array[i] == 0) {
                for (int j = 2; j * i < n; j++) {
                    array[j * i] = 1;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (array[i] == 0) {
                ans++;
            }
        }
        return ans;
    }

   /* public int countPrimes1(int n) {
        if (n <= 2) {
            return 0;
        }

        int ans = 0;
        for (int i = 3; i < n; i++) {
            if ((i % 2) == 0) {
                continue;
            }
            if (isPrime(i)) {
                ans++;
            }
        }
        return ans + 1;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
*/

    public int subarraySum(int[] nums, int k) {

        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        //sum[i,j] = preSum[j] - preSum[i-1]
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {

            if (map.containsKey(preSum[i] - k)) {
                count = count + map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        //sum[i,j] = preSum[j] - preSum[i-1]
        int count = 0;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) {
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println("------------");
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }


    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int[] preSums = new int[nums.length];
        for (int i = 0; i < preSums.length; i++) {
            if (i == 0) {
                preSums[i] = nums[i];
            } else {
                preSums[i] = preSums[i - 1] + nums[i];
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < preSums.length; i++) {
            int modulus = (preSums[i] % k + k) % k;
            if (map.containsKey(modulus)) {
                if (i - map.get(modulus) >= 2) {
                    return true;
                }
            } else {
                map.put(modulus, i);
            }
        }
        return false;
    }

    public int subarraysDivByK(int[] nums, int k) {

        int[] preSums = new int[nums.length + 1];
        preSums[0] = 0;
        for (int i = 1; i < preSums.length; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < preSums.length; i++) {
            int modulus = (preSums[i] % k + k) % k;
            //count = count + map.getOrDefault(modulus, 0);
            if (map.containsKey(modulus)) {
                count = count + map.get(modulus);
            }
            map.put(modulus, map.getOrDefault(modulus, 0) + 1);
        }
        return count;
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while (l < nums.length && r < nums.length) {
            sum = sum + nums[r];
            //缩小窗口
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i; j < preSum.length; j++) {
                int val = preSum[j] - preSum[i];
                if (val >= target) {
                    res = Math.min(res, j - i);
                }
            }
            //map.put(preSum[i],i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int pivotIndex(int[] nums) {
        int[] preArray = new int[nums.length];
        preArray[0] = nums[0];
        for (int i = 1; i < preArray.length; i++) {
            preArray[i] = nums[i] + preArray[i - 1];
        }
        int j = preArray.length - 1;
        for (int i = 0; i < preArray.length - 1; i++) {
            if (preArray[i] == preArray[j]) {
                return i;
            }
            if (preArray[i] == preArray[j] - preArray[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayQuestions questions = new ArrayQuestions();
/*
        System.out.println(questions.countPrimes(1000));
        System.out.println(questions.countPrimes1(1000));
*/
        int[] array = {2, 1, -1};
        //int[] array = {1, 7, 3, 6, 5, 6};

        System.out.println(questions.pivotIndex(array));

/*        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"ddddddddddg", "dgggggggggg"};
        String[] strs = {""};
        // questions.groupAnagrams(strs).stream().forEach(System.out::println);
        //questions.groupAnagrams(strs).stream().flatMap(list -> list.stream()).forEach(System.out::println);


        // int[] array = {1, 3, 5, 6};
        //int[] array = {1, 2, 3};
        //int[] array = { 2, 1,-1};
        //System.out.println(questions.sum(array));


        //System.out.println(questions.searchInsert(array, 0));
        //  int[] array = {1, 2, 3, 4, 5, 6};
        //int[] array = {6, 5, 4, 3};
        // System.out.println(questions.increasingTriplet(array));

        // System.out.println(questions.isPalindrome("bcd"));
        *//*System.out.println(questions.longestPalindrome("abadd"));
        System.out.println(questions.longestPalindrome("babad"));
        System.out.println(questions.longestPalindrome("aa"));
        System.out.println(questions.longestPalindrome("ac"));*//*

        // int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //int[][] intervals = {{1, 4}, {4, 5}};
        // System.out.println(questions.merge(intervals));


//        String s = "EPY2giL";
//        // System.out.println(questions.reverseWords(s));
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        //Arrays.sort(nums);
//        //questions.twoSum(nums,0);
//        questions.threeSum(nums).stream().forEach(System.out::println);

        //String text = "pwwkew";
        //System.out.println(questions.lengthOfLongestSubstring(text));
        //System.out.println(questions.lengthOfLongestSubstring2(text));

        //int[] nums = {5, 7, 7, 8, 8, 10};
        //int[] nums = {2, 2};
        // questions.searchRange(nums, 3);

        //int[] nums = {1, 2, 3, 1};
        //int[] nums = {1, 2, 1, 3, 5, 6, 4};
        //System.out.println(questions.findPeakElement(nums));
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {1};
        //System.out.println(questions.search(nums, 0));
        //int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //System.out.println(questions.searchMatrix(matrix, 20));

        //int[] arr = {100, 99, 79, 78, 67, 36, 26, 19};
        //int[] arr = {1,2,3,4,5};
        //int[] arr = {1, 2, 3};
        //int[] arr = {1, 1, 1};
        //int[] arr = {-1, -1, 1};
        // System.out.println(questions.peakIndexInMountainArray1(arr));
        //System.out.println(questions.peakIndexInMountainArray(arr));

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
       *//* int[] nums = {0, 1, 2, 4, 5, 6, 7};
        System.out.println(questions.searchRotateArray(nums, 0));*//*


        //System.out.println(questions.increasingTriplet(arr));

        /// System.out.println(questions.findPeakElement(arr));
        //System.out.println(questions.countPrimes(10));*/
        //int[] array = {23,2,4,6,7};
        // int[] array = {1, 1, 1, 1, 1, 1, 1, 1};
        // System.out.println(questions.minSubArrayLen(11, array));
        //  System.out.println(questions.minSubArrayLen1(11, array));


    }
}
