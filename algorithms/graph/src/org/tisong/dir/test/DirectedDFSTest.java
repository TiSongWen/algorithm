package org.tisong.dir.test;

import org.junit.Test;
import org.tisong.dir.Digraph;
import org.tisong.dir.DirectedDFS;
import org.tisong.stdlib.In;
import org.tisong.stdlib.StdOut;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/13/17.
 */
public class DirectedDFSTest {
    @Test
    public void marked() throws Exception {
        Digraph G = new Digraph(new In(this.getClass().getResource("tinyDG.txt")));

        In in = new In();

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(6);
        DirectedDFS reachable = new DirectedDFS(G, list);
        for (int v = 0; v < G.V(); v++)
            if (reachable.marked(v))
                StdOut.println(v + " ");
        StdOut.println();


    }


}