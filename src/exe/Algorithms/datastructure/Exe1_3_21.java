package exe.Algorithms.datastructure;

import exe.Algorithms.MyLink;

public class Exe1_3_21 {

	static class Node {
		String item;
		Node next;
	}

	private Node first;

	public boolean find(MyLink list, String key) {
		boolean flag = false;

		for (Node x = first; x != null; x = x.next) {
			if (x.item == key) {
				flag = true;
			}
		}
		return flag;
	}
}
