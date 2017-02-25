public class DepthFirstSearch {

	private boolean[] marked;

	/**
	 * 用于路径寻找
	 */
	private int[] edgeTo;

	private final int s;

	private void dfs(Graph G, int v) {
		marked[v] = true;

		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	/**
	 * 基于深度优先遍历的路径搜索问题
	 */ 
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;

		Stack<Integer> stack = new Stack<>();
		for (int w = v; w != s; w = edge[w]) {
			stack.push(w);
		}
		stack.push(w);
		return stack;
	}
}