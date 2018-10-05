package algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Quick3way 
 * @Description: 
 * 三向切分快速排序：对于只有若干个不同主键的随机数组，归并排序的时间复杂度是线性对数，而三项切分快速排序则是线性的
 * 			   ~(2ln2)NH次比较;H为香浓信息量
 * 三向切分的最坏情况就是主键值均不同时：H=lgN；
 * @author Goffery Gong
 * @date 2018年9月27日 上午10:30:04
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
		}//a[lo,lt-1]<v=a[lt,gt]<a[gt+1，hi]成立
		
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
