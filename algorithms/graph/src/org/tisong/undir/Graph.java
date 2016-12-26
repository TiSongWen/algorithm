package org.tisong.undir;

import org.tisong.stdlib.In;

import java.util.ArrayList;
import java.util.List;

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
    private List<Integer>[] adj;


    /**
     * 构造一个顶点数为V的图(并未添加边和顶点)
     */
    public Graph(int V) {
        this.V = V;
        E = 0;
        adj = new List[V];
        for (List l: adj) {
            l = new ArrayList();
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
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 查找和v顶点相邻的顶点
     * @param v 顶点
     * @return 顶点v的邻接表
     */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
