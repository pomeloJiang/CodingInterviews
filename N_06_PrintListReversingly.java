package codinginterviews;

import java.util.Stack;

/**
 * Description:从尾到头打印链表
 * 输入一个链表的头结点，从尾到头反过来打印出每个节点的值
 * User: pomelojiang
 * Date: 2019/1/26
 */
public class N_6_PrintListReversingly {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void createNode(Node head,int N) {
        for (int i = 0; i < N; i++) {
            Node node = new Node(i);
            head.next = node;
            head = node;
        }
    }

    public static void printList(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("头结点不能为空");
        }

        Stack<Node> nodes = new Stack<>();
        while (head != null) {
            nodes.push(head);
            head = head.next;
        }

        while (!nodes.empty()) {
            Node node = nodes.pop();
            System.out.print(node.value+" ");
        }
    }
}
