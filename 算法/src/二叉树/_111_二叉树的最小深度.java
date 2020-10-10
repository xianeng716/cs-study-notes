package 二叉树;
//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 315 👎 0

import 公共类.TreeNode;

public class _111_二叉树的最小深度 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        System.out.println(new _111_二叉树的最小深度().minDepth(a));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 1 + minDepth(root.left);
        int rightHeight = 1 + minDepth(root.right);

        if (leftHeight > 1 && rightHeight > 1) {
            return Math.min(leftHeight, rightHeight);
        } else if (leftHeight > 1) {
            return leftHeight;
        } else {
            return rightHeight;
        }

    }
}
