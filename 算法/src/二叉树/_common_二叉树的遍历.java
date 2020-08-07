package 二叉树;

import 公共类.TreeNode;

import java.util.*;

/**
 * 对应题目
 * 144.二叉树的前序遍历：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 94.二叉树的中序遍历：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 145.二叉树的后续遍历：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 102.二叉树的程序遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _common_二叉树的遍历 {
    List<Integer> results = new ArrayList<>();

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

//        List<Integer> list = new _common_二叉树的遍历().preorderTraversal(a);
//        List<Integer> list = new _common_二叉树的遍历().inorderTraversal(a);
//        List<Integer> list = new _common_二叉树的遍历().postorderTraversal(a);
//
//        for (Integer node : list) {
//            System.out.print(node + " ");
//        }
//        System.out.println();

        List<List<Integer>> lists = new _common_二叉树的遍历().levelOrder(a);

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> level = lists.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    /**
     * 层序遍历递归实现，深度优先算法
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(0, root, results);
        return results;
    }

    public void dfs(int index, TreeNode root, List<List<Integer>> res) {
        if (root != null) {
            //说明这一层的list还未创建
            if (res.size() <= index) {
                res.add(new ArrayList<>());
            }
            res.get(index).add(root.val);
            dfs(index + 1, root.left, res);
            dfs(index + 1, root.right, res);
        }
    }


    /**
     * 层序遍历非递归实现
     *
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> results = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            //这个size代表了这一层有多少个节点，需要提前获取
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node != null) {
//                    list.add(node.val);
//                    if (node.left != null) {
//                        queue.add(node.left);
//                    }
//                    if (node.right != null) {
//                        queue.add(node.right);
//                    }
//                }
//            }
//            if (!list.isEmpty()) {
//                results.add(list);
//            }
//        }
//
//        return results;
//    }


    /**
     * 前序遍历递归实现，通过栈来实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return results;
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        results.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * 前序遍历非递归实现，通过栈来实现
     *
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                result.add(node.val);
//                stack.push(node.right);
//                stack.push(node.left);
//            }
//        }
//        return result;
//    }

    /**
     * 中序遍历递归实现
     *
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        inOrder(root);
//        return results;
//    }
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        results.add(node.val);
        inOrder(node.right);
    }

    /**
     * 中序遍历非递归实现，通过栈来实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                results.add(node.val);
                node = node.right;
            }
        }

        return results;
    }


    /**
     * 后序遍历递归实现
     *
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        postOrder(root);
//        return results;
//    }
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        results.add(node.val);
    }

    /**
     * 后序遍历非递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode lastVisitNode = null;

        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.left;
        }
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            //一个根节点被访问的条件是没有右子树或者右边的已经被访问过了
            if (currentNode.right != null && currentNode.right != lastVisitNode) {
                stack.push(currentNode);
                currentNode = currentNode.right;
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            } else {
                results.add(currentNode.val);
                lastVisitNode = currentNode;
            }
        }

        return results;
    }
}
