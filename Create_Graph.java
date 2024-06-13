import java.util.*;

public class Create_Graph {
	private Map<String, List<String>> adjacencyList = new HashMap<>();

// Add an edge to the graph
	public void addEdge(String vertex1, String vertex2) {
		adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
		adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1); // For undirected graph
	}

// Print the graph
	public void printGraph() {
		adjacencyList.forEach((vertex, neighbors) -> System.out.println(vertex + ": " + neighbors));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Create_Graph graph = new Create_Graph();
// Getting number of edges
		System.out.print("Enter the number of edges: ");
		int edgesCount = scanner.nextInt();
		scanner.nextLine(); // consume newline
// Getting edges from the user
		System.out.println("Enter the edges (format: vertex1 vertex2):");
		for (int i = 0; i < edgesCount; i++) {
			String[] vertices = scanner.nextLine().split(" ");
			graph.addEdge(vertices[0], vertices[1]);
		}
// Print the graph
		System.out.println("Graph:");
		graph.printGraph();
		scanner.close();
	}
}