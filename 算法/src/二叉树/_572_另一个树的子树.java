package 二叉树;

import 公共类.TreeNode;

public class _572_另一个树的子树 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(12);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
        StringBuilder sb = new StringBuilder();
        new _572_另一个树的子树().inorderTree(a, sb);
        System.out.println(sb.toString());

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isTheSameTree(s, t);
    }
    public boolean isTheSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isTheSameTree(s.left, t.left) && isTheSameTree(s.right, t.right);
    }

    private void inorderTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append("^").append(root.val).append("^");
        inorderTree(root.left, sb);
        inorderTree(root.right, sb);
    }
}
