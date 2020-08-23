package 排序;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针
// 👍 536 👎 0
// 地址：https://leetcode-cn.com/problems/sort-colors/

import java.util.Arrays;

public class _75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new _75_颜色分类().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int redIndex = 0;
        int whiteIndex = 0;
        int blueIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redIndex++;
            }
            if (nums[i] == 1) {
                swap(nums, redIndex, whiteIndex);
                redIndex++;
                whiteIndex++;
            }

            if (nums[i] == 2) {
                swap(nums, whiteIndex, blueIndex);
                blueIndex--;
            }
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
