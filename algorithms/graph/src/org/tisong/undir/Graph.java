package org.tisong.undir;

import org.tisong.stdlib.In;

import java.net.URL;
import java.util.*;

/**
 * 无向图API设计，基于邻接链表 数组 + 链表的实现方式
 */
public class Graph {

    /**
     * 顶点数, 当图创建之后不可更改
     */
    private final int V;

    /**
     * 图的边数
     */
    private int E;

    /**
     * 每个顶点的邻接表
     */
    private Set<Integer>[] adj;


    /**
     * 构造一个顶点数为V的图(并未添加边和顶点)
     */
    public Graph(int V) {

        this.V = V;
        E = 0;
        adj = new Set[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedHashSet<>();
        }
    }

    /**
     * 从输入流中获取顶点和边
     */
    public Graph(In in) {

        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    /**
     * 获取顶点数
     * @return 顶点数
     */
    public int V() {
        return this.V;
    }

    /**
     * 获取边数
     * @return 边数
     */
    public int E() {
        return this.E;
    }

    /**
     * 向图中添加一条边
     * @param v 顶点
     * @param w 顶点
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 查找和v顶点相邻的顶点
     * @param v 顶点
     * @return 顶点v的邻接表
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    /**
     * 是否存在边 v-w
     * @param v 顶点v
     * @param w 顶点w
     * @return true-存在; false-不存在
     */
    public boolean hasEdge(int v, int w) {
        if (v >= V || w >= V) return false;

        for (int s : adj[v]) {
            if (s == w) {
                return true;
            }
        }
        return false;
    }


    public String toString() {
        return null;
    }
}
