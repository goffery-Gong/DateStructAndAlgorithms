package datastruct.stack;

/**
 * ͨ�����鶨��ջ��
 * @author PC
 * ȱ��1��Ԫ��ֻ����string��
 * ȱ��2�����ܵ��������С
 * ȱ��3�����ܹ�ʹ��foreach�����б���
 */
public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;
	
	//���캯������ʼ��cap��С��ջ
	public FixedCapacityStackOfStrings(int cap){
		a=new String[cap];
	}
	//�Ƿ�Ϊ���ж�
	public boolean isEmpty(){
		return N==0;
	}
	
	public boolean isFull(){
		return N==a.length;
	}
	
	//ջԪ�ظ���
	public int size(){
		return N;
	}
	//��ջ
	public void push(String Item){
		a[N++]=Item;
	}
	//��ջ
	public String pop(){
		return a[--N];
	}
}
