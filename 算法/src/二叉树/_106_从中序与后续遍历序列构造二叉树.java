package 二叉树;

import 公共类.TreeNode;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 263 👎 0

public class _106_从中序与后续遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = new _106_从中序与后续遍历序列构造二叉树().buildTree(inorder, postorder);
        System.out.println(treeNode);
    }

    Map<Integer, Integer> map = new HashMap<>();

    //
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1,
                0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int postorderstart, int postorderend, int inorderstart, int inorderend) {
        if (inorderstart > inorderend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderend]);
        int middle = map.get(postorder[postorderend]);
        int size_left = middle - inorderstart;
//        中序左子树的范围[inorderstart,middle-1] 后序左子树的范围[postorderstart,postorderstart+size_left-1]
//        中序右子树的范围[middle+1,inorderend] 后序右子树的范围[postorderstart+size_left,postorderend-1]
        root.left = buildTree(inorder, postorder, postorderstart, postorderstart + size_left - 1, inorderstart, middle - 1);
        root.right = buildTree(inorder, postorder, postorderstart + size_left, postorderend - 1, middle + 1, inorderend);

        return root;
    }
}
