package org.yj.offer;

import java.util.*;

public class Offer50 {


    public char firstUnrepeatableNumber(String text) {
        if (text == null || text.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character,Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
               return  entry.getKey();
            }
        }

        return ' ';
    }


    public static void main(String[] args) {
        Offer50 offer = new Offer50();

        System.out.println(offer.firstUnrepeatableNumber("abaccdeff"));

    }
}
