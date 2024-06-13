import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
	char data;
	int frequency;
	HuffmanNode left, right;

	HuffmanNode(char data, int frequency) {
		this.data = data;
		this.frequency = frequency;
		left = right = null;
	}

	public int compareTo(HuffmanNode node) {
		return this.frequency - node.frequency;
	}
}

public class HuffmanCoding {
	static void printCodes(HuffmanNode root, String code) {
		if (root == null)
			return;
		if (root.data != '\0') {
			System.out.println(root.data + ": " + code);
		}
		printCodes(root.left, code + "0");
		printCodes(root.right, code + "1");
	}

	static void huffmanCodes(char[] chars, int[] frequencies) {
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
		for (int i = 0; i < chars.length; i++) {
			pq.offer(new HuffmanNode(chars[i], frequencies[i]));
		}
		while (pq.size() > 1) {
			HuffmanNode left = pq.poll();
			HuffmanNode right = pq.poll();
			HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
			newNode.left = left;
			newNode.right = right;
			pq.offer(newNode);
		}
		HuffmanNode root = pq.poll();
		System.out.println("Huffman Codes:");
		printCodes(root, "");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of characters: ");
		int n = scanner.nextInt();
		char[] chars = new char[n];
		int[] frequencies = new int[n];
		System.out.println("Enter the characters and their frequencies:");
		for (int i = 0; i < n; i++) {
			chars[i] = scanner.next().charAt(0);
			frequencies[i] = scanner.nextInt();
		}
		huffmanCodes(chars, frequencies);
	}
}