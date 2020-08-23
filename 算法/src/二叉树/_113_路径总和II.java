package 二叉树;

import 公共类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _113_路径总和II {


    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(1);

        a.left = b;
        a.right = c;

        b.left = d;

        c.left = e;
        c.right = f;

        d.left = g;
        d.right = h;


        f.right = i;
        List<List<Integer>> result = new _113_路径总和II().pathSum(a, 22);
        System.out.println(new _113_路径总和II().pathSum(a, 22));
    }

    List<List<Integer>> res = new ArrayList();//全局变量来获取所有的结果路径

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> temp = new LinkedList<>();// 定义一个有序list来存储路径
        helper(root, sum, temp);
        return res;
    }

    public void helper(TreeNode node, int sum, LinkedList<Integer> temp) {
        if (node == null) {
            return;
        }
        temp.addLast(node.val);// 记录路径
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList(temp));
        }
        helper(node.left, sum - node.val, temp);
        helper(node.right, sum - node.val, temp);
        temp.removeLast();// 重点，遍历完后，需要把当前节点remove出去，因为用的是同一个list对象来存所有的路径
    }

}
