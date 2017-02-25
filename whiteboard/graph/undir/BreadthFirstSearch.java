public class BreadthFirstSearch {

	private boolean[] marked;

	private int[] edgeTo;


	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<>;

		queue.add(s);
		marked[s] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					queue.add(w);
					edgeTo[w] = v;
					marked[w] = true;
				}
			}
		}
	}
}