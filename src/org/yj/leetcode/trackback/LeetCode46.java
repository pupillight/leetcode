package org.yj.leetcode.trackback;

import org.yj.application.data.structure.linked.LinkNode;

import java.util.*;

public class LeetCode46 {

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        trackBack(nums,0);
        System.out.println(res);
        return res;
    }

    private void trackBack(int[] nums, int index) {

        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            trackBack(nums,0);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        LeetCode46 leetCode = new LeetCode46();

        int[] nums = {1,2,3};
       leetCode.permute(nums);
    }
}
