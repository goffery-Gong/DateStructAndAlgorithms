package algorithms.sort;

import java.awt.Font;

import edu.princeton.cs.algs4.StdIn;
import std.StdDraw;

public class TraceShell {
	
	private static int line=0;
	public static void sort(String[] a) {
		
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1,4,13...
		while (h >= 1) {
			// 将数组变为h有序
			for (int i = h; i < N; i++) {
				int j;
				for (j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
				draw(a, h, i, j);
				line++;
			}
			
			h = h / 3;
			footer(a,line);
			line++;
		}
	}

	private static void draw(String[] a,int h, int ith, int jth) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(-3.50, line, h + "");
		StdDraw.text(-2.50, line, ith + "");
		StdDraw.text(-1.25, line, jth + "");
		for (int i = 0; i < a.length; i++) {
			if (i == jth)
				StdDraw.setPenColor(StdDraw.BOOK_RED);
			else if (i > ith)
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else if (i < jth)
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else
				StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(i, line, a[i]);
		}
	}

	// exchange a[i] and a[j]
	private static void exch(String[] a, int i, int j) {
		String swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// is v < w ?
	private static boolean less(String v, String w) {
		return v.compareTo(w) < 0;
	}

	// display header
	private static void header(String[] a) {
		int n = a.length;

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(n / 2.0, -3, "a[ ]");
		for (int i = 0; i < n; i++)
			StdDraw.text(i, -2, i + "");
		StdDraw.text(-3.50, -2, "h");
		StdDraw.text(-2.50, -2, "i");
		StdDraw.text(-1.25, -2, "j");
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		StdDraw.line(-3, -1.65, n - 0.5, -1.65);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < n; i++)
			StdDraw.text(i, -1, a[i]);
	}

	// display footer
	private static void footer(String[] a, int line) {
		int n = a.length;
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < n; i++)
			StdDraw.text(i, line, a[i]);
	}

	// test client
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		int n=a.length;
		//所需行数
		int row=0;
		int h=1;
		while(h<n/3){
			row+=(n-h+1);
			h=3*h+1;
		}
		row+=(n-h+1);
		// set canvas size
		StdDraw.setCanvasSize(30 * (n + 3), 30 * (row + 3));
		StdDraw.setXscale(-4, n + 1);
		//StdDraw.setYscale(n + 1, -4);
		StdDraw.setYscale(row , -4);
		StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

		// draw the header
		header(a);

		// sort the array
		sort(a);

		
	}
}
