package 二叉树;

import 公共类.TreeNode;

//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
// 例如：
//
// 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/
// Related Topics 树 深度优先搜索
// 👍 37 👎 0

public class offer55_1二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = 1+maxDepth(root.left);
        int rightHeight = 1+maxDepth(root.right);
        return Math.max(leftHeight, rightHeight);
    }
}
