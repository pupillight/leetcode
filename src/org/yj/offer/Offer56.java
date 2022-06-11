package org.yj.offer;

import java.util.ArrayList;

public class Offer56 {

    public int[] unrepeatableNumbers(int[] array)
    {
        ArrayList<Integer> arrayList =new ArrayList<>();
        int res =array[0];
        for(int i=1;i<array.length;i++)
        {
            res = res ^ array[i];
           // if(res!=0)
           // {
           //     arrayList.add(array[i]);
           // }
        }
        System.out.println(res);
        return  null;
    }



    public static void main(String[] args) {

        Offer56 offer= new Offer56();
        int[] array= {4,3,4,6};
        offer.unrepeatableNumbers(array);


    }
}
