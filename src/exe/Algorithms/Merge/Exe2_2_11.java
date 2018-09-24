package exe.Algorithms.Merge;

import java.lang.reflect.Array;

import algorithms.sort.MergeX;

/**
 * @Description: 三种改进：1.对小规模子数组使用插入排序 2.测试待排序序列中左右半边是否已有序  
 * 3.去除原数组序列到辅助数组的拷贝
 * 
 * 注意：要注意的是，归并次数总是一个奇数（左侧归并+右侧归并+总归并），因此在第一次调用 Sort 方法时应该把 aux 和 a 互换传入。
 * 
 * @author Goffery Gong
 * @date 2018年9月24日 下午3:50:05
 */
public class Exe2_2_11 extends MergeX{

	public static void main(String[] args) {
    	Integer[] a = {  5, 2, 6, 8, 7, 6 ,9,10};
    	Exe2_2_11.sort(a);
        Exe2_2_11.show(a);
    }
	
}

// 泛型数组创建类
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