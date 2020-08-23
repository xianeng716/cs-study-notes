package 深度优先搜索;

import java.util.ArrayList;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法
// 👍 371 👎 0

public class _47_全排列II {

    public static void main(String[] args) {
        List<List<Integer>> list = new _47_全排列II().permuteUnique(new int[]{1, 1, 2});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
