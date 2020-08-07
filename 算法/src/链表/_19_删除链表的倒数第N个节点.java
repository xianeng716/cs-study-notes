package 链表;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
//地址：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

//leetcode submit region begin(Prohibit modification and deletion)


import 公共类.ListNode;

public class _19_删除链表的倒数第N个节点 {

    /**
     * 一个快指针先移动n+1次，然后慢指针开始向前移动，直到快指针走到头，此时慢指针就在要删除的倒数第N个节点的前一个元素，直接next=next.next即可
     * 需要处理一些特殊case，所以这里使用了一个虚拟头结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virturlHead = new ListNode(-1);
        virturlHead.next = head;

        ListNode slow = virturlHead;
        ListNode fast = head;
        int index = 0;

        while (fast != null) {
            fast = fast.next;
            if (index >= n) {
                slow = slow.next;
            }
            index++;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return virturlHead.next;
    }
}
