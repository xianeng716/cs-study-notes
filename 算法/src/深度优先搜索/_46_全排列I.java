package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 835 👎 0

public class _46_全排列I {

    public static void main(String[] args) {
        List<List<Integer>> list = new _46_全排列I().permute(new int[]{1, 2, 3});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return lists;
        list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(0);
        }
        used = new boolean[nums.length];
        dfs(0, nums);
        return lists;
    }

    public void dfs(int index, int[] nums) {
        if (index >= nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.set(index, nums[i]);
            dfs(index + 1, nums);
            used[i] = false;
        }
    }
}
