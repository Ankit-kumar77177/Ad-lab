import java.util.Scanner;

public class counting_inversion {
	private static int mergeAndCount(int[] arr, int l, int m, int r) {
		int[] left = new int[m - l + 1];
		int[] right = new int[r - m];
		System.arraycopy(arr, l, left, 0, left.length);
		System.arraycopy(arr, m + 1, right, 0, right.length);
		int i = 0, j = 0, k = l, swaps = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j])
				arr[k++] = left[i++];
			else {
				arr[k++] = right[j++];
				swaps += left.length - i;
			}
		}
		while (i < left.length)
			arr[k++] = left[i++];
		while (j < right.length)
			arr[k++] = right[j++];
		return swaps;
	}

	private static int mergeSortAndCount(int[] arr, int l, int r) {
		if (l >= r)
			return 0;
		int m = (l + r) / 2;
		return mergeSortAndCount(arr, l, m) + mergeSortAndCount(arr, m + 1, r) + mergeAndCount(arr, l, m, r);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements:");
		for (int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();
		System.out.println("Number of inversions: " + mergeSortAndCount(arr, 0, n - 1));
	}
}
