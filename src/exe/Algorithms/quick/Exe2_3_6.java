package exe.Algorithms.quick;

import algorithms.sort.RandomArray;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdOut;

public class Exe2_3_6 {
	public static int time;
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
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
		a[j]=temp;
	}

	private static boolean less(Comparable v, Comparable k) {
		time++;
		if(v==k) return false;
		return v.compareTo(k)<0;
	}
	
	public static int estimate(int N){
		return (int) (2*N*Math.log(N));
	}
	public static void main(String[] args) {
		//打印标题
        System.out.print("N"+"\t"+"准确值"+"\t"+"估计值");
        System.out.println();
        for(int N=100;N<=10000;N*=10){
        	Double[] a= RandomArray.randomArray(N);
        	sort(a);
        	System.out.print(N+"\t"+time+"\t"+estimate(N));
        	System.out.println();
        }
	}
}
