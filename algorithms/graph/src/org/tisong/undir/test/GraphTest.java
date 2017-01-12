package org.tisong.undir.test;

import org.tisong.stdlib.In;
import org.tisong.undir.Graph;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/12/17.
 */
public class GraphTest {



    @org.junit.Test
    public void v() throws Exception {
        Graph graph = new Graph(new In(this.getClass().getResource("tinyGex2.txt")));

    }

    @org.junit.Test
    public void e() throws Exception {

    }

    @org.junit.Test
    public void addEdge() throws Exception {

    }

    @org.junit.Test
    public void adj() throws Exception {

    }

    @org.junit.Test
    public void hasEdge() throws Exception {

    }

}