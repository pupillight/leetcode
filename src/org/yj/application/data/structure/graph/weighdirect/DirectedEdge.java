package org.yj.application.data.structure.graph.weighdirect;

public class DirectedEdge {
    public int from;
    public int to;
    public int weigh;

    public DirectedEdge(int from, int to, int weigh) {
        this.from = from;
        this.to = to;
        this.weigh = weigh;

    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }
}
