package 数组;
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。
//
//
//
// 示例 1:
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true
//
// 示例 2:
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true
//
// 示例 3:
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
// Related Topics 数组 哈希表
// 👍 190 👎 0

import java.util.HashMap;
import java.util.Map;


public class _219_存在重复元素II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.get(nums[i]);
            System.out.println(lastIndex);
            if (lastIndex != null && (i - lastIndex) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new _219_存在重复元素II().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//
//        System.out.println(new _219_存在重复元素II().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(new _219_存在重复元素II().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(new _219_存在重复元素II().containsNearbyDuplicate(new int[]{2, 2}, 3));

    }
}
