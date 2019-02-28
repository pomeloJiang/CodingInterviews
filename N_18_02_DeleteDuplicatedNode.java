package codinginterviews;

/**
 * Description:删除链表中重复的结点
 * 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * 结点被删除之后，链表如图3.4（b）所示。
 *
 * User: pomelojiang
 * Date: 2019/2/28
 */
public class N_18_02_DeleteDuplicatedNode {

    public ListNode deleteDuplicatedNode(ListNode pHead){
        //只有0个或1个节点，返回头节点
        if (pHead == null || pHead.getNext() == null){
            return pHead;
        }

        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.setNext(pHead);
        ListNode sHead = preHead;

        while (pHead != null && pHead.getNext() != null){
            if (pHead.getNext().getValue() == pHead.getValue()){
                int value = pHead.getValue();
                while (pHead != null && pHead.getValue() == value){
                    pHead = pHead.getNext();
                }
                sHead.setNext(pHead);
            }else {
                sHead = pHead;
                pHead = pHead.getNext();
            }
        }
        return preHead.getNext();
    }

    public static class ListNode{
        private int mValue;
        private ListNode mNext;

        public ListNode(){}

        public ListNode(int value){
            mValue = value;
        }

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
