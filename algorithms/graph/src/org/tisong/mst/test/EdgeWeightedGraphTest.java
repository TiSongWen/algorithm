package org.tisong.mst.test;

import org.junit.Test;
import org.tisong.mst.Edge;
import org.tisong.mst.EdgeWeightedGraph;
import org.tisong.stdlib.In;
import org.tisong.stdlib.StdOut;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/15/17.
 */
public class EdgeWeightedGraphTest {
    @Test
    public void adj() throws Exception {
        EdgeWeightedGraph G = getEdgeWeightedGraph();

        for (int i = 0; i < G.V(); i++) {
            for (Edge e : G.adj(i)) {
                StdOut.print(e + " ");
            }
            StdOut.println();
        }
    }

    @Test
    public void v() throws Exception {

    }

    @Test
    public void e() throws Exception {

    }

    private EdgeWeightedGraph getEdgeWeightedGraph() {
        return new EdgeWeightedGraph(new In(this.getClass().getResource("tinyEWG.txt")));
    }
}