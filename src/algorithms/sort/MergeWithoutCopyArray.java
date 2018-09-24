package algorithms.sort;

/**
 * @Description: 改进三；去除原数组序列到辅助数组的拷贝 参考如下：
 * http://www.cnblogs.com/penghuwan/p/7940440.html#_label5
 * @author Goffery Gong
 * @date 2018年9月24日 下午3:51:36
 */
public class MergeWithoutCopyArray {
	private static Comparable aux[];

	/**
	 * @description: 1. 初始化辅助数组aux，使其和原数组元素完全相同 2. 包装sort，向外只暴露一个数组参数
	 */
	public static void sort(Comparable a[]) {
		aux = a.clone(); // 拷贝一个和a所有元素相同的辅助数组
		sort(a, aux, 0, a.length - 1);
	}

	/**
	 * @description: 基于递归的归并排序算法
	 */

	private static void sort(Comparable a[], Comparable aux[], int low, int high) {
		if (low >= high) {
			return;
		} // 终止递归的条件
		int mid = low + (high - low) / 2; // 取得序列中间的元素
		sort(aux, a, low, mid); // 对左半边递归
		sort(aux, a, mid + 1, high); // 对右半边递归
		
		//if(a[mid+1]>a[mid]) System.arraycopy(aux, low, a, low, high-low+1);
		 
		merge(a, aux, low, mid, high); // 单趟合并
	}

	/**
	 * @description: 单趟合并算法
	 * @param a
	 *            输入数组
	 * @param low
	 *            ,mid,high a[low...high] 是待排序序列,其中a[low...mid]和
	 *            a[mid+1...high]已有序
	 */
	private static void merge(Comparable a[], Comparable aux[], int low, int mid, int high) {
		int i = low; // 游标i,开始时指向待排序序列中左半边的头元素
		int j = mid + 1; // 游标j,开始时指向待排序序列中右半边的头元素
		// 这里的for循环拷贝已经去除掉了
		for (int k = low; k <= high; k++) {
			if (i > mid) {
				a[k] = aux[j++]; // 左半边用尽
			} else if (j > high) {
				a[k] = aux[i++]; // 右半边用尽
			} else if (less(aux[j] ,aux[i])) {
				a[k] = aux[j++]; // 右半边当前元素小于左半边当前元素， 取右半边元素
			} else {
				a[k] = aux[i++]; // 右半边当前元素大于等于左半边当前元素，取左半边元素
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
