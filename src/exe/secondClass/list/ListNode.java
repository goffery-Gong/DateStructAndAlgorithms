package exe.secondClass.list;

public class ListNode {
	// ������
	public int data;
	// ָ����
	public ListNode next;

	public ListNode() {
		super();
	}

	public ListNode(int data) {
		super();
		this.data = data;
	}

	public ListNode(int data, ListNode next) {
		super();
		this.data = data;
		this.next = next;
	}

	// ��ʼ������ͷָ��
	static ListNode head = new ListNode();

	/**
	 * ����������ӽڵ�
	 * 
	 * @param value
	 */
	public static void addData(int value) {
		// ��ʼ��Ҫ����Ľڵ�
		ListNode newNode = new ListNode(value);

		// ��ʱ�ڵ�
		ListNode temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	/**
	 * ָ��λ�ò���ڵ�
	 * 
	 * @param head
	 * @param index
	 * @param value
	 */
	public static void insertNode(ListNode head, int index, int value) {
		// �ж�λ���Ƿ�Ϸ�
		if (index < 1 || index > linkListLength(head)) {
			System.out.println("����λ�ò��Ϸ�");
			return;
		}
		// ��ʼ����ʱ�ڵ�
		ListNode temp = head;

		// ��ǰָ��Ľڵ�λ��
		int curPos = 0;

		// ��ʼ��Ҫ����ڵ�
		ListNode insertnode = new ListNode(value);

		while (temp.next != null) {
			if (curPos == index - 1) {
				// temp��ʱ��ʾ����Ҫ����λ�õ���һ���ڵ�
				insertnode.next = temp.next;
				temp.next = insertnode;
			}
			curPos++;
			temp = temp.next;
		}
	}

	/**
	 * ��ȡ����ĳ���
	 * 
	 * @param head2
	 * @return
	 */
	private static int linkListLength(ListNode head2) {
		// TODO Auto-generated method stub
		int length = 0;

		ListNode temp = head.next;

		while (temp.next != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	/**
	 * ��������
	 *
	 * @param head ͷ�ڵ�
	 */
	public static void traverse(ListNode head) {

		// ��ʱ�ڵ㣬���׽ڵ㿪ʼ
		ListNode temp = head.next;

		while (temp != null) {

			System.out.print("��������" + temp.data);

			// ������һ��
			temp = temp.next;
		}
	}

	/**
	 * ɾ���ڵ�
	 * 
	 * @param head
	 * @param index
	 */
	public static void deleteNode(ListNode head, int index) {
		// �ж�λ���Ƿ�Ϸ�
		if (index < 1 || index > linkListLength(head)) {
			System.out.println("ɾ��λ�ò��Ϸ�");
			return;
		}
		// ��ʼ����ʱ�ڵ�
		ListNode temp = head;

		// ��ǰָ��Ľڵ�λ��
		int curPos = 0;

		while (temp.next != null) {
			if (index - 1 == curPos) {
				ListNode deleteNode = temp.next;
				temp.next = deleteNode.next;
				deleteNode.next = null;
			}
			curPos++;
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		addData(2);
		addData(3);
//		addData(4);
		System.out.println("����֮ǰ");
		traverse(head);

		insertNode(head, 1, 5);
		//nsertNode(head, 3, 5);
		System.out.println();
		System.out.println("����֮��");
		traverse(head);
		
		System.out.println();
		System.out.println("ɾ��֮��");
		deleteNode(head, 1);
		traverse(head);
		
	}
}
