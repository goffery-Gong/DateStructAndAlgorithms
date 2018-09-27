package algorithms.sort;
/**
 * @ClassName: Quick3way 
 * @Description: 三向切分快速排序：对于只有若干个不同主键的随机数组，归并排序的时间复杂度是线性对数，而三项切分快速排序则是线性的
 *
 * @author Goffery Gong
 * @date 2018年9月27日 上午10:30:04
 */
public class Quick3way {
	public static void sort(Comparable[] a) {
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
		a[i] = temp;
	}

}
