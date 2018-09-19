package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.introcs.StdOut;

/******************************************************************************
 *  Compilation:  javac InsertionX.java
 *  Execution:    java InsertionX < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *  
 *  Sorts a sequence of strings from standard input using an optimized
 *  version of insertion sort that uses half exchanges instead of 
 *  full exchanges to reduce data movement..
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java InsertionX < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java InsertionX < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/
/**
 * The {@code InsertionX} class provides static methods for sorting an array
 * using an optimized version of insertion sort (with half exchanges and a
 * sentinel).
 * <p>
 * For additional documentation, see <a
 * href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */

public class InsertionX {

	// This class should not be instantiated.
	private InsertionX() {
	}

	/**
	 * ʹ����Ȼ˳�������������������顣 Rearranges the array in ascending order, using the
	 * natural order.
	 * 
	 * @param a the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		int n = a.length;

		// put smallest element in position to serve as sentinel
		int exchanges = 0;
		for (int i = n - 1; i > 0; i--) {
			if (less(a[i], a[i - 1])) {
				exch(a, i, i - 1);
				exchanges++;
			}
		}
		if (exchanges == 0)
			return;

		// insertion sort with half-exchanges
		for (int i = 2; i < n; i++) {
			Comparable v = a[i];
			int j = i;
			for (; less(v, a[j - 1]); j--) //ͨ���ڱ������Թ�ܱ߽���j>0
				a[j] = a[j - 1]; // �������
			a[j] = v;
		}

		assert isSorted(a);
	}

	/*��ʹ���ڱ���ܱ߽���
	 * public static void sort(Comparable[] a){
		int N = a.length;
		for (int i = 2; i < N; i++) {
			Comparable t = a[i];
			int j = i;
			for (; j > 0 && less(t, a[j-1]); j--) {
				a[j] = a[j-1]; //�������
			}
			a[j] = t;
		}
	}*/

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
	}

	/**
	 * Reads in a sequence of strings from standard input; insertion sorts them;
	 * and prints them to standard output in ascending order.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		InsertionX.sort(a);
		show(a);

	}

}
