package exe.Algorithms.basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Exe2_1_24_25 {
	public static void sort(Comparable[] a) {
		
		int exchanges=0;
		// 通过将数组中最小元素移动到最左边，就可以去掉内循环的j>0，边界检测
		for (int i = a.length-1; i >0; i--) {
			if (less(a[i], a[i - 1])) {
				exch(a, i, i - 1);
				exchanges++;
			}
		}
		
		if(exchanges==0)
			return ;
		
		//不使用交换，将较大元素向右移动
		for(int i=2;i<a.length;i++){
			Comparable v=a[i];
			int j=i;
			for(;less(v,a[j-1]);j--)
				a[j]=a[j-1];
			a[j]=v;
		}
		
		assert isSorted(a);
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/
	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***************************************************************************
	 *  print array to standard output
	 ***************************************************************************/
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
	}
	
	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}
}
