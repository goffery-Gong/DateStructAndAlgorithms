package exe.secondClass.list;

import edu.princeton.cs.algs4.StdDraw;
/**
 * 要求实现一个函数，将两个链表表示的递增整数序列合并为一个非递减的整数序列。
 * @author PC
 *
 */
public class PTA02 {
	public static void main(String[] args) {
		int N=100;
		StdDraw.setXscale(0,N);
		StdDraw.setYscale(0,N*N);
		StdDraw.setPenRadius(.01);
		for(int i=1;i<=N;i++){
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}
}
