package exe.firstClass;

import java.util.Scanner;


/**
 * ������������⣨�����������еĺ��Լ���βԪ�أ�
 * @author PC
 *
 */
class Maximum_Subsequence_Sum {
	
	/**
	 * �Ż���ٷ�����������к�   O��n^2��
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
			v = 0;	//v�Ǵ�A[i]��A[j]�����к� 
			for (j = i; j<size; j++)
			{
				//������ͬ��i����ͬ��j��ֻҪ��j-1��ѭ���Ļ������ۼ�1���
				v = v + a[j];         //Sum(i, j+1) = Sum(i, j) + A[j+1]  
				if (v>max)  max = v;
			}
		}
		return max;
	}
	
	/**
	 * ���η�����������к�//O��NlogN��
	 * @param A
	 * @param left
	 * @param right
	 * @return
	 */
	public static int MaxSubSeqSum(int[] A, int left, int right)
	{
		//�������߸��Եķ����㷨��������кͣ��ݹ���ã�
		int MaxLeftSum, MaxRightSum, MaxSum;
		//�м�λ���������߸��Ե����߽��
		int MaxLeftBorderSum, MaxRightBorderSum;
		//�ݹ�������������߸��Ե������к�
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
	 
		//�Ƚ��������߸��Եķ����㷨��������кͣ��ݹ���ã��Լ��м�λ���������߸��Ե����߽��������֮��Ĵ�С
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
	 * ��̬�滮��(�����㷨)����������к�    //O��n��
	 * @param a
	 * @param size
	 * @return
	 */
	int max_dg(int[] a,int size)			
	{
		int start, finish = 0;
		int i, sum = 0, maxsum = 0, flag = 0, temp_sum = 0;
		for (i = 0; i<size; i++)              //�ڸ�ѭ�����ж��������Ƿ��������   
		{
			if (a[i]>0)flag = 1;       //��flag��ǣ�������������Ϊ1   
		}
		if (flag == 0)             //�������������������0����βԪ��
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
		/*��������������Ϊmaxsum,����ֻ�轫maxsum��ǰ�����������㼴��ȷ����һ��Ԫ��
		�±�start��������Ŀ�й涨���в�ֻһ����������к�ʱ���start��finish��С��
		��һ�飬����iҪ����0���Է���ǰ����ӵ���������к��ԡ�
		������涨�������finish-start��С��һ�飬�����ж�sum==0ʱ�˳�ѭ������
		*/
		for (i = finish; i >= 0; i--)
		{
			sum -= a[i];
			if (sum == 0)start = i;
		}
		return maxsum;
	}

	/**
	 * ���Ժ���
	 * @param args
	 */
	public static void main(String[] args) {
		int i,j;
		int[] a=new int[10];
		Scanner in=new  Scanner(System.in);
		//�������еĳ���
		System.out.println("please input a number");
		j=in.nextInt();
		//��������
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


