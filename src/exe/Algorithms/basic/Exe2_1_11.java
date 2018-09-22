package exe.Algorithms.basic;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.introcs.StdOut;
/**
 * ����������h��ŵ�������
 * @author PC
 *
 */
public class Exe2_1_11 {
	//������
	public static void sort(Comparable[] a) {
		int N = a.length;
		int[] htemp = new int[4];
		int h = 1;

		int size;
		htemp[0]=1;
		// ����h�������в���������
		for (size = 1; h < N / 3; size++) {
			// ���鲻����Ҫ�ӳ�һ��
			if (size > htemp.length) {
				int[] expand = new int[htemp.length * 2];
				for (int j = 0; j < htemp.length; j++)
					expand[j] = htemp[j];
				htemp = expand;
			}
			
			h = h * 3 + 1;
			htemp[size] = h;
		}

		// ����
		for (int t = size - 1; t >= 0; t--) {
			for (int i = htemp[t]; i < N; i++) {
				for (int j = i; j >= htemp[t] && less(a[j], a[j - htemp[t]]); j -= htemp[t])
					exch(a, j, j - htemp[t]);
			}
		}

		System.out.println(isSorted(a));
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

	// �Ƿ��Ѿ�����
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}
}
