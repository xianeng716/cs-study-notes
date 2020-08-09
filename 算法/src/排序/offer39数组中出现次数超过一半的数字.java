package 排序;

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
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
//
// Related Topics 位运算 分治算法
// 👍 48 👎 0

public class offer39数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        System.out.println(new offer39数组中出现次数超过一半的数字().
                majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }


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
