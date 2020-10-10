package 二叉树;

import 公共类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，确定它是否是一个完全二叉树。
//
// 百度百科中对完全二叉树的定义如下：
//
// 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：
//第 h 层可能包含 1~ 2h 个节点。）
//
//
//
// 示例 1：
//
//
//
// 输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
//
//
// 示例 2：
//
//
//
// 输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
//
//
//
//
// 提示：
//
//
// 树中将会有 1 到 100 个结点。
//
// Related Topics 树
// 👍 74 👎 0
public class _958_二叉树的完全性检验 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        c.left = f;
//        c.right = f;

//        b.left = d;
//        b.right = e;
//        e.right = f;

//        [1,2,3,5,null,7,8]

        System.out.println(new _958_二叉树的完全性检验().isCompleteTree(a));
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null)
                return false;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }
}
