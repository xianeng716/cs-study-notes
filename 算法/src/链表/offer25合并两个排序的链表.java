package 链表;


//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
//地址：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 分治算法


import 公共类.ListNode;

//leetcode submit region begin(Prohibit modification and deletion)
public class offer25合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newHead = new ListNode(-1);
        ListNode aCurrent = l1;
        ListNode bCurrent = l2;
        ListNode current = newHead;
        while (aCurrent != null || bCurrent != null) {
            if (aCurrent != null && bCurrent != null) {
                if (aCurrent.val < bCurrent.val) {
                    current.next = aCurrent;
                    aCurrent = aCurrent.next;
                } else {
                    current.next = bCurrent;
                    bCurrent = bCurrent.next;
                }
            } else if (aCurrent != null) {
                current.next = aCurrent;
                aCurrent = aCurrent.next;
            } else {
                current.next = bCurrent;
                bCurrent = bCurrent.next;
            }
            current = current.next;
        }

        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)