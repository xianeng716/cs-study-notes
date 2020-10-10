package 二叉树;

import 公共类.TreeNode;

public class _543_二叉树的直径 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(new _543_二叉树的直径().diameterOfBinaryTree(a));
    }

    int max = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max - 1;
    }
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
