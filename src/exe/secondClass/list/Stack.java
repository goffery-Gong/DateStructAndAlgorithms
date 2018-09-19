package exe.secondClass.list;

public class Stack {
	
	public ListNode stackTop;
	public ListNode stackButtom;
	
	public Stack(ListNode stackTop, ListNode stackButtom) {
		super();
		this.stackTop = stackTop;
		this.stackButtom = stackButtom;
	}
	public Stack() {
		super();
	}
	
	/**
	 * ��ջ
	 * @param stack
	 * @param value
	 */
	public static void push(Stack stack, int value){
		ListNode newNode=new ListNode(value);
		newNode.next=stack.stackTop;
		stack.stackTop=newNode;
	}
	
	/**
	 * ��ջ
	 * @param stack
	 * @return
	 */
	public static void pop(Stack stack){
		if(!isEmpty(stack)){
			ListNode top=stack.stackTop;
			stack.stackTop=top.next;
			System.out.println(top.data);
		}
	}
	
	private static boolean isEmpty(Stack stack) {
		if(stack.stackTop==stack.stackButtom){
			System.out.println("ջΪ��");
			return true;
		}else{
			System.out.println("ջ��Ϊ��");
			return false;
		}
	}
	
	/**
	 * ����ջ
	 * @param stack
	 */
	public static void traverse(Stack stack){
		ListNode stackTop=stack.stackTop;
		while(stackTop !=stack.stackButtom){
			System.out.println(stackTop.data);
			stackTop=stackTop.next;
		}
	}
	
	/**
	 * ���ջ
	 * @param stack
	 */
	public static void clearStack(Stack stack){
		stack.stackTop=stack.stackButtom;
	}
	
	/**
	 * ���Գ���
	 * @param args
	 */
	public static void main(String[] args){
		//��ʼ��ջ(��Ԫ��)
        Stack stack = new Stack();

//        //ջ����ջβ��ͬһָ��
//        stack.stackButtom = stack.stackTop;
//  
//        //ָ��null
//        stack.stackTop.next = null;

		push(stack,2);
		push(stack,3);
		push(stack,4);
		
		traverse(stack);
		
		clearStack(stack);
		
		traverse(stack);
/*		pop(stack);
		pop(stack);
		pop(stack);
		pop(stack);*/
	}
}
