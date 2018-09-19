package algorithms;

public class BinarySearch {
	public static int search(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid])
				hi = mid;
			else if (key > a[mid])
				lo = mid;
			else
				return mid;
		}
		return -1;
	}
}
