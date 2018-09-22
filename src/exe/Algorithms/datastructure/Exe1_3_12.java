package exe.Algorithms.datastructure;

import datastruct.stack.ListNodeStack;

/**
 * 编写一个可迭代的Stack用例，它含有一个静态的copy()方法，接受一个字符串的栈作为参数并返回该栈的一个副本。
 * @author PC
 * 程序在listNodeStack类中的copy函数
 */
public class Exe1_3_12 {
	
	public static void main(String[] args) {
		ListNodeStack<String> s1 = new ListNodeStack<String>();
        s1.push("first");
        s1.push("second");
        s1.push("third");
        
        ListNodeStack<String> s2 = ListNodeStack.copy(s1);
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
}
