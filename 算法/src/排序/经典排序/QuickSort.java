package 排序.经典排序;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 11, -6, 9, 2, 10, 31, 15, -8};
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 对 [begin, end] 范围的元素进行快速排序
     * @param begin
     * @param end
     */
    private void sort(int[] nums, int begin, int end) {
        if (end - begin < 2) return;
        // 确定轴点位置 O(n)
        int mid = pivotIndex(nums, begin, end);
        // 对子序列进行快速排序
        sort(nums, begin, mid);
        sort(nums, mid + 1, end);
    }
    /**
     * 构造出 [begin, end) 范围的轴点元素
     * @return 轴点元素的最终位置
     */
    private int pivotIndex(int[] nums, int begin, int end) {
        // 随机选择一个元素跟begin位置进行交换
        int pivoteindex = begin + (int) (Math.random() * (end - begin));
        int temp = nums[pivoteindex];
        nums[pivoteindex] = nums[begin];
        nums[begin] = temp;
        // 备份begin位置的元素
        int pivot = nums[begin];
        while (begin < end) {
            while (begin < end) {
                if (pivot < nums[end]) { // 右边元素 > 轴点元素
                    end--;
                } else { // 右边元素 <= 轴点元素
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end) {
                if (pivot > nums[begin]) { // 左边元素 < 轴点元素
                    begin++;
                } else { // 左边元素 >= 轴点元素
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        // 将轴点元素放入最终的位置
        nums[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }
}

