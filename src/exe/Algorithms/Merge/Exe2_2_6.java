package exe.Algorithms.Merge;

import algorithms.sort.RandomArray;
import algorithms.sort.SortCompare;
import edu.princeton.cs.introcs.StdOut;

/**
 * @ClassName: Merge 
 * @Description: �Զ����µĹ鲢���򣨸��õĽ��������aux�����Ϊsort�ľֲ����������ݸ�merge�������ܿ�����
 *
 * @author Goffery Gong
 * @date 2018��9��20�� ����4:47:49
 */
public class Exe2_2_6{
	//private static Comparable[] aux;
	private static int count;
	
	//������
	public static void sort(Comparable[] a) {
		Comparable[] aux= new Comparable[a.length];
		sort(a,aux, 0, a.length - 1);
	}

	//�ݹ����sort
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = (lo + hi) / 2;
		sort(a,aux, lo, mid);		//����������
		sort(a,aux, mid + 1, hi);	//���Ұ������
		merge(a,aux, lo, mid, hi);	//�鲢���
	}

	private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		
		//���Ƚ����鿽��һ�ݵ�aux[]
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
			count+=2;
		}
		//�ж�aux�е�Ԫ�ش�С���鲢��a[]��
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
		System.out.println("�����������Ϊ��"+count);
	}
}
