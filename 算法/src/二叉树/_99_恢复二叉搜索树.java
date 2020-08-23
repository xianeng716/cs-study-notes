package 二叉树;

//二叉搜索树中的两个节点被错误地交换。
//
// 请在不改变其结构的情况下，恢复这棵树。
//
// 示例 1:
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
//
//
// 示例 2:
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
//
// 进阶:
//
//
// 使用 O(n) 空间复杂度的解法很容易实现。
// 你能想出一个只使用常数空间的解决方案吗？
//
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import 公共类.TreeNode;

class _99_恢复二叉搜索树 {

    public TreeNode lastNode;
    public TreeNode firstNode;
    public TreeNode secondNode;


    /**
     * 中序遍历就是从小到大的顺序，通过中序遍历找逆序对即可找对对应节点
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inOrderTree(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inOrderTree(TreeNode root) {
        if (root == null) return;
        inOrderTree(root.left);
        if (lastNode != null && root.val < lastNode.val) {
            secondNode = root;

            if (firstNode == null) {
                firstNode = lastNode;
            }
        }
        lastNode = root;
        inOrderTree(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)