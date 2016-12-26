package org.tisong.undir;

import java.util.Stack;

/**
 * 深度优先搜索
 * 缺点：对于非连通图无法遍历所有顶点
 * 版本一:
 * 1. 基于一个点，搜索给定的另一个点是否与之连通
 * 2. 判断该图是否连通
 * 版本二：寻找路径
 * 1. 是否存在s到v的路径
 * 2. 获取s到v的路径
 * <strong>总结：</strong>
 * 深度优先搜索中路径的查找是和 Stack 一起配合，深度优先搜索就像一个人在走迷宫，而广度优先搜索则
 * 像一群人在走迷宫，当两个探索者相遇的是和，两个人便合二为一（并不只是表明同时汇合，可以一前一后）
 *  并继续使用先达到者的绳子
 */
public class DepthFirstSearch {

    /**
     * 标记其他顶点与起点s是否相连通
     */
    private boolean[] markded;

    /**
     * 从起点到一个顶点的路径标记
     * v, w有一条路径 ： edgeTo[w] = v; 是逆序存放
     */
    private int[] edgeTo;

    /**
     * 与起点相连通的顶点数
     */
    private int count;

    /**
     * 起点s
     */
    private final int s;

    /**
     * 找到G图中和s起点相连通的所有顶点
     */
    public DepthFirstSearch(Graph G, int s) {
        markded = new boolean[G.E()];
        edgeTo = new int[G.E()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * dfs 递归遍历
     */
    private void dfs(Graph G, int v) {
        markded[v] = true;
        count++;
        for (int w: G.adj(v)) {
            if (!markded[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断顶点v与起点s是否连通
     * @param v 顶点v
     * @return 连通 true; 否则 false;
     */
    public boolean marked(int v) {
        return markded[v];
    }


    public boolean hasPathTo(int v) {
        return markded[v];
    }

    /**
     * 获取起点到顶点v的路径, 若路径不存在, 返回 null
     * @param v 顶点v
     * @return 获取起点到顶点v的路径
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))  return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    /**
     * 获取图中与起点连通的顶点数
     * @return 顶点数
     */
    public int count() {
        return count;
    }
}
