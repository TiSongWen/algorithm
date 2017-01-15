package org.tisong.dir.test;

import org.junit.Test;
import org.tisong.dir.Digraph;
import org.tisong.stdlib.In;

import static org.junit.Assert.*;

/**
 * Created by tisong on 1/13/17.
 */
public class DepthFirstDirectedPathsTest {
    @Test
    public void pathTo() throws Exception {
        Digraph G = new Digraph(new In(this.getClass().getResource("tinyDG.txt")));
    }

}