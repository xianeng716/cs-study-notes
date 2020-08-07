package 二叉树;

import 公共类.TreeNode;

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索
// 👍 659 👎 0
//地址：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
public class _104_二叉树的最大深度 {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(6);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        d.right = g;

        System.out.println(new _104_二叉树的最大深度().maxDepth(a));
    }

    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
