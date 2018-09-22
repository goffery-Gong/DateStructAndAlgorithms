package exe.Algorithms.datastructure;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdOut;

public class Exe1_3_4 {
	
	public static boolean isBalanced(String s) {
		char LEFT_PAREN = '(';
		char RIGHT_PAREN = ')';
		char LEFT_BRACE = '{';
		char RIGHT_BRACE = '}';

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == LEFT_BRACE)
				stack.push(LEFT_BRACE);
			if (s.charAt(i) == LEFT_PAREN)
				stack.push(LEFT_PAREN);

			if (s.charAt(i) == RIGHT_BRACE) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFT_BRACE)
					return false;
			} else if (s.charAt(i) == RIGHT_PAREN) {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFT_PAREN)
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		In in=new In();
		String s = in.readAll().trim();
		StdOut.println(isBalanced(s));
	}
}
