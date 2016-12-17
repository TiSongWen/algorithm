package org.tisong.undir;

import org.tisong.stdlib.StdIn;
import org.tisong.stdlib.StdOut;

import java.io.IOException;

/**
 * 符号图的经典应用: 间隔的度数
 * 1. 社交网络中寻找两个人之间的关系(即可转化为寻找最短路径问题)
 */
public class DegreeOfSeparation {

    private SymbolGraph sg;

    private BreadthFirstPaths bfs;


    public DegreeOfSeparation(String stream, String sp) throws IOException {
        sg = new SymbolGraph(stream, sp);
    }

    public void findDegree(String start) {
        int index = sg.index(start);

        bfs = new BreadthFirstPaths(sg.G(), index);

        while(!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println("  " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not connected");
                }
            } else {
                StdOut.println("Not in database.");
            }
        }
    }
}
