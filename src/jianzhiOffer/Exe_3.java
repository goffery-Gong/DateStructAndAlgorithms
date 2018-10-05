package jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Exe_3 {
	/**
	 * ʹ��ջ
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack stack = new Stack();
		ArrayList<Integer> list = new ArrayList<>();

		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}

		while (!stack.isEmpty()) {
			list.add((Integer) stack.pop());
		}
		return list;
	}
	
	/**
	 * ʹ�õݹ����
	 */
	
	
	/**
	 * ʹ��Collections��ת����
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
         
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
         
        Collections.reverse(list);//ʹ��Collections��reverse������ֱ�ӽ�list��ת
        return list;
    }
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}