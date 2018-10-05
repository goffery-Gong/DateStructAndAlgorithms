package exe.Algorithms.quick;

import algorithms.Utils.ArrayUtils;
import algorithms.sort.RandomArray;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdOut;

public class Exe2_3_17 {
	public static void quickSortWithNoSentinels(Comparable[] a) {
		StdRandom.shuffle(a);
		
		int maxIndex = 0;
		for (int i = 1; i < a.length; i++) {
			if (ArrayUtils.less(a[maxIndex], a[i]))
				maxIndex = i;
		}
		
		ArrayUtils.exch(a, maxIndex, a.length - 1);
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if (lo >= hi)
			return;
		int j = partition(a, lo, hi);

		quickSort(a, lo, j - 1);
		quickSort(a, j + 1, hi);
	}


	private static int partition(Comparable[] a, int lo, int hi) {
		Comparable v = a[lo];
		
		int i = lo;
		int j = hi + 1;
		
		
		while (true) {
			while (ArrayUtils.less(a[++i], v));
//				if (i == hi)
//					break;
			while (ArrayUtils.less(v, a[--j])) {
//				if (j == lo)
//					break;
			}
			if (i >= j)
				break;
			ArrayUtils.exch(a, i, j);
		}
		ArrayUtils.exch(a, lo, j);
		return j;
	}


	public static void main(String[] args) {
//		Integer[] a = { 2, 2, 2, 2, 2, 2 };
		Double[] a= RandomArray.randomArray(10);
		quickSortWithNoSentinels(a);
		for (int i = 0; i < a.length; i++)
			StdOut.println(a[i]);
		StdOut.println();
	}
}
