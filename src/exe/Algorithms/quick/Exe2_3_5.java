package exe.Algorithms.quick;

import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Exe2_3_5 
 * @Description: 只有两种键值的数组排序
 *
 * @author Goffery Gong
 * @date 2018年10月5日 下午4:54:46
 */
public class Exe2_3_5 {
	public static void sort(Comparable[] a){
		int lt=0;
		int gt=a.length-1;
		int i=1;
		Comparable v=a[lt];
		
		while(i<=gt){
			int cmp =a[i].compareTo(v);
			if(cmp<0)
				exch(a,i++,lt++);
			else if(cmp>0)
				exch(a,i,gt--);
			else
				i++;
		}
	}
	
	private static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] a={1,2,2,1,2,1,2,2,1};
		sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i]);
        StdOut.println();
	}
}
