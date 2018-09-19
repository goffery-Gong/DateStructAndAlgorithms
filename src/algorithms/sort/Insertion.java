package algorithms.sort;

import std.StdDraw;

/**
 * array using Insertion sort.
 * @author PC
 * 平均比较次数：N*N/4；平均交换次数：N*N/4.最坏：N*N/2次比较；N*N/2次交换；最好：N-1次比较，0次交换
 * 主键不能重复
 * 插入排序对于部分有序数组很有效。
 * 提高插入排序的方法：在内循环中将较大的元素都向右移动而不总是交换两个元素；InsertionX
 */
public class Insertion {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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
	
}
