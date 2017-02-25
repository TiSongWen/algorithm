package org.tisong.sp;

import org.tisong.stdlib.StdIn;

/**
 * 优先级条件下并行任务调度问题：关键路径算法
 */
public class CPM {

    public static void main(String[] args) {
        int N = StdIn.readInt(); // 任务数
        StdIn.readLine();

        /**
         * v-w表示一个任务(两个顶点表示一个任务);再加上Start起始点与 End结束点
         */
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*N + 2);

        // 开始创建无环加权有向图
        int s = 2 * N, t = 2 * N + 1; // 起点s 与 终点t
        for (int i = 0; i < N; i++) {
            String[] a = StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            // 必备的三条边
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i, i+N, duration));
            G.addEdge(new DirectedEdge(i+N, t, 0.0));
            for (int j = 1; j < a.length; j++) {
                // 增加优先级限制
                G.addEdge(new DirectedEdge(i+N, Integer.parseInt(a[j]), 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);
    }
}
