package org.tisong.undir.test;

import org.junit.Test;
import org.tisong.stdlib.In;
import org.tisong.undir.BreadthFirstPaths;
import org.tisong.undir.BreadthFirstPaths2;
import org.tisong.undir.Graph;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/12/17.
 */
public class BreadthFirstPathsTest {

    BreadthFirstPaths bfp = null;

    @Test
    public void hasPathTo() throws Exception {

    }

    @Test
    public void pathTo() throws Exception {

    }

    @Test
    public void distTo() throws Exception {

        Graph G = new Graph(new In(this.getClass().getResource("tinyG.txt")));
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, 0);
        BreadthFirstPaths2 bfp2 = new BreadthFirstPaths2(G, 0);

        for (int i = 0; i < G.V(); i++) {
            assert (bfp.distTo(i) == bfp2.distTo(i));
        }

    }

    private BreadthFirstPaths getBreadthFirstPaths() {
        if (bfp == null) {
            bfp = new BreadthFirstPaths(new Graph(new In(this.getClass().getResource("tinyGex2.txt"))), 0);
        }
        return bfp;
    }
}