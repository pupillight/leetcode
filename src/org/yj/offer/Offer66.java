package org.yj.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer66 {

    //ArrayList<LinkedList> list = new ArrayList<>();

  /*  public int[] createArray(int[] array) {
        int[] res = new int[array.length];
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(array, list,0);

        System.out.println(arrayList);

        int index = 0;
        int i=0;
        while (index < arrayList.size()) {
            LinkedList<Integer> tmpLinkedList = arrayList.get(index);
            int tmp = 1;
            for (int j = 0; j < array.length - 1; j++) {
                tmp = tmp * tmpLinkedList.pollLast();
            }
            System.out.println(tmp);
            res[i] = tmp;
            i++;
            index=index+2;
        }
        return res;
    }

    private void backTrack(int[] array, LinkedList<Integer> list,int startIndex) {
        if (list.size() == array.length) {
            arrayList.add(new LinkedList(list));
            return;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (list.contains(array[i])) {
                continue;
            }
            list.add(array[i]);
            backTrack(array, list,startIndex);
            list.removeLast();
        }

    }
*/

   /* public int solution(int[] array)
    {

        int[] numbers= new int[array.length];

        for(int i=0;i<array.length;i++)
        {

            int tmp=1;
            for(int j=i+1;j<array.length;j++)
            {
                tmp= tmp*array[j];
            }
            numbers

        }


        return -1;
    }*/


    public int convertStr2Int(String str) {
        str = str.trim();
        int i = 0, sign = 1;
        int size = str.length();
        int res = 0;
        while (i < size) {
            if (i < size && str.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            while (i < size && (str.charAt(i) == ' ' || Character.isLetter(str.charAt(i)))) {
                i++;
            }
            while (i < size && Character.isDigit(str.charAt(i))) {
                int r = str.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                    return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + r;
                i++;
            }
        }

        res = sign * res;
        return res;
    }

    ArrayList<ArrayList> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList();

    public void solution(int[] array,int k) {
        backTrack(array, k,0);
    }

    private void backTrack(int[] array, int k, int startIndex) {
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = startIndex; i < array.length; i++) {
            if (list.contains(array[i])) {
                continue;
            }
            list.add(array[i]);
            backTrack(array, k,i+1);
            //backTrack(array, k,startIndex);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {

        Offer66 offer = new Offer66();
        //System.out.println(offer.convertStr2Int("42"));
        //System.out.println(offer.convertStr2Int("4193 with words"));
        //System.out.println(offer.convertStr2Int("words and 987"));
        //System.out.println(offer.convertStr2Int("   dfff   -42"));
        //System.out.println(offer.convertStr2Int("   dfff   -42"));
        //System.out.println(offer.convertStr2Int("-2147483648"));


        int[] array = {1, 2, 3};
        offer.solution(array,2);
        System.out.println(offer.res);
        //offer.createArray(array);
        //System.out.println(true && true);

    }
}
