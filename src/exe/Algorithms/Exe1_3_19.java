package exe.Algorithms;

/**
 * ����һ�δ��룬ɾ�������β��㣬����������׽��Ϊfirst��
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
		
		// ����Ϊ�գ�ֱ�ӷ���
		if (first == null) {
			return;
		}

		// ����ֻ��һ��Ԫ��
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
