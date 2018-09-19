package algorithms.sort;

/**
 * array using selection sort.
 * @author PC
 * �Ƚϴ�����N*N/2;����������N
 * �ص㣺1.����ʱ�����������еĳ�ʼ״̬������״̬���޹أ�2.�����ƶ������ٵģ�N�ν���������Ĵ�С�����Թ�ϵ��
 */
public class Selection {
	public static void sort(Comparable[] a){
		//��a[]������������
		int N=a.length;
		for(int i=0;i<N;i++){
			int min=i;
			//�����ҵ���������С��Ԫ�أ�Ȼ��a[i]��a[min]��λ
			for(int j=i+1;j<N;j++){
				if(less(a[j],a[min])) min=j;	//���a[j]<a[min]
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
