package exe.Algorithms.datastructure;

import datastruct.stack.ListNodeStack;

/**
 * ��дһ���ɵ�����Stack������������һ����̬��copy()����������һ���ַ�����ջ��Ϊ���������ظ�ջ��һ��������
 * @author PC
 * ������listNodeStack���е�copy����
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
