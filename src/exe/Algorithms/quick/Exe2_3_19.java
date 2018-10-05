package exe.Algorithms.quick;

import algorithms.Utils.ArrayUtils;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @ClassName: Exe2_3_19
 * @Description: 5ȡ���з�
 *
 * @author Goffery Gong
 * @date 2018��10��5�� ����5:07:51
 */
public class Exe2_3_19 {
	public static void QuickSortMedian5(Comparable[] a) {
		StdRandom.shuffle(a);
		QuickSortMedian5(a, 0, a.length - 1);
	}

	@SuppressWarnings("unchecked")
	private static void QuickSortMedian5(Comparable[] a, int lo, int hi) {
		// ��Խ��
		if (lo >= hi)
			return;

		// С��5��������ò�������:������a��lo~hi��������
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

		// ����Ϊ a b c d e �������
		// ���ȶ� b c ����
		if (ArrayUtils.less(a[lo + 2], a[lo + 1]))
			ArrayUtils.exch(a, lo + 2, lo + 1);
		// Ȼ�������� d e
		if (ArrayUtils.less(a[lo + 4], a[lo + 3]))
			ArrayUtils.exch(a, lo + 4, lo + 3);

		// ��ʱ���� b < c, d < e
		// �Ƚ� b d���ѽ�С��һ��ŵ� b c ��λ����ȥ
		if (ArrayUtils.less(a[lo + 3], a[lo + 1])) {
			ArrayUtils.exch(a, lo + 1, lo + 3);
			ArrayUtils.exch(a, lo + 2, lo + 4);
		}

		// ��ʱ���� b < c, b < d < e���� b �� b c d e �е���Сֵ
		// ���� a �� b
		ArrayUtils.exch(a, lo, lo + 1);

		// �������� b c
		if (ArrayUtils.less(a[lo + 2], a[lo + 1]))
			ArrayUtils.exch(a, lo + 2, lo + 1);

		// ��ʱ�ٴ����� b < c, d < e
		// �Ƚ� b d������С��һ��ŵ� b c ��λ����ȥ
		if (ArrayUtils.less(a[lo + 3], a[lo + 1])) {
			ArrayUtils.exch(a, lo + 1, lo + 3);
			ArrayUtils.exch(a, lo + 2, lo + 4);
		}

		// ��ʱ a �� b Ϊ������е���Сֵ�ʹ�Сֵ��˳�򲻹̶���a Ҳ�����Ǵ�Сֵ��
		// ���Ƚ� c �� d����С����һ����Ϊ��λ����������С������
		if (ArrayUtils.less(a[lo + 3], a[lo + 2]))
			ArrayUtils.exch(a, lo + 3, lo + 2);

		// ��ʱ c ��Ϊ��λ��
		ArrayUtils.exch(a, lo, lo + 2);

		// d e �ŵ�����ĩβ�䵱�ڱ�
		ArrayUtils.exch(a, lo + 3, hi);
		ArrayUtils.exch(a, lo + 4, hi - 1);

		// ����ָ��λ�ã�ǰ��λ�ͺ���λ���Ѿ��ں���λ����
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
