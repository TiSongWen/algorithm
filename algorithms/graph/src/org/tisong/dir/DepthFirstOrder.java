package org.tisong.dir;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tisong on 1/13/17.
 */
public class DepthFirstOrder {

    private boolean[] marked;

    private Queue<Integer> pre;

    private Queue<Integer> post;

    private Stack<Integer> reversePost;


    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre  = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        dfs(G, 0);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre.add(v);
        for (int w : G.adjs(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() { return pre; }

    public Iterable<Integer> post() { return post; }

    public Iterable<Integer> reversePost() { return reversePost; }

}
