package codinginterviews;

/**
 * Description:删除链表的节点
 * 题目一:在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 *
 * User: pomelojiang
 * Date: 2019/2/28
 */
public class N_18_01_DeleteNodeInList {

    public void deleteNode(ListNode head,ListNode toBeDeleted){
        if (head == null || toBeDeleted == null){
            return;
        }

        if (toBeDeleted.getNext() != null){
            //要删除的节点是非尾节点
            ListNode next = toBeDeleted.getNext();
            toBeDeleted.setValue(next.getValue());
            toBeDeleted.setNext(next.getNext());
        }else if (head == toBeDeleted){
            //链表只有一个节点，删除头节点
            head = null;  //该写法并不能将头节点置为null
        }else {
            //要删除的节点是尾节点且链表中有多个节点
            //需要遍历
            ListNode sHead = head;
            while (sHead.getNext() != null){
                sHead = sHead.getNext();
            }
            sHead.setNext(null);
        }
    }


    public static class ListNode{
        private int mValue;
        private ListNode mNext;

        public int getValue() {
            return mValue;
        }

        public void setValue(int mValue) {
            this.mValue = mValue;
        }

        public ListNode getNext() {
            return mNext;
        }

        public void setNext(ListNode mNext) {
            this.mNext = mNext;
        }
    }
}
