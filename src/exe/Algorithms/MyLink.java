package exe.Algorithms;

/**
 * ������
 * @author PC
 *
 */
public class MyLink {
	private Node first; // һ��ͷ���
    private int N;            // ������

    public MyLink() {
        first = null;
        N = 0;
    }

    /**
     * �Զ���һ���ڵ���
     */
    public static class Node{
        int item;
        Node next;
    }

    // �����ͷ���һ���µĽ��
    public void addNode(int i) {
        Node temp = first;
        first = new Node();
        first.item = i;
        first.next = temp;      
        N++;
    }

    // ɾ��һ��β���
    public void deleteLastNode() {
        if (N == 0) 
            return;
        if (N == 1) 
            first = null;
        else 
            for (Node x = first; x != null; x = x.next) {
                if (x.next.next == null)
                    x.next = null;
            }   
        N--;
    }

    // ɾ��ָ��λ�õĽ��
    public void deletePosition(int position) {
        if (position  == 1) {
            first = null;
            return;
        }
        if (position > N) 
            System.out.println("the position is too large");
        else {
            int index = 1; // ��¼������λ��
            for (Node x = first; x != null; x = x.next) {
                if (index + 1 == position) {
                    x.next = x.next.next;
                    break;
                }
                index++;
            }
        }   
    }

    //��ָ��λ����ӽ��
    public void addToPosition(int position, int value) {
        if (position > N + 1) 
            System.out.println("the position is too large");
        else {
            int index = 1;
            for (Node x = first; x != null; x = x.next) {
                if (index + 1 == position) {
                    Node temp = new Node();
                    temp.item = value;
                    temp.next = x.next;
                    x.next = temp;
                    break;
                }
                index++;
            }
        }
    }

    // �����������Ƿ���ĳ��ֵ
    public boolean find(int key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.item == key) 
                return true;
        }
        return false;
    }


    // ����һ�� toString�������ӡ
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Node x = first; x != null; x = x.next) {
            str.append(x.item);
            str.append(" ");
        }
        return str.toString();
    }
}
