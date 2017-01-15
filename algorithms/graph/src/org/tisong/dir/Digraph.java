package org.tisong.dir;

import org.tisong.stdlib.In;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tisong on 1/13/17.
 */
public class Digraph {

    private final int v; // 顶点数

    private int e; //边数

    private List<Integer>[] adjs;


    public Digraph(int v) {
        this.v = v;
        this.e = 0;
        adjs = new List[v];
        for (int i = 0; i < v; i++)  adjs[i] = new LinkedList<>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        if (v < 0 || v >= this.v)  return ;

        adjs[v].add(w);
        e++;
    }

    /**
     * @return 反向图
     */
    public Digraph reverse() {
        Digraph digraph = new Digraph(v);
        for (int i = 0; i < v; i++) {
            for (Integer adj : adjs[i]) {
                digraph.addEdge(adj, i);
            }
        }
        return digraph;
    }

    public String toString() {
        return "该方法暂未重写";
    }

    public int V() { return v; }

    public int E() { return e; }


    /**
     * TODO: Iterable 与 Iterator的区别
     * @param v
     * @return
     */
    public Iterable<Integer> adjs(int v) {
        return adjs[v];
    }

}
