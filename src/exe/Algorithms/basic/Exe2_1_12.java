package exe.Algorithms.basic;

import java.util.Random;

import edu.princeton.cs.introcs.StdOut;

public class Exe2_1_12 {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1,4,13...
		while (h >= 1) {
			// 将数组变为h有序
			int CompareTime=0;
			for (int i = h; i < N; i++) {
				for (int j = i; (j >= h && less(a[j], a[j - h]))&(CompareTime++>-1); j -= h) {
					exch(a, j, j - h);
				}
			}
			//System.out.println("h="+h+", CompareTime/size="+((double)CompareTime/(double)N));
			System.out.println("h="+h+", CompareTime/size="+((double)CompareTime/(double)N));
			h = h / 3;
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

	// print array to standard output
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		//String[] a = StdIn.readAllStrings();
		int size=100;
		Random random=new Random();
		for(int i=0;i<5;i++){
			Double[] a=new Double[size];
			//生成数组元素
			for(int j=0;j<size;j++)
				a[j]=random.nextDouble()*100;
			System.out.println("数组大小："+size);
			Exe2_1_12.sort(a);
			size*=10;
		}
	}
}
