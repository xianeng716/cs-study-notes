package 二叉树;

import 公共类.TreeNode;

import java.util.*;

public class offer32_3从上到下打印二叉树 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
//
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(3);
//        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);
//
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        c.right = e;

        List<List<Integer>> lists = new offer32_3从上到下打印二叉树().levelOrder(a);

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> level = lists.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //这个size代表了这一层有多少个节点，需要提前获取
            int size = queue.size();
            //打印奇数层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            if (list.size() > 0) {
                results.add(list);
            }
            list = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                if (node != null) {
                    list.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            if (list.size() > 0) {
                results.add(list);
            }
        }
        return results;
    }
}
