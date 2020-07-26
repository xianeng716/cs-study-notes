package 分治;
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
//
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 50000
//
//
// Related Topics 位运算 分治算法
// 地址:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
// 此题与面试题 17.10. 主要元素：https://leetcode-cn.com/problems/find-majority-element-lcci/相同

/**
 * 解题思路：如果是排序好的数组，找到中间的数字就是出现最多的数。但是如果采用排序算法的话，最快也是log(n)时间复杂度
 * 但是可以参考快速排序算法，随机选取节点，小的放左边，大的放右边，如果最后该节点的位置正好等于中间位置的话，那就是要找的数字
 * 如果不是的话，大于中间位置，说明要在它的左边找，如果小于中间位置的话就需要在右边找
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class offer39数组中出现次数超过一半的数字 {

    int pivoteIndex(int[] data, int begin, int end) {
        int pivoteIndex = begin + (int) (Math.random() * (end - begin));

        int temp = data[begin];
        data[begin] = data[pivoteIndex];
        data[pivoteIndex] = temp;

        int pivote = data[begin];

        while (begin < end) {
            while (begin < end) {
                if (data[end] > pivote) {
                    end--;
                } else {
                    data[begin++] = data[end];
                    break;
                }
            }
            while (begin < end) {
                if (data[begin] < pivote) {
                    begin++;
                } else {
                    data[end--] = data[begin];
                    break;
                }
            }
        }

        data[begin] = pivote;

        return begin;
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int begin = 0;
        int end = nums.length - 1;
        int middle = nums.length >> 1;
        int index = pivoteIndex(nums, begin, end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                begin = index + 1;
            }
            index = pivoteIndex(nums, begin, end);
        }

        return nums[index];
    }
}