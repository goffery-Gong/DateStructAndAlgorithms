package algorithms.sort;

/**
 * @ClassName: MergeBU
 * @Description: �Ե����ϵĹ鲢����
 * https://www.imooc.com/article/21653 
 * @author Goffery Gong
 * @date 2018��9��20�� ����8:52:34
 */
public class MergeBU {
	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[a.length];

		for (int size = 1; size < N; size = size * 2)	//sz�������С
			for (int lo = 0; lo < N - size; lo += size * 2) //lo����������
				merge(a, lo, lo + size - 1, Math.min(lo + 2 * size - 1, N - 1));
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;

		// ���Ƚ����鿽��һ�ݵ�aux[]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		// �ж�aux�е�Ԫ�ش�С���鲢��a[]��
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
		Integer[] a = { 2, 5, 8, 3, 6, 9 ,5};
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);

	}
}
