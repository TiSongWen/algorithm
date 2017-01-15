package org.tisong.dir;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 单点最短有向路径
 */
public class BreadthFirstDirectedPaths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    private final Digraph G;


    public BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        this.G = G;
        for (int i = 0; i < G.V(); i++)  edgeTo[i] = -1;
        bfs(G, s);
    }


    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        edgeTo[s] = s;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adjs(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (v < 0 || v >= G.V()) return null;

        Stack<Integer> stack = new Stack<>();
        for (int w = v; w != s && w != -1; w = edgeTo[w]) {
            stack.push(w);
        }
        return stack;
    }
}
