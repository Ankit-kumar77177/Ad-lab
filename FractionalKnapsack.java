import java.util.*;

public class FractionalKnapsack {
	static class Item {
		int weight, value;

		Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
// Input number of items and knapsack capacity
		System.out.print("Enter the number of items: ");
		int n = scanner.nextInt();
		System.out.print("Enter the capacity of knapsack: ");
		int capacity = scanner.nextInt();
		List<Item> items = new ArrayList<>();
// Input weight and value for each item
		System.out.println("Enter the weight and value for each item:");
		for (int i = 0; i < n; i++) {
			System.out.print("Item " + (i + 1) + ": ");
			int weight = scanner.nextInt();
			int value = scanner.nextInt();
			items.add(new Item(weight, value));
		}
// Sort items by value-to-weight ratio in descending order
		items.sort(Comparator.comparingDouble(item -> (double) item.value / item.weight).reversed());
		double maxValue = 0;
// Iterate through items and fill the knapsack
		for (Item item : items) {
			if (capacity <= 0)
				break;
			int weightTaken = Math.min(capacity, item.weight);
			maxValue += weightTaken * ((double) item.value / item.weight);
			capacity -= weightTaken;
		}
// Output the maximum value in the knapsack
		System.out.println("Maximum value in knapsack: " + maxValue);
	}
}