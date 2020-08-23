package 二叉树;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表
// 👍 277 👎 0

import 公共类.ListNode;
import 公共类.TreeNode;

public class _109_有序链表转换为二叉搜索树 {

    public static void main(String[] args) {
        ListNode a = new ListNode(-10);
        ListNode b = new ListNode(-3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        TreeNode root = new _109_有序链表转换为二叉搜索树().sortedListToBST(a);
        System.out.println(root);
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode middle = findMiddleNode(head);
        TreeNode root = new TreeNode(middle.val);
        if (head == middle) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);

        return root;
    }

    public ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

}
