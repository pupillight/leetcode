package org.yj.application.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortAlgorithm {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        int pivot = nums[l];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        if (left == right) {
            nums[l] = nums[left];
            nums[left] = pivot;
        }

        quickSort(nums, l, left - 1);
        quickSort(nums, left + 1, r);

    }

    public void mergeSort(int[] number) {
        mergeSort(number, 0, number.length - 1);
    }

    private void mergeSort(int[] number, int l, int r) {
        if (l >= r) {
            return;
        }


        int mid = l + (r - l) / 2;
        mergeSort(number, l, mid);
        mergeSort(number, mid + 1, r);
        sort(number, l, mid, r);
    }

    private void sort(int[] nums, int l, int mid, int r) {
        int p = l;
        int q = mid + 1;
        int[] tmp = new int[r - l + 1];
        int i = 0;
        while (p <= mid && q <= r) {
            if (nums[p] < nums[q]) {
                tmp[i++] = nums[p++];
            } else {
                tmp[i++] = nums[q++];
            }
        }
        while (p <= mid && i < tmp.length) {
            tmp[i++] = nums[p++];
        }
        while (q <= r && i < tmp.length) {
            tmp[i++] = nums[q++];
        }
        for (int j = 0; j < tmp.length; j++) {
            nums[l + j] = tmp[j];
        }
    }

    public static void fizzBuzz(int n) {
        // Write your code here

        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i%3==0)
            {
                System.out.println("Fizz");
            }
            else if(i%5==0)
            {
                System.out.println("Buzz");
            }
            else{
                System.out.println(n);
            }

        }

    }
   /* public static void fizzBuzz(int n) {
        // Write your code here

        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (n % 3 == 0) {
            System.out.println("Fizz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }

    }*/

    public static void main(String[] args) {
        SortAlgorithm instance = new SortAlgorithm();
/*        int count = 10;
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            nums[i] = random.nextInt(20);
        }
        //instance.mergeSort(nums);
        //int[] nums = {3, 5, 2, 9, 4};
        instance.quickSort(nums);
        Arrays.stream(nums).forEach((e) -> System.out.println(e));*/

        instance.fizzBuzz(3);

        //System.out.println(1 % 3);
    }

}
