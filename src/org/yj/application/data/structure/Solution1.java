package org.yj.application.data.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    /*  List<Integer>[] adj;*/
    Map<String, String> fromMap = new HashMap<>();
    Map<String, String> toMap = new HashMap<>();

    public int solution(int X, int Y, String[] C) {
        // Implement your solution here
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            String str = C[i];
            int index = str.indexOf(" ");
            String from = str.substring(0, index);
            String to = str.substring(index + 1);

            if (toMap.containsKey(from) && toMap.get(from).equals(to)) {
                ans++;
                continue;
            }

            if (!fromMap.containsKey(from)) {
                fromMap.put(from, to);
            }

            if (!toMap.containsKey(to)) {
                toMap.put(to, from);
            }


          /*  if(!formMap.containsKey(key)){
                formMap.put(key,value);
            }
            else{
                if(map.get(value).equals(key)){
                  ans++;
                }
            }*/
        }

        return ans;

       /* for (int i = 0; i < C.length; i++) {

            adj[i] = new ArrayList<>();
            String str=C[i];
            int index =str.indexOf(" ");
            str.substring(0,index);
            str.substring(index+1);

            adj[i].add()


        }*/
    }


    public int solution(int X) {
        // Implement your solution here
        X++;
        if (X % 7 == 0) {
            return solution(X);
        }

        if (String.valueOf(X).indexOf("7") > -1) {
            X++;
            return solution(X);
        }

        return X;
    }


    public static void main(String[] args) {
        Solution1 instance = new Solution1();
    /*    String[] strs={"1 2","2 1","2 3"};
        System.out.println(instance.solution(3, 3, strs));*/

        System.out.println(instance.solution(69));

    }
}
