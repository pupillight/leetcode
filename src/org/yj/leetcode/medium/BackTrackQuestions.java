package org.yj.leetcode.medium;

import java.util.*;

public class BackTrackQuestions {


/*
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(nums, path);
        return res;
    }


    private void backTrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTrack(nums, path);
            path.removeLast();
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        res.add(new ArrayList<>());
        subSetsBackTrack(nums, 0, path);
        return res;
    }

    private void subSetsBackTrack(int[] nums, int index, LinkedList<Integer> path) {
        if (!path.isEmpty()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            subSetsBackTrack(nums, i + 1, path);
            path.removeLast();
        }
    }


   */
/* private void init() {
        List<Character> list = null;
        list = new ArrayList<>();

        list.add('a');
        list.add('b');
        list.add('c');
        map.put('2', list);

        list = new ArrayList<>();
        list.add('d');
        list.add('e');
        list.add('f');
        map.put('3', list);

        list = new ArrayList<>();
        list.add('g');
        list.add('h');
        list.add('i');
        map.put('4', list);

    }*/
    /*



    Map<Character, String> map = new HashMap<>();
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder builder = new StringBuilder();
        letterBackTrack(digits, 0, builder);
        return this.combinations;
    }

    private void letterBackTrack(String digits, int i, StringBuilder builder) {
        if (i == digits.length()) {
            combinations.add(builder.toString());
            return;
        }
        String value = map.get(digits.charAt(i));
        for (int j = 0; j < value.length(); j++) {
            char c = value.charAt(j);
            builder.append(c);
            letterBackTrack(digits, i + 1, builder);
            builder.deleteCharAt(i);
        }
    }
*/

    /*    private void letterBackTrack(List<List<Character>> list, int count,int indexA) {

            if (path.size() == count) {
                StringBuilder builder =new StringBuilder();
                for(int i=0;i<path.size();i++){
                    builder.append(path.get(i));
                }
                combinations.add(builder.toString());
                return;
            }
            for (int i = indexA; i < count; i++) {
                List<Character> tmp = list.get(i);

                for (int j = 0; j < tmp.size(); j++) {
                    char c = tmp.get(j);
                    path.add(c + "");
                    letterBackTrack(list, count,indexA+1);
                    path.removeLast();
                }
            }


        }*/

    /*public List<String> generateParenthesis(int n) {

        StringBuilder builder = new StringBuilder();
        backTrack(n, 0, "", 0, 0);
        return res;
    }

    public void backTrack(int n, int index, String path, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        backTrack(n, index, path + "(", left + 1, right);
        backTrack(n, index, path + ")", left, right + 1);
        //builder.deleteCharAt(index);
    }*/
/*
    public List<String> generateParenthesis(int n) {
//        map.put(0, '(');
//        map.put(1, ')');
//        LinkedList<String> path = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backTrack(n, 0, "", 0, 0);
        return res;
    }

    public void backTrack(int n, int index, String path, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(path);
        if (builder.toString().length() == 2 * n) {
            res.add(builder.toString());
            return;
        }
        backTrack(n, index, builder.append('(').toString(), left + 1, right);
        backTrack(n, index, builder.append(')').toString(), left, right + 1);

    }
*/

  /*  public void backTrack1(int n, int index, StringBuilder builder, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (index == 2 * n) {
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            char c = map.get(i);
            builder.append(map.get(i));
            if (c == '(') backTrack(n, index + 1, builder, left + 1, right);
            if (c == ')') backTrack(n, index + 1, builder, left, right + 1);
            builder.deleteCharAt(index);
        }
    }*/
    /*List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(n, k, path, 1);
        return res;
    }

    private void backTrack(int n, int k, LinkedList<Integer> path, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {

            path.add(i);
            backTrack(n, k, path, i +1);
            path.removeLast();
        }
    }*/

/*
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();

        Arrays.sort(candidates);
        combinationSum2(candidates, target, path, 0);
        // new ArrayList<>(set);
        return new ArrayList<>(set);
    }

    private void combinationSum2(int[] candidates, int target, LinkedList<Integer> path, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            set.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i+1<candidates.length && candidates[i] == candidates[i + 1]) {
                continue;
            }
            int val = candidates[i];
            path.add(val);
            combinationSum2(candidates, target - val, path, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        combinationSum(candidates, target, path, 0);
        return list;
    }

    private void combinationSum(int[] candidates, int target, LinkedList<Integer> path, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int val = candidates[i];
            path.add(val);
            combinationSum(candidates, target - val, path, i);
            path.removeLast();
        }
    }
*/

/*    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s,0, "", res);
        return res;

    }

    public void backTracking(String s, int index,String path, List<String> res) {
        if (path.length() == s.length()) {
            res.add(path);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            backTracking(s, i+1,path + c, res);
        }
    }*/

    /*public List<String> readBinaryWatch(int turnedOn) {

        int[] hours = {8,4,2,1};
        int[] minutes={32,16,8,4,2,1};

        if(turnedOn>=9)
        {
            return new ArrayList<>();
        }
        for(int i= 0;i<hours.length;i++)
        {

        }


    }*/

    /*int result = 0;
    public int subsetXORSum(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backTrack(nums, 0, path);
        return result;
    }

    private void backTrack(int[] nums, int startIndex, LinkedList<Integer> path) {
        if (!path.isEmpty()) {
            int oxSum = 0;
            for (int i = 0; i < path.size(); i++) {
                oxSum ^= path.get(i);
            }
            result= result+oxSum;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1, path);
            path.removeLast();
        }
    }*/

   /* public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        LinkedList<Character> path = new LinkedList<>();
        backTrack(s, path,res);
        return res.toArray(new String[res.size()]);
    }

    private void backTrack(String s, LinkedList<Character> path, List<String> res) {
        if (path.size() == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                builder.append(path.get(i));
            }
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (path.contains(c)) {
                continue;
            }
            path.add(c);
            backTrack(s, path, res);
            path.removeLast();
        }
    }*/

/*    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }*/


    /*public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = graph.length;
        Queue<PathNode> queue = new LinkedList<>();
        queue.offer(new PathNode(0));

        while (!queue.isEmpty()) {
            PathNode node = queue.poll();
            if (node.val == n - 1) {
                resultList.add(node.path);
                continue;
            }
            for(int next: graph[node.val]){
                queue.offer(new PathNode(next , node.path));
            }
        }
        return resultList;
    }

*/

    public int countArrangement(int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList();
        backTrack(n, 1, path, res);

        return 0;
    }

    private void backTrack(int n, int index, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            backTrack(n, index, path, res);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        BackTrackQuestions questions = new BackTrackQuestions();
        int[][] graph = {{1, 2}, {3}, {3}, {}};

        questions.countArrangement(2);
        //questions.allPathsSourceTarget(graph);
       /* int[] array = {5, 1, 6};
        String[] res = questions.permutation("qwe");
        System.out.println(res);*/

        //questions.subsetXORSum(array);
        //int[] array = {1, 2, 3};
        //questions.permute(array).stream().forEach(System.out::println);
        // questions.subsets(array).stream().forEach(System.out::println);
        //questions.letterCombinations("").stream().forEach(System.out::println);

        //questions.generateParenthesis(2).stream().forEach(System.out::println);

        //questions.combine(4, 2).stream().forEach(System.out::println);
        //int[] candidates = {2, 3, 6, 7};
        // questions.combinationSum(candidates, 7).stream().forEach(System.out::println);
        //questions.letterCasePermutation("a1b2").stream().forEach(System.out::println);
        //System.out.println();
    }
}

class PathNode {
    public int val;
    public List<Integer> path;

    public PathNode() {
    }

    public PathNode(int val) {
        this.val = val;
        this.path = new ArrayList<>();
        this.path.add(val);
    }

    public PathNode(int val, List<Integer> path) {
        this.val = val;
        this.path = new ArrayList<>(path);
        this.path.add(val);
    }

}