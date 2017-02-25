package org.tisong.sp;

/**
 * 加权有向图最短路径算法
 */
public class DijkstraSP {

    private final int s;

    private double[] distTo;

    private DirectedEdge[] edgeTo;

    private IndexMinPQ<Double> pq;



    public DijkstraSP (EdgeWeightedDigraph G, int s) {
        this.s = s;

        /**
         * 所以对于最短路径而言，其核心是：不断放松
         */
        while(!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    /**
     * 放松一个边的含义 ：让边(s-w)的距离更短
     * 已知s-v, v-w, s-w, 判断s-w是否能够进行放松 : dist[s-v] + dist[v-w] < dist[s-w], 则s-w的边需要进行放松,得到更短的距离 s-v + v-w;
     * 否则v-w边失效
     * 那么需要放松哪个边呢?
     * @param G
     * @param v
     */
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weigth()) {
                distTo[w] = distTo[v] + e.weigth();
                edgeTo[w] = e;
            }
        }
    }


    /**
     * 顶点s到顶点v的最小距离, 倘若不存在则路径为无穷大
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 判断是否存在从顶点s到顶点v的路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }

    /**
     * 顶点s到顶点v的路径
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        return null;
    }
}



