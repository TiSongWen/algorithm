package org.tisong.dir;

/**
 * 拓扑排序
 */
public class Topological {

    public Iterable<Integer> order;

    public Topological(Digraph G) {
        if (!new DirectedCycle(G).hasCycle())
            order = new DepthFirstOrder(G).reversePost();
    }

    public Iterable<Integer> order() { return order; }

    public boolean isDAG() { return order != null; }
}
