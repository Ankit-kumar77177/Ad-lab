import java.util.*;

public class DijkstraAlgorithm {
	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static void dijkstra(List<List<Edge>> graph, int source) {
		int n = graph.size();
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
		pq.offer(source);
		while (!pq.isEmpty()) {
			int u = pq.poll();
			for (Edge edge : graph.get(u)) {
				int v = edge.to;
				int weight = edge.weight;
				if (dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pq.offer(v);
				}
			}
		}
		System.out.println("Shortest distances from source " + source + ":");
		for (int i = 0; i < n; i++) {
			System.out.println("Vertex " + i + ": " + dist[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of vertices: ");
		int n = scanner.nextInt();
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		System.out.print("Enter the number of edges: ");
		int m = scanner.nextInt();
		System.out.println("Enter the edges (from to weight):");
		for (int i = 0; i < m; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			int weight = scanner.nextInt();
			graph.get(from).add(new Edge(to, weight));
			graph.get(to).add(new Edge(from, weight)); // For undirected graph
		}
		System.out.print("Enter the source vertex: ");
		int source = scanner.nextInt();
		dijkstra(graph, source);
	}
}