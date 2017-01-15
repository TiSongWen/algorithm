package org.tisong.mst.test;

import org.junit.Test;
import org.tisong.mst.Edge;
import org.tisong.mst.EdgeWeightedGraph;
import org.tisong.mst.PrimMST;
import org.tisong.stdlib.In;
import org.tisong.stdlib.StdOut;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/15/17.
 */
public class PrimMSTTest {
    @Test
    public void edges() throws Exception {
        PrimMST mst = getPriMST();
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.println(mst.weight());
    }

    @Test
    public void weight() throws Exception {

    }

    public PrimMST getPriMST() {
        return new PrimMST(new EdgeWeightedGraph(new In(this.getClass().getResource("tinyEWG.txt"))));
    }
}