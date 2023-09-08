package org.yj.leetcode;

import java.awt.desktop.AppReopenedEvent;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class BinarySearch {


    /* public int bSearch(int[] nums, int target) {
         int left = 0;
         int right = nums.length - 1;

         while (left <= right) {
             int mid = left + (right - left) / 2;
             if (nums[mid] == target) {
                 return mid;
             } else if (target < nums[mid]) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }
         return -1;
     }*/
    /*public int bSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }*/
    public int bSearchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("left=" + left);
        System.out.println("right=" + right);
        return left;
    }

    public int bSearchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        System.out.println("left=" + left);
        System.out.println("right=" + right);
        return right;
    }

    public int search(int[] nums, int target) {
        int ans = -1;
        int peak = findPeak(nums);
        int len = nums.length;
        ans = bSearch(nums, 0, peak, target);
        if (ans == -1) {
            ans = bSearch(nums, peak + 1, len - 1, target);
        }
        return ans;
    }

    private int findPeak1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeak(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else {
                l++;
            }
        }
       /* while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }*/
        return l;
        // System.out.println(l);
        //System.out.println(r);
        // return l - 1;

    }

    public int findPeak2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        System.out.println(l);
        System.out.println(r);
        return l - 1;
       /* int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid;
            }
            else {
                r = mid - 1;
            }

        }
        return l;*/
    }

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
        return l;
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return l;
     /*   int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                r = mid - 1;
            } else if (nums[mid] < target) {
                if (mid + 1 == nums.length || nums[mid + 1] > target) {
                    return mid + 1;
                }
                l = mid + 1;
            }
        }
        return -1;*/
    }

    /*public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                if (mid == n) {
                    return mid;
                }
                if (isBadVersion(mid + 1)) {
                    return mid + 1;
                }
                left = mid + 1;
            }
        }
        return -1;
    }*/

    public int arrangeCoins(int n) {
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            sum = sum + arr[i];
            if (sum == n) {
                return i;
            } else if (sum > n) {
                return i - 1;
            }
        }
        return -1;
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            return e1[1] - e2[1];
        });
        for (int i = 0; i < mat.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                rowSum += mat[i][j];
            }
            queue.add(new Integer[]{i, rowSum});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }

    public int mySqrt(int x) {

        if (x == 1 || x == 0) {
            return x;
        }
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long v = (long) mid * mid;
            if (v == x) {
                return mid;
            } else if (v < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean isPerfectSquare(int num) {

        int l = 0;
        int r = num;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long v = (long) mid * mid;
            if (v == num) {
                return true;
            } else if (v < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else if (letters[mid] > target) {
                r = mid - 1;
            }
        }
        if (l >= letters.length) {
            return letters[0];
        }
        return letters[l];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] == target) {
                l = mid + 1;
            } else if (letters[mid] > target) {
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return letters[0];
      /*  if (l >= letters.length) {
            return letters[0];
        }
        return letters[l];*/
        // return letters[0];
       /* int l = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] == target) {
                if(mid+1==letters.length){
                    return letters[0];
                }
                return letters[mid + 1];
            } else if (letters[mid] > target) {
                if (mid == 0 || letters[mid - 1] < target) {
                    return letters[mid];
                }
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[0];*/
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] ans = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            ans[i++] = it.next();
        }


        return ans;
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map1.containsKey(key)) {
                int c1 = map1.getOrDefault(key, 0);
                int c2 = map2.getOrDefault(key, 0) + 1;
                if (c1 >= c2) {
                    map2.put(key, c2);
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map2.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = set.iterator();
        List<Integer> ans = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            for (int i = 0; i < entry.getValue(); i++) {
                ans.add(entry.getKey());
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (map1.containsKey(key)) {
                list.add(key);
                if (map1.get(key) - 1 == 0) {
                    map1.remove(key);
                } else {
                    map1.replace(key, map1.get(key) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect3(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];
        for (int t = 0; t < list.size(); t++) {
            res[t] = list.get(t);
        }
        return res;

    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] < n) {
            return n;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] < n) {
            return n;
        }
        int l = 0;
        int r = nums.length - 1;
        return missingNumber(nums, l, r);
    }

    public int missingNumber(int[] nums, int l, int r) {
        if (l >= r) return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid + 1] - nums[mid] > 1) {
            return nums[mid + 1] - 1;
        } else {
            int left = missingNumber(nums, l, mid - 1);
            if (left != -1) {
                return left;
            } else {
                return missingNumber(nums, mid, r);
            }
        }
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    //find the first number bigger than 0
    public int maximumCount(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= 0) {
                l = mid + 1;
            } else if (nums[mid] > 0) {
                r = mid - 1;
            }
        }

        System.out.println(l);
        System.out.println(r);
        while (r > -1 && nums[r] == 0) {
            r--;
        }
        int nCount = r + 1;
        int pCount = nums.length - l;
        if (nCount >= pCount) {
            return nCount;
        }
        return pCount;
    }

    public int maximumCount1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else if (nums[mid] >= 0) {
                r = mid - 1;
            }
        }
        System.out.println(l);
        System.out.println(r);
        int nCount = r + 1;

        while (l < nums.length && nums[l] == 0) {
            l++;
        }
        int pCount = nums.length - l;
        if (nCount >= pCount) {
            return nCount;
        }
        return pCount;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        r++;
        while (r < nums.length && nums[r] == target) {
            ans.add(r++);
        }
        return ans;
    }

    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
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
        int[] ans = new int[2];
        if (index == -1) return new int[]{-1, -1};
        l = r = index;
        while (l >= 0 && nums[l] == target) l--;
        while (r < nums.length && nums[r] == target) r++;
        ans[0] = l + 1;
        ans[1] = r - 1;
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int[] ans = new int[2];
        l--;
        ans[1] = l;
        while (l >= 0 && l < nums.length && nums[l] == target) {
            l--;
        }
        ans[0] = l + 1;

        if (ans[0] > ans[1]) {
            return new int[]{-1, -1};
        }
        return ans;
    }

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int l = 1, r = nums.length - 2;
        int peak = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                peak = mid;
                break;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
            if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                r = mid - 1;
            }
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
        }
        return peak;

    }

    public int findKthPositive(int[] arr, int k) {

        boolean flag = true;
        int t = 1;
        int index = 0;
        int count = 0;
        while (flag) {
            if (index < arr.length && arr[index] == t) {
                index++;
            } else {
                count++;
                if (count == k) {
                    return t;
                }
            }
            t++;
        }
        return -1;
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(matrix[i][j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }
        return ans;
    }

    public boolean search2(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l < nums.length - 1 && nums[l] == nums[l + 1]) l++;
        if (l == r && nums[l] == target) return true;
        while (r >= 1 && nums[r] == nums[r - 1]) r--;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target == nums[nums.length - 1]) {
                return true;
            } else if (target < nums[nums.length - 1]) {
                if (nums[mid] > target) {
                    if (nums[mid] < nums[nums.length - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    if (nums[mid] < nums[nums.length - 1]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public int findMin(int[] nums) {


        int l = 0, r = nums.length - 1;
        if (l == r) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[1] : nums[0];
        int lastOne = nums[nums.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
           /* if (mid == nums.length-1) {
                return nums[mid];
            }*/
            if (nums[mid] > lastOne) {
                l = mid + 1;
            } else if (nums[mid] <= lastOne) {
                if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    r = mid - 1;
                }
            }
        }
        System.out.println(l);
        System.out.println(r);
        return nums[l];
    }

    public int[] twoSum1(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(target - numbers[i]), i};
            }
        }
        return null;
    }

    private int findAnother(int[] nums, int target, int left, int right) {
        int l = left;
        int r = right;
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

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            //b search
            if (another <= 0) {
                break;
            }
            int result = findAnother(numbers, another, i + 1, numbers.length - 1);
            if (result != -1) {
                return new int[]{i, result};
            }
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {

                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }


    public int singleNonDuplicate(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
      /*  if (nums[l] < nums[l + 1]) {
            return nums[l];
        }
        if (nums[r] > nums[r - 1]) {
            return nums[r];
        }*/
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= nums.length - 2 && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            }
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {

                if (mid % 2 == 0) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
        }
        return -1;
    }

    private boolean isExist(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public int hIndex(int[] citations) {
        int n = citations.length - 1;

        for (int i = 0; i <= n; i++) {
            boolean result = isExist(citations, i);
            if (result) return citations[i];
        }
        return -1;
    }

    public int equalSubstring(String s, String t, int maxCost) {

        int len = s.length();
        int[] diffSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            diffSum[i + 1] = diffSum[i] + Math.abs(s.charAt(i ) - t.charAt(i));
        }

        int index =search4equalSubstring(diffSum,maxCost);

        return index-1;

    }

    private int search4equalSubstring(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                if (mid - 1 >= 0 && arr[mid - 1] <= target) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

      /*  int[] nums = {-3, -2, -1, 0, 0, 0, 1, 2};
        System.out.println(binarySearch.maximumCount(nums));
        System.out.println(binarySearch.maximumCount1(nums));*/
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(binarySearch.equalSubstring(s, t, maxCost));
        //int[] nums = {1, 2, 3};
        //System.out.println(binarySearch.findMin(nums));
        //System.out.println(binarySearch.search2(nums, 0));
        //int[] nums = {1};
        //Arrays.stream(binarySearch.searchRange(nums, 6)).forEach(System.out::println);
        //System.out.println(binarySearch.searchRange(nums, 8));
       /* int[][] mat =
                {{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}};*/
       /* int[][] mat =
                {{1, 0},
                        {1, 0},
                        {1, 0},
                        {1, 1,}
                };
        int k = 4;
        Arrays.stream(binarySearch.kWeakestRows(mat, k)).forEach(System.out::println);*/
        // int[] nums = {3, 0, 1};
        //System.out.println(binarySearch.missingNumber1(nums));

        //  int[] nums1 = {1, 2, 2, 1};
        // int[] nums2 = {2, 2};

        //int[] nums1 = {4,9,5};
        //int[] nums2 = {9,4,9,8,4};
        // Arrays.stream(binarySearch.intersect(nums1, nums2)).forEach(e -> System.out.println(e));
        //System.out.println(binarySearch.intersect(nums1, nums2));
        //char[] letters = {'e', 'e', 'g', 'g'};
        //char[] letters = {'c', 'f', 'j'};
        //System.out.println(binarySearch.nextGreatestLetter(letters, 'a'));
        //System.out.println(binarySearch.mySqrt(2147395599));
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {1, 3, 5};
        //int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        //int[] nums = {3, 1};
        //System.out.println(binarySearch.findPeak(nums));

        //int[] nums = {1, 2, 3, 5, 5, 5, 5, 8, 9};
        //int[] nums = {1, 3, 5, 6};
        //System.out.println(binarySearch.searchInsert(nums, 2));

        //int[] nums = {1, 2, 3, 5, 8, 9};
        // System.out.println(binarySearch.bSearchFirst(nums, 5 + 1));
        //System.out.println(binarySearch.bSearchLast(nums, 5));
        //System.out.println(binarySearch.search(nums, 1));

    }

}
