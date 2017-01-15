package org.tisong.mst;

/**
 * 最小生成树API
 */
public interface MST {

    /**
     * 最小生成树的所有边
     */
    public Iterable<Edge> edges();

    /**
     * 最小生成树的权重
     */
    public double weight();
}
