package org.yj.leetcode.medium;

public class SortSearchQuestions {


    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int index = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                index = mid;
                //
            } else if (nums[mid] > nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = index;

        int[] array = new int[nums.length];


        for (int i = 0; i <= index; i++) {
            array[i] = nums[index + i];
        }
        int j = 0;
        for (int i = index + 1; i < nums.length; i++) {
            array[i] = nums[j++];
        }

        System.out.println(left);
        System.out.println(right);


        return -1;

    }

    public int findPeakElement(int[] nums) {
        if (nums.length ==1) {
            return 0;
        }
        int i = 1, j = 0;
        while (i  < nums.length && j < nums.length) {
            if(nums[j] > nums[i] && i+1== nums.length) return j;
            if(nums[j] < nums[i] && i+1== nums.length) return i;
            if (nums[j] < nums[i] && nums[i] > nums[i + 1]) return i;
            j++;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        SortSearchQuestions questions = new SortSearchQuestions();


//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int target = 0;
//        questions.search(nums, target);

        int[] nums = {2, 1};
        System.out.println(questions.findPeakElement(nums));

    }
}
