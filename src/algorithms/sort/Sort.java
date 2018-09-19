package algorithms.sort;

import java.util.Arrays;

/**
 * 1. ����ĳ����� 2. ���Խ����������ͣ������Զ���Ƚ��� 3. @param <T>
 */
public abstract class Sort<T> {
	/** �������飬����Ϊ�˷���ʹ���������� */
	protected static Integer[] testArray = { 3, 2, 5, 1, 4, 7, 10 };

	/** �̳и�����Ҫʵ�����򷽷� */
	public  abstract void sort(Comparable<T>[] arr);

	/** ��������Ԫ�ص�ҵ�񷽷� */
	protected void exchange(Comparable<T>[] array, int i, int j) {
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/** �Ƚ�����Ԫ�صķ��� */
	protected static <T> boolean less(Comparable<T> a, Comparable<T> b) {
		return a.compareTo((T) b) < 0;
	}

	/** �ж������Ƿ�������ķ��� */
	protected static <T> boolean  isSorted(Comparable<T>[] array) {
		for (int i = 1; i < array.length; i++)
			if (less(array[i], array[i - 1]))
				return false;
		return true;
	}

	/** ���Է�����Ϊ�˷���Ѳ��Է���Ҳд���˸��࣬����ʵ����Ϻ����ֱ�ӵ��ÿ���� */
	protected void test(Comparable<T>[] arr) {
		// �������ǰ������
		System.out.println(Arrays.toString(arr));
		// ����
		sort(arr);
		// ��������Ľ��
		System.out.println(Arrays.toString(arr));
		// ����Ƿ��Ѿ�����
		System.out.println("�Ƿ��Ѿ�����" + isSorted(arr));
	}
}