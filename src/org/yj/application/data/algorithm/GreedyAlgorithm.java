package org.yj.application.data.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

        HashSet<String> set1 = new HashSet<String>();
        set1.add("beijing");
        set1.add("shanghai");
        set1.add("tianjin");

        HashSet<String> set2 = new HashSet<String>();
        set2.add("guangzhou");
        set2.add("beijing");
        set2.add("shenzhen");

        HashSet<String> set3 = new HashSet<String>();
        set3.add("chengdu");
        set3.add("shanghai");
        set3.add("hangzhou");

        HashSet<String> set4 = new HashSet<String>();
        set4.add("shanghai");
        set4.add("tianjin");


        HashSet<String> set5 = new HashSet<String>();
        set5.add("hangzhou");
        set5.add("dalian");


        map.put("K1", set1);
        map.put("K2", set2);
        map.put("K3", set3);
        map.put("K4", set4);
        map.put("K5", set5);


        HashSet<String> areas = new HashSet<String>();
        areas.add("beijing");
        areas.add("shanghai");
        areas.add("tianjin");
        areas.add("guangzhou");
        areas.add("shenzhen");
        areas.add("chengdu");
        areas.add("hangzhou");
        areas.add("dalian");

        ArrayList<String> selectKeys = new ArrayList<String>();

        while (areas.size() != 0) {
            String tmpKey = null;
            for (String key : map.keySet()) {
                HashSet<String> set = map.get(key);
                set.retainAll(areas);

                //greedy highlight
                if (set.size() > 0 && (tmpKey == null || set.size() > map.get(tmpKey).size())) {
                    tmpKey = key;
                }
            }
            selectKeys.add(tmpKey);
            areas.removeAll(map.get(tmpKey));
        }

        System.out.println(selectKeys);

    }


}
