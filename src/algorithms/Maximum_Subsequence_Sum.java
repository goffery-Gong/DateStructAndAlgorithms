package algorithms;

import java.util.Scanner;

/**
 * ������к�����
 * @ClassName: Maximum_Subsequence_Sum 
 * @Description: https://pintia.cn/problem-sets/951072707007700992/problems/968389834258796544 
 *
 * @author Goffery Gong
 * @date 2018��9��19�� ����4:34:43
 */
public class Maximum_Subsequence_Sum {
	/**
	 * ���
	 * @param a
	 * @return
	 */
	public static int max_sub1(int a[]){
		int max=a[0];
		int N=a.length;
		int tempSum=0;
		
		for(int i=0;i<N;i++){
			for (int j=i;j<N;j++){
				tempSum+=a[j];
				if(tempSum>max) max=tempSum;
			}
		}
		return max;
	}
	
	/**
	 * ��̬�滮��
	 * @param a
	 * @return
	 */
	public static int max_dg(int[] a)			
	{
		int start=0, finish = 0;
		int maxsum = 0;
		int temp_sum = 0;
		int flag = 0; 
	
		//�����к�������
		for (int i = 0,j=0; j<a.length; j++)
		{
			temp_sum += a[j];
			if (temp_sum > maxsum)
			{
				maxsum = temp_sum; 
				start=i+1;
				finish = j+1;
			}
			else if (temp_sum<0){
				temp_sum = 0;
				i=j+1;
			}
		}
		
		//�ڸ�ѭ�����ж��������Ƿ��������   	
		for (int i = 0; i<a.length; i++)       	
			if (a[i]>0) flag = 1;      //��flag��ǣ�������������Ϊ1   
		
		//�������������������0����βԪ��
		if (flag == 0)             	   
		{   
			maxsum = 0; start = 1; finish = a.length;
			return 0;
		}
	 
		System.out.println("��β���±�ֱ�Ϊ��" +start+" "+finish);
		return maxsum; 
	}
	
	public static void main(String[] args) {
		/*int i,j;
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
		}	*/
		
		int[] a={2,-1,-2,3,2};
		System.out.println("The sum of biggest row is:"+max_dg(a));
	}

}
