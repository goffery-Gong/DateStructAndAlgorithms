package exe.Algorithms.quick;

import algorithms.Utils.ArrayUtils;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Exe2_3_19
 * @Description: 5取样切分
 *
 * @author Goffery Gong
 * @date 2018年10月5日 下午5:07:51
 */
public class Exe2_3_19 {
	public static void QuickSortMedian5(Comparable[] a) {
		StdRandom.shuffle(a);
		QuickSortMedian5(a, 0, a.length - 1);
	}

	@SuppressWarnings("unchecked")
	private static void QuickSortMedian5(Comparable[] a, int lo, int hi) {
		// 别越界
		if (lo >= hi)
			return;

		// 小于5的数组采用插入排序:将数组a的lo~hi进行排序
		if (hi + 1 < lo + 5) {
			for (int i = lo; i <= hi; i++)
				for (int j = i; j > lo && ArrayUtils.less(a[j], a[j - 1]); j--)
					ArrayUtils.exch(a, j, j - 1);
			return;
		}

		int j = partition(a, lo, hi);
		QuickSortMedian5(a, lo, j - 1);
		QuickSortMedian5(a, j + 1, hi);
	}

	@SuppressWarnings("unchecked")
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;

		// 假设为 a b c d e 五个数字
		// 首先对 b c 排序
		if (ArrayUtils.less(a[lo + 2], a[lo + 1]))
			ArrayUtils.exch(a, lo + 2, lo + 1);
		// 然后再排序 d e
		if (ArrayUtils.less(a[lo + 4], a[lo + 3]))
			ArrayUtils.exch(a, lo + 4, lo + 3);

		// 这时满足 b < c, d < e
		// 比较 b d，把较小的一组放到 b c 的位置上去
		if (ArrayUtils.less(a[lo + 3], a[lo + 1])) {
			ArrayUtils.exch(a, lo + 1, lo + 3);
			ArrayUtils.exch(a, lo + 2, lo + 4);
		}

		// 这时满足 b < c, b < d < e，即 b 是 b c d e 中的最小值
		// 交换 a 和 b
		ArrayUtils.exch(a, lo, lo + 1);

		// 重新排序 b c
		if (ArrayUtils.less(a[lo + 2], a[lo + 1]))
			ArrayUtils.exch(a, lo + 2, lo + 1);

		// 这时再次满足 b < c, d < e
		// 比较 b d，把最小的一组放到 b c 的位置上去
		if (ArrayUtils.less(a[lo + 3], a[lo + 1])) {
			ArrayUtils.exch(a, lo + 1, lo + 3);
			ArrayUtils.exch(a, lo + 2, lo + 4);
		}

		// 这时 a 和 b 为五个数中的最小值和次小值（顺序不固定，a 也可以是次小值）
		// 最后比较 c 和 d，较小的那一个即为中位数（即第三小的数）
		if (ArrayUtils.less(a[lo + 3], a[lo + 2]))
			ArrayUtils.exch(a, lo + 3, lo + 2);

		// 此时 c 即为中位数
		ArrayUtils.exch(a, lo, lo + 2);

		// d e 放到数组末尾充当哨兵
		ArrayUtils.exch(a, lo + 3, hi);
		ArrayUtils.exch(a, lo + 4, hi - 1);

		// 调整指针位置，前两位和后两位都已经在合适位置了
		j -= 2;
		i += 2;

		Comparable v = a[lo];
		while (true) {
			while (ArrayUtils.less(a[++i], v))
				;
			while (ArrayUtils.less(v, a[--j]))
				;
			if (i >= j)
				break;
			ArrayUtils.exch(a, i, j);
		}
		ArrayUtils.exch(a, lo, j);
		return j;
	}
}
