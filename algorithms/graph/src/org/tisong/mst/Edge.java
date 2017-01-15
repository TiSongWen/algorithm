package org.tisong.mst;

/**
 * 无向权值图的边
 */
public class Edge implements Comparable<Edge> {

    private final int v;

    private final int w;

    private final double weight;

    public Edge(int v, int w, double weight) { this.v = v; this.w = w; this.weight = weight; }

    public int other(int vertex) {
        if (vertex == v)      return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int either() { return v; }

    public double weight() { return weight; }

    @Override
    public int compareTo(Edge edge) {
        return weight < edge.weight() ? -1 : (weight == edge.weight() ? 0 : 1);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
