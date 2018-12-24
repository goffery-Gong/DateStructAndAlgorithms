package algorithms.sort;

import java.util.Random;

import algorithms.Utils.ArrayUtils;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.introcs.StdOut;
/**
 * @ClassName: Quick 
 * @Description: ��������������԰�֡���NlogN��(��Ԫ����ͬ�����У�2.3.8)
 * 				 ������ÿ���з�������������֮һ��һ�������飨���������飩����N^2/2�αȽ�
 * 				 ƽ��ʱ�临�Ӷȣ�~2NlnN(~1.39NlogN)
 * @author Goffery Gong
 * @date 2018��9��27�� ����3:19:13
 */
public class Quick {
	public static int time;
	public void sss(){}
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		if(lo>=hi) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	public static int partition(Comparable[] a, int lo, int hi) {
		int i=lo;
		int j=hi+1;
		Comparable v=a[lo];
		while(true){
			while(ArrayUtils.less(a[++i],v)) if(i==hi) break;
			while(ArrayUtils.less(v,a[--j])) if(j==lo) break;
			if(i>=j) break;
			ArrayUtils.exch(a,i,j);
		}
		ArrayUtils.exch(a,lo,j);
		return j;
	}

	public static void shuffle(Object[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + new Random().nextInt(n-i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
	
	private static void validateNotNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("argument is null");
        }
    }
	public static void main(String[] args) {
		Integer[] a={2,2,2,2,2,2};
		//Double[] a= RandomArray.randomArray(100);
		sort(a);
        for (int i = 0; i < a.length; i++)
//            StdOut.print(a[i]);
        StdOut.println();
        System.out.println(time);
	}
}
