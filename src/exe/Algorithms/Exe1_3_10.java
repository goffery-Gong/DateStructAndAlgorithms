package exe.Algorithms;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Exe1_3_10 {
	
	/**
	 * 1����������ǲ�����ʱ��ֱ�����
	 * �������뿪����ʱ�򣬰���ѹջ
	 * 3����������Ǳ�����ʱ�����ж�ջ�Ƿ�Ϊ�գ���Ϊ�գ��������󲢽�����ش������ǿգ���ջ��Ԫ�����γ�ջ�����ֱ��������һ�������ţ���û�����������ţ�Ҳ�������󣬽�����ش���
	 * 4���������������op��+��- ������/��ʱ��
	 	a)ѭ��������ջ�ǿ�andջ�����ǿ�����andջ������������ȼ����������������������ȼ���ʱ��������������ջ��Ԫ�س�ջ���
		b)������������opѹջ
	 * 5����������ʽ�ķ�������ȫ���������ջ������Ԫ�أ����������γ�ջ�������������Ԫ�����������ţ���˵����ƥ�䣬�������󣬲�������ش���
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> operatorStack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals("("))
                operatorStack.push(str);
            else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                boolean isEmpty;
                boolean isLeftParen;
                boolean isLowerOperator;
                isEmpty = operatorStack.isEmpty();
                isLeftParen = false;
                isLowerOperator = false;
                if (!isEmpty) {
                    String stackTop = operatorStack.peek();
                    isLeftParen = operatorStack.peek().equals("(");
                    if ((stackTop.equals("+") || stackTop.equals("-")) && (str.equals("*") || str.equals("/"))) {
                        isLowerOperator = true;
                    }
                }
                if (!(isEmpty || isLeftParen || isLowerOperator)) {
                    for (int i = 0; i < operatorStack.size(); i++) {
                        StdOut.print(operatorStack.pop());
                    }
                }
                operatorStack.push(str);
            } else if (str.equals(")")) {
                String pop = operatorStack.pop();
                while (!pop.equals("(")) {
                    StdOut.print(pop);
                    pop = operatorStack.pop();
                }
            } else {
                StdOut.print(str);
            }
        }
        for (String str : operatorStack) {
            StdOut.print(str);
        }

    }		
}
