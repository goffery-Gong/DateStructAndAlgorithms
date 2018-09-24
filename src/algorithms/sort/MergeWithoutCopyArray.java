package algorithms.sort;

/**
 * @Description: �Ľ�����ȥ��ԭ�������е���������Ŀ��� �ο����£�
 * http://www.cnblogs.com/penghuwan/p/7940440.html#_label5
 * @author Goffery Gong
 * @date 2018��9��24�� ����3:51:36
 */
public class MergeWithoutCopyArray {
	private static Comparable aux[];

	/**
	 * @description: 1. ��ʼ����������aux��ʹ���ԭ����Ԫ����ȫ��ͬ 2. ��װsort������ֻ��¶һ���������
	 */
	public static void sort(Comparable a[]) {
		aux = a.clone(); // ����һ����a����Ԫ����ͬ�ĸ�������
		sort(a, aux, 0, a.length - 1);
	}

	/**
	 * @description: ���ڵݹ�Ĺ鲢�����㷨
	 */

	private static void sort(Comparable a[], Comparable aux[], int low, int high) {
		if (low >= high) {
			return;
		} // ��ֹ�ݹ������
		int mid = low + (high - low) / 2; // ȡ�������м��Ԫ��
		sort(aux, a, low, mid); // �����ߵݹ�
		sort(aux, a, mid + 1, high); // ���Ұ�ߵݹ�
		
		//if(a[mid+1]>a[mid]) System.arraycopy(aux, low, a, low, high-low+1);
		 
		merge(a, aux, low, mid, high); // ���˺ϲ�
	}

	/**
	 * @description: ���˺ϲ��㷨
	 * @param a
	 *            ��������
	 * @param low
	 *            ,mid,high a[low...high] �Ǵ���������,����a[low...mid]��
	 *            a[mid+1...high]������
	 */
	private static void merge(Comparable a[], Comparable aux[], int low, int mid, int high) {
		int i = low; // �α�i,��ʼʱָ����������������ߵ�ͷԪ��
		int j = mid + 1; // �α�j,��ʼʱָ��������������Ұ�ߵ�ͷԪ��
		// �����forѭ�������Ѿ�ȥ������
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				a[k] = aux[j++]; // �����þ�
			} else if (j > high) {
				a[k] = aux[i++]; // �Ұ���þ�
			} else if (less(aux[j] ,aux[i])) {
				a[k] = aux[j++]; // �Ұ�ߵ�ǰԪ��С�����ߵ�ǰԪ�أ� ȡ�Ұ��Ԫ��
			} else {
				a[k] = aux[i++]; // �Ұ�ߵ�ǰԪ�ش��ڵ������ߵ�ǰԪ�أ�ȡ����Ԫ��
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void main(String[] args) {
		//int[] a1 = { 5, 2, 6, 8, 7, 6 ,9,10};
		Double[] a11 = RandomArray.randomArray(10);
		sort(a11);
		//MergeX.sort(a);
		for (int i = 0; i < a11.length; i++)
			System.out.println(a11[i]);
	}
}
