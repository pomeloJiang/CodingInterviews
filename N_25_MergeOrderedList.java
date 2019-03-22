package codinginterviews;

/**
 * Description:输入两个递增排序的链表，合并这两个链表并使新链表
 * 中的节点依然是递增排序的。
 * <p>
 * User: pomelojiang
 * Date: 2019/3/22
 */
public class N_25_MergeOrderedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeOrderedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode newHead = null;
        ListNode current = null;
        if (list1.val < list2.val) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        current = newHead;

        while (list1 != null && list2 != null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }

        return newHead;
    }

    ////////////////////////// 测试
    public static void main(String[] args) {
        ListNode head = null;
//        head = testNullPoint();
//        head = testOneNullPoint();
        head = test();
        printList(head);
    }

    //测试两个头结点为null
    private static ListNode testNullPoint() {
        ListNode head1 = null, head2 = null;
        return new N_25_MergeOrderedList().mergeOrderedList(head1, head2);
    }

    //测试一个头结点为null
    private static ListNode testOneNullPoint(){
        ListNode node4 = new ListNode(7, null);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head1 = new ListNode(0, node1);

        ListNode head2 = null;
        return new N_25_MergeOrderedList().mergeOrderedList(head1, head2);
    }


    private static ListNode test(){
        ListNode node4 = new ListNode(7, null);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head1 = new ListNode(0, node1);

        ListNode nodeD = new ListNode(8, null);
        ListNode nodeC = new ListNode(6, nodeD);
        ListNode nodeB = new ListNode(4, nodeC);
        ListNode nodeA = new ListNode(2, nodeB);
        ListNode head2 = new ListNode(0, nodeA);

        return new N_25_MergeOrderedList().mergeOrderedList(head1, head2);
    }

    private static void printList(ListNode head){
        if (head == null){
            System.out.println("头结点为null");
            return;
        }

        while (head != null){
            System.out.println("head.val="+head.val);
            head = head.next;
        }
    }
}

