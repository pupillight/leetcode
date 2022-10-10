package org.yj.application.data.structure.graph;

public class Edge implements Comparable<Edge> {
    int left;
    int right;
    int weight;
    public Edge(int left, int right, int weight) {
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    public int vertex() {
        return this.left;
    }

    public int otherVertex(int p) {
        if (left == p) {
            return right;
        } else {
            return left;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
