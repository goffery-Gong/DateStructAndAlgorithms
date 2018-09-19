package exe.Algorithms;

/**
 * 给出一段代码，删除链表的尾结点，其中链表的首结点为first。
 * @author PC
 *
 */
public class Exe1_3_19 {

	static class Node {
		int item;
		Node next;
	}

	private Node first;

	public void deleteLastNode() {
		Node current = first;
		
		// 链表为空，直接返回
		if (first == null) {
			return;
		}

		// 链表只有一个元素
		if (current.next == null) {
			first = null;
		} 
		
		else {
			for(current=first;current!=null;current=current.next){
				if (current.next.next == null)
					current.next = null;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
