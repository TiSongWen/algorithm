public class DirectedCycle {

	private boolean[] marked;

	private boolean[] onStack;

	private int[] edgeTo;
	
	/**
	 * 保存环
	 */ 
	private Stack<Integer> stack;

	private boolean hasCycle;

	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		stack = new Stack<>();
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
			}
		}
	}

	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v]  = true;

		for (int w : G.adj(v)) {
			if (hasCycle) return ;

			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if (onStack[w]){
				hasCycle = true;
				for (int x = v; x != w; x = edgeTo[x]) {
					stack.push(x);
				}
				stack.push(w);
				stack.push(v);
			}
		}
		onStack[v] = false;
	}
}