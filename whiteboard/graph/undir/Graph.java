public class Graph {

	protected int V;

	protected int E;

	protected List<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public int V() { return V; }

	public int E() { return E; }

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
} 