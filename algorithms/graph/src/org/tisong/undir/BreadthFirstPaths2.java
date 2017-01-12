package org.tisong.undir;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tisong on 1/12/17.
 */
public class BreadthFirstPaths2 {

    /**
     * 默认为-1,而非0
     */
    private int[] edgeTo;

    private boolean[] marked;

    /**
     * 每个顶点到起点的最小距离, MAX_VALUE则表示不可达到
     */
    private int[] minDist;
    /**
     * 起点
     */
    private final int s;

    public BreadthFirstPaths2(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        minDist = new int[G.V()];
        for(int i = 0; i < G.V(); i++) {
            edgeTo[i] = -1;
        }
        for (int i = 0; i < G.V(); i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        bfs(G, s);

        for (int i = 0; i < G.V(); i++) {
            int dist = 0;
            for (int j = i; j != s && edgeTo[j] != -1; j = edgeTo[j]) {
                dist++;
            }
            if (dist != 0)  minDist[i] = dist;
        }
        //minDist[s] = 0;
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

    /**
     * 顶点v 到起点s的最短距离
     * @param v
     * @return
     */
    public int distTo(int v) {
        return minDist[v];
    }
}
