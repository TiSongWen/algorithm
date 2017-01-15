package org.tisong.dir;

import java.util.Stack;

/**
 * 寻找有向环
 */
public class DirectedCycle {
    private boolean hasCycle;

    private boolean[] marked;

    private boolean[] onStack;

    private int[] edgeTo;

    private Stack<Integer> stack;

    public DirectedCycle(Digraph G) {
        hasCycle = false;
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++)
            if (!marked[i])
                dfs(G, i);
    }


    private void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (int w : G.adjs(v)) {
            if (hasCycle) return ;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]){
                // 已经形成一个环
                hasCycle = true;
                stack = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    stack.push(x);
                stack.push(w);
                stack.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    /**
     * 环的顶点
     * @return
     */
    public Iterable<Integer> cycle() {
        return stack;
    }
}
