package exe.Algorithms;

import algorithms.sort.Sort;

/**
 * 
 * @ClassName: Exe2_1_14
 * @Description: 出列排序
 *
 * @author Goffery Gong
 * @param <T>
 * @date 2018年8月23日 下午3:30:52
 */
public class Exe2_1_14<T> extends Sort<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1; j++) {
				// step1:判断如果第一张比第二章大，则交换两张
				if (less(a[1], a[0]))
					exchange(a, 1, 0);
				// step2：将第一张移到末尾
				for (int z = 0; z < N - 1; z++)
					exchange(a, z, z + 1);
			}
			//step3：将第一张（最大的一张）放在末尾
			for (int z = 0; z < N - 1; z++)
				exchange(a, z, z + 1);
		}
	}

	public static void main(String[] args) {
		new Exe2_1_14().test(testArray);
	}
}
