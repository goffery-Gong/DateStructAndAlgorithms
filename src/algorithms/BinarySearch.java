package algorithms;

public class BinarySearch {
	public static int search(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid])
				hi = mid-1;
			else if (key > a[mid])
				lo = mid+1;
			else
				return mid;
		}
		return -1;
	}

    
    public static void main(String[] args) {
//		int[][] a={
//			{2,2,2,2,5,5,6},
//			{4,5,5,2,5,5,6},
//		};
		int[] a={2,2,2,2,5,5,6};
		//System.out.println(new BinarySearch().Find(3, a));
		System.out.println(search(3,a));
	}
}
