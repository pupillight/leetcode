package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.*;

public class Offer54 {

    public int getValue(TreeNode root, int k) {
        int res = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        getArray(root, list);
        return list.get(list.size() - k);
    }

    private void getArray(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getArray(root.left, list);
        list.add(root.value);
        getArray(root.right, list);
    }

    private Integer[] getArray1(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return null;
        }
        getArray(root.left, list);
        list.add(root.value);
        getArray(root.right, list);
        Integer[] array = new Integer[list.size()];

        return list.toArray(array);
    }

    public String reverseText(String text) {
        String res = text.trim();
        int i = res.length() - 1;
        int j = res.length() - 1;
        StringBuilder builder = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && res.charAt(i) != ' ') i--;
            builder.append(res.substring(i + 1, j + 1));
            builder.append(" ");
            j = i;
            while (i >= 0 && res.charAt(i) == ' ') i--;
            j = i;
        }

        res = builder.toString().trim();
        return res;
    }


    public String reverseText2(String text) {
        String res = text.trim();

        int i = res.length() - 1;
        int j = res.length() - 1;

        StringBuilder builder = new StringBuilder();
        while (i > 0) {
            if (res.charAt(i) == ' ') {
                builder.append(res.substring(i + 1, j + 1));
                builder.append(" ");
                j = i;

                while (res.charAt(i) == ' ') {
                    i--;
                    j--;
                }
                continue;
            }
            i--;
        }
        builder.append(res.substring(i, j + 1));
        return builder.toString();
    }

    public String reverseText1(String text) {
        String res = text.trim();
        String[] words = res.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                builder.append(words[i].trim());
                builder.append(" ");
            }

        }
        res = builder.toString().trim();
        return res;
    }


    public int findNumber(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int m = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int n = map.get(array[i]) + 1;
                map.replace(array[i], n);
                if (n > m) {
                    return array[i];
                }
            } else {
                map.put(array[i], 1);
            }
        }
       /* int m = array.length / 2;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int count = entry.getValue();
            if (count > m) {
                return entry.getKey();
            }
        }*/
        return Integer.MIN_VALUE;
    }


    public Integer[] miniNumbers(int[] array, int k) {

        Integer[] res = null;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            int tmp = priorityQueue.peek();
            if (array[i] < tmp) {
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }

        res = new Integer[priorityQueue.size()];
        priorityQueue.toArray(res);

        return res;
    }
    public int findMissedNumber(int[] array) {
        int res = Integer.MIN_VALUE;

        int i=1;
        res=array[0]^0;
        for (; i < array[array.length-1]; i++) {
            res = res ^ array[i]^i;
        }
        res= res^i;

/*        int[] tmpArray = new int[array.length + 1];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i] = i;
        }
        for(int i = 0; i < tmpArray.length; i++)
        {
            res = res^tmpArray[i];
        }*/
        return res;
    }


    public int findMissedNumber1(int[] array) {
        int res = Integer.MIN_VALUE;

        res=array[0];
        for (int i = 1; i < array.length; i++) {
            res = res ^ array[i];
        }

        int[] tmpArray = new int[array.length + 1];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i] = i;
        }
        for(int i = 0; i < tmpArray.length; i++)
        {
            res = res^tmpArray[i];
        }
        return res;
    }


    public static void main(String[] args) {
        Offer54 offer = new Offer54();

/*        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(offer.getValue(root, 1));*/

        //System.out.println(offer.reverseText(" the sky is blue"));
        //System.out.println(offer.reverseText("  hello world!  "));
        //System.out.println(offer.reverseText(" a good    example"));

        // System.out.println(offer.reverseText1(" a good    example"));
        //int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        //System.out.println(offer.findNumber(array));
        //int[] array = {0, 1, 2, 1, -1, -5};

        //Integer[] res = offer.miniNumbers(array, 5);

        //System.out.println(Arrays.toString(res));


        //int[] array = {0,1,2,4};
        int[] array = {0,1,2,3,4,5,6,8,9,10};

        System.out.println(offer.findMissedNumber(array));





    }


}
