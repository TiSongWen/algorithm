package org.tisong.undir;

/**
 * 连通分量(基于深度优先遍历)
 */
public class CC {

    private boolean[] marked;

    /**
     * 每个顶点对应的连通分量号
     */
    private int[] id;

    /**
     * 连通分量数
     */
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        // 从第一个顶点开始遍历
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }


    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * 判断两个顶点是否连通
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 返回顶点v所属第几个连通
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * 返回图中的连通数
     */
    public int count() {
        return count;
    }
}
