package codinginterviews;

/**
 * Description:输入一个链表，输出该链表中倒数第k个节点
 *
 * User: pomelojiang
 * Date: 2019/3/21
 */
public class N_22_FindKthToTail {

    static class ListNode {
        int mValue;
        ListNode pNext;
    }

    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null || k <= 0) {
            return null;
        }

        ListNode pFast = pHead, pSlow = pHead;
        k--;
        while (k > 0) {
            //若k大于链表长度，则返回null
            if (pFast.pNext == null) {
                return null;
            }
            pFast = pFast.pNext;
            k--;
        }

        while (pFast.pNext != null) {
            pFast = pFast.pNext;
            pSlow = pSlow.pNext;
        }
        return pSlow;
    }
}
