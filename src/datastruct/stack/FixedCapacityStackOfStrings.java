package datastruct.stack;

/**
 * 通过数组定义栈类
 * @author PC
 * 缺点1：元素只能是string类
 * 缺点2：不能调整数组大小
 * 缺点3：不能够使用foreach语句进行遍历
 */
public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;
	
	//构造函数，初始化cap大小的栈
	public FixedCapacityStackOfStrings(int cap){
		a=new String[cap];
	}
	//是否为空判断
	public boolean isEmpty(){
		return N==0;
	}
	
	public boolean isFull(){
		return N==a.length;
	}
	
	//栈元素个数
	public int size(){
		return N;
	}
	//入栈
	public void push(String Item){
		a[N++]=Item;
	}
	//出栈
	public String pop(){
		return a[--N];
	}
}
