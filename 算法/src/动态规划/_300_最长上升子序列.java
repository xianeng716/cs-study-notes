package 动态规划;

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划
// 👍 1051 👎 0
public class _300_最长上升子序列 {

    public static void main(String[] args) {
//        [1,3,6,7,9,4,10,5,6]
//        System.out.println(new _300_最长上升子序列().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new _300_最长上升子序列().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    count = Math.max(dp[j] + 1, count);
                }
            }
            dp[i] = count;
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
