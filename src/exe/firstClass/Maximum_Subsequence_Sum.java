package exe.firstClass;

import java.util.Scanner;


/**
 * 最大子序列问题（输出最大子序列的和以及首尾元素）
 * @author PC
 *
 */
class Maximum_Subsequence_Sum {
	
	/**
	 * 优化穷举法求最大子序列和   O（n^2）
	 * @param a
	 * @param size
	 * @return
	 */
	public static int max_sub(int[] a, int size)			
	{
		int i, j, v;
		int max = a[0];
		for (i = 0; i<size; i++)
		{
			v = 0;	//v是从A[i]到A[j]的子列和 
			for (j = i; j<size; j++)
			{
				//对于相同的i，不同的j，只要在j-1次循环的基础上累加1项即可
				v = v + a[j];         //Sum(i, j+1) = Sum(i, j) + A[j+1]  
				if (v>max)  max = v;
			}
		}
		return max;
	}
	
	/**
	 * 分治法求最大子序列和//O（NlogN）
	 * @param A
	 * @param left
	 * @param right
	 * @return
	 */
	public static int MaxSubSeqSum(int[] A, int left, int right)
	{
		//左右两边各自的分治算法最大子序列和（递归调用）
		int MaxLeftSum, MaxRightSum, MaxSum;
		//中间位置左右两边各自的最大边界和
		int MaxLeftBorderSum, MaxRightBorderSum;
		//递归过程中左右两边各自的子序列和
		int LeftBorderSum, RightBorderSum;
		int center;
		int i;
		
		if (left == right)
		{
			if (A[left] > 0)
				return A[left];
			else
				return 0;
		}
	 
		center = (left + right) / 2;
	 
		MaxLeftSum = MaxSubSeqSum(A, left, center);
		MaxRightSum = MaxSubSeqSum(A, center + 1, right);
	 
		MaxLeftBorderSum = 0;
		LeftBorderSum = 0;
	 
		for (i = center; i >= left; i--)
		{
			LeftBorderSum += A[i];
			if (LeftBorderSum > MaxLeftBorderSum)
				MaxLeftBorderSum = LeftBorderSum;
		}
	 
	 
		MaxRightBorderSum = 0;
		RightBorderSum = 0;
		for (i = center + 1; i <= right; i++)
		{
			RightBorderSum += A[i];
			if (RightBorderSum > MaxRightBorderSum)
				MaxRightBorderSum = RightBorderSum;
		}
	 
		//比较左右两边各自的分治算法最大子序列和（递归调用）以及中间位置左右两边各自的最大边界和这三者之间的大小
		MaxSum = Max_3(MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum);
	 
		return MaxSum;
	 
	}
	
	static int Max_3(int a, int b, int c)     
	{
		if (a < b)
			a = b;
		if (a < c)
			return c;
		else
			return a;
	}

	/**
	 * 动态规划法(在线算法)求最大子序列和    //O（n）
	 * @param a
	 * @param size
	 * @return
	 */
	int max_dg(int[] a,int size)			
	{
		int start, finish = 0;
		int i, sum = 0, maxsum = 0, flag = 0, temp_sum = 0;
		for (i = 0; i<size; i++)              //在该循环内判断序列中是否存在正数   
		{
			if (a[i]>0)flag = 1;       //用flag标记，若存在正数则为1   
		}
		if (flag == 0)             //若不存在正数，则输出0和首尾元素
		{   
			maxsum = 0; start = 0; finish = size - 1;
			return 0;
		}
	 
		for (i = 0; i<size; i++)
		{
			temp_sum += a[i];
			if (temp_sum > maxsum)
			{
				maxsum = temp_sum; finish = i;
			}
			else if (temp_sum<0)
				temp_sum = 0;
		}
		/*由于子序列最大和为maxsum,所以只需将maxsum与前面各项相减到零即可确定第一个元素
		下标start。由于题目中规定若有不只一组最大子序列和时输出start和finish较小的
		那一组，所以i要减到0。以防把前面相加等于零的子列忽略。
		若这里规定的是输出finish-start最小的一组，则在判断sum==0时退出循环即可
		*/
		for (i = finish; i >= 0; i--)
		{
			sum -= a[i];
			if (sum == 0)start = i;
		}
		return maxsum;
	}

	/**
	 * 测试函数
	 * @param args
	 */
	public static void main(String[] args) {
		int i,j;
		int[] a=new int[10];
		Scanner in=new  Scanner(System.in);
		//输入序列的长度
		System.out.println("please input a number");
		j=in.nextInt();
		//输入序列
		System.out.println("please input the numbers");
		for(i=0;i < j; i++){
			a[i]=in.nextInt();
		}
		System.out.println("the number row is:");
		for(i = 0; i < j; i++){
			System.out.print(a[i]+" ");
		}	
		
		System.out.println("The sum of biggest row is:"+max_sub(a,j));
	}
}


