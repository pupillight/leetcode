package org.yj.leetcode;

import org.yj.application.data.structure.linked.LinkNode;

import java.util.*;

public class LeetCode274 {


    public int hIndex(int[] citations) {

        Arrays.sort(citations);
        int l = 0;
        int r = citations.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //h 的位置的引用数量>=h位置后文章数量
            int count = citations.length - mid;
            if (citations[mid] == count) {
                return citations[mid];
            } else if (citations[mid] < count) {
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return citations.length-l;
    }


    public static void main(String[] args) {
        LeetCode274 leetCode = new LeetCode274();


       int[] citations = {1,2,100};
        System.out.println(leetCode.hIndex(citations));
    }
}
