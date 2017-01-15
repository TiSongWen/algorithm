package org.tisong.mst;

import org.tisong.stdlib.StdOut;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 个人思路的体现
 */
public class PrimMST implements MST {

    private PriorityQueue<Edge> edges;

    private List<Edge> minTree;

    private double weight;

    private boolean[] marked;

    public PrimMST(EdgeWeightedGraph G) {
        edges = new PriorityQueue<>();
        minTree = new LinkedList<>();
        weight = 0.0;
        marked = new boolean[G.V()];

        int vertex = 0;
        marked[0] = true;
        Edge minWeight = null;
        while(minTree.size() != G.V()-1) {
            for (Edge e : G.adj(vertex)) {
                if (!marked[e.other(vertex)]) {
                    //StdOut.print(e + "\t");
                    edges.add(e);
                }
            }
            //StdOut.println();
            minWeight = edges.poll();
            vertex = minWeight.either();
            if (marked[vertex] && marked[minWeight.other(vertex)]) { continue; }
            minTree.add(minWeight);

            if ( marked[vertex]) { vertex = minWeight.other(vertex); }
            //StdOut.println("min edge: " + minWeight + "vertex: " + vertex);
            marked[vertex] = true;
            weight += minWeight.weight();
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return minTree;
    }

    @Override
    public double weight() {
        return weight;
    }
}
