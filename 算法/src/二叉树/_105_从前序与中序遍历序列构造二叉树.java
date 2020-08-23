package 二叉树;

import 公共类.TreeNode;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 620 👎 0
public class _105_从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new _105_从前序与中序遍历序列构造二叉树().buildTree(preorder, inorder);
        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderstart, int preorderend, int inorderstart, int inorderend) {
        if (preorderstart > preorderend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderstart]);
        int middle = map.get(preorder[preorderstart]);
        int sizeLeft = middle - inorderstart;
        root.left = buildTree(preorder, inorder, preorderstart + 1, preorderstart + sizeLeft, inorderstart, middle - 1);
        root.right = buildTree(preorder, inorder, preorderstart + sizeLeft + 1, preorderend, middle + 1, inorderend);
        return root;
    }
}
