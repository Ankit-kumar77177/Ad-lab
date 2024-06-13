import java.util.*;

public class prims {
	private Map<String, List<Edge>> adjList = new HashMap<>();

	private static class Edge {
		String vertex;
		int weight;

		Edge(String vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

// Add an edge to the graph
	public void addEdge(String src, String dest, int weight) {
		adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(new Edge(dest, weight));
		adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Edge(src, weight));
	}

// Prim's algorithm to find MST
	public void primMST(String start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		Set<String> visited = new HashSet<>();
		int totalWeight = 0;
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited.add(edge.vertex)) {
				totalWeight += edge.weight;
				System.out.println("Edge included: " + edge.vertex + " with weight: " + edge.weight);
				for (Edge neighbor : adjList.getOrDefault(edge.vertex, Collections.emptyList())) {
					if (!visited.contains(neighbor.vertex)) {
						pq.add(new Edge(neighbor.vertex, neighbor.weight));
					}
				}
			}
		}
		System.out.println("Total weight of the MST: " + totalWeight);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		prims graph = new prims();
		System.out.print("Enter the number of edges: ");
		int edgesCount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the edges (format: vertex1 vertex2weight):");
		for (int i = 0; i < edgesCount; i++) {
			String[] edgeData = scanner.nextLine().split(" ");
			graph.addEdge(edgeData[0], edgeData[1], Integer.parseInt(edgeData[2]));
		}
		System.out.print("Enter the starting vertex for Prim's algorithm: ");
		String startVertex = scanner.nextLine();
		System.out.println("Prim's MST starting from vertex " + startVertex + ":");
		graph.primMST(startVertex);
		scanner.close();
	}
}