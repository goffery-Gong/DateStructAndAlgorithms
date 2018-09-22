package exe.Algorithms.Merge;

import algorithms.sort.RandomArray;
import algorithms.sort.SortCompare;
import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Merge 
 * @Description: 自顶向下的归并排序（更好的解决方案：aux数组变为sort的局部变量，传递给merge减少性能开销）
 *
 * @author Goffery Gong
 * @date 2018年9月20日 下午4:47:49
 */
public class Exe2_2_6{
	//private static Comparable[] aux;
	private static int count;
	
	//排序函数
	public static void sort(Comparable[] a) {
		Comparable[] aux= new Comparable[a.length];
		sort(a,aux, 0, a.length - 1);
	}

	//递归调用sort
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sort(a,aux, lo, mid);		//将左半边排序
		sort(a,aux, mid + 1, hi);	//将右半边排序
		merge(a,aux, lo, mid, hi);	//归并结果
	}

	private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		
		//首先将数组拷贝一份到aux[]
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
			count+=2;
		}
		//判断aux中的元素大小，归并到a[]中
		for (int k = lo; k <= hi; k++) {
			if (i > mid){
				a[k] = aux[j++];
				count+=2;
			}
			else if (j > hi){
				a[k] = aux[i++];
				count+=2;
			}
			else if (less(aux[j], aux[i])){
				a[k] = aux[j++];
				count+=4;
			}
			else{
				a[k] = aux[i++];
				count+=2;
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		Integer[] a = { 5,2};
		//Double[] a= RandomArray.randomArray(10);
		sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		System.out.println("访问数组次数为："+count);
	}
}
