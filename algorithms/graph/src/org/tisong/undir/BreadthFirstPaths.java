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

    /**
     * 每个顶点到起点的最小距离, MAX_VALUE则表示不可达到
     */
    private int[] minDist;
    /**
     * 起点
     */
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo  = new int[G.V()];
        minDist = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[s] = 0;
        bfs(G, s);

        for (int i = 0; i < G.V(); i++) {
            int dist = 0;
            for (int j = i; j != s; j = edgeTo[j]) {
                dist++;
            }
            minDist[i] = dist;
        }
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
