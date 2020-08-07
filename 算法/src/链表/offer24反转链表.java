package 链表;

import 公共类.ListNode;
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
//
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
// Related Topics 链表
// 👍 78 👎 0
// 地址：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class offer24反转链表 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

//        a.next = b;
//        b.next = c;
        ListNode current = new offer24反转链表().reverseList(a);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            ListNode temp = slow;
            slow = fast;
            fast = fast.next;
            slow.next = temp;
            if (temp == head) {
                temp.next = null;
            }
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

