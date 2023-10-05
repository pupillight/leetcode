package org.yj.generic;

import java.util.List;

public class Tester {

    List<Printer> printers;

    public <T> void addPrinter(List<RegularPrinter<T>> list) {

        list.add(new RegularPrinter<T>());
        //list.add(new CannonPrinter());

    }

    public static Number sum(List<? extends Number> nums) {
        double res = 0;
        for (Number num : nums) {
            res += num.doubleValue();
        }

        return res;
    }


    public static  int bSearch(int[] arr,int target){

        int l=0;
        int r= arr.length-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(target<arr[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public static void main(String[] args) {

        int[] arr= {1,3,6,19,30};
        System.out.println(bSearch(arr, 5));




        /*Printer hpPinter = new HPPinter();
        hpPinter.print("aaa");

        Printer<Integer> cannonPrinter = new CannonPrinter<>();
        cannonPrinter.print(145);


        cannonPrinter.println("a",1,"c");*/
    }
}
