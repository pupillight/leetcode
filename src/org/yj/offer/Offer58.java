package org.yj.offer;

import org.yj.application.data.structure.linked.LinkList;

public class Offer58 {

    public String reverseStr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }


        str = str.trim();
        int i = str.length() - 1;
        int j = i;

        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            while (i>= 0 && str.charAt(i) != ' ') {
                i--;
            }

            builder.append(str.substring(i+1, j+1));
            builder.append(' ');
            while (i>=0 && str.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }


        return builder.toString().trim();
    }


    public static void main(String[] args) {
        Offer58 offer = new Offer58();
        System.out.println(offer.reverseStr("a good    example "));
    }


}
