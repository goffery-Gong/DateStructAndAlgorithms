package algorithms.sort;

import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Merge 
 * @Description: 自顶向下的归并排序(将aux数组建立在merge函数中,每次循环中调用merge都会创建数组，增加内存开销)
 *
 * @author Goffery Gong
 * @date 2018年9月20日 下午4:47:49
 */
public class MergeInside {
	//排序函数
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
		/*for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);*/
		
		double time1 = SortCompare.timeSortedInput("MergeInside", 1000, 100);   // Total for alg1. 
        double time2 = SortCompare.timeSortedInput("Merge", 1000, 100);   // Total for alg2. 
        StdOut.printf("For %d random Doubles\n    %s is", 1000, "Merge"); 
        StdOut.printf(" %.1f times faster than %s\n", time1/time2, "MergeInside");  
	}
}
