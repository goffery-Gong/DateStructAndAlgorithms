package exe.firstClass;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class execise1 {

	public static void Print1Test(int N) {
		int i;
		for (i = 1; i <= N; i++) {
			System.out.println(i);
		}
	}

	public static void Print2Test(int N) {
		if (N > 0) {
			Print2Test(N - 1);
			System.out.println(N);
		}
	}

	/**
	 * 二分法查找1
	 * 
	 * @param list
	 * @param x
	 *            时间复杂度： c=log2(n) list必须是有序的
	 */
	public static void FindItem1(List<Integer> list, int x) {
		// list长度，左、右端点，中位数,查找次数
		int n = list.size();
		int left = 0;
		int right = n - 1;
		int M = (left + right) / 2;
		int count = 0;
		// 最大查找次数
		double max_time = Math.log(n) / Math.log(2);// (n/2)^c=1 => c=log2(n)
		// 二分法查找
		while (true) {
			count++;
			if (x < list.get(M)) {
				right = M;
			} else if (x > list.get(M)) {
				left = M;
			} else {
				System.out.println("x元素下标为" + M);
				break;
			}
			if (count > max_time) {
				System.out.println("没找到...");
				break;
			}
			M = (left + right) / 2;// java 中除号是取整
		}
		System.out.println("一共搜寻了" + count + "次");
	}

	/**
	 * 二分法查找2
	 * 
	 * @param list
	 * @param x
	 *            时间复杂度： c=log2(n) list必须是有序的
	 *            在二分查找的程序实现中,如果left和right的更新不是取mid+1
	 *            和mid-1而是都取mid,程序可能会出错，因为有可能left与right边界重合，从而陷入死循环。
	 */
	public static int FindItem2(List<Integer> list, int x) {
		int left = 1;
		int right = list.size();
		int M = (left + right) / 2;
		int count = 0;
		// 二分法查找
		while (left <= right) {
			M = (left + right) / 2;// java 中除号是取整

			if (x < list.get(M)) {
				right = M - 1;
			} else if (x > list.get(M)) {
				left = M + 1;
			} else {
				System.out.println("x元素下标为" + M);
				break;
			}
			count++;
		}
		System.out.println("一共搜寻了" + count + "次");
		return M;
	}

	/**
	 * 黄金分割（0.618）法查找3
	 * 
	 * @param list
	 * @param x
	 *            时间复杂度： c=log2(n) list必须是有序的
	 *            在二分查找的程序实现中,如果left和right的更新不是取mid+1
	 *            和mid-1而是都取mid,程序可能会出错，因为有可能left与right边界重合，从而陷入死循环。
	 */
	public static int FindItem3(List<Integer> list, int x) {
		int left = 1;
		int right = list.size();
		int M = (left + right) / 2;
		int count = 0;
		// 二分法查找
		while (left <= right) {
			// M=(left+right)/2;//java 中除号是取整
			M = (int) (left + 0.618 * (right - left));

			if (x < list.get(M)) {
				right = M - 1;
			} else if (x > list.get(M)) {
				left = M + 1;
			} else {
				System.out.println("x元素下标为" + M);
				break;
			}
			count++;
		}
		System.out.println("一共搜寻了" + count + "次");
		return M;
	}

	public static void main(String[] args) {
		// Print1Test(100000);
		// Print2Test(100000);

		// 二分法进行查找
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);

		long startTime = System.currentTimeMillis(); // 获取开始时间

		System.out.println("第一种方法：");
		for (int i = 0; i < 10000; i++) {
			FindItem2(list, 5);
		}
		long endTime = System.currentTimeMillis(); // 获取结束时间

		long startTime1 = System.currentTimeMillis(); // 获取开始时间
		System.out.println("第二种方法：");
		for (int i = 0; i < 10000; i++) {
			FindItem3(list, 5);
		}
		long endTime1 = System.currentTimeMillis(); // 获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
		System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");

	}
}
