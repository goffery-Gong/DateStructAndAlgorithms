package datastruct.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 通过链表表示堆栈
 * @author PC
 * @param <Item>
 */
public class ListNodeStack<Item> implements Iterable<Item>{
	//栈顶
	private Node first;
	//元素数量
	private int N;
	
	//定义节点的嵌套类型
	private class Node{
		Item item;
		Node next;
	} 
	
	public boolean isEmpty(){return first==null;}
	
	public int size()	{return N;}
	//入栈
	public void push(Item item){
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		N++;
	}
	
	//出栈
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}

	//返回最新进栈元素，而不删除
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
		
	}
	
	//拷贝堆栈（注意由于栈的迭代器是逆向的迭代器，实现时需要注意方向问题。）
	public static <Item> ListNodeStack<Item> copy(ListNodeStack<Item> s){
		
		ListNodeStack<Item> reslut=new ListNodeStack<Item>();
		ListNodeStack<Item> temp=new ListNodeStack<Item>();
		for(Item k:s){
			temp.push(k);
		}
		for(Item k:temp){
			reslut.push(k);
		}
		return reslut;	
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{

		private Node current=first;
		
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
}
