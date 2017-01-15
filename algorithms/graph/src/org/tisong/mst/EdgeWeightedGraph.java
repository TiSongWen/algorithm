package org.tisong.mst;

import org.tisong.stdlib.In;

import java.util.LinkedList;
import java.util.List;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    private final int V; // 顶点数

    private int E; // 边数

    private List<Edge>[] adj; // 邻接表


    public EdgeWeightedGraph(int V) {
        this.V = V;
        E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge edge = new Edge(v, w, weight);
            adj[v].add(edge);
            adj[w].add(edge);
        }
    }

    public Iterable<Edge> adj(int v) {
        if (v < 0 || v >= E) throw new RuntimeException(v + "not in the Graph");

        return adj[v];
    }

    /**
     * 顶点数
     */
    public int V() { return V; }

    /**
     * 边数
     */
    public int E() { return E; }
}
