package org.yj.leetcode;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Map;

public class LeetCode654 {


    public int finaMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                right = mid + 1;

            } else {
                left = mid;
            }

        }
        return nums[left];
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {


        for (int i = 0; i < nums.length; i++) {

        }
        return null;

    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int res = 0;
        int[] array = new int[n];
        Arrays.fill(array, 1);
        for (int i = 2; i * i < n; i++) {
            if (array[i] == 1) {
                for (int j = i; j * i < n; j++) {
                    array[i * j] = 0;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (array[i] == 1) {
                res++;
            }
        }
        return res;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        if (str1 == null || str1 == "" || str2 == "" || str2 == null) {
            return "";
        }
        int len = Math.min(str1.length(), str2.length());
        int i = 0;
        for (i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i );
    }


    public static String reverse(String text)
    {
        char[] array=text.toCharArray();
        int left=0;
        int right=array.length-1;
        while(left<right){
            char tmp=array[left];
            array[left]=array[right];
            array[right]= tmp;
            left++;
            right--;

        }
        return new String(array);
    }




    public static void main(String[] args) {
        LeetCode654 leetCode654 = new LeetCode654();
        int[] nums = {3, 2, 1};
        //int[] nums = {3, 2, 1, 6, 0, 5};
        //  System.out.println(leetCode654.finaMax(nums));


        //System.out.println(leetCode654.countPrimes(10));
       // String[] array ={"flower","flow","flight"};
        ///System.out.println(leetCode654.longestCommonPrefix(array));
        System.out.println(leetCode654.reverse("ab"));
    }
}
