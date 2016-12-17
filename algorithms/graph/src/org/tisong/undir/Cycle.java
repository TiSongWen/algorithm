package org.tisong.undir;

/**
 * 检测图中是否存在环(基于深度优先遍历)
 */
public class Cycle {

    private boolean[] marked;

    /**
     * 是否有环
     */
    private boolean hasCycle;


    public Cycle(Graph G) {
        marked = new boolean[G.V()];
        hasCycle = false;
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param G
     * @param v
     * @param p 上一个顶点
     */
    private void dfs(Graph G, int v, int p) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != p){
                // 判断是否存在环的关键条件: 该marked[w]项已标记, 且w不是上一个顶点p
                // 要跳过 0 —— 1 4 7 9; 4 - 0 2 8 中 0 - 4 与 4 - 0 的情况
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
