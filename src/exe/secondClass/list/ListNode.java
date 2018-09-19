package exe.secondClass.list;

public class ListNode {
	// 数据域
	public int data;
	// 指针域
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

	// 初始化链表头指针
	static ListNode head = new ListNode();

	/**
	 * 创建链表，添加节点
	 * 
	 * @param value
	 */
	public static void addData(int value) {
		// 初始化要加入的节点
		ListNode newNode = new ListNode(value);

		// 临时节点
		ListNode temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	/**
	 * 指定位置插入节点
	 * 
	 * @param head
	 * @param index
	 * @param value
	 */
	public static void insertNode(ListNode head, int index, int value) {
		// 判断位置是否合法
		if (index < 1 || index > linkListLength(head)) {
			System.out.println("插入位置不合法");
			return;
		}
		// 初始化临时节点
		ListNode temp = head;

		// 当前指向的节点位置
		int curPos = 0;

		// 初始化要插入节点
		ListNode insertnode = new ListNode(value);

		while (temp.next != null) {
			if (curPos == index - 1) {
				// temp此时表示的是要插入位置的上一个节点
				insertnode.next = temp.next;
				temp.next = insertnode;
			}
			curPos++;
			temp = temp.next;
		}
	}

	/**
	 * 获取链表的长度
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
	 * 遍历链表
	 *
	 * @param head 头节点
	 */
	public static void traverse(ListNode head) {

		// 临时节点，从首节点开始
		ListNode temp = head.next;

		while (temp != null) {

			System.out.print("遍历链表：" + temp.data);

			// 继续下一个
			temp = temp.next;
		}
	}

	/**
	 * 删除节点
	 * 
	 * @param head
	 * @param index
	 */
	public static void deleteNode(ListNode head, int index) {
		// 判断位置是否合法
		if (index < 1 || index > linkListLength(head)) {
			System.out.println("删除位置不合法");
			return;
		}
		// 初始化临时节点
		ListNode temp = head;

		// 当前指向的节点位置
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
		System.out.println("插入之前");
		traverse(head);

		insertNode(head, 1, 5);
		//nsertNode(head, 3, 5);
		System.out.println();
		System.out.println("插入之后");
		traverse(head);
		
		System.out.println();
		System.out.println("删除之后");
		deleteNode(head, 1);
		traverse(head);
		
	}
}
