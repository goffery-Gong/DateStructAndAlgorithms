package algorithms.sort;

/**
 * @ClassName: Merge 
 * @Description: 归并排序
 *
 * @author Goffery Gong
 * @date 2018年9月20日 下午4:47:49
 */
public class Merge {
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	//递归调用sort
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);		//将左半边排序
		sort(a, mid + 1, hi);	//将右半边排序
		merge(a, lo, mid, hi);	//归并结果
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		Comparable[] aux = new Comparable[a.length];

		//首先将数组拷贝一份到aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		//判断aux中的元素大小，归并到a[]中
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		Integer[] a = { 2, 5, 8, 3, 6, 9 };
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}
}
