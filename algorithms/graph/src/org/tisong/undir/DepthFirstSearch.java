package org.tisong.undir;

/**
 * 深度优先搜索
 * 版本一:
 * 1. 基于一个点，搜索给定的另一个点是否与之连通
 * 2. 判断该图是否连通
 */
public class DepthFirstSearch {

    /**
     * 标记其他顶点与起点s是否相连通
     */
    private boolean[] markded;

    /**
     * 与起点相连通的顶点数
     */
    private int count;

    /**
     * 找到G图中和s起点相连通的所有顶点
     */
    public DepthFirstSearch(Graph G, int s) {
        markded = new boolean[G.E()];
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

    /**
     * 获取图中与起点连通的顶点数
     * @return 顶点数
     */
    public int count() {
        return count;
    }
}
