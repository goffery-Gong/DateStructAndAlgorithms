package exe.Algorithms.datastructure;

import edu.princeton.cs.algs4.Stack;

public class Exe1_3_9 {
	
	public static String CompleteParentese(String str) {
		Stack<String> dataStack = new Stack<String>();
		Stack<String> optrStack = new Stack<String>();

		for (int i = 0; i < str.length(); i++) {
			if (isData(str.charAt(i))) {
				// 处理数字情况
				dataStack.push(String.valueOf(str.charAt(i)));
			} else if (isOptr(str.charAt(i))) {
				// 处理操作符情况
				optrStack.push(String.valueOf(str.charAt(i)));
			} else  {
				// 处理右括号的情况
				String d2 = dataStack.pop();
				String d1 = dataStack.pop();
				String opt = optrStack.pop();
				String corstr = "(" + d1 + opt + d2 + ")";
				dataStack.push(corstr);
			}
		}

		while (optrStack.size() > 0) {
			String d2 = dataStack.pop();
			String d1 = dataStack.pop();
			String opt = optrStack.pop();
			String corstr = "(" + d1 + opt + d2 + ")";
			dataStack.push(corstr);
		}
		return dataStack.pop();
	}

	private static boolean isOptr(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static boolean isData(char c) {
		return c >= '0' && c <= '9';
	}
	
	 public static void main(String[] args) {
	        String str = "1+2)*3-4)*5-6)))";
	        
	        String res = CompleteParentese(str);
	        System.out.println(res);
	    }
}
