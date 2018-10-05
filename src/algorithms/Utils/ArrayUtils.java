package algorithms.Utils;

@SuppressWarnings("unchecked")
public class ArrayUtils {
	/**
	 * ����
	 * @param a
	 * @param i
	 * @param j
	 */
	public static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	/**
	 * �Ƚ�������<����true��>=����false
	 * @param v
	 * @param k
	 * @return
	 */
	public static boolean less(Comparable v, Comparable k) {
		return v.compareTo(k)<0;
	}
	
	/**
	 * �Ƿ�������
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
}
