package exe.Algorithms.Merge;

import java.lang.reflect.Array;

import algorithms.sort.MergeX;

/**
 * @Description: ���ָĽ���1.��С��ģ������ʹ�ò������� 2.���Դ��������������Ұ���Ƿ�������  
 * 3.ȥ��ԭ�������е���������Ŀ���
 * 
 * ע�⣺Ҫע����ǣ��鲢��������һ�����������鲢+�Ҳ�鲢+�ܹ鲢��������ڵ�һ�ε��� Sort ����ʱӦ�ð� aux �� a �������롣
 * 
 * @author Goffery Gong
 * @date 2018��9��24�� ����3:50:05
 */
public class Exe2_2_11 extends MergeX{

	public static void main(String[] args) {
    	Integer[] a = {  5, 2, 6, 8, 7, 6 ,9,10};
    	Exe2_2_11.sort(a);
        Exe2_2_11.show(a);
    }
	
}

// �������鴴����
class ArrayMaker<T> {
	private Class<T> type;

	public ArrayMaker(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	T[] createArray(int size) {
		return (T[]) Array.newInstance(type, size);
	}

}