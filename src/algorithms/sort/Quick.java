package algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a,0,a.length);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(lo>=hi) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		Comparable v=a[lo];
		while(true){
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}

	private static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp=a[i];
		a[i]=a[j];
		a[i]=temp;
	}

	private static boolean less(Comparable v, Comparable k) {
		if(v==k) return false;
		return v.compareTo(k)<0;
	}
	
	public static void main(String[] args) {
		
	}
}
