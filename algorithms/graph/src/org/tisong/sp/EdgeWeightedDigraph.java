package org.tisong.sp;

import java.util.LinkedList;
import java.util.List;

/**
 * 加权有向图
 */
public class EdgeWeightedDigraph {

    private final int V; // 顶点总数

    private int E; // 边的总数

    private List<DirectedEdge>[] adj; // 邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    public void addEdge (DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }


    public Iterable<DirectedEdge> adj(int v) {
        if (v >= V) throw new IllegalArgumentException("out of the number of edges");

        return adj[v];
    }

    public int V() { return V; }

    public int E() { return E; }
}
