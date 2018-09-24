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
		//将前一半元素放到aux中
		for (int i = lo; i <= mid; i++)
			aux[i] = a[i];
		//将后一半元素降序放到aux中
		for (int j = mid + 1; j <= hi; j++)
			aux[j] = a[hi - j + mid + 1];

		int i = lo;
		int j = hi;
		//经过上面操作，右边j--，左边i++,就不需要mid作为分割进行遍历aux数组了
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
		Integer[] a = {  5, 2, 6, 8, 7, 6 ,9,10 };
		//Double[] a = RandomArray.randomArray(10);
		fastMergeSort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
