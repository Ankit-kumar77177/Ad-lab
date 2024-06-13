import java.util.*;

 class krushkal {
	private List<Edge> edges = new ArrayList<>();
	private Map<String, String> parent = new HashMap<>();
	private Map<String, Integer> rank = new HashMap<>();

	private static class Edge implements Comparable<Edge> {
		String src, dest;
		int weight;

		Edge(String src, String dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

// Add an edge to the graph
	public void addEdge(String src, String dest, int weight) {
		edges.add(new Edge(src, dest, weight));
		parent.putIfAbsent(src, src);
		parent.putIfAbsent(dest, dest);
		rank.putIfAbsent(src, 0);
		rank.putIfAbsent(dest, 0);
	}

// Find the root of the set containing 'vertex'
	private String find(String vertex) {
		if (!vertex.equals(parent.get(vertex))) {
			parent.put(vertex, find(parent.get(vertex)));
		}
		return parent.get(vertex);
	}

// Union by rank
	private void union(String root1, String root2) {
		if (rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else if (rank.get(root1) < rank.get(root2)) {
			parent.put(root1, root2);
		} else {
			parent.put(root2, root1);
			rank.put(root1, rank.get(root1) + 1);
		}
	}

// Kruskal's algorithm to find MST
	public void kruskalMST() {
		Collections.sort(edges);
		List<Edge> mst = new ArrayList<>();
		int totalWeight = 0;
		for (Edge edge : edges) {
			String root1 = find(edge.src);
			String root2 = find(edge.dest);
			if (!root1.equals(root2)) {
				mst.add(edge);
				union(root1, root2);
				totalWeight += edge.weight;
			}
		}
		System.out.println("Edges in the MST:");
		for (Edge edge : mst) {
			System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
		}
		System.out.println("Total weight of the MST: " + totalWeight);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		krushkal graph = new krushkal();
		System.out.print("Enter the number of edges: ");
		int edgesCount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the edges (format: vertex1 vertex2weight):");
		for (int i = 0; i < edgesCount; i++) {
			String[] edgeData = scanner.nextLine().split(" ");
			graph.addEdge(edgeData[0], edgeData[1], Integer.parseInt(edgeData[2]));
		}
		graph.kruskalMST();
		scanner.close();
	}
}
