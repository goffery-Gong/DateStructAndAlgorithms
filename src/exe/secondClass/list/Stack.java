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
	 * 进栈
	 * @param stack
	 * @param value
	 */
	public static void push(Stack stack, int value){
		ListNode newNode=new ListNode(value);
		newNode.next=stack.stackTop;
		stack.stackTop=newNode;
	}
	
	/**
	 * 出栈
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
			System.out.println("栈为空");
			return true;
		}else{
			System.out.println("栈不为空");
			return false;
		}
	}
	
	/**
	 * 遍历栈
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
	 * 清空栈
	 * @param stack
	 */
	public static void clearStack(Stack stack){
		stack.stackTop=stack.stackButtom;
	}
	
	/**
	 * 测试程序
	 * @param args
	 */
	public static void main(String[] args){
		//初始化栈(无元素)
        Stack stack = new Stack();

//        //栈顶和栈尾是同一指向
//        stack.stackButtom = stack.stackTop;
//  
//        //指向null
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
