package exe.Algorithms.Merge;

import algorithms.sort.RandomArray;

/**
 * 快速归并
 * 
 * @ClassName: Exe2_2_10
 * @Description: TODO
 *
 * @author Goffery Gong
 * @date 2018年9月22日 下午10:13:53
 */
public class Exe2_2_10 {
	public static <T> void fastMergeSort(Comparable<T>[] a) {
		Comparable<T>[] aux = new Comparable[a.length];
		fastMergeShort(a, aux, 0, a.length - 1);
	}

	private static void fastMergeShort(Comparable[] a, Comparable[] aux,
			int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		fastMergeShort(a, aux, lo, mid);
		fastMergeShort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo,
			int mid, int hi) {
		for (int i = lo; i <= mid; i++)
			aux[i] = a[i];
		for (int j = mid + 1; j <= hi; j++)
			aux[j] = a[hi - j + mid + 1];

		int i = lo;
		int j = hi;
		for (int k = lo; k <= hi; k++)
			if (less(aux[j], aux[i]))
				a[k] = aux[j--];
			else
				a[k] = aux[i++];
	}

	private static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		//Integer[] a = { 2, 5, 8, 3, 6, 9 };
		Double[] a = RandomArray.randomArray(10);
		fastMergeSort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		/*
		 * double time1 = SortCompare.timeSortedInput("MergeInside", 1000, 100);
		 * // Total for alg1. double time2 =
		 * SortCompare.timeSortedInput("Merge", 1000, 100); // Total for alg2.
		 * StdOut.printf("For %d random Doubles\n    %s is", 1000, "Merge");
		 * StdOut.printf(" %.1f times faster than %s\n", time1/time2,
		 * "MergeInside");
		 */
	}
}
