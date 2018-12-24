package datastruct.queue;

import java.util.Iterator;

/**
 * 队列的链表实现
 * @param <Item>
 */
public class QueueByLinkedList<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	// 入队（表尾）
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		N++;
	}

	// 出队（表头）
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last = null;
		}
		return item;
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
