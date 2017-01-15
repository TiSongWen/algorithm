package org.tisong.dir;


/**
 * 有向图中的可达性(DFS深度遍历)
 */
public class DirectedDFS {

    private boolean marked[];

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }


    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s])
                dfs(G, s);
        }
    }


    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adjs(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    /**
     * 判断v点是否可达到s点
     * @param v
     * @return
     */
    public boolean marked(int v) {
        if (v < 0 || v >= marked.length) return false;
        return marked[v];
    }

}
