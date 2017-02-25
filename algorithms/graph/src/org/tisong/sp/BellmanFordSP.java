package org.tisong.sp;

import java.util.Queue;

/**
 * Created by tisong on 2/6/17.
 */
public class BellmanFordSP {

    private double[] distTo;

    private DirectedEdge[] edgeTo;

    private Queue<Integer> queue;

    private boolean[] onQ;

    private Iterable<DirectedEdge> cycle;

    private int cost; // relax()调用次数

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {

        queue.add(s);
        onQ[s] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.remove();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weigth()) {
                distTo[w] = distTo[v] + e.weigth();
                edgeTo[w] = e;
                if (!onQ[w]) {
                    queue.add(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
            }
        }
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    private void findNegativeCycle() {
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(edgeTo.length);

        for (int v = 0; v < edgeTo.length; v++) {
            if (edgeTo[v] != null) {
                spt.addEdge(edgeTo[v]);
            }
        }

//        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(spt);
//
//        cycle = cf.cycle();
    }
}
