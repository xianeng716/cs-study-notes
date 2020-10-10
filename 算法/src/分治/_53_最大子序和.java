package 分治;


//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2500 👎 0

public class _53_最大子序和 {


    public static void main(String[] args) {
        System.out.println(new _53_最大子序和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

//    /**
//     * 分治算法
//     *
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        return maxSubArray(nums, 0, nums.length);
//    }

    public int maxSubArray(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        int leftMax = nums[mid - 1];
        int rightMax = nums[mid];
        int leftSum = 0;
        int rightSum = 0;

        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        for (int j = mid; j < end; j++) {
            rightSum += nums[j];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax,
                Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));
    }


//    /**
//     * 暴力求解法
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum = nums[j] + sum;
//                max = Math.max(sum, max);
//            }
//        }
//        return max;
//    }
}