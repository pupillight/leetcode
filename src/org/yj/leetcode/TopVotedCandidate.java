package org.yj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopVotedCandidate {

    List<int[]> list = new ArrayList<>();
    int[] number;

    Map<Integer, Integer> map = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {

/*        number=new int[persons.length];

        for (int i = 0; i < persons.length; i++) {
            //number[persons[i]]++;
            //map.put(persons[i], )
        }*/

        int val = 0;
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= val) {
                val = map.get(persons[i]);
                list.add(new int[]{times[i], persons[i]});
            }else{
                list.add(new int[]{times[i], list.get(i-1)[1]});
            }

        }
    }

    public int q(int t) {
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {

            int mid = i + (j - i) / 2;
            if (list.get(mid)[0] > t) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return list.get(i - 1)[1];
    }


    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 2, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate instance = new TopVotedCandidate(persons, times);
    }
}
