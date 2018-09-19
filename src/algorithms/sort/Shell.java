package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * ϣ������
 * 
 * @author PC
 *
 */
public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		
		while (h < N / 3)
			h = 3 * h + 1; // 1,4,13...
		while (h >= 1) {
			// �������Ϊh����
			int compareTime=0;
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h])&(compareTime++>-1); j -= h) {
					exch(a, j, j - h);
				}
			}
			System.out.println("h="+h+"ʱ���Ƚϴ���Ϊ��"+compareTime);
			h = h / 3;
		}
		
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Shell.sort(a);
		show(a);
	}
}
