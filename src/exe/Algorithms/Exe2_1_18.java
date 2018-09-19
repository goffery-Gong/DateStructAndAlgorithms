package exe.Algorithms;

import java.awt.Font;

import std.StdDraw;

public class Exe2_1_18 {
	
	//画图总程序
	private static void paintTrace(String[] a) {
		int n=a.length;
		
		// set canvas size
        StdDraw.setCanvasSize(30*(n+3), 30*(n+3));
        StdDraw.setXscale(-3, n+1);
        StdDraw.setYscale(n+1, -4);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));
		
		header(a);
		sort(a);
		footer(a);

	}
	
	//排序
	public static void sort(String[] a) {
		for (int i = 1; i < a.length; i++) {
			String v = a[i];
			int j = i;
			for (; j > 0 && less(v, a[j - 1]); j--)
				a[j] = a[j - 1];
			a[j] = v;
			draw(a, i, i, j);
		}
	}

	//绘制数据部分
	private static void draw(String[] a, int row, int ith, int jth) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(-2.50, row, ith + "");
		StdDraw.text(-1.25, row, jth + "");
		for (int i = 0; i < a.length; i++) {
			if (i == jth)
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else if (i > ith)
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else if (i < jth)
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else
				StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(i, row, a[i]);
		}

	}

	

	// display header
	private static void header(String[] a) {
		int n = a.length;

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n / 2.0, -3, "a[ ]");
		for (int i = 0; i < n; i++)
			StdDraw.text(i, -2, i + "");
		StdDraw.text(-2.50, -2, "i");
		StdDraw.text(-1.25, -2, "j");
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.line(-3, -1.65, n - 0.5, -1.65);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < n; i++)
			StdDraw.text(i, -1, a[i]);
	}

	// display footer
	private static void footer(String[] a) {
		int n = a.length;
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < n; i++)
			StdDraw.text(i, n, a[i]);
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void show(Comparable[] a) {
		for (Comparable i : a)
			System.out.print(i + " ");

	}

	public static void main(String[] args) {
		String[] a = { "22" ,"33" ,"10"};
		paintTrace(a);
	}

}
