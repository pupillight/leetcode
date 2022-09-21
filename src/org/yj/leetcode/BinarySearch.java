package org.yj.leetcode;

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
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid-1;
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
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int[] nums = {1, 3, 5};
        //int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        //int[] nums = {3, 1};
        //System.out.println(binarySearch.findPeak(nums));

        int[] nums = {1, 2, 3, 5, 5, 5, 5, 8, 9};
        //int[] nums = {1, 2, 3, 5, 8, 9};
        System.out.println(binarySearch.bSearchFirst(nums, 5+1));
        System.out.println(binarySearch.bSearchLast(nums, 5));
        //System.out.println(binarySearch.search(nums, 1));

    }

}
