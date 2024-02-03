package org.yj.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphQuestions {

/*    class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }*/

    public void shortestPath1(int[][] g, int s, int d) {
        int count = g.length;
        List<Integer>[] adj = new List[count];
        int[] dist = new int[count];
        int[] path = new int[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (g[i][j] != -1) {
                    adj[i].add(j);
                }
            }
        }
        dist[s] = 0;
        path[s] = s;
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> (e1[1] - e2[1]));
        queue.add(new int[]{s, dist[s]});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            for (Integer w : adj[v]) {
                int weight = g[v][w];
                int sum = dist[v] + weight;
                if (sum < dist[w]) {
                    dist[w] = sum;
                    path[w] = v;
                    queue.add(new int[]{w, dist[w]});
                }
            }
        }

        Stack<Integer> stack = route(path, d);
        System.out.println(dist[d]);
        System.out.println(stack);
    }

    public void shortestPath(int[][] g, int s, int d) {
        int count = g.length;
        List<Integer>[] adj = new List[count];
        int[] dist = new int[count];
        int[] path = new int[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        /*for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (g[i][j] != -1) {
                    adj[i].add(j);
                }
            }
        }*/
        dist[s] = 0;
        path[s] = s;
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> (e1[1] - e2[1]));
        queue.add(new int[]{s, dist[s]});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            for (int i = 0; i < g.length; i++) {
                if (g[v][i] > 0) {
                    adj[v].add(i);
                }
            }
            for (Integer w : adj[v]) {
                int weight = g[v][w];
                int sum = dist[v] + weight;
                if (sum < dist[w]) {
                    dist[w] = sum;
                    path[w] = v;
                    queue.add(new int[]{w, dist[w]});
                }
            }
        }

        Stack<Integer> stack = route(path, d);
        System.out.println(dist[d]);
        System.out.println(stack);
    }

    public Stack<Integer> route(int[] path, int p) {

        Stack<Integer> stack = new Stack<>();
        stack.push(p);
        while (p != path[p]) {
            p = path[p];
            stack.push(p);
        }
        return stack;

    }

    private void addEdge(int v, int w, List<Integer>[] adj) {
        adj[v].add(w);
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {


        List<Integer>[] vertx = new List[n];
        for (int i = 0; i < n; i++) {
            vertx[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            vertx[s].add(d);
            vertx[d].add(s);
        }
        int[] mark = new int[n];
        boolean res = dfs(source, destination, vertx, mark);
        return res;
    }

    private boolean dfs(int source, int dest, List<Integer>[] vertx, int[] mark) {

        if (source == dest) {
            return true;
        }
        boolean res = false;
        mark[source] = 1;
        List<Integer> list = vertx[source];
        for (Integer v : list) {
            if (mark[v] == 0 && dfs(v, dest, vertx, mark)) {
                return true;
            }
        }
        return false;
    }

    private void canVisitAllRoomsDfs(int v, List<Integer>[] adj, boolean[] visited) {
        visited[v] = true;
        for (Integer u : adj[v]) {
            if (!visited[u]) {
                canVisitAllRoomsDfs(u, adj, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        List<Integer>[] adj = new List[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            adj[i] = new ArrayList();
            List<Integer> room = rooms.get(i);
            adj[i] = room;
        }

        //判断联通性
        boolean[] visited = new boolean[rooms.size()];
        canVisitAllRoomsDfs(0, adj, visited);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }

        return true;
    }

    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            int n = watchedVideos.size();
            boolean[] visited = new boolean[n];
            visited[id] = true;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            queue.offer(id);
            while (!queue.isEmpty() && level > 0) {
                level--;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int curr = queue.poll();
                    int[] currFriends = friends[curr];
                    for (int friend : currFriends) {
                        if (!visited[friend]) {
                            visited[friend] = true;
                            queue.offer(friend);
                        }
                    }
                }
            }
            Map<String, Integer> counts = new HashMap<String, Integer>();
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                List<String> currVideos = watchedVideos.get(curr);
                for (String video : currVideos) {
                    counts.put(video, counts.getOrDefault(video, 0) + 1);
                }
            }
            List<String> videosByFriends = new ArrayList<String>(counts.keySet());
            Collections.sort(videosByFriends, (a, b) -> {
                int count1 = counts.get(a), count2 = counts.get(b);
                if (count1 != count2) {
                    return count1 - count2;
                } else {
                    return a.compareTo(b);
                }
            });
            return videosByFriends;
        }
    }


    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer>[] adj = new List[friends.length];
        boolean[] visited = new boolean[friends.length];
        for (int i = 0; i < friends.length; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < friends[i].length; j++) {
                adj[i].add(friends[i][j]);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        visited[id] = true;
        while (!queue.isEmpty() && level > 0) {
            level--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
               /* for (int friend : friends[v]) {
                    if (!visited[friend]) {
                        visited[friend]=true;
                        queue.add(friend);
                    }
                }*/
                for (Integer u : adj[v]) {
                    if (!visited[u]) {
                        visited[u] = true;
                        queue.add(u);
                    }
                }
            }
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            watchedVideos.get(v).forEach(e -> {
                map.put(e, map.getOrDefault(e, 0) + 1);
            });
        }
        List<String> res = map.entrySet().stream().sorted((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e1.getValue() - e2.getValue();
        }).map(e -> e.getKey()).collect(Collectors.toList());
        return res;
       /* List<String> res = new ArrayList<>(map.keySet());
        Collections.sort(res, (e1, e2) -> {
            int count1 = map.get(e1);
            int count2 = map.get(e2);
            if (count1 == count2) {
                return e1.compareTo(e2);
            }
            return count1 - count2;
        });*/


    }

    class Video {
        String name;
        int times;

        public Video(String name, int times) {
            this.name = name;
            this.times = times;
        }
    }


    List<List<Integer>> paths = new ArrayList<>();

    class Node {
        int x, y;

        Node pre;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];

        //Node pre = new Node[row + col];
        Node pre = new Node(0, 0);
        LinkedList<Integer> path = new LinkedList<>();
        //visited[0][0]=true;
        //path.add(heights[0][0]);
        minimumEffortPathDfs(heights, row, col, 0, 0, visited, path, pre);


        System.out.println(paths);
        System.out.println(path);
        return -1;
    }

    private void minimumEffortPathDfs(int[][] heights, int row, int col, int i, int j, boolean[][] visited, LinkedList<Integer> path, Node pre) {

      /*  if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] ==true) {
            return;
        }*/

        visited[i][j] = true;
        path.add(heights[i][j]);
        if (i == row - 1 && j == col - 1) {
            //path.add(heights[i][j]);
            paths.add(new ArrayList<>(path));
            return;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < directions.length; k++) {
            int m = directions[k][0];
            int n = directions[k][1];

            int tx = i + m;
            int ty = j + n;
            if (tx >= 0 && tx < row && ty >= 0 && ty < col && visited[tx][ty] == false) {
                //visited[tx][ty] = true;
                //path.add(heights[tx][ty]);
                pre = new Node(tx, ty);
                pre.pre = new Node(i, j);
                minimumEffortPathDfs(heights, row, col, tx, ty, visited, path, pre);
                visited[tx][ty] = false;
                path.removeLast();
            }
        }
        //path.removeLast();
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        List<Integer>[] adj = new List[len];
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> paths = new ArrayList<>();
       // path.add(0);
        dfs1(graph, 0, path, paths);
        return paths;
    }

    private void dfs1(int[][] graph, int s, LinkedList<Integer> path, List<List<Integer>> paths) {
        path.add(s);
        if (s == (graph.length - 1)) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int v : graph[s]) {

            dfs1(graph, v, path, paths);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        GraphQuestions questions = new GraphQuestions();

        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(questions.allPathsSourceTarget(graph));


        //int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        //int[][] heights = {{1, 2}, {3, 8}};
        //questions.minimumEffortPath(heights);
        //Edge edge = new Edge();

       /* int[][] g = {{0, 6, 3, -1, -1, -1},
                {6, 0, 2, 5, -1, -1},
                {3, 2, 0, 3, 4, -1},
                {-1, 5, 3, 0, 2, 3},
                {-1, -1, 4, 2, 0, 5},
                {-1, -1, -1, 3, 5, 0}};


        questions.shortestPath(g, 0, 4);*/

       /* int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(questions.validPath(3, edges, 0, 2));*/

      /*  List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("C"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));

        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        System.out.println(questions.watchedVideosByFriends(watchedVideos, friends, 0, 1));*/

      /*  List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println(questions.canVisitAllRooms(rooms));*/

/*
        int[][] edges = {{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}};
        System.out.println(questions.validPath(10, edges, 5, 9));*/


    }

}
