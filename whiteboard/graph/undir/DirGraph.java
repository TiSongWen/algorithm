public class DirGraph extends Graph{

	public DirGraph(int V) {
		super(V);
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}


}