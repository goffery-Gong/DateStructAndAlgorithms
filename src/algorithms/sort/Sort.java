package algorithms.sort;

import java.util.Arrays;

/**
 * 1. 排序的抽象类 2. 可以接受任意类型，可以自定义比较器 3. @param <T>
 */
public abstract class Sort<T> {
	/** 测试数组，这里为了方便使用整型数组 */
	protected static Integer[] testArray = { 3, 2, 5, 1, 4, 7, 10 };

	/** 继承该类需要实现排序方法 */
	public  abstract void sort(Comparable<T>[] arr);

	/** 交换数组元素的业务方法 */
	protected void exchange(Comparable<T>[] array, int i, int j) {
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/** 比较两个元素的方法 */
	protected static <T> boolean less(Comparable<T> a, Comparable<T> b) {
		return a.compareTo((T) b) < 0;
	}

	/** 判断数组是否已排序的方法 */
	protected static <T> boolean  isSorted(Comparable<T>[] array) {
		for (int i = 1; i < array.length; i++)
			if (less(array[i], array[i - 1]))
				return false;
		return true;
	}

	/** 测试方法，为了方便把测试方法也写进了父类，子类实现完毕后可以直接调用看结果 */
	protected void test(Comparable<T>[] arr) {
		// 输出排序前的数组
		System.out.println(Arrays.toString(arr));
		// 排序
		sort(arr);
		// 输出排序后的结果
		System.out.println(Arrays.toString(arr));
		// 输出是否已经排序
		System.out.println("是否已经排序：" + isSorted(arr));
	}
}