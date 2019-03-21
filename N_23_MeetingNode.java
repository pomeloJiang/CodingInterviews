package codinginterviews;

/**
 * Description:如果一个链表中包含环，如何找出环的入口节点？
 * <p>
 * User: pomelojiang
 * Date: 2019/3/21
 */
public class N_23_MeetingNode {

    static class ListNode {
        int mValue;
        ListNode pNext;
    }

    public ListNode getEntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        //求链表中环的长度
        int nodesInLoop = 1;
        ListNode pNode = meetingNode;
        while (pNode.pNext != meetingNode) {
            pNode = pNode.pNext;
            nodesInLoop++;
        }

        ListNode pFast = pHead, pSlow = pHead;
        while (nodesInLoop > 0) {
            pFast = pFast.pNext;
            nodesInLoop--;
        }

        while (pFast != pSlow) {
            pFast = pFast.pNext;
            pSlow = pSlow.pNext;
        }

        return pFast;
    }

    /**
     * 快慢指针，如果相遇，则链表有环
     */
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode pSlow = pHead.pNext;
        if (pSlow == null) {
            return null;
        }

        ListNode pFast = pSlow.pNext;
        while (pFast != null && pSlow != null) {
            //如果快慢指针相遇，链表有环
            if (pFast == pSlow) {
                return pFast;
            }

            //快指针每次走两步
            pSlow = pSlow.pNext;
            pFast = pFast.pNext;
            if (pFast != null) {
                pFast = pFast.pNext;
            }
        }

        return null;
    }

}
