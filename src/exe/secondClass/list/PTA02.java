package exe.secondClass.list;

import edu.princeton.cs.algs4.StdDraw;
/**
 * Ҫ��ʵ��һ�������������������ʾ�ĵ����������кϲ�Ϊһ���ǵݼ����������С�
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
