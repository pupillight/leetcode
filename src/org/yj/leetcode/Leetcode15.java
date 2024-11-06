package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode15 {


    public static ArrayList<Integer> threeNumbSum1(int[] array, int value) {

        ArrayList res;
        Set<String> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == value) {
                        List<Integer> list = Arrays.asList(array[i], array[j], array[k]);
                        Collections.sort(list);
                        set.add(list.toString());
                    }
                }
            }
        }
        return res = new ArrayList(set);
    }

    public static ArrayList<Integer> threeNumbSum(int[] array, int value) {

        ArrayList res = new ArrayList();
        Set<String> set = new HashSet();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {

            if (i > 1 && array[i] == array[i - 1]) {
                continue;
            }
            int target = value - array[i];
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target) {
                    List<Integer> list = Arrays.asList(array[i], array[left], array[right]);
                    System.out.println(list);
                    res.add(list);
                    //set.add(list.toString());
                    while (array[left] == array[++left]) ;
                    while (array[right] == array[--left]) ;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            /*for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == value) {
                        List<Integer> list = Arrays.asList(array[i], array[j], array[k]);
                        Collections.sort(list);
                        set.add(list.toString());
                    }
                }
            }*/
        }
        //return res = new ArrayList(set);
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];

            int target = 0 - num;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    List list = List.of(num, nums[l++], nums[r--]);
                    res.add(new ArrayList<>(list));

                }
            }
        }
        List ans = res.stream().distinct().collect(Collectors.toList());
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - num;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    List list = List.of(num, nums[l], nums[r]);
                    res.add(new ArrayList<>(list));
                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                }
            }
        }
        return res;
    }


    public void mergeSort(int[] array) {

        int[] tmpArray = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        merge(array, left, mid, right);

    }

    private void merge(int[] array, int left, int mid, int right) {
        //copy from array to tmpArray
        //int[] tmpArray= new int[array.length];
        int[] tmpArray = Arrays.copyOf(array, array.length);


        for (int i = left; i <= right; i++) {
            tmpArray[i] = array[i];
        }
        int a = left;
        int b = mid + 1;
        int i = left;

        while (a < mid + 1 && b < right + 1) {
            if (tmpArray[a] < tmpArray[b]) {
                array[i] = tmpArray[a++];
            } else {
                array[i] = tmpArray[b++];
            }
            i++;
        }

        while (a < mid + 1) {
            array[i++] = tmpArray[a++];
        }
        while (b < right + 1) {
            array[i++] = tmpArray[b++];
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int[] productExceptSelf(int[] nums) {

        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            total = total * nums[i];
        }

        int[] arr = new int[nums.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = total /nums[i];
        }
        Arrays.stream(arr).forEach(System.out::println);
        return arr;
    }

    public static void main(String[] args) {
        //int[] array = {3, 1, 6, 0, 23, 6, 9, 4, 3, 5};
        int[] array = {4, 9, 1};
        Leetcode15 leetcode = new Leetcode15();
        //int[] nums = {-1, 0, 1, 2, -1, -4};
     /*   int[] nums = {-0, 1, 1};
        System.out.println(leetcode.threeSum(nums));*/

      int[]  nums = {1,2,3,4};
        leetcode.productExceptSelf(nums);

    }


}
