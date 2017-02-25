package org.tisong.sp;

import org.tisong.dir.Topological;

/**
 * 无环加权有向图最短路径
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;

    private double[] distTo;


    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0D;

//        Topological top = new Topological(G);
//        for (int v : top.order()) {
//            relax(G, v);
//        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {

    }
}
