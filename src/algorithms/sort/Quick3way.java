package algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Quick3way 
 * @Description: 
 * �����зֿ������򣺶���ֻ�����ɸ���ͬ������������飬�鲢�����ʱ�临�Ӷ������Զ������������зֿ��������������Ե�
 * 			   ~(2ln2)NH�αȽ�;HΪ��Ũ��Ϣ��
 * �����зֵ�������������ֵ����ͬʱ��H=lgN��
 * @author Goffery Gong
 * @date 2018��9��27�� ����10:30:04
 */
public class Quick3way {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	@SuppressWarnings("unchecked")
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		Comparable v = a[lt];
		
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0)
				exch(a, i++, lt++);
			else if (cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}//a[lo,lt-1]<v=a[lt,gt]<a[gt+1��hi]����
		
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

	private static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] a={2,1,2,1,2,1,2,2,1};
		sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i]);
        StdOut.println();
	}
}
