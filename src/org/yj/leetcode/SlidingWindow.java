package org.yj.leetcode;

import org.yj.application.data.collections.MaxHeap;

import java.util.*;
import java.util.stream.Collectors;

public class SlidingWindow {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = Math.abs(map.get(nums[i]) - i);
                if (diff <= k) {
                    return true;
                }
                map.replace(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        max = sum;
        for (int j = k; j < nums.length; j++) {
            sum = sum - nums[j - k] + nums[j];
            // double average=sum / k;
            max = Math.max(max, sum);
        }

        return max / (k * 1.0);
    }

    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        if (str.length() < k) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = k;
        while (r <= str.length()) {
            String s = str.substring(l, r);
            int value = Integer.parseInt(s);
            if (value != 0 && num % value == 0) {
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }

    public int countGoodSubstrings(String s) {
        return countGoodSubstrings(s, 3);
    }

    private int countGoodSubstrings(String s, int k) {
        int len = s.length();
        if (len < k) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = k;
        while (r <= len) {
            String subStr = s.substring(l, r);
            System.out.println(subStr);
            if (isGoodStr(subStr)) {
                // System.out.println(subStr);
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }

    private boolean isGoodStr(String subStr) {
        Set<Character> set = new HashSet<>();
        for (char c : subStr.toCharArray()) {
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    public String longestNiceSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                //System.out.println(subStr);
                if (isNiceSubStr(subStr)) {
                    if (subStr.length() > ans.length()) {
                        ans = subStr;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isNiceSubStr(String subStr) {
        for (int i = 0; i < subStr.length(); i++) {
            char c = subStr.charAt(i);
            if (Character.isUpperCase(c) && subStr.indexOf(Character.toLowerCase(c)) == -1) {
                return false;
            }
            if (Character.isLowerCase(c) && subStr.indexOf(Character.toUpperCase(c)) == -1) {
                return false;
            }
        }
        return true;
    }


   /* public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (j <= i && sum >= target) {
                len = Math.min(len, i - j + 1);
                sum = sum - nums[j];
                j++;
            }
        }

        int ans = len == Integer.MAX_VALUE ? 0 : len;
        return ans;
    }*/


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        List<List<Integer>> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i <= j && j < nums.length) {
            int value = 1;
            List<Integer> list = new ArrayList<>();
            for (int t = i; t <= j; t++) {
                value = value * nums[t];
                list.add(nums[t]);
            }
            if (value < k) {
                res.add(list);
            }
            j++;
            if (j == nums.length && i < nums.length) {
                i++;
                j = i;
            }
        }
        ans = res.size();
        return ans;
    }


    public int minSubArrayLen(int target, int[] nums) {

        int sum = 0, index = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - index + 1);
                sum = sum - nums[index];
                index++;
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 1;
        int index = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                index = Math.max(map.get(c) + 1, index);
            }
            map.put(c, i);
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 1;
        int index = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(index));
                index++;
            }
            set.add(c);
            ans = Math.max(ans, i - index + 1);
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
/*            if (deque.isEmpty()) {
                deque.add(nums[i]);
            }
            if (nums[i] < deque.peekLast()) {
                deque.add(nums[i]);
            }*/
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(nums[i]);
        }
        res.add(deque.peekFirst());
        for (int i = k; i < nums.length; i++) {
            //deque.pollFirst();
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.add(nums[i]);
            int val = deque.peekFirst();
            res.add(val);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        System.out.println(res);
        return ans;
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        boolean ans = false;
        int k = s1.length();
        int[] array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i) - 'a']++;
        }
        int j = 0;
        for (int i = 0; i < s2.length() && j <= i; i++) {
            if (i - j + 1 == k) {
                String tmp = s2.substring(j, i + 1);
                ans = isAnagram2(array, tmp);
                j++;
                if (ans) return true;
            }
        }
        return false;
    }

    public boolean isAnagram2(int[] array, String t) {
        int[] array2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            array2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(array, array2);
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int i = 0;
        boolean ans = false;
        while (i < nums.length) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                ans = true;
                return ans;
            }
            i++;
        }
        return false;
    }

    public int minimumRecolors2(String blocks, int k) {

        int l = 0, r = 0;
        int len = blocks.length();
        int res = Integer.MAX_VALUE;
        //Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (r = 0; r < len; r++) {
            char c = blocks.charAt(r);
            if (c == 'W') {
                count++;
            }
            if (r - l + 1 == k) {
                res = Math.min(res, count);
                System.out.println(blocks.charAt(l));
                if (blocks.charAt(l) == 'W') count--;
                l++;
            }
        }

        return res;
    }

    public int minimumRecolors(String blocks, int k) {

        int count = 0;
        int min = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        min = count;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            if (min > count) {
                min = count;
            }
        }
        return min;
    }

    public int minimumRecolors1(String blocks, int k) {

        int ans = -1;
        int len = blocks.length();
        int i = 0, j = 0, count = 0;
        int min = Integer.MAX_VALUE;
        while (j < len && i <= j) {
            char c = blocks.charAt(j);
            if (c == 'W') {
                count++;
            }
            if (j - i + 1 == k) {
                if (min > count) {
                    min = count;
                }
                if (blocks.charAt(i) == 'W') {
                    count--;
                }
                i++;
            }
            j++;
        }
        ans = min;
        return ans;
    }

    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < nums.length) {
            if (i - j + 1 == k) {
                int diff = nums[i] - nums[j];
                minDiff = Math.min(minDiff, diff);
                j++;
            }
            i++;
        }

        return minDiff;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {

        if (k <= 0) return 0;
        int len = nums.length;
        int i = 0, j = 0;
        int ans = 1;
        int count = 0;
        while (i < len && j <= i) {
            ans = ans * nums[i];
            while (j <= i && ans >= k) {
                ans = ans / nums[j];
                j++;

            }

            count += i - j + 1;
            i++;
        }

        return count;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            arr[p.charAt(i) - 'a']++;
        }

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i - j + 1 == p.length()) {
                String tmp = s.substring(j, i + 1);
                if (isAnagram2(arr, tmp)) {
                    list.add(j);
                }
                j++;
            }
        }
        return list;
    }

    public int lengthOfLongestSubstring2(String s) {

        int i = 0, j = 0;
        int k = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while (i < k && j <= i) {
            char c = s.charAt(i);
            while (set.contains(c) && j <= i) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {


        int len = customers.length;
        int total = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int increase = sum;
        for (int i = minutes; i < len; i++) {
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes];
            }
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            increase = Math.max(increase, sum);
        }

        return total + increase;
    }

    private boolean isDuplicate(int[] arr) {

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 0) return true;
        }
        return false;
    }

    public long maximumSubarraySum(int[] nums, int k) {

        int len = nums.length;
        int curSum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean isRepeat = false;
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                isRepeat = true;
            }
            curSum += nums[i];
        }
        if (!isRepeat) max = curSum;
        for (int i = k; i < len; i++) {
            isRepeat = false;
            curSum = curSum - nums[i - k] + nums[i];
            map.put(nums[i - k], map.getOrDefault(nums[i - k], 0) - 1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            for (Integer value : map.values()) {
                if (value > 1) {
                    isRepeat = true;
                    break;
                }
            }
            if (!isRepeat) max = Math.max(max, curSum);
        }
        return max;
    }


    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(s.charAt(i));
        }
        map.put(builder.toString(), 1);
        for (int i = 10; i < s.length(); i++) {
            builder.deleteCharAt(0);
            builder.append(s.charAt(i));
            String tmp = builder.toString();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        List<String> list = map.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        return list;

    }

    public int bSearch(int[] arr, int x) {
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                r = mid - 1;
            } else if (arr[mid] <= x) {
                l = mid + 1;
            } else {
                return mid;
            }

        }
        return mid;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        //binary search
        int index = bSearch(arr, x);

        int l = index;
        int r = index;
        if (index == 0) {

            l = index;
            r = index + k - 1;
        } else {
            l = index;
            r = index;
            while (l >= 0 && r < arr.length && r - l + 1 < k) {
                l--;
                r++;
            }
            while (l == 0 && r - l + 1 < k) {
                r++;
            }
            while (r == arr.length - 1 && r - l + 1 < k) {
                l--;
            }
        }

        for (int i = l; i <= r; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int res = 0;
        int[] frequence = new int[26];
        int max = 0;
        while (fast < chars.length) {
            frequence[chars[fast] - 'A']++;
            max = Math.max(max, frequence[chars[fast] - 'A']);
            fast++;
            while (fast - slow > max + k) {
                frequence[chars[slow] - 'A']--;
                slow++;
            }
            res = Math.max(res, fast - slow);
        }
        return res;
    }

    public int longestOnes1(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        int len = nums.length;
        int res = 0;
        while (r < len) {
            if (nums[r] == 0) {
                count++;
            }
            if (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        int len = nums.length;
        int res = 0;
        while (r < len) {
            if (nums[r] == 1) {
                count++;
            }
            r++;
            while (r - l > count + k) {
                if (nums[l] == 1) {
                    count--;
                }
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }


    public int longestSubarray(int[] nums) {

        int l = 0, r = 0, count = 0;
        int len = nums.length;
        int res = 0;

        while (r < len) {
            if (nums[r] == 0) {
                count++;
            }
            r++;
            while (count > 1) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res - 1;
    }

    public int lengthOfLongestSubstring4(String s) {
        int l = 0, r = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (r < len) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            res = Math.max(res, r - l);
        }

        return res;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int l = 0, r = 0, len = s.length();
        int diff = 0;
        while (r < len) {
            char c1 = s.charAt(r);
            char c2 = t.charAt(r);
            diff += Math.abs(c2 - c1);
            while (diff > maxCost) {
                diff -= Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            r++;
            res = Math.max(res, r - l);
        }


        return res;
    }


    public int binaryGap(int n) {

        String str = Integer.toBinaryString(n);
        int j = 0;
        int max = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                max = Math.max(max, i - j);
                j = i;
            }
        }
        return max;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
            if (i == 1) {
                res = diff[i];
                continue;
            }
            if (diff[i] > res) {
                res = diff[i];
            }
        }
        return res;
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int res = 0;
        int l = 0;
        int r = 0;
        while (l <= r && r < nums.length - 1) {
            if (nums[r] % 2 == 0 && nums[r + 1] % 2 == 1 && nums[r] <= threshold && nums[r + 1] <= threshold) {
                res = Math.max(res, r + 1 - l);
                r += 2;
            } else if (nums[r] % 2 == 0 && nums[r + 1] % 2 == 1 && nums[r] <= threshold && nums[r + 1] > threshold) {
                r++;
                l = r;
                continue;
            }
            //r += 2;
        }
        if (r == nums.length - 1 && nums[r] % 2 == 0 && nums[r] <= 5) {
            res = Math.max(res, r - l);
        }
        return res + 1;
    }


    public int maximumStrongPairXor(int[] nums) {

        int k = 2;
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - j + 1 == k) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff <= Math.min(nums[i], nums[j])) {
                    int oxr = nums[i] ^ nums[j];
                    System.out.println(oxr);
                    res = Math.max(res, nums[i] ^ nums[j]);
                }
                j++;
            }
        }
        return res;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                System.out.println(i - j + 1);
                res = Math.min(res, i - j + 1);
                sum = sum - nums[j];
                j++;
            }
        }


        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int l1 = 0, l2 = 0;
        int len = nums.length;
        int r1 = len - 1, r2 = len - 1;
        int lSum = 0;
        int rSum = 0;
        int sum = 0;

        for (int i = 0; i < firstLen; i++) {
            lSum += nums[i];
            l1++;
        }
        for (int i = len - 1; i >= len - secondLen; i--) {
            rSum += nums[i];
            r1--;
        }

        while (l1 < len || r1 >= 0) {

            sum = Math.max(sum, lSum + rSum);
            if (l1 < len) {
                lSum += nums[l1];
                lSum -= nums[l2];
                l1++;
                l2++;
            }

            if (r1 >= 0) {
                rSum += nums[r1];
                rSum -= nums[r2];

                r1--;
                r2--;
            }


        }


        return sum;
    }

    public int maxAscendingSum(int[] nums) {

        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = 1;
        int len = nums.length;
        int max = nums[0];
        int sum = nums[0];
        while (i < j && j < len) {
            if (nums[i] < nums[j]) {
                sum += nums[j];
                i++;
            } else {
                i = j;
                sum = nums[i];
            }
            max = Math.max(max, sum);
            j++;
        }


        return max;
    }

    public int maxAscendingSumDfs(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }

                res = Math.max(res, dp[i]);
            }


        }
        return res;
    }

    public int maxAscendingSumDfs1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        SlidingWindow instance = new SlidingWindow();

        int[] nums = {1, 7, 3, 5, 9, 4, 8};
        //System.out.println(instance.maxAscendingSum(nums));
        System.out.println(instance.maxAscendingSumDfs(nums));

        /*String s = "krrgw";
        String t = "zjxss";
        System.out.println(instance.equalSubstring(s, t, 19));*/

        //System.out.println(instance.binaryGap(2));
       /* int[] nums = {10};
        System.out.println(instance.maximumGap(nums));*/


      /*  int[] nums = {2, 3, 4, 5};
        int threshold = 4;

        System.out.println(instance.longestAlternatingSubarray(nums, threshold));
*/
        // int[] nums = {1, 2, 3, 4, 5};
        //System.out.println(instance.maximumStrongPairXor(nums));


        /*int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(instance.minSubArrayLen1(7, nums));
        */
        /*int[] nums = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen = 1, secondLen = 2;
        System.out.println(instance.maxSumTwoNoOverlap(nums, firstLen, secondLen));*/
        //System.out.println(instance.minimumRecolors2("BB", 1));
        //System.out.println(instance.lengthOfLongestSubstring4("pwwkew"));
        //int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        //System.out.println(instance.longestSubarray(nums));
        //int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        //System.out.println(instance.longestOnes(nums, 2));
        //int[] arr = {1, 2, 3, 4, 5};
        //int x = 3;
//        System.out.println(instance.characterReplacement("AABCABBB", 2));
        //System.out.println(instance.bSearch(arr, 0));
        //System.out.println(instance.findClosestElements(arr, 4, 3));
        //System.out.println(instance.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        //int[] nums = {5, 3, 3, 1, 1};
        //int[] nums = {9, 9, 9, 1, 2, 3};
        //int k = 3;
        //System.out.println(instance.maximumSubarraySum(nums, k));

        //System.out.println(instance.checkInclusion("ab", "eidbaooo"));
        //System.out.println(instance.minimumRecolors("WBWBBBW", 2));
        //int[] arr = {1, 2, 3};
        //int k = 0;
        // int[] nums = {10, 5, 2, 6};
        //int k = 100;
        //System.out.println(instance.numSubarrayProductLessThanK1(nums, k));

    }
}
