package org.tisong.dir.test;

import org.junit.Test;
import org.tisong.dir.Digraph;
import org.tisong.stdlib.In;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/13/17.
 */
public class DigraphTest {


    @Test
    public void addEdge() throws Exception {

    }

    @Test
    public void reverse() throws Exception {
        Digraph digraph = getDigraph();

        digraph.reverse();
    }


    @Test
    public void v() throws Exception {

    }

    @Test
    public void e() throws Exception {

    }

    @Test
    public void adjs() throws Exception {



    }


    private Digraph getDigraph() {
        return new Digraph(new In(this.getClass().getResource("tinyG.txt")));
    }
}