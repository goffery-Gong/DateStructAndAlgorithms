package exe.Algorithms;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

/**
 * 编写一段程序EvaluatePostfix，从标准输入中得到一个后序表达式，求值并打印结果。
 * 
 * @author PC
 * 
 */
public class Exe1_3_11 {
	public static Double evaluatePostfix(String str) {
		Stack<Double> stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+') {
				double d2 = stack.pop();
				double d1 = stack.pop();
				stack.push(d1 + d2);
			} else if (str.charAt(i) == '-') {
				double d2 = stack.pop();
				double d1 = stack.pop();
				stack.push(d1 - d2);
			} else if (str.charAt(i) == '*') {
				double d2 = stack.pop();
				double d1 = stack.pop();
				stack.push(d1 * d2);
			} else if (str.charAt(i) == '/') {
				double d2 = stack.pop();
				double d1 = stack.pop();
				stack.push(d1 / d2);
			} else {
				// System.out.println((double) (str.charAt(i)-'0'));
				stack.push((double) (str.charAt(i) - '0'));// chr转为int再转为double
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(evaluatePostfix(scanner.nextLine()));
		}
		scanner.close();
	}

}
