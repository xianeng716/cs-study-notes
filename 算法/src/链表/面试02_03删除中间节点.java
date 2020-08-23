package 链表;

//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//
//
//
// 示例：
//
// 输入：单向链表a->b->c->d->e->f中的节点c
//结果：不返回任何数据，但该链表变为a->b->d->e->f
//
// Related Topics 链表
// 👍 42 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import 公共类.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 面试02_03删除中间节点 {
    public void deleteNode(ListNode node) {
        if(node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            node = null;
        }
    }
}
