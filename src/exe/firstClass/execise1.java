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
	 * ���ַ�����1
	 * 
	 * @param list
	 * @param x
	 *            ʱ�临�Ӷȣ� c=log2(n) list�����������
	 */
	public static void FindItem1(List<Integer> list, int x) {
		// list���ȣ����Ҷ˵㣬��λ��,���Ҵ���
		int n = list.size();
		int left = 0;
		int right = n - 1;
		int M = (left + right) / 2;
		int count = 0;
		// �����Ҵ���
		double max_time = Math.log(n) / Math.log(2);// (n/2)^c=1 => c=log2(n)
		// ���ַ�����
		while (true) {
			count++;
			if (x < list.get(M)) {
				right = M;
			} else if (x > list.get(M)) {
				left = M;
			} else {
				System.out.println("xԪ���±�Ϊ" + M);
				break;
			}
			if (count > max_time) {
				System.out.println("û�ҵ�...");
				break;
			}
			M = (left + right) / 2;// java �г�����ȡ��
		}
		System.out.println("һ����Ѱ��" + count + "��");
	}

	/**
	 * ���ַ�����2
	 * 
	 * @param list
	 * @param x
	 *            ʱ�临�Ӷȣ� c=log2(n) list�����������
	 *            �ڶ��ֲ��ҵĳ���ʵ����,���left��right�ĸ��²���ȡmid+1
	 *            ��mid-1���Ƕ�ȡmid,������ܻ������Ϊ�п���left��right�߽��غϣ��Ӷ�������ѭ����
	 */
	public static int FindItem2(List<Integer> list, int x) {
		int left = 1;
		int right = list.size();
		int M = (left + right) / 2;
		int count = 0;
		// ���ַ�����
		while (left <= right) {
			M = (left + right) / 2;// java �г�����ȡ��

			if (x < list.get(M)) {
				right = M - 1;
			} else if (x > list.get(M)) {
				left = M + 1;
			} else {
				System.out.println("xԪ���±�Ϊ" + M);
				break;
			}
			count++;
		}
		System.out.println("һ����Ѱ��" + count + "��");
		return M;
	}

	/**
	 * �ƽ�ָ0.618��������3
	 * 
	 * @param list
	 * @param x
	 *            ʱ�临�Ӷȣ� c=log2(n) list�����������
	 *            �ڶ��ֲ��ҵĳ���ʵ����,���left��right�ĸ��²���ȡmid+1
	 *            ��mid-1���Ƕ�ȡmid,������ܻ������Ϊ�п���left��right�߽��غϣ��Ӷ�������ѭ����
	 */
	public static int FindItem3(List<Integer> list, int x) {
		int left = 1;
		int right = list.size();
		int M = (left + right) / 2;
		int count = 0;
		// ���ַ�����
		while (left <= right) {
			// M=(left+right)/2;//java �г�����ȡ��
			M = (int) (left + 0.618 * (right - left));

			if (x < list.get(M)) {
				right = M - 1;
			} else if (x > list.get(M)) {
				left = M + 1;
			} else {
				System.out.println("xԪ���±�Ϊ" + M);
				break;
			}
			count++;
		}
		System.out.println("һ����Ѱ��" + count + "��");
		return M;
	}

	public static void main(String[] args) {
		// Print1Test(100000);
		// Print2Test(100000);

		// ���ַ����в���
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

		long startTime = System.currentTimeMillis(); // ��ȡ��ʼʱ��

		System.out.println("��һ�ַ�����");
		for (int i = 0; i < 10000; i++) {
			FindItem2(list, 5);
		}
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��

		long startTime1 = System.currentTimeMillis(); // ��ȡ��ʼʱ��
		System.out.println("�ڶ��ַ�����");
		for (int i = 0; i < 10000; i++) {
			FindItem3(list, 5);
		}
		long endTime1 = System.currentTimeMillis(); // ��ȡ����ʱ��
		System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
		System.out.println("��������ʱ�䣺" + (endTime1 - startTime1) + "ms");

	}
}
