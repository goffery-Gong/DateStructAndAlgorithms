package datastruct.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * ͨ�������ʾ��ջ
 * @author PC
 * @param <Item>
 */
public class ListNodeStack<Item> implements Iterable<Item>{
	//ջ��
	private Node first;
	//Ԫ������
	private int N;
	
	//����ڵ��Ƕ������
	private class Node{
		Item item;
		Node next;
	} 
	
	public boolean isEmpty(){return first==null;}
	
	public int size()	{return N;}
	//��ջ
	public void push(Item item){
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		N++;
	}
	
	//��ջ
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}

	//�������½�ջԪ�أ�����ɾ��
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
		
	}
	
	//������ջ��ע������ջ�ĵ�����������ĵ�������ʵ��ʱ��Ҫע�ⷽ�����⡣��
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
