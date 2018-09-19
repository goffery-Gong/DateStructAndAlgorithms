package datastruct.stack;

import java.util.Iterator;

/**
 * ͨ�����鶨��ջ��
 * @author PC
 * �ܹ���̬���������С��ʵ��
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a =(Item[]) new Object[1];//ջԪ��
	private int N=0;						 //Ԫ������
	
	/*//���캯������ʼ��cap��С��ջ
	public ResizingArrayStack(int cap){
		a=(Item[]) new Object[cap];
	}*/
	
	//�Ƿ�Ϊ���ж�
	public boolean isEmpty(){
		return N==0;
	}
	//ջԪ�ظ���
	public int size(){
		return N;
	}
	
	//��ջ�ƶ���һ����СΪmax����������
	private void resize(int max){
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++){
			temp[i]=a[i];
		}
		a=temp;
	}
	
	//��ջ
	public void push(Item item){
		//ȷ��ջ�������
		if(N==a.length){resize(2*a.length);}
		a[N++]=item;
	}
	
	//��ջ
	public Item pop(){
		Item item=a[--N];
		
		//�����������
		a[N]=null;
		
		//ʹջ��ʹ���ʲ�����1/4
		if(N>0 && N==a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	//�Զ����������
	private class ReverseArrayIterator implements Iterator<Item>{
		//֧�ֺ���ȳ��ĵ���
		private int i=N;
		
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		
	}
}
