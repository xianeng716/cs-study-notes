package 递归;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 328 👎 0

public class _77_组合 {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(null);
//        System.out.println(list.size());

        List<List<Integer>> lists = new _77_组合().combine(4, 2);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        generate(1, n, k, new LinkedList<>(), results);
        return results;
    }

    public void generate(int start, int n, int k, LinkedList<Integer> temp, List<List<Integer>> results) {
        if (temp.size() == k) {
            results.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            generate(i + 1, n, k, temp, results);
            temp.removeLast();
        }
    }


}
