import java.util.*;

public class IntervalScheduling {
// Interval class to store start and end times
	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of intervals: ");
		int n = scanner.nextInt();
		List<Interval> intervals = new ArrayList<>();
		System.out.println("Enter intervals (start end):");
		for (int i = 0; i < n; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			intervals.add(new Interval(start, end));
		}
// Sort intervals by their end times
		intervals.sort(Comparator.comparingInt(i -> i.end));
		List<Interval> selectedIntervals = new ArrayList<>();
		int lastEndTime = -1;
// Select intervals using the Greedy algorithm
		for (Interval interval : intervals) {
			if (interval.start >= lastEndTime) {
				selectedIntervals.add(interval);
				lastEndTime = interval.end;
			}
		}
// Print the selected intervals
		System.out.println("Selected intervals:");
		for (Interval interval : selectedIntervals) {
			System.out.println("[" + interval.start + ", " + interval.end + "]");
		}
	}
}