import java.util.*;

public class BFS {
	private Map<String, List<String>> adjList = new HashMap<>();

// Add an edge to the graph
	public void addEdge(String v1, String v2) {
		adjList.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
		adjList.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
	}

// Breadth-First Search (BFS) implementation
	public void bfs(String start) {
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		visited.add(start);
		queue.add(start);
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			System.out.print(vertex + " ");
			for (String neighbor : adjList.get(vertex)) {
				if (visited.add(neighbor)) {
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BFS graph = new BFS();
		System.out.print("Enter number of edges: ");
		int edgesCount = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter edges (format: vertex1 vertex2):");
		for (int i = 0; i < edgesCount; i++) {
			String[] vertices = scanner.nextLine().split(" ");
			graph.addEdge(vertices[0], vertices[1]);
		}
		System.out.print("Enter starting vertex for BFS: ");
		String startVertex = scanner.nextLine();
		System.out.println("BFS traversal starting from vertex " + startVertex + ":");
		graph.bfs(startVertex);
		scanner.close();
	}
}