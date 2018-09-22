package algorithms.sort;

import edu.princeton.cs.introcs.StdRandom;

public class RandomArray {
	
	public static Double[] randomArray(int n){
		Double[] a=new Double[n];
		 for (int i = 0; i < n; i++)
	         a[i] = StdRandom.uniform(0.0, 1.0);
		 return a;
	}
	
	public static void main(String[] args) {
		Double[] index= randomArray(10);
		for(int i=0;i<index.length;i++)
			System.out.println(index[i]);
	}
}
