package jianzhiOffer;

public class Exe_1 {
	/**
	 * 方法一
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			if (binarySearch(target, array[i]))
				return true;
		}
		return false;
	}

	private boolean binarySearch(int target, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (target < a[mid])
				hi = mid - 1;
			else if (target > a[mid])
				lo = mid + 1;
			else {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法二
	 * 
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find2(int target, int[][] array) {
		int row = 0;
		int col = array[0].length - 1;

		while (row <= array.length - 1 && col >= 0) {
			if (target > array[row][col])
				row++;
			else if (target < array[row][col])
				col--;
			else
				return true;
		}
		return false;
	}

}
