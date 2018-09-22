package exe.Algorithms.Merge;

public class Exe2_2_5 {
	public static void topDownSort(Comparable[] a) {
		topDownSort(0, a.length - 1);
	}

	private static void topDownSort(int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = (lo + hi) / 2;
		topDownSort(lo, mid);
		topDownSort(mid + 1, hi);
		merge(lo, mid, hi);
	}

	public static void buttomUpSort(Comparable[] a) {
		int N = a.length;
		for (int size = 1; size < N; size *= 2)
			for (int lo = 0; lo < N - size; lo += 2 * size)
				merge(lo, lo + size - 1, Math.min(lo + 2 * size - 1, N - 1));
	}

	private static void merge(int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		System.out.print(hi - lo + 1);
		System.out.print(" ");
	}

	public static void main(String[] args) {
		String[] a = new String[39];
		Exe2_2_5.topDownSort(a);
		System.out.println();
		Exe2_2_5.buttomUpSort(a);
	}
}
