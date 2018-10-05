package algorithms.sort;



/**
 * array using Insertion sort.
 * @author PC
 * ƽ���Ƚϴ�����N*N/4��ƽ������������N*N/4.���N*N/2�αȽϣ�N*N/2�ν�������ã�N-1�αȽϣ�0�ν���
 * ���������ظ�
 * ����������ڲ��������������Ч��
 * ��߲�������ķ���������ѭ���н��ϴ��Ԫ�ض������ƶ��������ǽ�������Ԫ�أ�InsertionX
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
	
	/**
     * Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint (inclusive)
     * @param hi right endpoint (exclusive)
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        assert isSorted(a, lo, hi);
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
	
	//is the array a[lo..hi) sorted
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
