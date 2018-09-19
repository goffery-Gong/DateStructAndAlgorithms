package exe.Algorithms;

import algorithms.sort.Sort;

/**
 * 
 * @ClassName: Exe2_1_14
 * @Description: ��������
 *
 * @author Goffery Gong
 * @param <T>
 * @date 2018��8��23�� ����3:30:52
 */
public class Exe2_1_14<T> extends Sort<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1; j++) {
				// step1:�ж������һ�űȵڶ��´��򽻻�����
				if (less(a[1], a[0]))
					exchange(a, 1, 0);
				// step2������һ���Ƶ�ĩβ
				for (int z = 0; z < N - 1; z++)
					exchange(a, z, z + 1);
			}
			//step3������һ�ţ�����һ�ţ�����ĩβ
			for (int z = 0; z < N - 1; z++)
				exchange(a, z, z + 1);
		}
	}

	public static void main(String[] args) {
		new Exe2_1_14().test(testArray);
	}
}
