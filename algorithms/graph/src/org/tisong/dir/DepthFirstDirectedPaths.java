package org.tisong.dir;

import java.util.Stack;

/**
 * 单点有向路径
 */
public class DepthFirstDirectedPaths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    private final Digraph G;

    public DepthFirstDirectedPaths(Digraph G, int s) {
        this.s = s;
        this.G = G;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            edgeTo[i] = -1;
        }
        edgeTo[s] = s;
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adjs(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
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
