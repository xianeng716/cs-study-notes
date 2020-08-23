package 二叉树;

import 公共类.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _297_二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        String treeString = new _297_二叉树的序列化与反序列化().serialize(a);
        System.out.println(treeString);
        TreeNode root = new _297_二叉树的序列化与反序列化().deserialize(treeString);
        System.out.println(root);
    }


    public void preOrderTree(TreeNode root, StringBuilder sb) {
        if(root == null) {

            return;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        return null;
    }
}
