package exe.Algorithms.quick;

import java.util.Random;

import edu.princeton.cs.introcs.StdOut;
import algorithms.Utils.ArrayUtils;
import algorithms.sort.RandomArray;

/**
 * @ClassName: Exe2_3_18 
 * @Description: ��ȡ���з�
 * 
 * @author Goffery Gong
 * @date 2018��10��5�� ����4:53:49
 */
public class Exe2_3_18 {
	public static void QuickSortMedian3(Comparable[] a){
		Shuffle(a);
		QuickSortMedian3(a,0,a.length-1);
	}

	@SuppressWarnings("unchecked")
	private static void QuickSortMedian3(Comparable[] a, int lo, int hi) {
		if(lo>=hi) return;
		if(hi==lo+1) {
			if(ArrayUtils.less(a[hi], a[lo]))
				ArrayUtils.exch(a, lo, hi);
			return;
		}
		int j=partition(a,lo,hi);
		QuickSortMedian3(a,lo,j-1);
		QuickSortMedian3(a,j+1,hi);
	}

	@SuppressWarnings("unchecked")
	private static int partition(Comparable[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		
		//ȡ������ǰ��������������,lo+1��Ϊ��λ��
		if(ArrayUtils.less(a[lo+1], a[lo])) ArrayUtils.exch(a, lo, lo+1);
		if(ArrayUtils.less(a[lo+2], a[lo])) ArrayUtils.exch(a, lo, lo+2);
		if(ArrayUtils.less(a[lo+2], a[lo+1])) ArrayUtils.exch(a, lo+1, lo+2);
		
		//����Ϊ����Ϊ��ʼ�з�Ԫ�ط�������࣬��lo+2�ϴ�ķ������Ҳ���Ϊ�ڱ�
		ArrayUtils.exch(a, lo, lo+1);
		ArrayUtils.exch(a, lo+2, hi);
		
		Comparable v=a[lo];
		while(true){
			while(ArrayUtils.less(a[++i], v));
			while(ArrayUtils.less(v,a[--j]));
			if(i>=j) break;
			ArrayUtils.exch(a, i, j);
		}
		ArrayUtils.exch(a, lo, j);
		return j;
	}

	private static void Shuffle(Object[] a) {
		// TODO Auto-generated method stub
		int n=a.length;
		for(int i=0;i<a.length;i++){
			int r =i+new Random().nextInt(n-i);
			Object temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}
	
	public static void main(String[] args) {
		//Integer[] a={2,2,2,2,2,2};
		Double[] a= RandomArray.randomArray(10);
		QuickSortMedian3(a);
        for (int i = 0; i < a.length; i++){
            StdOut.print(a[i]);
            StdOut.println();
        }
	}
}
