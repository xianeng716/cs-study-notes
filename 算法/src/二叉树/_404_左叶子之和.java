package 二叉树;

//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 👍 179 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import 公共类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class _404_左叶子之和 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(new _404_左叶子之和().sumOfLeftLeaves(a));
    }

//    List<TreeNode> list = new ArrayList<>();

    int count = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        inOrderTree(root);
        return count;
    }

    public void inOrderTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null && treeNode.left.right == null && treeNode.left.left == null) {
            count += treeNode.left.val;
        }

        inOrderTree(treeNode.left);
        inOrderTree(treeNode.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
