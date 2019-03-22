package codinginterviews;

/**
 * Description:定义一个函数，输入一个链表的头结点，
 * 反转该链表并输出反转后链表的头结点。
 * <p>
 * User: pomelojiang
 * Date: 2019/3/21
 */
public class N_24_ReverseList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}

