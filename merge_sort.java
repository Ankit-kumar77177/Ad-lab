import java.util.Scanner;

public class merge_sort {
	private static void mergeSort(int[] arr, int l, int r) {
		if (l >= r)
			return;
		int m = (l + r) / 2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int[] temp = new int[r - l + 1];
		int i = l, j = m + 1, k = 0;
		while (i <= m && j <= r) {
			temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		}
		while (i <= m)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		System.arraycopy(temp, 0, arr, l, temp.length);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements:");
		for (int i = 0; i < n; i++)
			arr[i] = scanner.nextInt();
		mergeSort(arr, 0, n - 1);
		System.out.println("Sorted array:");
		for (int num : arr)
			System.out.print(num + " ");
	}
}