package org.tisong.undir;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先搜索 (使用队列进行搜索辅助)
 * 应用: 最短路径
 */
public class BreadthFirstPaths {

    private int[] edgeTo;

    private boolean[] marked;

    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }


    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> paths = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            paths.push(x);
        }
        paths.push(s);
        return paths;
    }
}
