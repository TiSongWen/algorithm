package org.tisong.undir;

import org.tisong.stdlib.In;
import org.tisong.stdlib.StdOut;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个图的顶点，找出所有连通的点
 */
public class Search {

    private boolean[] marked;

    private int count; // 连通的总数

    private List<Integer> adjs; // 连通的结点


    public Search(Graph G, int s) {
        marked = new boolean[G.V()];
        adjs = new LinkedList<>();
        adjs.add(s);
        marked[s] = true;

        for (int v : G.adj(s)) {
            search(G, v);
        }
    }

    public Search() {}

    private void search(Graph G, int v) {
        if (marked[v]) return ;
        count++;
        adjs.add(v);
        marked[v] = true;
        for (int e : G.adj(v)) {
            search(G, e);
        }
    }

    public List<Integer> connected() {
        return adjs;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(new Search().getClass().getResource("tinyG.txt")));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);

        for (int v : search.connected()) {
            StdOut.print(v + " ");
        }
        StdOut.println();
    }



}
