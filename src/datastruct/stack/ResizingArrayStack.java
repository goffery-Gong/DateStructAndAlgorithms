package datastruct.stack;

import java.util.Iterator;

/**
 * 通过数组定义栈类
 * @author PC
 * 能够动态调整数组大小的实现
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
	private Item[] a =(Item[]) new Object[1];//栈元素
	private int N=0;						 //元素数量
	
	/*//构造函数，初始化cap大小的栈
	public ResizingArrayStack(int cap){
		a=(Item[]) new Object[cap];
	}*/
	
	//是否为空判断
	public boolean isEmpty(){
		return N==0;
	}
	//栈元素个数
	public int size(){
		return N;
	}
	
	//将栈移动到一个大小为max的新数组中
	private void resize(int max){
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++){
			temp[i]=a[i];
		}
		a=temp;
	}
	
	//入栈
	public void push(Item item){
		//确保栈不会溢出
		if(N==a.length){resize(2*a.length);}
		a[N++]=item;
	}
	
	//出栈
	public Item pop(){
		Item item=a[--N];
		
		//避免对象游离
		a[N]=null;
		
		//使栈的使用率不低于1/4
		if(N>0 && N==a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	//自定义迭代器类
	private class ReverseArrayIterator implements Iterator<Item>{
		//支持后进先出的迭代
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
