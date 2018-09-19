package algorithms.sort;

/**
 * array using selection sort.
 * @author PC
 * 比较次数：N*N/2;交换次数：N
 * 特点：1.运行时间与输入序列的初始状态（有序状态）无关；2.数据移动是最少的（N次交换与数组的大小是线性关系）
 */
public class Selection {
	public static void sort(Comparable[] a){
		//将a[]按照升序排列
		int N=a.length;
		for(int i=0;i<N;i++){
			int min=i;
			//首先找到数组中最小的元素，然后将a[i]与a[min]换位
			for(int j=i+1;j<N;j++){
				if(less(a[j],a[min])) min=j;	//如果a[j]<a[min]
			}
			exch(a,i,min);
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
		return v.compareTo(w)<0;
	}
}
