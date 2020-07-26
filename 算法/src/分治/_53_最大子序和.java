package 分治;

public class _53_最大子序和 {

    /**
     * 分治算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return maxSubArray(nums, 0, nums.length);
    }

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